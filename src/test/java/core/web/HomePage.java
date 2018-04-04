package core.web;

import core.BaseFunctions;
import core.Helpers;
import model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HomePage {
    private BaseFunctions baseFunctions;
    private Helpers helpers = new Helpers();

    private static final By ARTICLE = By.xpath(".//h3[@class='top2012-title']");
    private static final By TITLE = By.xpath(".//a[@class='top2012-title']");
    private static final By COMMENTS = By.xpath(".//a[@class='comment-count']");

    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public List<WebElement> getAllArticles() {
        return baseFunctions.findElements(ARTICLE);
    }

    public List<String> getAllArticleTitles() {
        List<WebElement> articles = getAllArticles();
        assertFalse("Article list on the main page of the web version is empty.", articles.isEmpty());

        List<String> articleTitles = new ArrayList<>();
        for (WebElement article : articles) {
            articleTitles.add(article.findElement(TITLE).getText());
        }
        return articleTitles;
    }

    public List<Article> getFirstFiveArticles() {
        List<WebElement> articles = getAllArticles();
        assertFalse("Article list on the main page of the web version is empty.", articles.isEmpty());

        return helpers.getFirstFiveArticles(articles, TITLE, COMMENTS);
    }

}
