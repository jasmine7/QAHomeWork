package core.qaGuruTickets;

import core.BaseFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class ReservationPage {

    private BaseFunctions baseFunctions;
    private static final By NAME_FIELD = By.xpath(".//input[@id='name']");
    private static final By SURNAME_FIELD = By.xpath(".//input[@id='surname']");
    private static final By DISCOUNT_CODE_FIELD = By.xpath(".//input[@id='discount']");
    private static final By ADULTS_FIELD = By.xpath(".//input[@id='adults']");
    private static final By CHILDREN_FIELD = By.xpath(".//input[@id='children']");
    private static final By LUGGAGE_FIELD = By.xpath(".//input[@id='bugs']");
    private static final By FLIGHT_DROPDOWN = By.xpath(".//select[@id='flight']");
    private static final By GET_PRICE_BUTTON = By.xpath(".//div[@id='fullForm']/span[@style='cursor: pointer;']");
    private static final By BOOK_BUTTON = By.xpath(".//div[@class='infoBox']/span[@style='cursor: pointer;']");
    private static final By SEAT_13 = By. xpath(".//div[text()='13']");

    public ReservationPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void insertName(String name) {
        assertFalse("Field name is not presented on the reservation page.",
                baseFunctions.findElements(NAME_FIELD).isEmpty());
        baseFunctions.findElement(NAME_FIELD).sendKeys(name);
    }

    public void insertSurname(String surname) {
        assertFalse("Surname field is not presented on the reservation page.",
                baseFunctions.findElements(SURNAME_FIELD).isEmpty());
        baseFunctions.findElement(SURNAME_FIELD).sendKeys(surname);
    }

    public void insertDiscountCode(String discountCode) {
        assertFalse("Discount code field is not presented on the reservation page.",
                baseFunctions.findElements(DISCOUNT_CODE_FIELD).isEmpty());
        baseFunctions.findElement(DISCOUNT_CODE_FIELD).sendKeys(discountCode);
    }

    public void insertAdultsCount(String adults) {
        assertFalse("Adults count field is not presented on the reservation page.",
                baseFunctions.findElements(ADULTS_FIELD).isEmpty());
        baseFunctions.findElement(ADULTS_FIELD).sendKeys(adults);
    }

    public void insertChildrenCount(String children) {
        assertFalse("Children count field is not presented on the reservation page.",
                baseFunctions.findElements(CHILDREN_FIELD).isEmpty());
        baseFunctions.findElement(CHILDREN_FIELD).sendKeys(children);
    }

    public void insertLuggageCount(String luggage) {
        assertFalse("Luggage count field is not presented on the reservation page.",
                baseFunctions.findElements(LUGGAGE_FIELD).isEmpty());
        baseFunctions.findElement(LUGGAGE_FIELD).sendKeys(luggage);
    }

    public void chooseFlightDate(String date) {
        assertFalse("Dropdown menu for flight date is not presented on the reservation page.",
                baseFunctions.findElements(FLIGHT_DROPDOWN).isEmpty());
        Select dropdown = new Select(baseFunctions.findElement(FLIGHT_DROPDOWN));
        dropdown.selectByVisibleText(date);
    }

    public void clickGetPriceButton() {
        assertFalse("Get price button is not presented on the reservation page.",
                baseFunctions.findElements(GET_PRICE_BUTTON).isEmpty());
        baseFunctions.findElement(GET_PRICE_BUTTON).click();
    }

    public void clickBookButton() {
        assertFalse("Book button is not presented on the reservation page.",
                baseFunctions.findElements(BOOK_BUTTON).isEmpty());
        baseFunctions.findElement(BOOK_BUTTON).click();
    }

    public void chooseSeat() {
        assertFalse("Button for seat Nr. 13 is not presented on the reservation page.",
                baseFunctions.findElements(SEAT_13).isEmpty());
        baseFunctions.findElement(SEAT_13).click();
    }
}
