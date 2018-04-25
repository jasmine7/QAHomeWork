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
    private ReservationResponse response = new ReservationResponse();

    @When("we are requesting reservations")
    public void get_reservation_result() throws IOException {
        responses = requester.getReservations();
    }

    @When("name is (.*)")
    public void get_name(String name) {
        response.setName(name);
    }

    @When("surname is (.*)")
    public void get_surname(String surname) {
        response.setSurname(surname);
    }

    @When("departure airport is (.*)")
    public void get_departure_airport(String afrom) {
        response.setAfrom(afrom);
    }

    @When("arrival airport is (.*)")
    public void get_arrival_airport(String ato) {
        response.setAto(ato);
    }

    @When("discount code is (.*)")
    public void get_discount_code(String discount) {
        response.setDiscount(discount);
    }

    @When("adults count is (.*)")
    public void get_adults_count(Integer adults) {
        response.setAdults(adults);
    }

    @When("children count is (.*)")
    public void get_children_count(Integer children) {
        response.setChildren(children);
    }

    @When("luggage count is (.*)")
    public void get_luggage_count(Integer bugs) {
        response.setBugs(bugs);
    }

    @When("flight date is (.*)")
    public void get_flight_date(String flight) {
        response.setFlight(flight);
    }

    @When("seat number is (.*)")
    public void get_seat_number(Integer seat) {
        response.setSeat(seat);
    }

    @Then("reservation should be in list")
    public void check_reservation(){
        Boolean isReservationPresented = false;

        for(int i = 0; i < responses.size(); i++) {
            if(responses.get(i).getName().equals(response.getName()) &&
                    responses.get(i).getSurname().equals(response.getSurname()) &&
                    responses.get(i).getAfrom().equals(response.getAfrom()) &&
                    responses.get(i).getAto().equals(response.getAto()) &&
                    responses.get(i).getDiscount().equals(response.getDiscount()) &&
                    responses.get(i).getAdults().equals(response.getAdults()) &&
                    responses.get(i).getChildren().equals(response.getChildren()) &&
                    responses.get(i).getBugs().equals(response.getBugs()) &&
                    responses.get(i).getFlight().equals(response.getFlight()) &&
                    responses.get(i).getSeat().equals(response.getSeat())) {
                isReservationPresented = true;
                break;
            }

        }

        assertTrue("There isn't reservation with that field.", isReservationPresented);
    }
}
