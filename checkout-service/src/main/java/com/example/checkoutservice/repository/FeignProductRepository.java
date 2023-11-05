package com.example.checkoutservice.repository;

import com.example.checkoutservice.configuration.LoadBalancerConfiguration;
import com.example.checkoutservice.product.dto.Product;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="product-service") // aca indicamos que es un cliente y al nombre del servicio que nos vamos a comunicar
// @FeignClient(url ="https://localhost:8080") con esto podemos conectarnos a un cliente por medio de una URL
@LoadBalancerClient(value = "stores", configuration = LoadBalancerConfiguration.class)
public interface FeignProductRepository {

    @RequestMapping(method= RequestMethod.GET,value ="/products")    // este path sale del controller de product-service
    Product getProductById(@RequestParam String id, @RequestParam Boolean throwError);

}


