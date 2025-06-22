package l9.pages_and_hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static l9.pages_and_hw.TestData.*;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static l9.pages_and_hw.utils.RandomUtils.*;

public class RegistrationWithRandomUtilsTests extends TestBase {

    @Test
    void afterChainPageObject() {
        String
                userName = getRandomString(10),
                lastName = getRandomString(6),
                userEmail = getRandomEmail(),
                userGender = getRandomItemFromStringArray(genders);
        registrationPage
                .openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
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
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
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
