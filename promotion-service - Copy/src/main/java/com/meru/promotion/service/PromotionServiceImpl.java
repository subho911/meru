package com.meru.promotion.service;

import com.meru.promotion.dao.PromotionRepository;
import com.meru.promotion.entity.Promotion;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.meru.promotion.util.PromoUtils.dateTimeDiffDays;
import static com.meru.promotion.util.PromoUtils.getNullPropertyNames;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService{


    @Autowired
    private PromotionRepository promotionRepository;

    @Transactional
    //@HystrixCommand(fallbackMethod = "sendError")
    public Promotion createPromotion(Promotion promotion) {

        Optional updated = promotionRepository.findById(promotion.getId());
        if (dateTimeDiffDays(promotion.getStartDate(), promotion.getEndDate()) < 0)
            throw new UnsupportedOperationException("End Date Can not be before Start date");
        if (updated.isPresent())
            throw new UnsupportedOperationException("Promotion already Exists");
            return promotionRepository.save(promotion);

    }

    //@HystrixCommand(fallbackMethod = "sendError")
    public List<Promotion> findAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion findById(Long id) {
        return promotionRepository.findById(id).get();
    }

    @Transactional
    public Promotion updatePromotion(Long id, Promotion updated) {
        Optional<Promotion> promotion = promotionRepository.findById(id);//.get();
        Promotion existing = new Promotion();
        if(promotion.isPresent()) {
            existing = promotion.get();
        }
        copyProperties(updated, existing, getNullPropertyNames(updated));
        if(dateTimeDiffDays(existing.getStartDate(), existing.getEndDate()) < 0) {
            throw new UnsupportedOperationException("End Date Can not be before Start date");
        }
        return promotionRepository.save(existing);
    }

    @Override
    public void deleteAllPromotions() {
        promotionRepository.deleteAll();
    }

    @Override
    //@Transactional()
    public void deleteSelectedPromoton(String name) {
        promotionRepository.deleteByName(name);
    }

    @Override
    public List<Promotion> findByName(String name) {
        List<Promotion> promotions = promotionRepository.findByName(name);
        return promotions;
    }

    public List sendError() {
        System.out.println("Fallback error>>>>>");
        return null;
    }
}
