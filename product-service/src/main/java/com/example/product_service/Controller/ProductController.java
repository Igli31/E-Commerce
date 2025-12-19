package com.example.product_service.Controller;

import com.example.product_service.DTO.ProductDTO;
import com.example.product_service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.createProduct(productDTO);
        return new ResponseEntity<>(productDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductDTO productDTO = productService.getProductById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDTOS = productService.getAllProducts();
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.updateProduct(id, productDTO);
        return new ResponseEntity<>(productDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getByName/{name}")
    public ProductDTO getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }
}
