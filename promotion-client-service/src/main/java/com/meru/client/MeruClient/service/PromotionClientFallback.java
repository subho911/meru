package com.meru.client.MeruClient.service;

import com.meru.client.MeruClient.entity.Promotion;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Collections;

@Component
public class PromotionClientFallback implements PromotionClient{
    @Override
    public Collection getPromotions() {
        System.out.println("IN PromotionClientFallback>>>");
        return Collections.EMPTY_LIST;
    }

    @Override
    public String createPromotion(Promotion promotion) {
        System.out.println("IN createPromotionClientFallback>>>");
        return "Server Busy";
    }

    @Override
    public String updatePromotion(Long id, Promotion promotion) {
        return "Server Busy";
    }

    public Collection getPromotions(String name) {
        return Collections.EMPTY_LIST;
    }

    public void clearAllPromotions() {

    }

    public void clearSelectedPromotion(String name) {

    }
}
