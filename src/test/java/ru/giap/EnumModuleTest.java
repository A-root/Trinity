package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EnumModuleTest {

    @BeforeTest
    public void LoginSite() {
        Login login = new Login();
        login.LoginPage();
    }

    @Test(priority = 2)
    public void openEnumModule() {
        sleep(1000);
        $(By.xpath("//*[@id = 'btn-mdl-all']")).shouldBe(visible).click();
        $(By.id("5-9")).shouldBe(visible).click();
    }

    @Test(priority = 3)
    public void createFolder() {
        title().contentEquals("Перечисления");
        $(By.cssSelector("[iddb='0']>.jstree-anchor")).contextClick();
        $(By.xpath("//a[@rel=0]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Тестовая папка").pressEnter();
    }

    @Test(priority = 4)
    public void createEnumInFilder() {
//        $(By.cssSelector("a:contains('Тестовая папка')")).contextClick();
        $(By.xpath("//a[@rel=2]")).shouldBe(visible).click();
        $(By.xpath("//input[@name='name']")).setValue("Тестовое перечисление");
        $(By.id("add-new")).click();
    }

    @Test(priority = 5)
    public void editEnum(){

    }
}
