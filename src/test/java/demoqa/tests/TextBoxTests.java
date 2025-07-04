package demoqa.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import demoqa.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("selenoid")
public class TextBoxTests {

//    @BeforeAll
//    static void beforeAll() throws MalformedURLException {
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "128.0";
////        Configuration.holdBrowserOpen = true;
//        Configuration.timeout = 10000;
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.remote = "http://localhost:4444/wd/hub";
//    }

    static WebDriver driver;

    @BeforeAll
    public static void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    @Test
    void fillFormTest() {
        open("/text-box");

        $(".text-center").shouldHave(text("Text Box"));

        $("#userName").setValue("Andrew Pridankin");
        $("#userEmail").setValue("pridankin@gmail.com");
        $("#currentAddress").setValue("Ulitsa moya 5/3");
        $("#permanentAddress").setValue("Ulitsa moya 5/3");

        $("#submit").click();
    }

    @Test
    void homeworkFillFormTest() {
        open("/automation-practice-form");

        $(".text-center").shouldHave(text("Practice Form"));

        // убирает рекламу
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Andrew");
        $("#lastName").setValue("Pridankin");
        $("#userEmail").setValue("pridankin@gmail.com");

        // Проверка выбора пола по радио-кнопке
        $("label[for=gender-radio-1]").click();
//        $("#gender-radio-1").parent().click();   // то же самое, что и строка выше

        // Проверка ввода номера телефона
        $("#userNumber").setValue("9930106544");

        // Проверка для поля ввода даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2025");
        // :not() — чтобы, например, не кликнул 30 число прошлого месяца
        $(".react-datepicker__day--017:not(.react-datepicker__day--outside-month)").click();

        // Проверка выбора предметов (автозаполнение)
        $("#subjectsInput").setValue("Maths").pressEnter();

        // Проверка выбора хобби по чекбоксам
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-3]").click();

        // Проверка загрузки изображения

        $("#uploadPicture").uploadFromClasspath("img/image.png");

        // Проверка поля ввоода адреса
        $("#currentAddress").setValue("Kotovskogo 5/3");

        // Проверка для выбора штата и города через селектор (не классический селектор, созданный через div)
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        // Клик по кнопке
        $("#submit").click();

        // Проверка прохождения текста (появление модального окна)
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    void pageObjectsTest() {
        RegistrationPage registrationPage = new RegistrationPage();

        String userName = "Andrew";
        String lastName = "Pridankin";
        String userEmail = "pridankin@gmail.com";

        registrationPage
                .openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setPhoneNumber("9930106544")
                .setBirthDate("17", "April", "2025")
                .setSubject("Maths")
                .setHobbies()
                .setPicture("img/image.png")
                .setAddress("Kotovskogo 5/3")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

        registrationPage
                .verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName);
    }
}
