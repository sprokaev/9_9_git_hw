package gugu.qa;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

class SimpleTest {

    @BeforeAll
    public static void setUp() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void shouldSearchInGitHub() {
        Selenide.open("/");
        $("[data-test-selector='nav-search-input']").click();
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();

        webdriver().shouldHave(url("https://github.com/search?q=selenide"));
    }


}
