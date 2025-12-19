package com.example.inventory_service.DTO;

import lombok.Data;

@Data
public class InventoryDTO {

    private Long productId;
    private Integer availableStock;
    private Integer reservedStock;
}
