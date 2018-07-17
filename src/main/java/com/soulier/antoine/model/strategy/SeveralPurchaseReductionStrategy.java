package com.soulier.antoine.model.strategy;


/**
 * SeveralPurchaseReductionStrategy - supermarket-kata
 * Created by soulierantoine on 17/07/2018
 */

public class SeveralPurchaseReductionStrategy extends IPricingStrategy {

    private float reductionPercentage;
    private float productPrice;
    private int quantityThreshold;

    public SeveralPurchaseReductionStrategy(float reductionPercentage, float price, int quantityThreshold) {
        this.reductionPercentage = reductionPercentage;
        this.productPrice = price;
        this.quantityThreshold = quantityThreshold;
    }

    @Override
    public float getProductPrice() {
        if (quantity >= quantityThreshold) {
            return productPrice - ((productPrice * reductionPercentage) / 100);
        } else {
            return this.productPrice;
        }
    }
}
