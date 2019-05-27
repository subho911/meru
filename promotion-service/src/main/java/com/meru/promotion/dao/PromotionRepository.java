package com.meru.promotion.dao;

import com.meru.promotion.entity.Promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    public List<Promotion> findByName(String name);

    public void deleteByName(String name);
}
