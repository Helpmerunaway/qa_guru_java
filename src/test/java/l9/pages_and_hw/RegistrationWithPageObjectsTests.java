package l9.pages_and_hw;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

//Задание
//1. Возьмите ваш код написанный в рамках ДЗ для формы https://demoqa.com/automation-practice-form
//2. Добавьте в ваш код PageObjects / Components, в тестовом классе не должно остаться локаторов
// В поле ответа приложите ссылку на ваш репозиторий в GitHub

public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void beforePageObject() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("johndoe@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__month-container").$(byText("14")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/example.png");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/pictures/example.png"));
        $("#currentAddress").setValue("Ulica Pushkina, dom Kolotushkina");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("John Doe"));
        $(".modal-body").shouldHave(text("johndoe@mail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9999999999"));
        $(".modal-body").shouldHave(text("14 February,2008"));
        $(".modal-body").shouldHave(text("Arts"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("example.png"));
        $(".modal-body").shouldHave(text("Ulica Pushkina, dom Kolotushkina"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }

    @Test
    void afterChainPageObject() {
        String userName = "John";
        String lastName = "Doe";
        String userEmail = "johndoe@mail.ru";

        registrationPage
                .openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setPhone("9999999999")
                .setBirthDate("14", "February", "2008")
                .setSubject("Arts")
                .setSubject("Computer")
                .setHobbieReading()
                .UploadPic("pictures/example.png")
                .setAddress("Ulica Pushkina, dom Kolotushkina")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " Doe")
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9999999999")
                .verifyResult("Date of Birth", "14 February,2008")
                .verifyResult("Subjects", "Arts")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "example.png")
                .verifyResult("Address", "Ulica Pushkina, dom Kolotushkina")
                .verifyResult("State and City", "NCR Delhi")
                .clickCloseModal();
    }
}
