package core;

import model.Article;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public List<Article> getFirstFiveArticles(List<WebElement> articles, By title, By comments) {

        List<Article> firstFiveArticles = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            Article article = new Article();
            WebElement webElement = articles.get(i);

            Assert.assertFalse("Title for the article Nr. " + (i + 1) + " is not presented.",
                    webElement.findElements(title).isEmpty());
            article.setTitle(webElement.findElement(title).getText());
            article.setArticleLink(webElement.findElement(title).getAttribute("href"));

            if(webElement.findElements(comments).isEmpty()) {
                article.setCommentCount(0);
                article.setCommentLink(null);
            } else {
                WebElement commentCount = webElement.findElement(comments);
                article.setCommentCount(convertStringCommentsToInteger(commentCount.getText()));
                article.setCommentLink(commentCount.getAttribute("href"));
            }
            firstFiveArticles.add(article);
        }

        return firstFiveArticles;
    }

    public Integer convertStringCommentsToInteger(String comments) {
        return Integer.valueOf(comments.substring(1, comments.length() - 1));
    }

}
