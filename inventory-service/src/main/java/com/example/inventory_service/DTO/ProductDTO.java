package com.example.inventory_service.DTO;

import lombok.Data;

@Data
public class ProductDTO {

    private String name;
    private Double price;
    private Integer stock;
}
