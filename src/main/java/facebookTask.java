import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookTask {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        Thread.sleep(3000);


        driver.findElement(By.id("email")).sendKeys("Test123"); //email
        driver.findElement(By.name("pass")).sendKeys("123456"); //password


        driver.findElement(By.partialLinkText("Nie")).click();  //forgotten password

//        driver.navigate().to("https://www.google.com/");
//                Thread.sleep(3000);
//
//                driver.navigate().back();
//                Thread.sleep(3000);
//
//                driver.navigate().forward();
//                Thread.sleep(3000);
//
//                driver.navigate().refresh();
//                Thread.sleep(3000);





    }

}
