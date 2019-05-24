package com.meru.client.MeruClient.service;

import com.meru.client.MeruClient.entity.Promotion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@FeignClient(value = "promotion", fallback = PromotionClientFallback.class)//, configuration = PromotionClientConfiguration.class)

public interface PromotionClient {
    @GetMapping("/promotion-api/promotions")
    public Collection getPromotions();

    @PostMapping("/promotion-api/promotions")
    public String createPromotion(@RequestBody Promotion promotion);

    @PutMapping("/promotion-api/promotions/{id}")
    public String updatePromotion(@PathVariable(value="id") Long id, @RequestBody Promotion promotion);

    @GetMapping("/promotion-api/promotions/{name}")
    public Collection getPromotions(@PathVariable(value="name") String name);

    @DeleteMapping("/promotion-api/promotions")
    public void clearAllPromotions();

    @DeleteMapping("/promotion-api/promotions/{name}")
    public void clearSelectedPromotion(@PathVariable(value="name") String name);
}
