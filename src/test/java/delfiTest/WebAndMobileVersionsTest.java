package delfiTest;

import core.BaseFunctions;
import model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * This test compares the first five articles on the web version of the page with the first five articles on
 * the mobile version of the page.
 * Article title and number of comments are have to be checked on the main page, article page and comment page.
 */

public class WebAndMobileVersionsTest {
    private BaseFunctions baseFunctions = new BaseFunctions();
    private static final Logger LOGGER = LogManager.getLogger(WebAndMobileVersionsTest.class);
    private static final String WEB_MAIN_PAGE_URL = "http://rus.delfi.lv";
    private static final String MOBILE_MAIN_PAGE_URL = "http://m.rus.delfi.lv";

    @Test
    public void FirstFiveArticlesTest() {

        LOGGER.info("We are opening http://rus.delfi.lv main page.");
        baseFunctions.goToUrl(WEB_MAIN_PAGE_URL);

        core.web.HomePage webHomePage = new core.web.HomePage(baseFunctions);

        LOGGER.info("We are receiving the first five articles on the web version.");
        List<Article> firstFiveWebArticles = webHomePage.getFirstFiveArticles();

        LOGGER.info("We are opening http://m.rus.delfi.lv main page.");
        baseFunctions.goToUrl(MOBILE_MAIN_PAGE_URL);

        core.mobile.HomePage mobileHomePage = new core.mobile.HomePage(baseFunctions);

        LOGGER.info("We are receiving the first five articles on the mobile version.");
        List<Article> firstFiveMobileArticles = mobileHomePage.getFirstFiveArticles();

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
            baseFunctions.goToUrl(firstFiveWebArticles.get(i).getArticleLink());

            core.web.ArticlePage webArticlePage = new core.web.ArticlePage(baseFunctions);

            assertTrue("Article title on the article page Nr. " + (i + 1) +
                            " of the web version doesn't match with the article title on the main page.",
                    firstFiveWebArticles.get(i).getTitle()
                            .equals(webArticlePage.getArticleTitle()));

            assertTrue("Comment count on the article page Nr. " + (i + 1) +
                            " of the web version doesn't match with comment count on the main page.",
                    firstFiveWebArticles.get(i).getCommentCount()
                            .equals(webArticlePage.getArticleComments()));

            LOGGER.info("We are opening the article page Nr. " + (i + 1) + " of the mobile version.");
            baseFunctions.goToUrl(firstFiveMobileArticles.get(i).getArticleLink());

            core.mobile.ArticlePage mobileArticlePage = new core.mobile.ArticlePage(baseFunctions);

            assertTrue("Article title on the article page Nr. " + (i + 1) +
                            " of the mobile version doesn't match with the article title on the main page.",
                    firstFiveMobileArticles.get(i).getTitle()
                            .equals(mobileArticlePage.getArticleTitle()));

            assertTrue("Comment count on the article page Nr. " + (i + 1) +
                            " of the mobile version doesn't match with comment count on the main page.",
                    firstFiveMobileArticles.get(i).getCommentCount()
                            .equals(mobileArticlePage.getArticleComments()));

            if(firstFiveWebArticles.get(i).getCommentLink() != null) {
                LOGGER.info("We are opening the comment page for the article Nr. " + (i + 1) + " of the web version.");
                baseFunctions.goToUrl(firstFiveWebArticles.get(i).getCommentLink());

                core.web.CommentsPage webCommentPage = new core.web.CommentsPage(baseFunctions);

                assertTrue("Article title on the comment page Nr. " + (i + 1) +
                                " of the web version doesn't match with the article title on the main page.",
                        firstFiveWebArticles.get(i).getTitle()
                                .equals(webCommentPage.getArticleTitle()));

                assertTrue("Comment count on the comment page for the article Nr. " + (i + 1) +
                                " of the web version doesn't match with comment count on the main page.",
                        firstFiveWebArticles.get(i).getCommentCount()
                                .equals(webCommentPage.getCommentCount()));
            } else {
                LOGGER.info("The article Nr. " + (i + 1) + " on the web version doesn't have comments.");
            }

            if(firstFiveMobileArticles.get(i).getCommentLink() != null) {
                LOGGER.info("We are opening the comment page for the article Nr. " + (i + 1) + " of the mobile version.");
                baseFunctions.goToUrl(firstFiveMobileArticles.get(i).getCommentLink());

                core.mobile.CommentsPage mobileCommentPage = new core.mobile.CommentsPage(baseFunctions);

                assertTrue("Article title on the comment page Nr. " + (i + 1) +
                                " of the mobile version doesn't match with the article title on the main page.",
                        firstFiveMobileArticles.get(i).getTitle()
                                .equals(mobileCommentPage.getArticleTitle()));

                assertTrue("Comment count on the comment page for the article Nr. " + (i + 1) +
                                " of the mobile version doesn't match with comment count on the main page.",
                        firstFiveWebArticles.get(i).getCommentCount()
                                .equals(mobileCommentPage.getCommentCount()));
            } else {
                LOGGER.info("The article Nr. " + (i + 1) + " on the mobile version doesn't have comments.");
            }

        }
    }

    @After
    public void closeBrowser() {
        baseFunctions.closeBrowser();
    }

}