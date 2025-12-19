package com.example.inventory_service.Service;

import com.example.inventory_service.DTO.InventoryDTO;
import com.example.inventory_service.DTO.ProductDTO;

import java.util.List;

public interface InventoryService {

    InventoryDTO createInventory(InventoryDTO inventoryDTO);
    InventoryDTO getInventoryById(Long id);
    List<InventoryDTO> getAllInventories();
    InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO);
    void delteInventoryById(Long id);
    ProductDTO getProductById(Long productId);
    boolean isProductAvailable(Long productId, int requestedAmount);
}
