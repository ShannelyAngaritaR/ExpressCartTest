package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import utils.MongoDBSeeder;

import static org.junit.jupiter.api.Assertions.assertTrue;


// Configuración para la ejecución en paralelo
@Execution(ExecutionMode.CONCURRENT)
public class CartTestParalelas {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private CartPage cart;
    protected static MongoDBSeeder conn;

    @BeforeAll
    public static void beforeClass() {
        // Inicializamos la conexión a la base de datos y limpiamos la colección de productos
        conn = new MongoDBSeeder();
        conn.clearProducts();
        conn.seedProducts();
    }

    @BeforeEach
    public void beforeEach() {
        // Limpiamos y re-seed la base de datos antes de cada test


        // Configuración del WebDriver para cada hilo
        String driverPath = System.getProperty("user.dir") + "/src/test/resources/WebDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeDriver chromeDriver = new ChromeDriver();
        driver.set(chromeDriver);
        driver.get().manage().window().maximize();
        driver.get().get("http://localhost:1111");

        // Configuramos la página del carrito
        cart = new CartPage(driver.get());
    }

    @AfterEach
    public void afterEach() {
        // Cerramos el navegador después de cada test
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    @AfterAll
    public static void afterAll() {
        conn.clearProducts();
    }

    @Test
    public void testAddItemToCart() {
        assertTrue(cart.clickAddToCart());
    }

    @Test
    public void testRemoveItemFromCart() {
        assertTrue(cart.deleteAddToCart());
    }

    @Test
    public void testVerifyItemFromCart() {
        assertTrue(cart.verifyAddToCart());
    }

    @Test
    public void testMaxItemFromCart() {
        assertTrue(cart.verifyMxAddToCart());
    }


}

