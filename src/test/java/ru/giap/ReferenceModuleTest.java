package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ReferenceModuleTest {

    @BeforeTest
    public void LoginSite() {
        Login login = new Login();
        login.LoginPage();
    }

    @Test(priority = 2)
    public void openReferenceModule() {
        sleep(5000);
        $(By.xpath("//*[@id = 'btn-mdl-all']")).click();
        $(By.id("4-9")).click();
    }

    @Test(dependsOnMethods = "openReferenceModule")
    public void createFolder() {
        sleep(3000);
        title().contentEquals("Справочники");
        $(By.cssSelector("[iddb='0']>.jstree-anchor")).contextClick();
        $(By.xpath("//a[@rel=0]")).shouldBe(visible).click();
        $(By.cssSelector(".jstree-rename-input")).setValue("Тестовая папка").pressEnter();
        sleep(5000);
    }

    @Test(priority = 4)
    public void createReferenceInFolder(){
//        $(By.cssSelector("a:contains('Тестовая папка')")).contextClick();
        $(By.xpath("//a[@rel=1]")).shouldBe(visible).click();
        $(By.xpath("//input[@name='name']")).setValue("Тестовый справочник");
        $(By.id("add-new")).click();
    }

    @Test(priority = 5)
    public void editReference(){
//        $(By.cssSelector("a:contains('Тестовый справочник')")).click();//выделяем справочник
//        $(By.cssSelector(".caption-subject.font-dark.bold")).shouldBe(text("Тестовый справочник"));//проверяем заголовок справочника
//        $(By.cssSelector(".bootstrap-switch-handle-off")).click();
//        $(By.id("ChangeStruc")).click();
//        $(By.cssSelector("#inputparam  input")).setValue("Класс опасности");
//        $(By.name("")).setValue("Не пожароопасная");
//        $(By.xpath()).click();
//        $(By.name("")).setValue("Пожароопасная (Газ)");
//        $(By.xpath()).click();
//        $(By.name("")).setValue("Пожароопасная (ГЖ)");
//        $(By.xpath()).click();
//        $(By.name("")).setValue("Пожароопасная (ЛВЖ)");
//        $(By.xpath()).click();
//        $(By.id("edit-data")).click();
    }

    @Test(priority = 6)
    public void addValueInReference(){
        $(By.cssSelector(".addparam")).click();

    }
}
