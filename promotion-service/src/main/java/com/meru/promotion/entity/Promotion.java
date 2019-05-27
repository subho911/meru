package com.meru.promotion.entity;

import com.meru.promotion.entity.converter.LocalDateConverter;
import lombok.*;

import javax.persistence.Id;

/*import javax.persistence.Entity;
import javax.persistence.Id;*/
import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter @Setter @NoArgsConstructor @ToString
@Table(name="promotions")
public class Promotion {

    @Id
    private long id;
    private String name;
    private String type;
    private String description;
    private Integer discountPc;
    @Convert(converter = LocalDateConverter.class)
    private String startDate;
    @Convert(converter = LocalDateConverter.class)
    private String endDate;

}
