package l9.pages_and_hw;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static l9.pages_and_hw.TestData.*;
import static l9.pages_and_hw.utils.RandomUtils.*;

public class RegistrationWithFakerTestsHomework extends TestBase {

    @Test
    void afterChainPageObject() {
        String
                userName = getRandomName(),
                lastName = getRandomLastName(),
                userEmail = getRandomEmailAddress(),
                currentAddress = getRandomCurrentAddress(),
                userGender = getRandomItemFromStringArray(genders),
                userNumber = getRandomUserNumber(),
                userBirthDay_day = getRandomBirthDay(),
                userBirthDay_month = getRandomItemFromStringArray(months),
                userBirthDay_year = getRandomBirthYear(),
                userSubjects = getRandomItemFromStringArray(subjects),
                userHobbies = getRandomItemFromStringArray(hobbies),
                userPictureLocation = "pictures/example.png",
                userState = "NCR",
                userCity = getRandomItemFromStringArray(cities);
        registrationPage
                .openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userNumber)
                .setBirthDate(userBirthDay_day, userBirthDay_month, userBirthDay_year)
                .setSubject(userSubjects)
                .setHobbies(userHobbies)
                .UploadPic(userPictureLocation)
                .setAddress(currentAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", userBirthDay_day + " " + userBirthDay_month + "," + userBirthDay_year)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", "example.png")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", userState+ " " + userCity)
                .clickCloseModal();
    }
}
