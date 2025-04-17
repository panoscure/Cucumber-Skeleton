package api;

import io.restassured.response.Response;
import org.testng.Assert;
import utils.ConfigReader;
import utils.Logger;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class SensorInfoApi {

    private Response response;

    public void callSensorInfoApi(String terminalId, String terminalIp) {
        String url = ConfigReader.getProperty("get_sensor_info");

        response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("terminal_id", terminalId)
                .formParam("terminal_ip", terminalIp)
                .when()
                .post(url);

        assertNotNull(response, "Response is null");
        assertEquals(response.getStatusCode(), 200, "Unexpected HTTP Status Code");

        Logger.info("Response Body (Pretty):\n" + response.prettyPrint());

    }

    public void validateCrontab(int maxAllowed) {
        Object crontabObj = response.jsonPath().get("crontab");
        try {
            Integer crontab = crontabObj != null ? Integer.parseInt(crontabObj.toString()) : null;
            if (crontab == null) {
                Logger.error("Crontab is null");
                Assert.fail("Crontab is null");
            }
            else {
                assertTrue(crontab <= maxAllowed, "crontab: " + crontab + " > " + maxAllowed);
            }
        }
        catch (NumberFormatException e) {
            Logger.error("Crontab is not a valid number: " + crontabObj);
            Assert.fail("Invalid crontab value: " + crontabObj);
        }
    }

    public void validateSecondaryUrl() {
        String secondaryUrl = response.jsonPath().getString("secondary_url");
        assertNotNull(secondaryUrl, "secondary_url is null");
        assertFalse(secondaryUrl.trim().isEmpty(), "secondary_url is empty");
    }

    public void validateMessage(String expectedMessage) {
        String message = response.jsonPath().getString("message");
        assertEquals(message.trim(), expectedMessage.trim(), "Message does not match");
    }
}
