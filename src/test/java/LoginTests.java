//import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.Test;
//
//import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//
//public class LoginTests {
//
//    @Test
//    void successfulLoginTest() {
//        Configuration.browser = "safari";
//        Configuration.holdBrowserOpen = true;
//
//        open("https://qa.guru/crm/system/login");
//        $(".login-form").shouldHave(text("Войти"));
//
//        $("[name=email]").setValue("qagurubot@gmail.com");
//        $("[name=password]").setValue("qagurupassword").pressEnter();
//        $(".main-header__login").click();
//
//        $("logined-form").shouldHave(text("Здравствуйте, QA_GURU_BOT"));
//    }
//}
