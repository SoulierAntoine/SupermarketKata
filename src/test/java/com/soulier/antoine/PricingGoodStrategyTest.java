package com.soulier.antoine;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * PricingGoodStrategyTest - supermarket-kata
 * Created by soulierantoine on 17/07/2018
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.soulier.antoine",
        format = { "html:target/cucumber/supermarket.html", "pretty" }
)
public class PricingGoodStrategyTest {
}
