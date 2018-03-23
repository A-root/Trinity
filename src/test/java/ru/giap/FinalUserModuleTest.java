package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FinalUserModuleTest {

    private String userName = "Test100";
    private String userNameNew = "Test101";

    @Test(priority = 1)
    public void openLoginPage() {
        open("https://system.misnik.by:8484/index.php/login");
        $(By.xpath("//*[@id='username']")).setValue("IT");
        $(By.xpath("//*[@id='password']")).setValue("IT");
        $(By.cssSelector("#loginbtn > form > div.form-actions > button")).click();
        $(By.xpath("//span[@class='username']")).shouldHave(text("Пользователь для автотестов"));
    }

    @Test(priority = 2)
    public void openUserModule() {
        sleep(2000);
        $(By.xpath("//*[@id = 'btn-mdl-all']")).shouldBe(visible).click();
        $(By.xpath("id('1-9')")).shouldBe(visible).click();
    }

    @Test(dependsOnMethods = "openUserModule")
//    @Description("Создание пользователя")
    public void createUser() {
        $(By.xpath("//*[@id='add-user']")).click();
        $(By.xpath("//*[@id='SubmitForm']/div[1]/div[2]/input")).setValue(userName);
        sleep(500);
        $(By.xpath("/html/body/div[6]/div/div/div[3]/button[2]")).click();
        $(By.xpath("//*[@class='bootbox-close-button close']")).click();
        String user = $$(By.xpath("//td[3]")).findBy(text(userName)).getText();
        System.out.println("Создан пользователь: " + user);
    }

    @Test(priority = 3)
//    @Description("Редактирование данных пользователя")
    public void editUser() {
        $(By.xpath("//*[@id='input_search_user']")).setValue(userName);                                   //пишем в поиск
        $(By.xpath("//td[3]")).shouldHave(text(userName)).click();                          //проверяем запись в таблице что нашлось
        $(By.xpath("//*[@class = 'edit btn blue']")).click();                               //нажимаем кнопку редактирования
//        $(By.cssSelector(".div.modal-header > h4"))
//                .shouldBe(text("Редактирование пользователя " +userName));                  //Проверяем заголовок окна
        $(By.xpath("//*[@id='SubmitForm']/div[1]/div[2]/input")).clear();                   //Удаляем имя пользователя
        $(By.xpath("//*[@data-bb-handler='confirm']")).click();                                     //Сохраняем
//        $(".modal-content").shouldBe(visible).shouldHave(text("Ошибка"));         //Проверяем наличие сообщения с ошибкой
        $(By.xpath("//*[@id='SubmitForm']/div[1]/div[2]/input")).setValue(userNameNew);     //Изменяем имя пользователя
        $(By.xpath("//*[@data-bb-handler='confirm']")).click();                                   //Сохраняем
//        $(".modal-content").shouldBe(visible).shouldHave(text("Успешно"));        //Проверяем наличие сообщения об успехе переименования
        $(By.xpath("//*[@id='input_search_user']")).setValue(userNameNew);                                //Ищем переименованого пользователя
        $(By.xpath("//*[@class = 'edit btn blue']")).click();                               //Нажимаем на кнопку редакрирования
        $(By.id("generate-pwd")).click();                                                   //Генерим новый пароль
        $(By.xpath("//*[@data-bb-handler='confirm']")).click();                                     //Сохраняем
//        $(".modal-content").shouldBe(visible).shouldHave(text("Успешно"));        //Проверяем наличие сообщение о успешности редактирования
        $(By.xpath("//*[@class='bootbox-close-button close']")).click();                    //Закрываем окно
    }

    @Test(priority = 4)
//    @Description("Блокировка и разблокировка пользователя")
    public void blockUser() {
        $(By.xpath("//*[@id='input_search_user']")).setValue(userNameNew);                                          //ищем пользователя
        $(By.xpath("//*[@class = 'block btn red-sunglo']")).click();                                                //нажимаем кнопку Блокировать пользвателя
//        $(By.xpath("//*[@class = 'modal-title']")).shouldBe(text("Данный пользователь будет заблокирован!"));       //Проверяем заголовок окна подтверждения
        $(By.xpath("//*[@class = 'btn red-sunglo']")).click();                                                      //Подтверждаем блокировку пользователя
        $(By.xpath("//*[@class = 'toast toast-success']")).shouldBe(visible).shouldHave(text("Успешно"));            //Проверяем сообщение о успешности блокировки
        $(By.xpath("//*[@class = 'unblock btn green-dark']")).click();                                              //нажимаем кнопку Разблокировать пользователя
//        $(By.xpath("//*[@class = 'modal-title']")).shouldBe(text("Данный пользователь будет разблокирован!"));      //Проверяем заголовок окна подтверждения разблокировки
        $(By.xpath("//*[@class = 'btn green-dark']")).click();                                                      //Подтверждаем разблокировку пользователя
        $(By.xpath("//*[@class = 'toast toast-success']")).shouldBe(visible).shouldHave(text("Успешно"));           //Проверяем сообщение о успешности разблокировки
    }

    @Test(priority = 5)
//    @Description("Добавление пользователя в группу")
    public void addUserInGroup() {
        $(By.xpath("//*[@id='input_search_user']")).setValue(userNameNew);
        $(By.xpath("//*[@class = 'edit btn blue']")).click();
        $(By.xpath("//*[@id='SubmitForm']/div[5]/div[2]/span/span[1]/span/ul/li/input")).setValue("Могилев").pressEnter();
        sleep(1000);
        $(By.className("select2-selection__choice__remove")).click();
        $(By.xpath("//*[@data-bb-handler='confirm']")).click();
    }

    @Test(priority = 6)
//    @Description("Изменение прав пользователя")
    public void changeRightUser() {
        $(By.id("input_search_user")).setValue(userNameNew);
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

    @Test(priority = 7)
//    @Description("Удаление пользовалетя")
    public void deleteUser() {
        sleep(1000);
        $(By.xpath("//*[@id='input_search_user']")).setValue(userNameNew);                           //ищем пользователя
        $(By.xpath("//*[@class = 'delete btn red-sunglo']")).click();                               //Нажимаем кнопку Удалить пользователя
//        $(By.className("modal-title")).shouldBe(text("Данный пользователь будет удален!"));         //Проверяем заголовок окна подтверждения
        $(By.xpath("//*[@class = 'btn red-sunglo']")).click();                                      //Подтверждаем удаление
        sleep(3000);
//        $(".modal-content").shouldBe(visible).shouldHave(text("успешно"));               //Проверяем сообщение о успешности удаления пользователя
    }
}

