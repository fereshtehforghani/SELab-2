package calculator;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value;
    private double result;

    @Before
    public void before() {
        calculator = new Calculator();
    }
    @Given("^One input value (\\d+) and operator rvs$")
    public void oneInputValueAndOperatorRvs(int arg0) {
        value = arg0;
    }

    @Given("^One input value -(\\d+) and operator rvs$")
    public void one_input_value_and_operator_rvs(int arg1) {
        value = -1 * arg1;
    }

    @When("^I reverse the value$")
    public void iReverseTheValue() throws Exception{
        result = calculator.rvs(value);
        System.out.println(result);
    }

    @Then("^I expect the result (\\d+)\\.(\\d+)$")
    public void iExpectTheResult(int arg0, int arg1) {
        int numdigits = String.valueOf(arg1).length();
        double a = arg0 + Math.pow(10, -1 * numdigits) * arg1;
        Assert.assertEquals(a, result, 0.0001);
    }

    @Then("^I expect the result -(\\d+)\\.(\\d+)$")
    public void i_expect_the_result(int arg1, int arg2) {
        int numdigits = String.valueOf(arg2).length();
        double a = arg1 - Math.pow(10, -1 * numdigits) * arg2;
        Assert.assertEquals(a, result, 0.0001);
    }

    @Then("^I expect the result (\\d+)$")
    public void i_expect_the_result(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
