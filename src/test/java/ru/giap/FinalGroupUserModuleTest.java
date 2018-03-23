package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FinalGroupUserModuleTest {

    private String nameGroup = "Тестовая группа";
    private String newNameGroup = "Группа для теста";

    @Test(priority = 1)
    public void openLoginPage() {
        open("https://system.misnik.by:8484/index.php/login");
        $(By.xpath("//*[@id='username']")).setValue("TaushevIS");
        $(By.xpath("//*[@id='password']")).setValue("tMYPHSIa");
        $(By.cssSelector("#loginbtn > form > div.form-actions > button")).click();
        $(By.xpath("//span[@class='username']")).shouldHave(text("Таушев Игорь Сергеевич"));
    }

    @Test(priority = 2)
    public void openGroupUserModule() {
        sleep(1000);
        $(By.xpath("//*[@id = 'btn-mdl-all']")).shouldBe(visible).click();
        $(By.xpath("id('8-9')")).shouldBe(visible).click();
    }

    @Test(priority = 3)
//    @Description("Добавляем новую группу")
    public void addGroup() {
        $(By.id("add-group")).click();
//        $(By.className("modal-title")).shouldBe(text("Добавление группы "));
        $(By.xpath("//*[@id='SubmitForm']/div[1]/div[2]/input")).setValue(nameGroup);
        sleep(1000);
        $(By.xpath("//*[@class='modal-footer']/button[@data-bb-handler='confirm']")).click();
    }

    @Test(priority = 4)
//    @Description("Редактируем данные группы")
    public void editGroup() {
        $(By.id("input_search_group_user")).setValue(nameGroup);
        $(By.xpath("//*[@class='edit btn blue']")).click();
        $(By.xpath("//*[@id='SubmitForm']//input[@type='text']")).clear();
        $(By.xpath("//*[@class='modal-footer']/button[@data-bb-handler='confirm']")).click();
        sleep(1000);
        $(By.xpath("//*[@id='SubmitForm']//input[@type='text']")).setValue(newNameGroup);
        $(By.xpath("//*[@class='modal-footer']/button[@data-bb-handler='confirm']")).click();
        $(By.id("input_search_group_user")).setValue(newNameGroup);
        $(By.xpath("//*[@class='edit btn blue']")).click();
        $(By.xpath("//*[@id='SubmitForm']//input[@type='search']"))
                .setValue("testIE").pressEnter()
                .setValue("taushevIS").pressEnter();
        $(By.xpath("//li[@title='TaushevIS']/span[@class='select2-selection__choice__remove']")).click();
        $(By.xpath("//*[@class='modal-footer']/button[@data-bb-handler='confirm']")).click();
    }

    @Test(priority = 5)
//    @Description("Проверяем назначение прав группы")
    public void editRightGroup() {
        $(By.id("input_search_group_user")).setValue(newNameGroup);
        $(By.xpath("//*[@class='modules btn red-sunglo']")).click();
        //Назначаем 1 право
        $(By.xpath("//label[@for='users.read']/span[@class='box']")).click();
        sleep(500);
        $(By.xpath("//label[@for='users.read']/span[@class='check']")).click();
        //Назначаем группу прав
        sleep(500);
        $(By.xpath("//*[@class='btn btn-sm check-all']")).click();
        sleep(500);
        $(By.xpath("//*[@class='btn btn-sm uncheck-all']")).click();
        //Назначаем права на дерево
        sleep(500);
        $(By.id("TypePerButt")).click();//открываем дерево
        //выбираем ветки в дереве
        $(By.xpath("//li[@iddb='2127']//*[@class='jstree-icon jstree-checkbox']")).click();
        $(By.xpath("//li[@iddb='991']//*[@class='jstree-icon jstree-checkbox']")).click();
        $(By.xpath("//li[@iddb='1032']//*[@class='jstree-icon jstree-checkbox']")).click();

        $(By.xpath("//tr[@iddb='2127']//a[@class='delper btn btn-xs red-sunglo']")).click();//удаляем первый элемент из таблицы
        $(By.xpath("//*[@id='change-typeper-table']")).click();//открываем режим "Таблица"
        $(By.xpath("//tr[@id='991']//input[@permis='addchild'][@type='checkbox']")).click();//Ставим чекбокс
        $(By.xpath("//*[@id='mass-apply-table']")).click();//сохраняем
        $(By.xpath("//*[@id='mass-change-typeper']")).click();//Открываем элемент "Массовое назначение"
        $(By.xpath("//label[@for='read']/span[@class='box']")).click();
        $(By.xpath("//label[@for='del']/span[@class='box']")).click();//Ставим чекбокс
        sleep(1000);
        $(By.xpath("//*[@id='mass-apply']")).click();//сохраняем
        $(By.xpath("//*[@id='Save-change']")).click();//сохраняем назначение прав на дерево

        //Назначаем все права
        $(By.xpath("//*[@data-bb-handler='check']")).click();
        sleep(1000);
        $(By.xpath("//*[@data-bb-handler='check']")).click();
        $(By.xpath("//*[@class='modal-footer']/button[@data-bb-handler='success']")).click();//сохраняем изменение прав
    }

    @Test(priority = 6)
//    @Description("Удаление группы")
    public void deleteGroup() {
        $(By.id("input_search_group_user")).setValue(newNameGroup);
        $(By.xpath("//*[@class='delete btn red-sunglo']")).click();
//        $(By.className("modal-title")).shouldBe(text("Данная группа будет удалена!"));
        $(By.xpath("//*[@class='modal-footer']/button[@data-bb-handler='confirm']")).click();
        sleep(1000);
    }
}
