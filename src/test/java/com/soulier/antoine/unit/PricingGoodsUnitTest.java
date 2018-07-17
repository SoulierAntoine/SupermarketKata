package com.soulier.antoine.unit;

import com.soulier.antoine.model.Client;
import com.soulier.antoine.model.Product;
import com.soulier.antoine.model.strategy.FixPriceStrategy;
import com.soulier.antoine.model.strategy.SeveralPurchaseFreeStrategy;
import com.soulier.antoine.model.strategy.SeveralPurchaseReductionStrategy;
import com.soulier.antoine.model.strategy.WeightStrategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * PricingGoodsUnitTest - supermarket-kata
 * Created by soulierantoine on 17/07/2018
 */
public class PricingGoodsUnitTest {

    @Test(expected = Exception.class)
    public void noPricingStrategy() throws Exception {
        // Given
        Product p = new Product("apple", 0.5F);
        Client c = new Client();

        // When
        c.purchase(p, 10);

        // Then an exception has been thrown
    }

    @Test
    public void fixPrice() {

        // Given
        Product p = new Product("apple", 0.5F);
        p.setPricingStrategy(new FixPriceStrategy(1.00F));
        Client c = new Client();

        // When
        try {
            c.purchase(p, 10);
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }

        // Then
        Assert.assertEquals(10.0, c.getDebt(), 0.0);
    }

    @Test
    public void priceDependsOnWeight() {

        // Given
        Product p = new Product("apple", 0.5F);
        p.setPricingStrategy(new WeightStrategy(p.getWeight(), 1.5F));
        Client c = new Client();

        // When
        try {
            c.purchase(p, 10);
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }

        // Then
        Assert.assertEquals(7.5, c.getDebt(), 0.0);
    }

    @Test
    public void severalPurchaseGivesReduction() {

        // Given
        Product p = new Product("apple", 0.5F);
        p.setPricingStrategy(new SeveralPurchaseReductionStrategy(10.0F, 1.0F, 3));
        Client c = new Client();

        // When
        try {
            c.purchase(p, 3);
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }

        // Then
        Assert.assertEquals(2.7, c.getDebt(), 0.1);
    }

    @Test
    public void severalPurchaseGivesFreeProduct() {

        // Given
        Product p = new Product("apple", 0.5F);
        p.setPricingStrategy(new SeveralPurchaseFreeStrategy(1.0F, 1, 3));
        Client c = new Client();

        // When
        try {
            c.purchase(p, 3);
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }

        // Then
        Assert.assertEquals(2.0, c.getDebt(), 0.0);
    }
}
