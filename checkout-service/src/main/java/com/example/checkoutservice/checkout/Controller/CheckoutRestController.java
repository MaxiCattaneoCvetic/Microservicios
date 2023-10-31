package com.example.checkoutservice.checkout.Controller;

import com.example.checkoutservice.checkout.model.Checkout;
import com.example.checkoutservice.checkout.service.interfac.ICheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutRestController {
    private ICheckoutService iCheckoutService;

    public CheckoutRestController(ICheckoutService iCheckoutService) {
        super();
        this.iCheckoutService = iCheckoutService;
    }


    @GetMapping("/{id}")
    public Checkout getById(@PathVariable String id) {
        Checkout checkout = new Checkout(id);
        return checkout;


    }




    @GetMapping() // este controller recibe un listado de IDs y devuelve una instancia de checkout en json
    //con el requestHeader leemos el header que viene desde el gateway
    public Checkout getCheckout(@RequestParam List<String> productsIds, @RequestHeader("X-Request-from") String requestFrom,@RequestParam() Map<String,String> headers){
        System.out.println("Enviado desde: " + requestFrom);
        if (!requestFrom.equals("gateway") ){
            return null;

        }
        return iCheckoutService.buildCheckout(productsIds);

    }






}
