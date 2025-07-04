package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SetValueOptions.withText;

public class SelenideRepositorySearch {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "safari";
        Configuration.browserSize = "1300x900";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://www.github.com");

        $("button.header-search-button")
                .shouldBe(
                        visible,
                        enabled,
                        interactable
                )
                .click();

        // Ввести текст поиска
        $("#query-builder-test").setValue("Selenide").pressEnter();

        // Найдем все элементы списка
//        $$("ul.repo-list li").first().$("a").click();

        $$("[data-testid='results-list']").first().$("a").click();

        // Проверим заголовок
        $("#repository-container-header").shouldHave(text("selenide/selenide"));
    }

    @Test
    public void solntsevShouldBeTopContributor() {
        open("https://www.github.com/selenide/selenide");

        $("a[href='/selenide/selenide/graphs/contributors']")
                .scrollTo()
                .parent()
                .parent()
                .$$("ul li")
                .first()
                .hover();

        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
