package l9.pages_and_hw;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

}
