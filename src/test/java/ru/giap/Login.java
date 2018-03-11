package ru.giap;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Login {
    public void LoginPage() {
        open("https://system.misnik.by:8484/index.php/login");
        $(By.xpath("//*[@id='username']")).setValue("IT");
        $(By.xpath("//*[@id='password']")).setValue("IT");
        $(By.cssSelector("#loginbtn > form > div.form-actions > button")).click();
        $(By.xpath("//span[@class='username']")).shouldHave(text("Пользователь для автотестов"));
    }
}
