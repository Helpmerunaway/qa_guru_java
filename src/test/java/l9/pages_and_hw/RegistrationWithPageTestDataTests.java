package l9.pages_and_hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static l9.pages_and_hw.TestData.*;

public class RegistrationWithPageTestDataTests extends TestBase {

//    static String
//            userName,
//            lastName,
//            userEmail;

//    @BeforeEach
//    void prepareTestData() {
//        userName = "John";
//        lastName = "Doe";
//        userEmail = "johndoe@mail.ru";
//    }

    @Test
    void afterChainPageObject() {
//        String userName = "John",
//                lastName = "Doe",
//                userEmail = "johndoe@mail.ru";

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
