package core.web;

import core.BaseFunctions;
import core.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class ArticlePage {
    private BaseFunctions baseFunctions;
    private Helpers helpers = new Helpers();

    private static final By HEADER = By.xpath(".//div[@class='article-title']");
    private static final By TITLE = By.xpath(".//span[@itemprop='headline name']");
    private static final By COMMENTS = By.xpath(".//a[@class='comment-count']");

    public ArticlePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getArticleTitle() {
        List<WebElement> articleTitles = baseFunctions.findElement(HEADER).findElements(TITLE);
        assertFalse("Article title on the article page of the web version is not presented.",
                articleTitles.isEmpty());
        return baseFunctions.findElement(HEADER).findElement(TITLE).getText();
    }

    public Integer getArticleComments() {
        if(baseFunctions.findElement(HEADER).findElements(COMMENTS).isEmpty()) {
            return 0;
        } else {
            return helpers.convertStringCommentsToInteger(baseFunctions
                    .findElement(HEADER).findElement(COMMENTS).getText());
        }
    }
}
