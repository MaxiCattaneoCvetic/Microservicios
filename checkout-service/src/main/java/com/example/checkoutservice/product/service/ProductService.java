package com.example.checkoutservice.product.service;

import com.example.checkoutservice.product.dto.Product;
import com.example.checkoutservice.product.service.interfa.IProductService;
import com.example.checkoutservice.repository.FeignProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService  implements IProductService {

    private FeignProductRepository feignProductRepository; // cliente


    public ProductService(FeignProductRepository feignProductRepository) {
        this.feignProductRepository = feignProductRepository;
    }



    @Override
    public Product getProduct(String id) {
        return feignProductRepository.getProductById(id);
    }


}

