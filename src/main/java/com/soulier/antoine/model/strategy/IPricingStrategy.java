package com.soulier.antoine.model.strategy;


import lombok.Getter;
import lombok.Setter;

/**
 * IPricingStrategy - supermarket-kata
 * Created by soulierantoine on 16/07/2018
 */

@Getter
@Setter
public abstract class IPricingStrategy {

    protected int quantity = 0;

    public abstract float getProductPrice();
}
