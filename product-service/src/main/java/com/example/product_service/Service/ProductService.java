package com.example.product_service.Service;

import com.example.product_service.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProducts();
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProductById(Long id);
}
