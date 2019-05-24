package com.meru.client.MeruClient.service;

import com.meru.client.MeruClient.entity.Promotion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Service
public interface MeruClientService {
    public Collection getPromotions();
    public String createPromotion(Promotion promotion);

    public String updatePromotion(Long id, Promotion promotion);

    public Collection getPromotions(String name);

    public void clearAllPromotions();

    public void clearSelectedPromotion(String name);
}
