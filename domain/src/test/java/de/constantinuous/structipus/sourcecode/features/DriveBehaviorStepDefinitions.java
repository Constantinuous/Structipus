package de.constantinuous.structipus.sourcecode.features;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by RichardG on 14.01.2016.
 */
public class DriveBehaviorStepDefinitions {

    @Steps
    private PorscheSteps porscheSteps;

    @Given("I have a porsche")
    public void givenIHaveANewPorsche() { porscheSteps.buy_new_porsche(); }

    @When("I put the pedal to the metal")
    public void whenIAccelerateReallyFast() { porscheSteps.accelerate_really_fast(); }

    @Then("I should drive $expected")
    public void thenIShouldCount(int expected) {
        porscheSteps.speed_should_be(expected);
    }
}
