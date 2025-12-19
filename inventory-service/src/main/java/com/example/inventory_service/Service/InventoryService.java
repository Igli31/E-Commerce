package com.example.inventory_service.Service;

import com.example.inventory_service.DTO.InventoryDTO;

import java.util.List;

public interface InventoryService {

    InventoryDTO createInventory(InventoryDTO inventoryDTO);
    InventoryDTO getInventoryById(Long id);
    List<InventoryDTO> getAllInventories();
    InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO);
    void delteInventoryById(Long id);
}
