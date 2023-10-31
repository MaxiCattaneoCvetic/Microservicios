package com.example.checkoutservice.checkout.service.interfac;


import com.example.checkoutservice.checkout.model.Checkout;

import java.util.List;

public interface ICheckoutService  {
    public Checkout buildCheckout(List<String> productsId);

}
