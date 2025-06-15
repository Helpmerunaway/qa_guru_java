package l9.pages;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void fillFormTest() {
        String userName = "John";
        String lastName = "Doe";
        String userEmail = "johndoe@mail.ru";

        registrationPage.openPage();
        registrationPage.setFirstName(userName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(userEmail);
        registrationPage.setGender("Male");
        registrationPage.setPhone("9999999999");
        registrationPage.setBirthDate("14", "February", "2008");
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
        registrationPage.verifyResultsModalAppears();
        registrationPage.verifyResult("Student Name", userName + " Doe");
        registrationPage.verifyResult("Student Email", userEmail);
        registrationPage.verifyResult("Gender", "Male");
        registrationPage.verifyResult("Mobile", "9999999999");
        registrationPage.verifyResult("Date of Birth", "14 February,2008");
        registrationPage.verifyResult("Subjects", "Arts");
        registrationPage.verifyResult("Hobbies", "Reading");
        registrationPage.verifyResult("Picture", "example.png");
        registrationPage.verifyResult("Address", "Ulica Pushkina, dom Kolotushkina");
        registrationPage.verifyResult("State and City", "NCR Delhi");
//        $(".modal-body").shouldHave(text("John Doe"));
//        $(".modal-body").shouldHave(text("johndoe@mail.ru"));
//        $(".modal-body").shouldHave(text("Male"));
//        $(".modal-body").shouldHave(text("9999999999"));
////        $(".modal-body").shouldHave(text("14 February,2008"));
//        $(".modal-body").shouldHave(text("Arts"));
//        $(".modal-body").shouldHave(text("Reading"));
//        $(".modal-body").shouldHave(text("example.png"));
//        $(".modal-body").shouldHave(text("Ulica Pushkina, dom Kolotushkina"));
//        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }

    @Test
    void successfulRegistrationTest() {
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
                .setBirthDate("14", "February", "2008");
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
                .verifyResult("State and City", "NCR Delhi");
        $("#closeLargeModal").click();
    }
}
