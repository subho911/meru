package com.meru.promotion.controller;

import com.meru.promotion.dao.PromotionRepository;
import com.meru.promotion.entity.Promotion;
import com.meru.promotion.service.PromotionService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PromotionController.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class promotionControllerTest1 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PromotionService promotionService;

    @MockBean
    private PromotionRepository promotionRepository;

   @Test
    public void testGetOperation() throws Exception{
        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02");
        List<Promotion> promotions = Arrays.asList(promotion);
        Mockito.when(promotionRepository.findAll()).thenReturn(promotions);
        given(promotionService.findAllPromotions()).willReturn(promotions);

        mvc.perform(
                get("/promotion-api/promotions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

   @Test
    public void testNamedGetOperation() throws Exception{
        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02");
        List<Promotion> promotions = Arrays.asList(promotion);
        given(promotionService.findByName(promotion.getName())).willReturn(promotions);

        mvc.perform(
                get("/promotion-api/promotions/testName")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void createPromotion() throws Exception {
        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02");
        String jsonString = "{\n" +
                "\"id\": 55,\n" +
                "\"name\": \"Spring\",\n" +
                "\"type\": \"S\",\n" +
                "\"description\": \"Promotion for Spring break\",\n" +
                "\"discountPc\": 10,\n" +
                "\"startDate\": null,\n" +
                "\"endDate\": \"2019-04-29\"\n" +
                "}";
       Mockito.when(promotionService.createPromotion(any(Promotion.class)))
               .thenReturn(promotion);

       mvc.perform(
               post("/promotion-api/promotions")
               .contentType(MediaType.APPLICATION_JSON)
               .content(jsonString)
       ).andExpect(status().isCreated());

    }

    @Test
    public void updatePromotion() throws Exception{
        String jsonString = "{\n" +
                "\"id\": 55,\n" +
                "\"name\": \"Spring\",\n" +
                "\"type\": \"S\",\n" +
                "\"description\": \"Promotion for Spring break\",\n" +
                "\"discountPc\": 10,\n" +
                "\"startDate\": null,\n" +
                "\"endDate\": \"2019-04-29\"\n" +
                "}";
        Mockito.when(promotionService.updatePromotion(anyLong(), any(Promotion.class)))
                .thenReturn(null);
        mvc.perform(
                put("/promotion-api/promotions/55")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString)
        ).andExpect(status().isNotFound());
    }

    @Test
    public void getPromotions1() {
    }

    @Test
    public void clearAllPromotions() {
    }

    @Test
    public void clearSelectedPromotion() {
    }
}
