package com.meru.promotion.controller;

import com.meru.promotion.entity.Promotion;
import com.meru.promotion.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/promotion-api")
public class PromotionController {

    @Autowired
    PromotionService promotionService;

    @GetMapping("/promotions")
   public Collection getPromotions() {
        System.out.println(">> promotion-api: PromotionController:getPromotions");
        Collection<Promotion> promotions =  promotionService.findAllPromotions();
        promotions.stream().forEach(a -> System.out.println(a.getStartDate()));
        System.out.println(">> promotion-api: "+promotions);

        /*if(promotions.size()>0) {
            return new ResponseEntity<Collection<Promotion>>(promotions, HttpStatus.OK);
        }
        return new ResponseEntity("Currently No Promotions Available",
                HttpStatus.OK);*/

        return promotions;

    }

    @PostMapping("/promotions")
    public String createPromotion(@RequestBody Promotion promotion) {
        promotionService.createPromotion(promotion);
        return "Success";
    }


    @PutMapping("/promotions/{id}")
    public String updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion) {
        Promotion updated = promotionService.updatePromotion(id, promotion);
       /* if(updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);*/
       return "Success";
    }

    @GetMapping("/promotions/{name}")
    public Collection getPromotions(@PathVariable String name) {
        Collection<Promotion> promotions =  promotionService.findByName(name);

        return promotions;
        /*if(promotions.size()>0) {
            return new ResponseEntity(promotions, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);*/
    }

    @DeleteMapping("/promotions")
    public void clearAllPromotions() {
        promotionService.deleteAllPromotions();
       // return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/promotions/{name}")
    public void clearSelectedPromotion(@PathVariable String name) {
        promotionService.deleteSelectedPromoton(name);
        //return new ResponseEntity(HttpStatus.OK);
    }



}
