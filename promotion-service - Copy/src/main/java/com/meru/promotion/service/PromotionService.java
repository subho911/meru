package com.meru.promotion.service;


import com.meru.promotion.entity.Promotion;

import java.util.List;

public interface PromotionService {

    public Promotion createPromotion(Promotion promotion);

    public List<Promotion> findAllPromotions();

    public Promotion findById(Long id) ;

    public List<Promotion> findByName(String name) ;

    public Promotion updatePromotion(Long id, Promotion updated);

    public void deleteAllPromotions();

    public void deleteSelectedPromoton(String name);
}
