package com.mowitmow.integration;

import static org.junit.Assert.assertEquals;

import com.mowitmow.service.TendeuseManagerService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TendeuseManagerServiceIntegrationSteps {
    private TendeuseManagerService tendeuseManagerService;
    private String resultat;

    @Given("^tendeuse service initié$")
    public void tendeuse_service_initie() throws Throwable {
        tendeuseManagerService = new TendeuseManagerService();
    }

    // @When("^tendeuse service execute \"(.*)\"$")
    // public void tendeuse_service_excute(String instruction) throws Throwable {
    // System.err.println(instruction);
    // resultat = tendeuseManagerService.lancerInstructionEtAfficher(instruction);
    // }
    @When("^tendeuse service execute \"([^\"]*)\"$")
    public void tendeuse_service_execute(String instructions) throws Throwable {
        System.err.println(instructions);
        resultat = tendeuseManagerService.lancerInstructionEtAfficher(instructions);
    }

    @Then("^le resultat doit être \"([^\"]*)\"$")
    public void le_resultat_doit_etre(String resultatAttendu) throws Throwable {
        assertEquals(resultatAttendu, resultat);
    }
}
