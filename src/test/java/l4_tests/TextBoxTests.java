package l4_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest(){
        open("/text-box");
        $("#userName").setValue("Serega Pirat");
        $("#userEmail").setValue("serega@pirat.com");
        $("#currentAddress").setValue("Kachalka");
        $("#permanentAddress").setValue("Thailand");
        $("#submit").click();
        $("#output").shouldHave(text("Serega Pirat"), text("serega@pirat.com"), text("Kachalka"), text("Thailand"));
    }

}
