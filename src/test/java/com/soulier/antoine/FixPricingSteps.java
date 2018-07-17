package com.soulier.antoine;

import com.soulier.antoine.model.Client;
import com.soulier.antoine.model.Product;
import com.soulier.antoine.model.strategy.FixPriceStrategy;
import cucumber.api.java8.En;
import org.junit.Assert;

/**
 * FixPricingSteps - supermarket-kata
 * Created by soulierantoine on 16/07/2018
 */

public class FixPricingSteps implements En {

    private Product product;
    private Client client;

    public FixPricingSteps() {

        Given("^I have a product costing (.+) USD$", (Float arg) -> {
            product = new Product();
            product.setPricingStrategy(new FixPriceStrategy(arg));
            client = new Client();
        });

        When("^a client purchase (\\d+) product$", (Integer arg) -> client.purchase(product, arg));

        Then("^he pays (.+) USD$", (Float arg) -> Assert.assertEquals(client.getDebt(), arg, 0.0));
    }
}
