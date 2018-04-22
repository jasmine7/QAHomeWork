package core.qaGuruTickets;

import core.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private BaseFunctions baseFunctions;
    private static final By DEPARTURE_AIRPORTS_DROPDOWN = By.xpath(".//select[@id='afrom']");
    private static final By ARRIVAL_AIRPORTS_DROPDOWN = By.xpath(".//select[@id='bfrom']");
    private static final By GO_BUTTON = By.xpath(".//span[@class='gogogo']");


    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void chooseDepartureAirport(String departureAirport) {
        Select dropdown = new Select(baseFunctions.findElement(DEPARTURE_AIRPORTS_DROPDOWN));
        dropdown.selectByVisibleText(departureAirport);
    }

    public void chooseArrivalAirport(String arrivalAirport) {
        Select dropdown = new Select(baseFunctions.findElement(ARRIVAL_AIRPORTS_DROPDOWN));
        dropdown.selectByVisibleText(arrivalAirport);
    }

    public void goToNextReservationStep() {
        baseFunctions.findElement(GO_BUTTON).click();
    }
}
