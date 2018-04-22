package core.qaGuruTickets;

import core.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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
        baseFunctions.findElement(NAME_FIELD).sendKeys(name);
    }

    public void insertSurname(String surname) {
        baseFunctions.findElement(SURNAME_FIELD).sendKeys(surname);
    }

    public void insertDiscountCode(String discountCode) {
        baseFunctions.findElement(DISCOUNT_CODE_FIELD).sendKeys(discountCode);
    }

    public void insertAdultsCount(String adults) {
        baseFunctions.findElement(ADULTS_FIELD).sendKeys(adults);
    }

    public void insertChildrenCount(String children) {
        baseFunctions.findElement(CHILDREN_FIELD).sendKeys(children);
    }

    public void insertLuggageCount(String luggage) {
        baseFunctions.findElement(LUGGAGE_FIELD).sendKeys(luggage);
    }

    public void chooseFlightDate(String date) {
        Select dropdown = new Select(baseFunctions.findElement(FLIGHT_DROPDOWN));
        dropdown.selectByVisibleText(date);
    }

    public void clickGetPriceButton() {
        baseFunctions.findElement(GET_PRICE_BUTTON).click();
    }

    public void clickBookButton() {
        baseFunctions.findElement(BOOK_BUTTON).click();
    }

    public void chooseSeat() {
        baseFunctions.findElement(SEAT_13).click();
    }
}
