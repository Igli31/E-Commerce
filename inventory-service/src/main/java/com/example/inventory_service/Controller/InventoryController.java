package com.example.inventory_service.Controller;

import com.example.inventory_service.DTO.InventoryDTO;
import com.example.inventory_service.DTO.ProductDTO;
import com.example.inventory_service.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    ResponseEntity<InventoryDTO> createInventory(@RequestBody InventoryDTO inventoryDTO){
        InventoryDTO inventoryDTO1 = inventoryService.createInventory(inventoryDTO);
        return new ResponseEntity<>(inventoryDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<InventoryDTO> getInventoryById(@PathVariable Long id){
        InventoryDTO inventoryDTO = inventoryService.getInventoryById(id);
        return new ResponseEntity<>(inventoryDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    ResponseEntity<List<InventoryDTO>> getAllInventories(){
        List<InventoryDTO> inventoryDTOS = inventoryService.getAllInventories();
        return new ResponseEntity<>(inventoryDTOS, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<InventoryDTO> updateInventory(@PathVariable Long id, @RequestBody InventoryDTO inventoryDTO){
        InventoryDTO updatedInventory = inventoryService.updateInventory(id, inventoryDTO);
        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteInventoryById(@PathVariable Long id){
        inventoryService.delteInventoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return inventoryService.getProductById(id);
    }

    @GetMapping("/checkAvailability/{productId}")
    ResponseEntity<Boolean> isProductAvailable(@PathVariable Long productId, @RequestParam int requestedAmount){
        boolean isAvailable = inventoryService.isProductAvailable(productId, requestedAmount);
        return new ResponseEntity<>(isAvailable, HttpStatus.OK);
    }

    @GetMapping("/checkAvailability/{productName}/requestedAmount")
    ResponseEntity<Boolean> isProductAvailableByName(@PathVariable String productName, @PathVariable int requestedAmount){
        boolean isAvailable = inventoryService.isProductAvailableByName(productName, requestedAmount);
        return new ResponseEntity<>(isAvailable, HttpStatus.OK);
    }
}
