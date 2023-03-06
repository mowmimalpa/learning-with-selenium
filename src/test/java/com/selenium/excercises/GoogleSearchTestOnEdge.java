package com.selenium.excercises;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;

public class GoogleSearchTestOnEdge {
    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\Dawid\\excercises_selenium\\src\\test\\resources\\drivers\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy("eager");
        // Uruchom nowy egzemplarz Edge
        driver = new EdgeDriver(options);
        // Przejdź do Google
        driver.get("http://www.google.com");
        // Akceptowanie pop-up z ciasteczkami
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        Thread.sleep(3000);
    }
    @Test
    public void testGoogleSearch() {
        // Znajdź element wprowadzania tekstu za pomocą jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do szukania
        element.sendKeys("w3schools");
        // Prześlij formularz
        element.submit();
        // Wyszukiwanie w Google jest renderowane dynamicznie za pomocą JavaScript.
        // Poczekaj na załadowanie strony. Timeout po 10 sekundach
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase()
                        .startsWith("w3schools");
            }
        });
        assertEquals("w3schools - Szukaj w Google",
                driver.getTitle());
    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}