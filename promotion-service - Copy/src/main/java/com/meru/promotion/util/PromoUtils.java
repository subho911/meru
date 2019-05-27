package com.meru.promotion.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;


public class PromoUtils {

    public static Date stringToDbDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return Date.valueOf(localDate);
    }

    public static String dbDateToString(Date dt) {
        return dt.toLocalDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }


    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

    public static long dateTimeDiffDays(String fromDateTime,String toDateTime){
        if(fromDateTime == null || toDateTime == null) {
            throw new UnsupportedOperationException("Date cannot be Null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate to = LocalDate.parse(toDateTime, formatter);
        LocalDate from = LocalDate.parse(fromDateTime, formatter);
        return ChronoUnit.DAYS.between(from,to);

    }


}
