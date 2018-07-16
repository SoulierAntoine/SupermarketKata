package com.soulier.antoine;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * FixPricingSteps - supermarket-kata
 * Created by soulierantoine on 16/07/2018
 */

public class FixPricingSteps implements En {
    public FixPricingSteps() {
        Given("^I have a product costing \$(\\d+).(\\d+)$", (Float arg) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        Then("^a client purchase (\\d+) product$", (Integer arg) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        When("^he pays \$(\\d+).(\\d+)$", (Float arg) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
