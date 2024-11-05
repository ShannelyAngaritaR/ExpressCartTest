package tests;

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

@Execution(ExecutionMode.CONCURRENT)
public class Error500CartTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeEach
    public void setUp() {
        String driverPath = System.getProperty("user.dir") + "/src/test/resources/WebDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    @Test
    // Test que crea un error en la pagina web
    public void testServerErrorSimulation() {
        try {

            driver.get().get("http://localhost:1111/causeError500");
        } catch (WebDriverException e) {

            String errorMessage = e.getMessage();
            assertTrue(errorMessage.contains("ERR_CONNECTION_REFUSED") ||
                    errorMessage.contains("500"));
            return;
        }

        fail("Se esperaba un error 500, pero no se produjo.");
    }
}
