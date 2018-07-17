package com.soulier.antoine.model.strategy;

import lombok.Getter;
import lombok.Setter;

/**
 * WeightStrategy - supermarket-kata
 * Created by soulierantoine on 17/07/2018
 */

@Getter
@Setter
public class WeightStrategy extends IPricingStrategy {

    private float pricePerOunce;
    private float productWeight;

    public WeightStrategy(float weight, float pricePerOunce) {
        this.productWeight = weight;
        this.pricePerOunce = pricePerOunce;
    }

    @Override
    public float getProductPrice() {
        return productWeight * pricePerOunce;
    }
}
