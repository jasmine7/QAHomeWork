package delfiTest;

import model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


/**
 * This test compares the first five articles on the web version of the page with the first five articles on
 * the mobile version of the page.
 * Article title and number of comments are have to be checked on the main page, article page and comment page.
 */

public class webAndMobileVersionsTest {

    private static final Logger LOGGER = LogManager.getLogger(webAndMobileVersionsTest.class);

    private static final String WEB_MAIN_PAGE_URL = "http://rus.delfi.lv";
    private static final String MOBILE_MAIN_PAGE_URL = "http://m.rus.delfi.lv";

    private static final By WEB_MAIN_PAGE_ARTICLE = By.xpath(".//h3[@class='top2012-title']");
    private static final By WEB_MAIN_PAGE_ARTICLE_TITLE = By.xpath(".//a[@class='top2012-title']");
    private static final By WEB_MAIN_PAGE_ARTICLE_COMMENTS = By.xpath(".//a[@class='comment-count']");

    private static final By MOBILE_MAIN_PAGE_ARTICLE = By.xpath(".//div[@class='md-mosaic-title']");
    private static final By MOBILE_MAIN_PAGE_ARTICLE_TITLE = By.xpath(".//a[@class='md-scrollpos']");
    private static final By MOBILE_MAIN_PAGE_ARTICLE_COMMENTS = By.xpath(".//a[@class='commentCount']");

    private static final By WEB_ARTICLE_PAGE_HEADER = By.xpath(".//div[@class='article-title']");
    private static final By WEB_ARTICLE_PAGE_TITLE = By.xpath(".//span[@itemprop='headline name']");
    private static final By WEB_ARTICLE_PAGE_COMMENTS = By.xpath(".//a[@class='comment-count']");

    private static final By MOBILE_ARTICLE_PAGE_HEADER = By.xpath(".//div[@class='article-title']");
    private static final By MOBILE_ARTICLE_PAGE_TITLE = By.xpath(".//h1");
    private static final By MOBILE_ARTICLE_PAGE_COMMENTS = By.xpath(".//a[@class='commentCount']");

    private static final By WEB_COMMENT_PAGE_TITLE = By.xpath(".//a[@class='comment-main-title-link']");
    private static final By MOBILE_COMMENT_PAGE_TITLE = By.xpath(".//span[@class='text']");

    private static final By COMMENT_PAGE_ANONYMOUS_COMMENTS = By
            .xpath(".//a[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']/span");
    private static final By COMMENT_PAGE_REGISTERED_COMMENTS = By
            .xpath(".//a[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-anon']/span");

    @Test
    public void FirstFiveArticlesTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/svetlana/Documents/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LOGGER.info("We are opening http://rus.delfi.lv main page.");
        driver.get(WEB_MAIN_PAGE_URL);

        List<WebElement> webMainPageArticles = driver
                .findElements(WEB_MAIN_PAGE_ARTICLE);
        assertFalse("Article list on the main page of the web version is empty.",
                webMainPageArticles.isEmpty());

        List<Article> firstFiveWebArticles = getFirstFiveArticles(
                webMainPageArticles,
                WEB_MAIN_PAGE_ARTICLE_TITLE,
                WEB_MAIN_PAGE_ARTICLE_COMMENTS);

        LOGGER.info("We are opening http://m.rus.delfi.lv main page.");
        driver.get(MOBILE_MAIN_PAGE_URL);

        List<WebElement> mobileMainPageArticles = driver
                .findElements(MOBILE_MAIN_PAGE_ARTICLE);
        assertFalse("Article list on the main page of the mobile version is empty.",
                mobileMainPageArticles.isEmpty());

        List<Article> firstFiveMobileArticles = getFirstFiveArticles(
                mobileMainPageArticles,
                MOBILE_MAIN_PAGE_ARTICLE_TITLE,
                MOBILE_MAIN_PAGE_ARTICLE_COMMENTS);

        for(int i = 0; i < 5; i++) {
            LOGGER.info("We are comparing the article title Nr. " + (i + 1));
            assertTrue("The article title Nr. " + (i + 1) + " on the main page did not match.",
                    firstFiveWebArticles.get(i).getTitle()
                            .equals(firstFiveMobileArticles.get(i).getTitle()));
            LOGGER.info("we are comparing the comments for the article Nr. " + (i + 1));
            assertTrue("Comment counts for the article Nr. " + (i + 1) + " on the main page did not match.",
                    firstFiveWebArticles.get(i).getCommentCount()
                            .equals(firstFiveMobileArticles.get(i).getCommentCount()));
        }

        for(int i = 0; i < 5; i++) {
            LOGGER.info("We are opening the article page Nr. " + (i + 1) + " of the web version.");
            driver.get(firstFiveWebArticles.get(i).getArticleLink());

            assertTrue("Article title on the article page Nr. " + (i + 1) +
                            " of the web version doesn't match with the article title on the main page.",
                    firstFiveWebArticles.get(i).getTitle()
                            .equals(driver.findElement(WEB_ARTICLE_PAGE_HEADER)
                                    .findElement(WEB_ARTICLE_PAGE_TITLE).getText()));

            assertTrue("Comment count on the article page Nr. " + (i + 1) +
                            " of the web version doesn't match with comment count on the main page.",
                    firstFiveWebArticles.get(i).getCommentCount()
                            .equals(convertStringCommentsToInteger(driver.findElement(WEB_ARTICLE_PAGE_HEADER)
                                    .findElement(WEB_ARTICLE_PAGE_COMMENTS).getText())));

            LOGGER.info("We are opening the article page Nr. " + (i + 1) + " of the mobile version.");
            driver.get(firstFiveMobileArticles.get(i).getArticleLink());

            assertTrue("Article title on the article page Nr. " + (i + 1) +
                            " of the mobile version doesn't match with the article title on the main page.",
                    firstFiveMobileArticles.get(i).getTitle()
                            .equals(driver.findElement(MOBILE_ARTICLE_PAGE_HEADER)
                                    .findElement(MOBILE_ARTICLE_PAGE_TITLE).getText()));

            assertTrue("Comment count on the article page Nr. " + (i + 1) +
                            " of the mobile version doesn't match with comment count on the main page.",
                    firstFiveMobileArticles.get(i).getCommentCount()
                            .equals(convertStringCommentsToInteger(driver.findElement(MOBILE_ARTICLE_PAGE_HEADER)
                                    .findElement(MOBILE_ARTICLE_PAGE_COMMENTS).getText())));

            LOGGER.info("We are opening the comment page for the article Nr. " + (i + 1) + " of the web version.");
            driver.get(firstFiveWebArticles.get(i).getCommentLink());

            String webCommentPageTitle = driver.findElement(WEB_COMMENT_PAGE_TITLE).getText();

            if(webCommentPageTitle.contains(": коммент")) {
                assertTrue("Article title on the comment page Nr. " + (i + 1) +
                                " of the web version doesn't match with the article title on the main page.",
                        firstFiveWebArticles.get(i).getTitle()
                                .equals(webCommentPageTitle.substring(0,
                                        webCommentPageTitle.indexOf(": коммент"))));
            } else {
                assertTrue("Article title on the comment page Nr. " + (i + 1) +
                                " of the web version doesn't match with the article title on the main page.",
                        firstFiveWebArticles.get(i).getTitle()
                                .equals(webCommentPageTitle));
            }

            Integer webCommentPageComments = convertStringCommentsToInteger(driver
                    .findElement(COMMENT_PAGE_ANONYMOUS_COMMENTS).getText()) +
                    convertStringCommentsToInteger(driver
                            .findElement(COMMENT_PAGE_REGISTERED_COMMENTS).getText());

            assertTrue("Comment count on the comment page for the article Nr. " + (i + 1) +
                            " of the web version doesn't match with comment count on the main page.",
                    firstFiveWebArticles.get(i).getCommentCount()
                            .equals(webCommentPageComments));

            LOGGER.info("We are opening the comment page for the article Nr. " + (i + 1) + " of the mobile version.");
            driver.get(firstFiveMobileArticles.get(i).getCommentLink());

            assertTrue("Article title on the comment page Nr. " + (i + 1) +
                            " of the mobile version doesn't match with the article title on the main page.",
                    firstFiveMobileArticles.get(i).getTitle()
                            .equals(driver.findElement(MOBILE_COMMENT_PAGE_TITLE).getText()));

            Integer mobileCommentPageComments = convertStringCommentsToInteger(driver
                    .findElement(COMMENT_PAGE_ANONYMOUS_COMMENTS).getText()) +
                    convertStringCommentsToInteger(driver
                            .findElement(COMMENT_PAGE_REGISTERED_COMMENTS).getText());

            assertTrue("Comment count on the comment page for the article Nr. " + (i + 1) +
                            " of the mobile version doesn't match with comment count on the main page.",
                    firstFiveWebArticles.get(i).getCommentCount()
                            .equals(mobileCommentPageComments));
        }

        driver.quit();
    }

    private List<Article> getFirstFiveArticles(List<WebElement> articles, By title, By comments) {

        List<Article> firstFiveArticles = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            Article article = new Article();
            WebElement webElement = articles.get(i);

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

    private Integer convertStringCommentsToInteger(String comments) {
        return Integer.valueOf(comments.substring(1, comments.length() - 1));
    }
}