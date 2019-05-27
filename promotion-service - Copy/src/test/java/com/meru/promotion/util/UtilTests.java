package com.meru.promotion.util;

import com.meru.promotion.entity.Promotion;
import org.junit.Test;

import java.util.Arrays;

import static com.meru.promotion.util.PromoUtils.getNullPropertyNames;
import static java.lang.System.out;
import static org.springframework.beans.BeanUtils.copyProperties;

import static com.meru.promotion.util.PromoUtils.dateTimeDiffDays;

public class UtilTests {

    @Test
    public void test() {
        out.println(dateTimeDiffDays("2019-03-01", "2019-02-02"));
    }

    @Test
    public void copyProps() {
        Promotion existing = new Promotion(
                2, "testName1", "PRO3", "TestDesc",
                10, "2019-03-01", "2019-03-02");

        Promotion updated = new Promotion(
                2, "testName1", "PRO4", null,
                10, "2019-03-01", "2019-03-30");
        Arrays.asList(getNullPropertyNames(updated)).stream().forEach(out::println);
        copyProperties(updated, existing, getNullPropertyNames(updated));
        System.out.println(existing.toString());
    }
}
