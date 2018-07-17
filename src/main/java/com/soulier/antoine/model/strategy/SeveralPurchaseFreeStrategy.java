package com.soulier.antoine.model.strategy;

/**
 * SeveralPurchaseFreeStrategy - supermarket-kata
 * Created by soulierantoine on 17/07/2018
 */

public class SeveralPurchaseFreeStrategy extends IPricingStrategy {

    private float productPrice;
    private float quantityThreshold;
    private int freeProduct;

    public SeveralPurchaseFreeStrategy(float productPrice, int freeProduct, int quantityThreshold) {
        this.productPrice = productPrice;
        this.quantityThreshold = quantityThreshold;
        this.freeProduct = freeProduct;
    }

    @Override
    public float getProductPrice() {
        if (quantity >= quantityThreshold) {
             return ((quantity * productPrice) - (freeProduct * productPrice)) / quantity;
        } else {
            return productPrice;
        }
    }
}
