package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.title;

public class UnitModuleTest {

    @BeforeTest
    public void LoginSite() {
        Login login = new Login();
        login.LoginPage();
    }

    @Test(priority = 1)
    public void openUnitModule(){
        sleep(1000);
        $(By.xpath("//*[@id = 'btn-mdl-all']")).shouldBe(visible).click();
        $(By.id("7-9")).shouldBe(visible).click();
        title().contentEquals("Единицы измерения");
    }

    @Test(priority = 2)
    public void createFolder() {
        $(By.cssSelector("[iddb='0']>.jstree-anchor")).contextClick();
        $(By.xpath("//a[@rel=0]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Тестовая папка").pressEnter();
    }

    @Test(priority = 3)
    public void createUnitInFolder(){
//        $(By.cssSelector("a:contains('Тестовая папка')")).contextClick();
        $(By.xpath("//a[@rel=2]")).shouldBe(visible).click();
        $(By.xpath("//input[@name='name']")).setValue("Тестовое единица измерения");
        $(By.id("add-new")).click();
    }
}
