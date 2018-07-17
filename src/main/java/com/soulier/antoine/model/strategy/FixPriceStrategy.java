package com.soulier.antoine.model.strategy;

/**
 * FixPriceStrategy - supermarket-kata
 * Created by soulierantoine on 17/07/2018
 */
public class FixPriceStrategy extends IPricingStrategy {

    private float price;

    public FixPriceStrategy(float price) {
        this.price = price;
    }

    @Override
    public float getProductPrice() {
        return price;
    }
}
