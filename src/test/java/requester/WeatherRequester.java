package requester;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.weather.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class WeatherRequester {

    private static final String URL =
            "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    public WeatherResponse getWeather() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        String responseToParse = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseToParse, WeatherResponse.class);
    }

}
