package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideAllureTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = "safari";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(withText("Search or jump to...")).click();

//        $("#query-builder-test-leadingvisual-wrap")
//                .shouldBe(visible)
//                .setValue("eroshenkoam/allure-example");
    }
}
