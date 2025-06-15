package l9.pages_and_hw;

import com.codeborne.selenide.SelenideElement;
import l9.pages_and_hw.components.CalendarComponent;
import l9.pages_and_hw.components.RegistrationResultsModal;
import l9.pages_and_hw.components.UploadPicture;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private UploadPicture uploadPicture = new UploadPicture();
    private static final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            emailInput = $("#userEmail"),
            genterRadio = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsField = $("#subjectsContainer"),
            subjectsInput = $("#subjectsInput"),
            stateOrCitySelectOption = $("#stateCity-wrapper");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;

    }

    public RegistrationPage clearLastName(){
        lastNameInput.clear();
        return this;

    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;

    }

    public RegistrationPage setGender(String value){
        genterRadio.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setPhone(String value){
        phoneInput.setValue(value);
        return this;

    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public RegistrationPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();
        return this;

    }

    public RegistrationPage verifyResult(String key, String value){
        registrationResultsModal.verifyResult(key, value);
        return this;

    }

    public RegistrationPage setSubject(String value){
        subjectsField.click();
        subjectsInput.setValue(value).pressEnter();
        return this;

    }

    public RegistrationPage setHobbieReading(){
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        return this;

    }

    public RegistrationPage UploadPic(String path){
        uploadPicture.setPicture(path);
        return this;

    }

    public RegistrationPage setAddress(String value){
        $("#currentAddress").setValue(value);
        return this;

    }

    public RegistrationPage setState(String value){
        $("#state").click();
        stateOrCitySelectOption.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setCity(String value){
        $("#city").click();
        stateOrCitySelectOption.$(byText(value)).click();
        return this;

    }

    public RegistrationPage clickSubmit(){
        $("#submit").click();
        return this;

    }

    public RegistrationPage clickCloseModal(){
        $("#closeLargeModal").click();
        return this;

    }




}
