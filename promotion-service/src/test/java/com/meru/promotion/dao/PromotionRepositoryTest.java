package com.meru.promotion.dao;

import com.meru.promotion.dao.PromotionRepository;
import com.meru.promotion.entity.Promotion;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PromotionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PromotionRepository promotionRepository;

    @Test
    public void a1fetchPromoNameWhenEmpty() {

        assertThat(promotionRepository.findAll().isEmpty());
    }

    @Test
    public void findByName() {

        Promotion promotion1 = promotionRepository.save(new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02"));

        Promotion promotion2 = promotionRepository.save(new Promotion(
                3, "testName", "PRO1", "TestDesc1",
                10, "2019-02-28", "2019-03-02"));
        entityManager.persist(promotion1);
        entityManager.persist(promotion2);
        assertThat(promotionRepository.findByName("testName").size()==2);
    }

    @Test
    public void deleteByName() {
        Promotion promotion1 = promotionRepository.save(new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02"));

        Promotion promotion2 = promotionRepository.save(new Promotion(
                3, "testName", "PRO1", "TestDesc1",
                10, "2019-02-28", "2019-03-02"));

        entityManager.persist(promotion1);
        entityManager.persist(promotion2);
        assertThat(promotionRepository.findByName("testName").size()==2);
        promotionRepository.deleteByName("testName");
        assertThat(promotionRepository.findByName("testName").isEmpty());
    }

    @Test
    public void saveDuplicatePromotion() {
        Promotion promotion = promotionRepository.save(new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02"));

        promotionRepository.save(promotion);
        assertNotNull(promotionRepository.save(promotion));
    }

    @Test
    public void savePromotion() {
        Promotion promotion = promotionRepository.save(new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02"));

        assertThat(promotion).hasFieldOrPropertyWithValue("name", "testName");
        assertThat(promotion).hasFieldOrPropertyWithValue("endDate", "2019-03-02");
        assertThat(promotionRepository.findByName("testName").size()>0);
    }


    @Test
    public void deleteFromEmptyTable() {
        //Delete records in Empty table and make sure no exception is thrown
        promotionRepository.deleteAll();
        assertEquals(0, promotionRepository.findAll().size());
    }
}
