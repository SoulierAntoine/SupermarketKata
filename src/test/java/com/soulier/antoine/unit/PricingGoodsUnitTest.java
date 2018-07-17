package com.soulier.antoine.unit;

import com.soulier.antoine.model.Client;
import com.soulier.antoine.model.Product;
import com.soulier.antoine.model.strategy.impl.FixPriceStrategy;
import com.soulier.antoine.model.strategy.impl.SeveralPurchaseFreeStrategy;
import com.soulier.antoine.model.strategy.impl.WeightStrategy;
import com.soulier.antoine.model.strategy.impl.SeveralPurchaseReductionStrategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * PricingGoodsUnitTest - supermarket-kata
 * Created by soulierantoine on 17/07/2018
 */
public class PricingGoodsUnitTest {

    @Test
    public void fixPrice() {

        // Given
        Product p = new Product("apple", 0.5F);
        p.setPricingStrategy(new FixPriceStrategy(1.00F));
        Client c = new Client();

        // When
        c.purchase(p, 10);

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
        c.purchase(p, 10);

        // Then
        Assert.assertEquals(7.5, c.getDebt(), 0.0);
    }

    @Test
    public void severalPurchaseGivesReduction() {

        // Given
        Product p = new Product("apple", 0.5F);
        p.setPricingStrategy(new SeveralPurchaseReductionStrategy());
        Client c = new Client();

        // When
        c.purchase(p, 3);

        // Then
        Assert.assertEquals(2.5, c.getDebt(), 0.0);
    }

    @Test
    public void severalPurchaseGivesFreeProduct() {

        // Given
        Product p = new Product("apple", 0.5F);
        p.setPricingStrategy(new SeveralPurchaseFreeStrategy());
        Client c = new Client();

        // When
        c.purchase(p, 3);

        // Then
        Assert.assertEquals(2.0, c.getDebt(), 0.0);
    }
}
