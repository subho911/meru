package com.meru.client.MeruClient.cotroller;

import com.meru.client.MeruClient.controller.MeruClientController;
import com.meru.client.MeruClient.entity.Promotion;
import com.meru.client.MeruClient.service.MeruClientService;
import com.meru.client.MeruClient.service.PromotionClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MeruClientController.class)
public class MeruClientControllerTest {
    @MockBean
    PromotionClient promotionClient;

    @MockBean
    MeruClientService meruClientService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAll() throws Exception{
        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02");
        List<Promotion> promotions = Arrays.asList(promotion);
        Mockito.when(promotionClient.getPromotions()).thenReturn(promotions);
        Mockito.when(meruClientService.getPromotions()).thenReturn(promotions);

        mvc.perform(
                get("/view-service/promotion/promotions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

   /* @Test
    public void testGetAllHystrix() throws Exception{
        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02");
        List<Promotion> promotions = Arrays.asList(promotion);
        Mockito.when(promotionClient.getPromotions()).thenThrow(UnsupportedOperationException.class);
        Mockito.when(meruClientService.getPromotions()).thenThrow(UnsupportedOperationException.class);

        mvc.perform(
                get("/view-service/promotion/promotions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"));
    }*/

}
