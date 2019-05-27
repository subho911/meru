package com.meru.promotion.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;

import static com.meru.promotion.util.PromoUtils.dbDateToString;
import static com.meru.promotion.util.PromoUtils.stringToDbDate;

@Converter(autoApply = false)
public class LocalDateConverter implements AttributeConverter<String, Date> {

    @Override
    public Date convertToDatabaseColumn(String attribute) {
        return attribute == null ? null : stringToDbDate(attribute) ;
    }

    @Override
    public String convertToEntityAttribute(Date dbData) {
        return dbData == null ? null : dbDateToString(dbData);
    }
}
