package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CreateVessel {

    @BeforeTest
    public void LoginSite(){
        FinalLogin finalLogin = new FinalLogin();
        finalLogin.LoginPage();
    }

    @Test(priority = 2)
    public void openVesselModule() {
        sleep(1000);
        $(By.id("1-3")).shouldBe(visible).click();
    }

    @Test(priority = 3)
//    @Description("Создание сосуда")
    public void createVessel() {
        /*определяем переменные*/
        String positionVessel = "Ar-42x";
        String date = "25/02/2011";
        /*------------------------*/
        $(By.xpath("//label[@title='Сосуды и аппараты']")).shouldBe(text("Сосуды и аппараты"));//проверяем заголовок окна
        sleep(5000);
        $(By.xpath("//*[@title = 'Добавить сосуд (аппарат)']")).click();//нажимаем кнопку Добавить
        sleep(5000);
        $(By.xpath("//li[@interfaceid='169']")).shouldBe(visible).click();//выбираем интерфейс для добавления
        $(By.xpath(".//select[@name= '6327']/../span")).click();//кликаем на Место
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='АВТ-4']")).click(); //Выбираем АВТ-4
        $(By.xpath(".//select[@name= '7217']/../span")).click();//кликаем на Тип
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Емкость']")).click();//Выбираем Емкость
        $(By.xpath("//input[@name='6328']")).setValue(positionVessel);//выбираем Позицию
        $(By.xpath("//input[@name='6330']")).setValue(date).pressEnter();//выбираем Дату
        $(By.cssSelector("button.add_0")).click();
        sleep(1000);
    }

    @Test(priority = 4)
//    @Description("Заполняем вкладку \"Основные параметры")
    public void generalInfo() {
        /*определяем переменные*/
        String nameVessel = "Сосуд для тестирования";
        String factoryNumber = "T52-x001";
        String invNumber = "65721-9";
        String dateIn = "25/11/2010";
        int normSrok = 20;
        String categoryVessel = "Сосуд";
        String aimVessel = "Буферная емкость на нагнетании компрессора";
        String note = "В паспорте не указана сварка, ссылаются на паспорт завода-изготовителя";
        double volume = 22.6;
        String model = "Test";
        int length = 2850;
        int weight = 300;
        int maxWeight = 75;
        int compensation = 20;
        int count = 3;
        int heatExchangeSurface = 10;
        String regNumber = "12x-42I";
        String regDate = "10/03/2011";
        /*------------------------*/
        /*Заполняем основные данные*/
        sleep(5000);
        $(By.xpath("//*[@name = '6324']")).setValue(nameVessel);
        $(By.xpath(".//select[@name= '6831']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Подлежит учету']")).click();
        $(By.xpath("//*[@name = '6332']")).setValue(factoryNumber);
        $(By.xpath("//*[@name = '6329']")).setValue(invNumber);
        $(By.xpath("//*[@name = '6334']")).setValue(dateIn);
        $(By.xpath("//select[@name= '7216']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='ООО \"Глазовский завод \"Химмаш\", г. Глазов, Россия']")).click();
        $(By.xpath("//*[@name = '6335']")).setValue(String.valueOf(normSrok));
        $(By.xpath(".//select[@name= '6343']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='3']")).click();
        $(By.xpath("//*[@class = 'btn default text-open t6445']")).click();
        $(By.xpath("//textarea[count(. | //*[@class = 't6445 ']) = count(//*[@class = 't6445 '])]")).setValue(aimVessel);
        $(By.xpath("//*[@type = 'button'][count(. | //*[@value = 't6445']) = count(//*[@value = 't6445'])]")).click();
        $(By.xpath("//*[@class = 'btn default text-open t6519']")).click();
        $(By.xpath("//textarea[count(. | //*[@class = 't6519 ']) = count(//*[@class = 't6519 '])]")).setValue(note);
        $(By.xpath("//*[@type = 'button'][count(. | //*[@value = 't6519']) = count(//*[@value = 't6519'])]")).click();

        /*Заполнем технические характеристики*/
        $(By.xpath("//*[@name = '6348']")).setValue(String.valueOf(volume));
        $(By.xpath("//*[@name = '6342']")).setValue(String.valueOf(model));
        $(By.xpath(".//select[@name= '6338']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Горизонтальное']")).click();
        $(By.xpath("//*[@name = '6347']")).setValue(String.valueOf(length));
        $(By.xpath(".//select[@name= '6346']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Постоянный']")).click();
        $(By.xpath(".//select[@name= '6350']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Минеральная вата']")).click();
        $(By.xpath(".//select[@name= '6351']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Имеется']")).click();
        $(By.xpath(".//select[@name= '7062']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Имеется']")).click();
        $(By.xpath(".//select[@name= '7063']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Имеется']")).click();
        $(By.xpath(".//select[@name= '7064']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Отсутствует']")).click();
        $(By.xpath(".//select[@name= '7865']/../span")).click();
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Не предусмотрено требованиями НТД']")).click();
        $(By.xpath("//*[@name = '6845']")).setValue(String.valueOf(weight));
        $(By.xpath("//*[@name = '6852']")).setValue(String.valueOf(maxWeight));
        $(By.xpath("//*[@name = '6851']")).setValue(String.valueOf(compensation));
        $(By.xpath("//*[@name = '6339']")).setValue(String.valueOf(count));
        $(By.xpath("//*[@name = '6341']")).setValue(String.valueOf(heatExchangeSurface));
        $(By.cssSelector("button.add_0")).click();
        sleep(3000);
        try {
            /*Заполняем данные о регистарции*/
            $(By.xpath("//a[@interfaceid='313']")).click();                                                                 //разворачиваем блок регистрации
            $(By.xpath("//a[@title='Добавить']")).click();                                                                  //добаляем данные о регистарции
            $(By.xpath("//*[@name = '6835']")).setValue(String.valueOf(regNumber));                                         //пишем номер
            $(By.xpath("//*[@name = '6839']")).setValue(String.valueOf(regDate)).pressEnter();                              //пишем дату
            $(By.xpath(".//select[@name= '6840']/../span")).click();                                                        //клик по месту
            $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Ростехнадзор']")).click();                     //выбираем место
            $(By.cssSelector("button.add_1")).click();//сохраняем
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
//    @Description(Заполняем вкладку \"Параметры эксплуатации")
    public void operatingParameters() {
        /*Определяем переменные*/
        String date1 = "30/03/2012";
        String env1 = "Нестабильный бензин";
        String pros1 = "Корпус";
        int Pin1 = 1;
        int Tin1 = 110;
        int Pout1 = 1;
        int Tout1 = 130;
        int Praz1 = 1;
        int Traz1 = 130;
        double Pcalc1 = 2.5;
        int Tcalc1 = 250;
        String date2 = "30/03/2012";
        String env2 = "Фракция 240-350С";
        String pros2 = "Трубное";
        int Pin2 = 1;
        int Tin2 = 110;
        int Pout2 = 1;
        int Tout2 = 130;
        int Praz2 = 1;
        int Traz2 = 130;
        double Pcalc2 = 2.5;
        int Tcalc2 = 250;
        /*------------------------------------------------------------------------------------------------------------*/
        $(By.xpath("//button[@groupid='470']")).click();//переходим на вкладку Параметры эксплуатации
        $(By.cssSelector("form_0 .m-t-btn-add-obj")).click();//Нажиаем добавить
        $(By.xpath(".//select[@name= '6857']/../span")).click(); //Клик на пространиство
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Корпус']")).click();//выбираем пространство
        $(By.xpath("//button[@class='btn btn-success btn-sm m-m-btn-success_yet']")).click();//Нажимаем на Добавить еще
        $(By.xpath(".//select[@name= '6857']/../span")).click();//Клик на пространиство
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Трубное']")).click();//выбираем пространство
        $(By.cssSelector("button.add_1")).click();//Нажимаем Добавить
        /*------------------------------------------------------------------------------------------------------------*/
        $(By.xpath("//a[@interfaceid='317']")).click();//История параметров
        $(By.cssSelector("form_0 .m-t-btn-add-obj")).click();//Нажимаем Добавить
        $(By.xpath("//*[@name = '6970']")).setValue(date1).pressEnter();//вводим дату
        $(By.xpath(".//select[@name= '6982']/../span")).click();//клик на источник
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Запись в паспорте']")).click();//выбираем источник
        $(By.xpath("//*[@name = '6977']")).setValue(env1);//вводим среду источника
        $(By.xpath("//*[@name = '6969']")).setValue(pros1);//вводим пространство источника
        $(By.xpath(".//select[@name= '7523']/../span")).click();//клик на значения
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Проектные']")).click();//выбираем значения
        $(By.cssSelector(".form_1 .array-enum-open")).click();//клик на пространиство
        $(By.xpath(".//select[@name= '6982']/../span")).click();//клик на пространиство
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Корпус']")).click();//выбираем пространство
        $(By.xpath("//button[@class='btn btn-primary btn-sm array-submit']")).click();//подтверждаем пространство
        $(By.xpath("//*[@name = '6971']")).setValue(String.valueOf(Pin1));//давление вход
        $(By.xpath("//*[@name = '7028']")).setValue(String.valueOf(Pout1));//давление выход
        $(By.xpath("//*[@name = '6972']")).setValue(String.valueOf(Praz1));//разрешенное давление
        $(By.xpath("//*[@name = '6973']")).setValue(String.valueOf(Pcalc1));//расчетное давление
        $(By.xpath("//*[@name = '6974']")).setValue(String.valueOf(Tin1));//температура вход
        $(By.xpath("//*[@name = '7029']")).setValue(String.valueOf(Tout1));//температура выход
        $(By.xpath("//*[@name = '6975']")).setValue(String.valueOf(Traz1));//разрешенная температура
        $(By.xpath("//*[@name = '6976']")).setValue(String.valueOf(Tcalc1));//расчетная температура
        $(By.cssSelector("button.addmore_1")).click();//клик Добавить еще
        $(By.xpath("//*[@name = '6970']")).setValue(date2).pressEnter();//вводим дату
        $(By.xpath(".//select[@name= '6982']/../span")).click();//клик на источник
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Паспорт']")).click();//выбираем источник
        $(By.xpath("//*[@name = '6977']")).setValue(env2);//вводим среду источника
        $(By.xpath("//*[@name = '6969']")).setValue(pros2);//вводим пространство источника
        $(By.xpath(".//select[@name= '7523']/../span")).click();//клик на значения
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Проектные']")).click();//выбираем значения
        $(By.cssSelector(".form_1 .array-enum-open")).click();//клик на пространиство
        $(By.xpath(".//select[@name= '6982']/../span")).click();//клик на пространиство
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Трубное']")).click();//выбираем пространство
        $(By.xpath("//button[@class='btn btn-primary btn-sm array-submit']")).click();//подтверждаем пространство
        $(By.xpath("//*[@name = '6971']")).setValue(String.valueOf(Pin2));//давление вход
        $(By.xpath("//*[@name = '7028']")).setValue(String.valueOf(Pout2));//давление выход
        $(By.xpath("//*[@name = '6972']")).setValue(String.valueOf(Praz2));//разрешенное давление
        $(By.xpath("//*[@name = '6973']")).setValue(String.valueOf(Pcalc2));//расчетное давление
        $(By.xpath("//*[@name = '6974']")).setValue(String.valueOf(Tin2));//температура вход
        $(By.xpath("//*[@name = '7029']")).setValue(String.valueOf(Tout2));//температура выход
        $(By.xpath("//*[@name = '6975']")).setValue(String.valueOf(Traz2));//разрешенная температура
        $(By.xpath("//*[@name = '6976']")).setValue(String.valueOf(Tcalc2));//расчетная температура
        $(By.cssSelector("button.add_1")).click();//клик Добавить
        /*------------------------------------------------------------------------------------------------------------*/
        $(By.xpath("//a[@interfaceid='504']")).click();//Технологические среды
        date1 = "2012";
        env1 = "Нестабильный бензин";
        date2 = "2012";
        env2 = "Фракция 240-350С";
        $(By.cssSelector("form_0 .m-t-btn-add-obj")).click();//Нажимаем Добавить
        $(By.xpath("//*[@name = '7252']")).setValue(date1).pressEnter();//Дата
        $(By.xpath(".//select[@name= '7253']/../span")).click();//клик на источник
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Паспорт']")).click();//выбираем источник
        $(By.xpath("//*[@name = '7241']")).setValue(env1);//вводим среду
        $(By.xpath(".//select[@name= '7242']/../span")).click();//клик на класс опасности
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='4']")).click();//выбираем класс
        $(By.xpath(".//select[@name= '7243']/../span")).click();//клик на взрывоопасность
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Взрывопожароопасная']")).click();//выбираем взрывоопасность
        $(By.cssSelector(".form_1 .array-enum-open")).click();//клик на пространство
        $(By.xpath(".//select[@name= '7242']/../span")).click();//клик на пространство
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='4']")).click();//выбираем пространство
        $(By.cssSelector(".array-submit")).click();//подтверждаем
        $(By.cssSelector("button.add_1")).click();//клик на Добавить

        $(By.cssSelector("form_0 .m-t-btn-add-obj")).click();//Нажимаем Добавить
        $(By.xpath("//*[@name = '7252']")).setValue(date2).pressEnter();//Дата
        $(By.xpath(".//select[@name= '7253']/../span")).click();//клик на источник
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Паспорт']")).click();//выбираем источник
        $(By.xpath("//*[@name = '7241']")).setValue(env2);//вводим среду
        $(By.xpath(".//select[@name= '7242']/../span")).click();//клик на класс опасности
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='4']")).click();//выбираем класс
        $(By.xpath(".//select[@name= '7243']/../span")).click();//клик на взрывоопасность
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Взрывопожароопасная']")).click();//выбираем взрывоопасность
        $(By.cssSelector(".form_1 .array-enum-open")).click();//клик на пространство
        $(By.xpath(".//select[@name= '7242']/../span")).click();//клик на пространство
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='4']")).click();//выбираем пространство
        $(By.cssSelector(".array-submit")).click();//подтверждаем
        $(By.cssSelector("button.add_1")).click();//клик на Добавить
        $(By.cssSelector("button.add_1")).click();//Клик на Добавить
        /*------------------------------------------------------------------------------------------------------------*/
        $(By.xpath("//a[@interfaceid='545']")).click();//режим эксплуатации
        date1 = "02/02/2012";
        $(By.cssSelector("form_0 .m-t-btn-add-obj")).click();//Нажимаем Добавить
        $(By.xpath(".//select[@name= '7330']/../span")).click();//клик на название
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Постоянный']")).click();//выбираем название
        $(By.xpath("//*[@name = '7252']")).setValue(date1).pressEnter();//дата начала
        $(By.cssSelector("button.add_1")).click();//Добавить
        $(By.cssSelector("button.save_0")).click();//Сохраняем
        sleep(3000);
    }

    @Test(priority = 6)
//    @Description("Заполняем вкладку \"Сведения об элементах")
    public void informationAboutElements(){
        /*Определяем переменные*/
        String name1 = "Вентиль";
        String code1 = "Ar-42.В1";
        String passCode1 = "-";
        int count1 = 1;
        int Dy1 = 15;
        /*------------------------------------------------------------------------------------------------------------*/
        $(By.xpath("//button[@groupid='254']")).click();//переходим на вкладку Сведения о элементах
        $(By.cssSelector("form_0 .m-t-btn-add-obj")).click();//Нажимаем Добавить
        $(By.xpath(".//select[@name= '6358']/../span")).click(); //Клик на тип элемента
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Арматура']")).click();//выбираем тип
        $(By.xpath(".//select[@name= '6674']/../span")).click(); //Клик на подтип элемента
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='Вентиль']")).click();//выбираем подтип
        $(By.xpath("//*[@name = '6356']")).setValue(name1);//вводим название
        $(By.xpath("//*[@name = '6592']")).setValue(code1);//вводим шифр
        $(By.xpath("//*[@name = '6681']")).setValue(passCode1);//вводим шифр по паспорту
        $(By.xpath("//*[@name = '6853']")).setValue(String.valueOf(count1));//вводим количество
        //Добавим Сварку
        $(By.cssSelector(".form_0 [interid='321'] .array-str-open.tS6468")).click();//Добавим термообработку
        $(By.cssSelector(".form_1 [id='popover656240'] .tS6468 ")).setValue("Отсутствует");
        $(By.cssSelector(".form_1 [id='popover656240'] .array-submit ")).click();
        //////////Геометрические характеристики
        $(By.xpath("//*[@name = '6366']")).setValue(String.valueOf(Dy1));//вводим Dy
        /////////Материальное исполнение
        $(By.xpath(".//select[@name= '6358']/../span")).click();//Клик на материал
        $(By.cssSelector(".select2-search__field")).setValue("25");//Пишем материал
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='25']")).click();//Выбираем найденное
        $(By.xpath(".//select[@name= '7293']/../span")).click(); //Клик на гост
        $(By.xpath(".//ul[@class= 'select2-results__options']/li[text()='ГОСТ 1050-88']")).click();//выбираем гост
        $(By.cssSelector("button.add_1_0")).click();//добавляем элемент
        /*-----------------------------------*/
    }
}
