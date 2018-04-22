package cucumberStepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.ReservationResponse;
import requester.ReservationRequester;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ReservationTestStepDefs {

    private List<ReservationResponse> responses = new ArrayList<>();
    private ReservationRequester requester = new ReservationRequester();
    private ReservationResponse response;

    @When("we are requesting reservations")
    public void get_reservation_result() throws IOException {
        responses = requester.getReservations();

    }

    @Then("reservation id should be (.*)")
    public void get_reservation_with_certain_id(Long id) {
        Boolean isReservationIdPresented = false;
        for(int i = 0; i < responses.size(); i++) {
            response = responses.get(i);
            if(response.getId().equals(id)) {
                isReservationIdPresented = true;
                break;
            }
        }
        assertTrue("There isn't reservation with id " + id, isReservationIdPresented);
    }


    @Then("name should be (.*)")
    public void check_name(String name) {
        assertEquals("Wrong name: ", name, response.getName());
    }

    @Then("surname should be (.*)")
    public void check_surname(String surname) {
        assertEquals("Wrong surname: ", surname, response.getSurname());
    }

    @Then("departure airport should be (.*)")
    public void check_departure_airport(String afrom) {
        assertEquals("Wrong departure airport: ", afrom, response.getAfrom());
    }

    @Then("arrival airport should be (.*)")
    public void check_arrival_airport(String ato) {
        assertEquals("Wrong arrival airport: ", ato, response.getAto());
    }

    @Then("discount code should be (.*)")
    public void check_discount_code(String discount) {
        assertEquals("Wrong discount code: ", discount, response.getDiscount());
    }

    @Then("adults count should be (.*)")
    public void check_adults_count(Integer adults) {
        assertEquals("Wrong adults count: ", adults, response.getAdults());
    }

    @Then("children count should be (.*)")
    public void check_children_count(Integer children) {
        assertEquals("Wrong children count: ", children, response.getChildren());
    }

    @Then("luggage count should be (.*)")
    public void check_luggge_count(Integer bugs) {
        assertEquals("Wrong luggage count: ", bugs, response.getBugs());
    }

    @Then("flight date should be (.*)")
    public void check_flight_date(String flight) {
        assertEquals("Wrong flight date: ", flight, response.getFlight());
    }

    @Then("seat number should be (.*)")
    public void check_seat_number(Integer seat) {
        assertEquals("Wrong seat number: ", seat, response.getSeat());
    }
}
