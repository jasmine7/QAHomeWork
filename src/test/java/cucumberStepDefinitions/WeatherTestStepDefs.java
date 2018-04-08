package cucumberStepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.WeatherResponse;
import requester.WeatherRequester;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class WeatherTestStepDefs {

    private WeatherResponse response = new WeatherResponse();
    private WeatherRequester requester = new WeatherRequester();


    @When("we are requesting weather")
    public void get_weather_result() throws IOException {
        response = requester.getWeather();
    }

    @Then("LON should be (.*)")
    public void check_lon(BigDecimal lon) {
        assertEquals("Wrong LON: ", lon, response.getCoord().getLon());
    }

    @Then("LAT should (.*)")
    public void check_lat(BigDecimal lat) {
        assertEquals("Wrong LAT: ", lat, response.getCoord().getLat());
    }
}
