package core.qaGuruTickets;

import core.BaseFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class HomePage {

    private BaseFunctions baseFunctions;
    private static final By DEPARTURE_AIRPORTS_DROPDOWN = By.xpath(".//select[@id='afrom']");
    private static final By ARRIVAL_AIRPORTS_DROPDOWN = By.xpath(".//select[@id='bfrom']");
    private static final By GO_BUTTON = By.xpath(".//span[@class='gogogo']");


    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void chooseDepartureAirport(String departureAirport) {
        assertFalse("There isn't dropdown menu for departure airport.",
                baseFunctions.findElements(DEPARTURE_AIRPORTS_DROPDOWN).isEmpty());
        Select dropdown = new Select(baseFunctions.findElement(DEPARTURE_AIRPORTS_DROPDOWN));
        dropdown.selectByVisibleText(departureAirport);
    }

    public void chooseArrivalAirport(String arrivalAirport) {
        assertFalse("There isn't dropdown menu for arrival airport.",
                baseFunctions.findElements(ARRIVAL_AIRPORTS_DROPDOWN).isEmpty());
        Select dropdown = new Select(baseFunctions.findElement(ARRIVAL_AIRPORTS_DROPDOWN));
        dropdown.selectByVisibleText(arrivalAirport);
    }

    public void goToNextReservationStep() {
        assertFalse("Go button isn't presented on the home page.",
                baseFunctions.findElements(GO_BUTTON).isEmpty());
        baseFunctions.findElement(GO_BUTTON).click();
    }
}
