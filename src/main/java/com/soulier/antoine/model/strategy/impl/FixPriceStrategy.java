package com.soulier.antoine.model.strategy.impl;

import com.soulier.antoine.model.strategy.IPricingStrategy;

/**
 * FixPriceStrategy - supermarket-kata
 * Created by soulierantoine on 17/07/2018
 */
public class FixPriceStrategy implements IPricingStrategy {

    private float price;

    public FixPriceStrategy(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
