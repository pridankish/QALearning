package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = "safari";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Проверяем работоспособность кнопки регистрации", () -> {
            $(withText("Sign up")).click();
        });

//        $("#query-builder-test-leadingvisual-wrap")
//                .shouldBe(visible)
//                .setValue("eroshenkoam/allure-example");
    }

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
    }

    // Лэйблы

    @Test
    @Feature("Issue в репозитории")
    @Story("Создании Issue")
    @Owner("pridankish")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://google.com")
    @DisplayName("Создание Issue для неавторизованного пользователя")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для неавторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создании Issue");
        Allure.label("owner", "pridankish");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://google.com");
    }
}
