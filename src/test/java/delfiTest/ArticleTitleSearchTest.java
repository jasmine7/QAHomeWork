package delfiTest;

import core.BaseFunctions;
import core.web.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


/**
 * This test checks, that certain article title is presented on the main page.
 */

public class ArticleTitleSearchTest {
    private BaseFunctions baseFunctions = new BaseFunctions();
    private static final Logger LOGGER = LogManager.getLogger(ArticleTitleSearchTest.class);

    private static final String WEB_MAIN_PAGE_URL = "http://rus.delfi.lv";
    private static final String ARTICLE_TITLE = "Министр обороны России заявил об угрозе новой гонки вооружений";

    @Test
    public void webMainPageArticleTitleSearchTest() {
        LOGGER.info("We are opening http://rus.delfi.lv main page.");
        baseFunctions.goToUrl(WEB_MAIN_PAGE_URL);

        HomePage homePage = new HomePage(baseFunctions);

        LOGGER.info("We find all article titles.");
        List<String> articleTitles = homePage.getAllArticleTitles();

        LOGGER.info("Compare all article titles with certain article title.");
        boolean isTitlePresented = false;
        for(String title: articleTitles) {
            if(title.equals(ARTICLE_TITLE)) {
                isTitlePresented = true;
                break;
            }
        }
        Assert.assertTrue("Article title isn't presented on the main page.", isTitlePresented);

        baseFunctions.closeBrowser();
    }

}
