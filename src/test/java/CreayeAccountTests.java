import com.ilcarro.qa.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreayeAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isElementPresent(By.cssSelector("[href='/signup']")))
            wd.findElement(By.cssSelector("//a[contains(., 'logOut')]")).click();
    }


        @Test
         public void testSingUp(){
            wd.findElement(By.cssSelector("[href='/signup']")).click();
           Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));

           wd.findElement(By.cssSelector("#first_name")).click();
           wd.findElement(By.cssSelector("#first_name")).clear();
           wd.findElement(By.cssSelector("#first_name")).sendKeys("AS");

           wd.findElement(By.cssSelector("#second_name")).click();
            wd.findElement(By.cssSelector("#second_name")).clear();
            wd.findElement(By.cssSelector("#second_name")).sendKeys("VF");

            wd.findElement(By.cssSelector("#email")).click();
            wd.findElement(By.cssSelector("#email")).clear();
            wd.findElement(By.cssSelector("#email")).sendKeys("aa@bb109.com");

            wd.findElement(By.cssSelector("#password")).click();
            wd.findElement(By.cssSelector("#password")).clear();
            wd.findElement(By.cssSelector("#password")).sendKeys("123456789Ah");

        }



}
