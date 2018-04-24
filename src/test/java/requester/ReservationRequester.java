package requester;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ReservationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class ReservationRequester {

    private static final String URL = "http://www.qaguru.lv/tickets/getReservations.php";

    public List<ReservationResponse> getReservations() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        String responseToParse = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseToParse, new TypeReference<List<ReservationResponse>>(){});
    }

}
