import com.thoughtworks.selenium.webdriven.commands.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by agorb on 11.08.2016.
 */
public class FInanceUA {
    @Test
    public void testName() throws Exception{
        String expectedResult = "927";
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://finance.i.ua/");

        WebElement buttonBuy = driver.findElement(By.xpath("//span[@onclick='fn_changeSell(this)']"));
        WebElement currency = driver.findElement(By.id("fn_c1"));
        WebElement bank = driver.findElement(By.id("fn_bank"));
        WebElement sum = driver.findElement(By.id("fn_s1"));
        WebElement result = driver.findElement(By.id("fn_o1_1"));
        WebElement rate = driver.findElement(By.id("fn_i1_1"));
        double sumToBuy = 2000;


        driver.manage().window().maximize();
        buttonBuy.click();
        new Select(currency).selectByVisibleText("USD");
        sum.sendKeys(sumToBuy+"");
        new Select(bank).selectByVisibleText("НБУ");

        /*WebElement wait = (new WebDriverWait(driver,10))
                .until(not(ExpectedConditions.textToBePresentInElementLocated(result, "0.00")));*/


        double rateNumber = Double.valueOf(rate.getAttribute("value"));
        double resultNumber = Double.valueOf(result.getAttribute("value"));
       /* Assert.assertEquals(rateNumber*sumToBuy-resultNumber>0.0001);*/
        Assert.assertTrue(rateNumber*sumToBuy-resultNumber<0.0001);



        /*new Select(carType).selectByVisibleText("Легковые 2001-3000 см³");

        new Select(driver.findElement(By.id("pay"))).selectByVisibleText("200 000 грн");

        WebElement result = driver.findElement(By.id("price-office-dis"));
        WebElement resultl = (new WebDriverWait(driver,10)).until(ExpectedConditions.textToBePresentInElement(result,expectedResult));

        String actualResult = driver.findElement(By.id("price-office-dis")).getText();
        Assert.assertEquals(actualResult,expectedResult);*/

        driver.quit();
    }
}
