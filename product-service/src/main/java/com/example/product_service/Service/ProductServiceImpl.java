package com.example.product_service.Service;

import com.example.product_service.DTO.ProductDTO;
import com.example.product_service.Entity.Product;
import com.example.product_service.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product createdProduct = productRepository.save(product);
        return modelMapper.map(createdProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).get();
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id).get();
        modelMapper.map(productDTO, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
