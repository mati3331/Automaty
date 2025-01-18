package PodPipeline;

import helpers.BrowserManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumTest {
    WebDriver driver;

    @BeforeEach
    public void setup () {
        // Zarządzanie ChromeDriver przez WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Ustawienie opcji Chrome w trybie headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Uruchomienie przeglądarki w trybie headless
        options.addArguments("--no-sandbox"); // Optymalizacja dla środowisk CI/CD (np. Docker)
        options.addArguments("--disable-dev-shm-usage"); // Wsparcie dla Docker

        // Zastosowanie ustawionych opcji w WebDriverze
        driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/");
    }

    @AfterEach
    public void cleanup () {
        driver.quit();
    }

    @Test
    public void wejscieNaYoutube() {
        // Testowanie czy strona jest dostępna
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        // Możesz dodać asercje tutaj, np.
        // assertTrue(title.contains("YouTube"));
    }
}

