package stepdefinitions;

import api.SensorInfoApi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class apiSteps {

    private SensorInfoApi api;

    @When("I call the sensor info API with terminal_id {string} and terminal_ip {string}")
    public void i_call_the_sensor_info_api_with_terminal_id_and_terminal_ip(String terminalId, String terminalIp) {
        api = new SensorInfoApi();
        api.callSensorInfoApi(terminalId, terminalIp);
    }

    @Then("the crontab value should be less than or equal to {string}")
    public void the_crontab_value_should_be_less_than_or_equal_to(String maxCrontabStr) {
        int maxCrontab = Integer.parseInt(maxCrontabStr);
        api.validateCrontab(maxCrontab);
    }

    @Then("the secondary_url should not be empty")
    public void the_secondary_url_should_not_be_empty() {
        api.validateSecondaryUrl();
    }

    @Then("the response message should be {string}")
    public void the_response_message_should_be(String expectedMessage) {
        api.validateMessage(expectedMessage);
    }
}

