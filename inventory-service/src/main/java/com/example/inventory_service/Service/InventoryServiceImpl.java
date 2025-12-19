package com.example.inventory_service.Service;

import com.example.inventory_service.DTO.InventoryDTO;
import com.example.inventory_service.Entity.Inventory;
import com.example.inventory_service.Repository.InventoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = modelMapper.map(inventoryDTO, Inventory.class);
        Inventory createdInventory = inventoryRepository.save(inventory);
        return modelMapper.map(createdInventory, InventoryDTO.class);
    }

    @Override
    public InventoryDTO getInventoryById(Long id) {
        Inventory inventory = inventoryRepository.findById(id).get();
        return modelMapper.map(inventory, InventoryDTO.class);
    }

    @Override
    public List<InventoryDTO> getAllInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream()
                .map(inventory -> modelMapper.map(inventory, InventoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) {
        Inventory existingInventory = inventoryRepository.findById(id).get();
        modelMapper.map(inventoryDTO, existingInventory);
        Inventory updatedInventory = inventoryRepository.save(existingInventory);
        return modelMapper.map(updatedInventory, InventoryDTO.class);
    }

    @Override
    public void delteInventoryById(Long id) {
        inventoryRepository.deleteById(id);
    }
}
