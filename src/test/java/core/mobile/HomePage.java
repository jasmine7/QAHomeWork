package core.mobile;

import core.BaseFunctions;
import core.Helpers;
import model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class HomePage {
    private BaseFunctions baseFunctions;
    private Helpers helpers = new Helpers();

    private static final By ARTICLE = By.xpath(".//div[@class='md-mosaic-title']");
    private static final By TITLE = By.xpath(".//a[@class='md-scrollpos']");
    private static final By COMMENTS = By.xpath(".//a[@class='commentCount']");

    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public List<WebElement> getAllArticles() {
        return baseFunctions.findElements(ARTICLE);
    }

    public List<Article> getFirstFiveArticles() {
        List<WebElement> articles = getAllArticles();
        assertFalse("Article list on the main page of the web version is empty.", articles.isEmpty());

        return helpers.getFirstFiveArticles(articles, TITLE, COMMENTS);
    }

}
