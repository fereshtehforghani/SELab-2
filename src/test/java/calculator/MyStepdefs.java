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
    private String exception = "defined";

    @Before
    public void before() {
        calculator = new Calculator();
    }
    @Given("^One input value (\\d+) and operator rvs$")
    public void oneInputValueAndOperatorRvs(int arg0) {
        value = arg0;
    }

    @Given("^One input value (\\d+) and operator sqrt$")
    public void oneInputValueAndOperatorSqrt(int arg0) {
        value = arg0;
    }

    @Given("^One input value -(\\d+) and operator rvs$")
    public void one_input_value_and_operator_rvs(int arg1) {
        value = -1 * arg1;
    }

    @Given("^One input value -(\\d+) and operator sqrt$")
    public void one_input_value_and_operator_sqrt(int arg1) {
        value = -1 * arg1;
    }

    @When("^I reverse the value$")
    public void iReverseTheValue() throws Exception{
        result = calculator.rvs(value);
        if (result == 0){
            exception = "not defined : divide by zero";
            System.out.println(exception);
            return;
        }
        System.out.println(result);
    }

    @When("^I squareroot the value$")
    public void iSquarerootTheValue() throws Exception{
        result = calculator.sqrt(value);
        if (result == -1){
            exception = "not defined : negative number";
            System.out.println(exception);
            return;
        }
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


    @Then("^I expect the sqrt result (\\d+)\\.(\\d+)$")
    public void iExpectTheSqrtResult(int arg0, int arg1) {
        int numdigits = String.valueOf(arg1).length();
        double a = arg0 + Math.pow(10, -1 * numdigits) * arg1;
        Assert.assertEquals(a, result, 0.0001);
    }

//    @Then("^I expect the result (\\d+)$")
//    public void i_expect_the_result(int arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
////        throw new PendingException();
//        Assert.assertEquals(arg1, 0);
//    }
//
//    @Then("^I expect the sqrt result -(\\d+)$")
//    public void i_expect_the_sqrt_result(int arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
////        throw new PendingException();
//        Assert.assertEquals(arg1, -1 * value);
//    }

    @Then("^I expect the result not defined : divide by zero$")
    public void i_expect_the_result_not_defined_divide_by_zero() {
        Assert.assertEquals("not defined : divide by zero", exception);
    }

    @Then("^I expect the sqrt result not defined : negative number$")
    public void i_expect_the_sqrt_result_not_defined_negative_number() {
        Assert.assertEquals("not defined : negative number", exception);
    }
}
