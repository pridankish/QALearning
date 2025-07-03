package junit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitSimpleTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "safari";
        open("https://google.com");
    }

    @DisplayName("Демонстрационный тест")
    @Test
    void simpleTest() {
        Assertions.assertTrue(3 > 2);
    }

    @Disabled
    @DisplayName("Демонстрационный тест1")
    @Test
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void simpleTest2() {
        Assertions.assertTrue(3 > 2);
    }

    @CsvSource({
        "Allure testops, https://qameta.io",
        "Selenide, https://selenide.org"
    })
    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче гугла по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void productSiteUrlShouldBePresentInResultsOfSearchInGoogleByProductNameQuery(
            String productName,
            String productUrl
    ) {
        $("[name=q]").setValue(productName).pressEnter();
        $("[id=search]").shouldHave(text(productUrl));
    }

    @ValueSource(strings = {
            "Allure testops",
            "Selenide"
    })
    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче гугла по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void searchResultCountTests(
            String productName
    ) {
        $("[name=q]").setValue(productName).pressEnter();
        $$("div[class=g]").shouldHave(CollectionCondition.sizeGreaterThan(5));
    }
}
