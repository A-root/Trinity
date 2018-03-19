package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class UnitModuleTest {

    @BeforeTest
    public void LoginSite() {
        Login login = new Login();
        login.LoginPage();
    }

    @AfterTest
    public void tearDown() {
        close();
    }

    @Test(priority = 1)
    final public void openUnitModule() {
        sleep(1000);
        $(By.xpath("//*[@id = 'btn-mdl-all']")).shouldBe(visible).click();
        $(By.id("7-9")).shouldBe(visible).click();
        title().contentEquals("Единицы измерения");
    }

    @Test(priority = 2)
    final public void createFolder() {
        title().contentEquals("Единицы измерения");
        sleep(5000);
        $(By.cssSelector("[iddb='0'] >.jstree-anchor")).contextClick();
        $(By.xpath("//a[@rel=0]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Тестовая папка").pressEnter();
        $(By.cssSelector(".toast-success")).shouldBe(visible);//проверяем уведомление об успехе создания
    }

    @Test(priority = 3)
    public void createUnitInFolder() {
        $(By.xpath("//*[contains(text(),'Тестовая папка')]")).contextClick();
        $(By.xpath("//a[@rel=0]")).shouldBe(visible).click();
        $(By.cssSelector("[name='0']")).setValue("Тестовая единица измерения");
        $(By.xpath("//span[@mathquill-block-id='73']")).setValue("x+273.15");
        $(By.xpath("//span[@mathquill-block-id='75']")).setValue("x-273.15");
        $(By.cssSelector("[data-bb-handler='success']")).click();
        $(By.cssSelector(".toast-success")).shouldBe(visible);//проверяем уведомление об успехе создания
        sleep(3000);
        /*-----Добавляем еще одну единицу измерения------*/
        $(By.xpath("//*[contains(text(),'Тестовая папка')]")).contextClick();
        $(By.xpath("//a[@rel=0]")).shouldBe(visible).click();
        $(By.cssSelector("[name='0']")).setValue("Основная тестовая единица измерения");
        $(By.xpath("//span[@mathquill-block-id='73']")).setValue("x");
        $(By.xpath("//span[@mathquill-block-id='75']")).setValue("x");
        $(By.cssSelector("[data-bb-handler='success']")).click();
        $(By.cssSelector(".toast-success")).shouldBe(visible);//проверяем уведомление об успехе создания
        sleep(3000);
    }

    @Test
    public void changeName(){
        $(By.xpath("//*[contains(text(),'Тестовая папка')]")).contextClick();
        $(By.xpath("//a[@rel=1]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Переименованная папка").pressEnter();
        $(By.xpath("//*[contains(text(),'Тестовая единица измерения')]")).contextClick();
        $(By.xpath("//a[@rel=1]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Тестовая папка").pressEnter();
        /*-----Переименовываем единицу измерения------*/
        $(By.xpath("//*[contains(text(),'Тестовая папка')]")).click();
        $(By.xpath("//*[contains(text(),'Тестовая единица измерения')]")).contextClick();
        $(By.xpath("//a[@rel=1]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Вторичная единица измерения").pressEnter();
        $(By.xpath("//*[contains(text(),'Тестовая единица измерения')]")).contextClick();
        $(By.xpath("//a[@rel=1]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Тестовая единица измерения").pressEnter();
    }

    @Test(priority = 5)
    public void deleteUnit(){
        $(By.xpath("//*[contains(text(),'Тестовая папка')]")).click();
        $(By.xpath("//*[contains(text(),'Тестовая единица измерения')]")).contextClick();
        $(By.xpath("//a[@rel=1]")).shouldBe(visible).click();
        $(By.cssSelector(".bootbox-body")).shouldBe(text("Вы действительно хотите удалить единицу измерения Тестовая единица измерения?"));
        $(By.cssSelector("[data-bb-handler='ok']")).click();
        $(By.cssSelector(".toast-success")).shouldBe(visible);
    }

    @Test(priority = 6)
    public void deleteFolder(){
        $(By.xpath("//*[contains(text(),'Тестовая папка')]")).contextClick();
        $(By.xpath("//a[@rel=2]")).shouldBe(visible).click();
        $(By.cssSelector(".bootbox-body")).shouldBe(text("Вы действительно хотите удалить группу Тестовая папка?"));
        $(By.cssSelector("[data-bb-handler='ok']")).click();
        $(By.cssSelector(".toast-success")).shouldBe(visible);
    }
}
