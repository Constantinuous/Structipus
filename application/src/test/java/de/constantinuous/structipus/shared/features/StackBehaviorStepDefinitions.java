package de.constantinuous.structipus.shared.features;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by RichardG on 14.01.2016.
 */
public class StackBehaviorStepDefinitions {

    @Steps
    private StackSteps stackSteps;


    @Given("I have an empty stack")
    public void givenIHaveAnEmptyStack() { stackSteps.create_an_empty_stack(); }

    @When("I push an item '$item'")
    public void whenIPushAnItem(String item) { stackSteps.push_an_item(item); }

    @When("I pop the stack")
    public void whenIPopAnItem() { stackSteps.pop_an_item(); }

    @Then("I should count $expected")
    public void thenIShouldCount(@Named("expected") int expected) {
        stackSteps.count_should_be(expected);
    }
}
