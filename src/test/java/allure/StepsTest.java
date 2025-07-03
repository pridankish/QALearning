package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

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
}
