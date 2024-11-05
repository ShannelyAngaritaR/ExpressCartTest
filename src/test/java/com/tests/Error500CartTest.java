package com.tests;

import com.pages.CartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertTrue;

public class Error500CartTest {
    private static  WebDriver driver;
    private CartPage cart;

    @BeforeEach
    public void setUp() {
        String driverPath = System.getProperty("user.dir") + "/src/test/resources/WebDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(); // Crear una nueva instancia de ChromeDriver
        driver.manage().window().maximize();
        driver.get("http://localhost:1111/causeError"); // Navega a la URL de la aplicación
        cart = new CartPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    // Test que crea un error en la pagina web
    public void testServerErrorSimulation() {
        assertTrue(cart.controlError500());
    }
}
