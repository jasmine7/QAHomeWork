package cucumberStepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.weather.WeatherResponse;
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

    @Then("city NAME should be (.*)")
    public void check_city_name(String name) {
        assertEquals("Wrong city name: ", name, response.getName());
    }

    @Then("city ID should be (.*)")
    public void check_city_id(Long id) {
        assertEquals("Wrong city id: ", id, response.getId());
    }

    @Then("country should be (.*)")
    public void check_country(String country) {
        assertEquals("Wrong country: ", country, response.getSys().getCountry());
    }

    @Then("max temperature should be greater than min temperature")
    public void compare_max_temp_with_min_temp() {
        assertTrue("Max temperature less than min temperature",
                response.getMain().getTemp_max().compareTo(response.getMain().getTemp_min()) > 0);
    }
}
