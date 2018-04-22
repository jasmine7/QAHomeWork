package qaGuruTicketsTest;

import core.BaseFunctions;
import core.qaGuruTickets.HomePage;
import core.qaGuruTickets.ReservationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ReservationTest {

    private BaseFunctions baseFunctions = new BaseFunctions();
    private static final Logger LOGGER = LogManager.getLogger(ReservationTest.class);
    private static final String URL = "http://www.qaguru.lv/tickets/";

    @Test
    public void makeReservationTest() {
        LOGGER.info("We are opening http://www.qaguru.lv/tickets/ home page");
        baseFunctions.goToUrl(URL);

        HomePage homePage = new HomePage(baseFunctions);

        LOGGER.info("We are choosing departure airport.");
        homePage.chooseDepartureAirport("RIX");
        LOGGER.info("We are choosing arrival airport.");
        homePage.chooseArrivalAirport("JFC");
        LOGGER.info("We are going to the next reservation step.");
        homePage.goToNextReservationStep();

        LOGGER.info("We are opening reservation page.");
        ReservationPage reservationPage = new ReservationPage(baseFunctions);

        LOGGER.info("We insert name.");
        reservationPage.insertName("John");

        LOGGER.info("We insert surname.");
        reservationPage.insertSurname("Smith");

        LOGGER.info("We insert discount code.");
        reservationPage.insertDiscountCode("Code123");

        LOGGER.info("We insert adults count.");
        reservationPage.insertAdultsCount("2");

        LOGGER.info("We insert children count.");
        reservationPage.insertChildrenCount("1");

        LOGGER.info("We insert luggage count.");
        reservationPage.insertLuggageCount("2");

        LOGGER.info("We choose flight date.");
        reservationPage.chooseFlightDate("13-05-2018");

        LOGGER.info("We get flight price.");
        reservationPage.clickGetPriceButton();

        LOGGER.info("We click on the Book! button.");
        reservationPage.clickBookButton();

        LOGGER.info("We choose seat Nr. 13.");
        reservationPage.chooseSeat();

        LOGGER.info("We finish reservation.");
        reservationPage.clickBookButton();
    }
}
