package com.meru.client.MeruClient.service;

import com.meru.client.MeruClient.entity.Promotion;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class MeruClientServiceImpl implements MeruClientService {

    @Autowired
    PromotionClient promotionClient;


    @Override
    //@HystrixCommand(fallbackMethod = "failed")
    public Collection getPromotions() {
        System.out.println("getPromotions");
        return promotionClient.getPromotions();
    }

    @Override
    //@HystrixCommand(fallbackMethod = "failed")
    public String createPromotion(Promotion promotion) {
        System.out.println("create Promotion");
        System.out.println(promotion.toString());
        return promotionClient.createPromotion(promotion);
    }

    @Override
    public String updatePromotion(Long id, Promotion promotion) {
        return promotionClient.updatePromotion(id, promotion);
    }

    @Override
    public Collection getPromotions(String name) {
        return promotionClient.getPromotions(name);
    }

    @Override
    public void clearAllPromotions() {
        promotionClient.clearAllPromotions();
    }

    @Override
    public void clearSelectedPromotion(String name) {
        promotionClient.clearSelectedPromotion(name);
    }
    public Collection failed(){
        System.out.println(">>>>>>>>>Failed");
        return Collections.EMPTY_LIST;
    }
}
