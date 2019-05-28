package com.meru.client.MeruClient.controller;

import com.meru.client.MeruClient.entity.Promotion;
import com.meru.client.MeruClient.service.MeruClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/view-service")
public class MeruClientController {
    @Autowired
    MeruClientService meruClientService;

    @GetMapping("/promotion/promotions")
    public Collection getPromotions() {
        System.out.println("MeruClientController: getPromotions");

       return meruClientService.getPromotions();
    }

    @PostMapping("/promotion/promotions")
    public String createPromotion(@RequestBody Promotion promotion) {
        System.out.println("MeruClientController: createPromotion");
        System.out.println(promotion.toString());
        return meruClientService.createPromotion(promotion);
    }

    @PutMapping("/promotion/promotions/{id}")
    public String updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion) {
        return meruClientService.updatePromotion(id, promotion);
    }

    @GetMapping("/promotion/promotions/{name}")
    public Collection getPromotions(@PathVariable String name) {
        return meruClientService.getPromotions(name);
    }

    @DeleteMapping("/promotion/promotions")
    public void clearAllPromotions() {
        meruClientService.clearAllPromotions();
    }

    @DeleteMapping("/promotion/promotions/{name}")
    public void clearSelectedPromotion(@PathVariable String name) {
        meruClientService.clearSelectedPromotion(name);
    }
/*    @GetMapping("/")
    public ResponseEntity getPromotions1() {
        System.out.println("MeruClientController: first");
        return meruClientService.getPromotions();
    }*/
}
