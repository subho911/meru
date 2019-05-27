package com.meru.promotion.service;

import com.meru.promotion.dao.PromotionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.meru.promotion.entity.Promotion;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(SpringRunner.class)
public class PromotionServiceTest {

    @TestConfiguration
    static class PromotionServiceImplTestContextConfiguration {
        @Bean
        public PromotionService promotionService() {
            return new PromotionServiceImpl();
        }
    }
    @Autowired
    private PromotionService promotionService;

    @MockBean
    PromotionRepository promotionRepository;

    @Before
    public void setup() {

        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02");
        Promotion promotion1 = new Promotion(
                3, "testName", "PRO", "TestDesc",
                10, "2019-03-28", "2019-03-02");

        //Mockito.when(promotionRepository.save(any(Promotion.class))).thenReturn(promotion);
        Mockito.when(promotionRepository.save(any(Promotion.class))).thenReturn(promotion);

        Mockito.when(promotionRepository.findById(anyLong())).thenReturn(Optional.of(promotion));
    }

    @Test
    public void s1TestSavewithIncorectDateRange() {
        promotionRepository.deleteAll();
        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-03-28", "2019-03-02");
        System.out.println(promotion.toString());
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> promotionService.createPromotion(promotion))
                .withMessage("End Date Can not be before Start date");
    }

    @Test
    public void updatePromotion() {
        Promotion promotion = new Promotion(
                2, "testName1", "PRO3", null,
                10, "2019-03-01", "2019-03-02");

        assertEquals("TestDesc",
                promotionService.updatePromotion(promotion.getId(), promotion).getDescription());
    }

    @Test
    public void createDuplicatePromotion() {
        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02");

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> promotionService.createPromotion(promotion));
    }

    @Test
    public void findAllPromotions() {

    }

    @Test
    public void findById() {
    }

    @Test
    public void findByName() {
    }


    @Test
    public void deleteAllPromotions() {
        //Delete records in Empty table and make sure no exception is thrown
        promotionService.deleteAllPromotions();
        assertEquals(0,promotionService.findAllPromotions().size());

    }

    @Test
    public void deleteSelectedPromoton() {


    }
}
