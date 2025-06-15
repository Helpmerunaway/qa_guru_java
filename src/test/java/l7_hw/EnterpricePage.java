package l7_hw;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
//Задание
//1. На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions. Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
//
public class EnterpricePage {
    @Test
    void enterprisePageChecks(){
        open("https://github.com");
        $$(".HeaderMenu-link").findBy(text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        $(byText("developer platform")).shouldBe(visible);
    }

}