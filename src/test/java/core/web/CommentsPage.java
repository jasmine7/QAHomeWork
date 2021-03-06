package core.web;

import core.BaseFunctions;
import core.Helpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class CommentsPage {
    private BaseFunctions baseFunctions;
    private Helpers helpers = new Helpers();

    private static final By TITLE = By.xpath(".//a[@class='comment-main-title-link']");
    private static final By ANONYMOUS_COMMENTS = By
            .xpath(".//a[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']/span");
    private static final By REGISTERED_COMMENTS = By
            .xpath(".//a[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-anon']/span");

    public CommentsPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getArticleTitle() {
        assertFalse("Article title on the comment page of the web version is not presented.",
                baseFunctions.findElements(TITLE).isEmpty());

        String articleTitle = baseFunctions.findElement(TITLE).getText();

        if(articleTitle.contains(": коммент")) {
            return articleTitle.substring(0, articleTitle.indexOf(": коммент"));
        } else {
            return articleTitle;
        }
    }

    public Integer getCommentCount() {
        return helpers.convertStringCommentsToInteger(baseFunctions.findElement(ANONYMOUS_COMMENTS).getText()) +
                helpers.convertStringCommentsToInteger(baseFunctions.findElement(REGISTERED_COMMENTS).getText());

    }
}
