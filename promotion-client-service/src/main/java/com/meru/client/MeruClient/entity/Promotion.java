package com.meru.client.MeruClient.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Promotion {

   // @Id
    private long id;
    private String name;
    private String type;
    private String description;
    private Integer discountPc;
    //@Convert(converter = LocalDateConverter.class)
    private String startDate;
   // @Convert(converter = LocalDateConverter.class)
    private String endDate;

}
