package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class CssXpathExamples {

    @BeforeAll
    static void beforeAll() {
        Configuration.remote = "http://localhost:4444/wd/hub";
    }

    @Test
    void cssXpathExample() {
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");

        $("[id=email]").setValue("1");
        $("#email").setValue("1");

        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1");
    }
}
