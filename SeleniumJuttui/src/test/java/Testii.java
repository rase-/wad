
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonykovanen
 */
public class Testii {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://t-avihavai.users.cs.helsinki.fi/lets/Chat");
        WebElement element = driver.findElement(By.name("tunnus"));
        element.sendKeys("tunnus");
        element.submit();
        System.out.println(driver.getPageSource());
    }
}
