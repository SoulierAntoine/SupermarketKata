package com.soulier.antoine.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Client - supermarket-kata
 * Created by soulierantoine on 16/07/2018
 */

@Getter
@Setter
public class Client {

    private List<Product> products;
    private float debt;

    public Client() {

        products = new ArrayList<>();
        debt = 0.0F;
    }

    private void purchase(Product product) {

        products.add(product);
        debt += product.getPrice();
    }

    public void purchase(Product product, int quantity) throws Exception {

        if (product.getPricingStrategy() == null) {
            throw new Exception("You have to set a pricing strategy first.");
        }

        product.getPricingStrategy().setQuantity(quantity);
        for (int i = 0; i < quantity; ++i) {
            purchase(product);
        }
    }
}
