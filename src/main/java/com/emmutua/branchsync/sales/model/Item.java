package com.emmutua.branchsync.sales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "unit_price")
    private String unitPrice;
    @Column(name = "items_sold")
    private Integer itemsSold;
    @Column(name = "total_income")
    private Float totalIncome;
    @Column(name = "creation_date")
    private LocalDate localDate;
    @Column(name = "creation_time")
    private LocalTime localTime;
}
