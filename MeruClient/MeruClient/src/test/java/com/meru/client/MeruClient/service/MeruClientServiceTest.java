package com.meru.client.MeruClient.service;

import static org.assertj.core.api.Assertions.assertThat;
import com.meru.client.MeruClient.entity.Promotion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class MeruClientServiceTest {


    @TestConfiguration
    static class MeruClientServiceImplTestContextConfiguration {
        @Bean
        public MeruClientService meruClientService() {
            return new MeruClientServiceImpl();
        }
    }
    @Autowired
    private MeruClientService meruClientService;

    @MockBean
    PromotionClient promotionClient;

    @Test
    public void test(){


    }

/*    @Test
    public void testGetAllHystrix() throws Exception{

        
        Promotion promotion = new Promotion(
                2, "testName", "PRO", "TestDesc",
                10, "2019-02-28", "2019-03-02");
        List<Promotion> promotions = Arrays.asList(promotion);
        Mockito.when(promotionClient.getPromotions()).thenThrow(UnsupportedOperationException.class);
        assertThat((meruClientService.getPromotions().isEmpty()));


    }
*/
}
