package com.meru.promotion;

import com.meru.promotion.dao.PromotionRepository;
import com.meru.promotion.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
public class PromotionServiceApplication {

	@Autowired
	PromotionRepository promotionRepository;
	public static void main(String[] args) {
		SpringApplication.run(PromotionServiceApplication.class, args);
	}

//	@Bean
//	//@Autowired
//	public CommandLineRunner loadData() {
//		return (args) -> {
//			Promotion promotion = new Promotion();
//			promotion.setId(34);
//			promotion.setName("Spring1");
//			promotion.setDescription("Promotion for Spring break");
//			promotion.setDiscountPc(10);
//			promotion.setType("S");
//			promotion.setStartDate("2019-04-05");//new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-05"));
//			promotion.setEndDate("2019-04-23");
//			promotionRepository.save(promotion);
//		};
//	}

}
