package com.soulier.antoine.model;


import com.soulier.antoine.model.strategy.IPricingStrategy;
import lombok.Getter;
import lombok.Setter;

/**
 * Product - supermarket-kata
 * Created by soulierantoine on 16/07/2018
 */

@Getter
@Setter
public class Product {

    private String name;
    private float weight;
    private IPricingStrategy pricingStrategy;

    public Product(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public Product() {
        this.name = "";
        this.weight = 0.0F;
    }

    public float getPrice() throws Exception {

        if (pricingStrategy == null) {
            throw new Exception("You have to set a pricing strategy first.");
        }
        return pricingStrategy.getProductPrice();
    }
}
