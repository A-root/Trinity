package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
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
        $(By.xpath("//a[@rel=2]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Тестовая папка").pressEnter();
    }

    @Test(priority = 4)
    public void createEnumInFolder() {
        $(By.cssSelector("[name='Тестовая папка']>.jstree-anchor")).contextClick();
        $(By.xpath("//a[@rel=1]")).shouldBe(visible).click();
        sleep(1000);
        $(By.cssSelector("#new-enum-name")).setValue("Тестовое перечисление");
        sleep(1000);
        $(By.xpath("//div[@id='container-select-enum']//input[@type='text']")).setValue("Элемент1").pressEnter()
                .setValue("Элемент2").pressEnter()
                .setValue("Элемент3").pressEnter();
        $(By.xpath("//button[@id='new-enum-btn']")).click();
    }

    @Test(priority = 5)
    public void editEnum() {
//        $(By.cssSelector("[name='Тестовая папка'] > .jstree-ocl:nth-of-type(1)")).click();
        sleep(3000);
        $(By.cssSelector("[name='Тестовое перечисление'] > .jstree-ocl:nth-of-type(1)")).click();
        //добавляем элемент в перечисление
        $(By.id("addElEnum-textInput")).setValue("Элемент4");
        $(By.id("def-main-ch")).click();
        $(By.id("addElEnum-btn")).click();
        //удаляем элемент из перечисления
        $(By.id("enum-delete-choose")).click();
        $(By.xpath("//form[@id='EditEnumContainer']/div/div[@class='col-md-2']//span[@class='box']")).click();
        $(By.id("enum-delete-choose")).click();
        $(By.cssSelector("#basicDanger .modal-body")).shouldBe(text("Удалить выбранные элементы перечисления?"));
        $(By.id("deleteBtn")).click();
    }

    @Test(priority = 6)
    public void deleteEnum() {
        //удаляем перечисление
        $(By.cssSelector("[name='Тестовое перечисление'] > .jstree-ocl:nth-of-type(1)")).contextClick();
        $(By.xpath("//a[@rel=2]")).shouldBe(visible).click();
        $(By.cssSelector("")).shouldHave(text("Вы действительно хотите удалить перечисление!"));
        $(By.id("deleteBtn")).click();
        //удаляем папку
        $(By.cssSelector("[name='Тестовая папка'] > .jstree-ocl:nth-of-type(1)")).contextClick();
        $(By.xpath("//a[@rel=2]")).shouldBe(visible).click();
        $(By.cssSelector("")).shouldHave(text("Вы действительно хотите удалить папку!"));
        $(By.id("deleteBtn")).click();
    }

    @AfterTest
    public void tearDown(){
        close();
    }
}
