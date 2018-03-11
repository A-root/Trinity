package ru.giap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EnumTest {
    @Test(priority = 1)
    public void openLoginPage() {
        open("https://system.misnik.by:8484/index.php/login");
        $(By.xpath("//*[@id='username']")).setValue("TaushevIS");
        $(By.xpath("//*[@id='password']")).setValue("tMYPHSIa");
        $(By.cssSelector("#loginbtn > form > div.form-actions > button")).click();
        $(By.xpath("//span[@class='username']")).shouldHave(text("Таушев Игорь Сергеевич"));
    }

    @Test(priority = 2)
    public void openEnumModule() {
        sleep(1000);
        $(By.xpath("//*[@id = 'btn-mdl-all']")).shouldBe(visible).click();
        $(By.id("5-9")).shouldBe(visible).click();
    }

    @Test
    public void createFolder(){
        title().contentEquals("Перечисления");
        $(By.id(".//44789835_anchor")).contextClick()
                .$(By.xpath("//a[@rel=2]")).click();


    }
}
