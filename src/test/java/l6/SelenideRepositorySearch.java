package l6;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop(){
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        //sleep(5000);
        $$("[data-testid='results-list']").first().$("a").click();
        // .classname #id1 a[href=abc].red
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
