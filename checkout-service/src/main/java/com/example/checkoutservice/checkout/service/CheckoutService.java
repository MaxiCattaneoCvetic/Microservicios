package com.example.checkoutservice.checkout.service;

import com.example.checkoutservice.checkout.model.Checkout;
import com.example.checkoutservice.checkout.service.interfac.ICheckoutService;
import com.example.checkoutservice.product.dto.Product;
import com.example.checkoutservice.product.service.ProductService;
import com.example.checkoutservice.product.service.interfa.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService  implements ICheckoutService {

    private final IProductService iProductService;
    private ProductService productService;

    public CheckoutService(IProductService iProductService) {
        this.iProductService = iProductService;
    }


    @Override
    public Checkout buildCheckout(List<String> productsIds) {
        Double total = 0.0;
        //recorremos el listado de ids y por cada ids envia un getProdcutService y obtiene el producto
        // una vez que tenemos el producto sumamos el precio y armamos el obj
        for (String id : productsIds) {
            Product product = iProductService.getProduct(id);
            System.out.println("Respuesta desde " + product.getInstance());
            total += product.getPrice();

        }
        Checkout checkout = new Checkout("234", "www.dh.com", total.toString(), List.of("credit_card"));

        return checkout;

    }

}




