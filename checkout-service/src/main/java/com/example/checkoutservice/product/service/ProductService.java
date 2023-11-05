package com.example.checkoutservice.product.service;

import com.example.checkoutservice.product.dto.Product;
import com.example.checkoutservice.product.service.interfa.IProductService;
import com.example.checkoutservice.repository.FeignProductRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ProductService  implements IProductService {

    private FeignProductRepository feignProductRepository; // cliente
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(FeignProductRepository feignProductRepository) {
        this.feignProductRepository = feignProductRepository;
    }



    @Override
    @CircuitBreaker(name="product",fallbackMethod = "getProductFallBackMethod" ) // este es el metodo que se ejecuta cuando se comunica con producto
    @Retry(name = "product") // aca configuramos el numero de reintentos
    public Product getProduct(String id) {
        logger.info("intentando obtener el producto con id " + id);
        return feignProductRepository.getProductById(id,true);
    }

    // este metodo tiene que tener la misma firma en donde esta aplicado el @circuitBeaker, ya que va a ser quien remplaza al metodo cuando esta open
    //CallNotPermittedException es la expcion que arroja el circuid cuando esta en estado open
    public Product getProductFallBackMethod(String id, CallNotPermittedException exception){
        logger.error("Circuit brearker en estado OPEN");
        return new Product();


    }


}

