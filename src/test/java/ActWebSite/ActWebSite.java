package ActWebSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ActWebSite {

    public static void Login(String login, String pass, WebDriver driver) {
        driver.findElement(By.linkText("Войти")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void Exit(WebDriver driver) {
        driver.findElement(By.linkText("Выйти")).click();
    }

    public static void Regist(String login, String pass, WebDriver driver) {

        driver.findElement(By.linkText("Зарегистрироваться")).click();
        driver.findElement(By.id("username")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("passwordConfirm")).sendKeys(pass);
        driver.findElement(By.cssSelector("dl:nth-child(1) > .btn")).click();

    }

    public static void setFio(
            String firstName,
            String lastName,
            String middleName,
            String eMail,
            String phone,
            WebDriver driver
    ) {
        driver.findElement(By.linkText("Задать\\изменить ФИО")).click();
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("middlename")).sendKeys(middleName);
        driver.findElement(By.id("email")).sendKeys(eMail);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.cssSelector("dl:nth-child(1) > .btn")).click();
    }

    public static void DellUser(String login, String pass, WebDriver driver) {
        driver.findElement(By.linkText("Управление пользователями")).click();
        driver.findElement(By.cssSelector("tr:nth-child(2) button")).click();
    }
}
