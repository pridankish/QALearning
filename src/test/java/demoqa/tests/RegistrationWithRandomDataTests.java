package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class RegistrationWithRandomDataTests extends TestData {
    Faker faker = new Faker(new Locale("ru"));

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "safari";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "http://localhost:4444/wd/hub";
    }

    @BeforeEach
    void beforeEach() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        address = faker.address().streetAddress();
    }

    @Test
    void pageObjectsTest() {
        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setPhoneNumber("9930106544")
                .setBirthDate("17", "April", "2025")
                .setSubject("Maths")
                .setHobbies()
                .setPicture("img/image.png")
                .setAddress(address)
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

        registrationPage
                .verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName);
    }
}
