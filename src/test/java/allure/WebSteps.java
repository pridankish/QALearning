package allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Проверяем работоспособность кнопки регистрации")
    public void checkingSignUpButton(String repo) {
        $(withText("Sign up")).click();
    }
}
