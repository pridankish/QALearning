package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies() {
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-3]").click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage submitForm() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage verifyRegistrationResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
