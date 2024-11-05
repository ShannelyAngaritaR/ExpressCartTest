package com.tests;

import org.junit.jupiter.api.*;
import org.junitpioneer.jupiter.RetryingTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pages.CartPage;
import com.utils.MongoDBSeeder;

import static org.junit.Assert.assertTrue;

public class CartTests {
    private static  WebDriver driver; // Cambiar a no estático
    private CartPage cart;
    protected static MongoDBSeeder conn;

    @BeforeAll
    public static void beforeClass() {
        conn = new MongoDBSeeder();
        conn.clearProducts();
    }

    @BeforeEach
    public void beforeEach() {
        conn.clearProducts();
        conn.seedProducts(); // Sembrar productos antes de cada prueba
        String driverPath = System.getProperty("user.dir") + "/src/test/resources/WebDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(); // Crear una nueva instancia de ChromeDriver
        driver.manage().window().maximize();
        driver.get("http://localhost:1111"); // Navega a la URL de la aplicación
        cart = new CartPage(driver); // Inicializa la página del carrito
    }

    @AfterAll
    public static void afterAll() {

        conn.clearProducts();


    }
    @AfterEach
    public  void afterEach() {
        driver.close();

    }




    @Order(1)
    @RetryingTest(2)
    public void testAddItemToCart() {
        assertTrue(cart.clickAddToCart());
    }


    @RetryingTest(2)
    @Order(2)
    public void testRemoveItemFromCart() {
        assertTrue(cart.deleteAddToCart());
    }


    @RetryingTest(2)
    @Order(3)
    public void testVerifyItemFromCart() {
        assertTrue(cart.verifyAddToCart());
    }


    @RetryingTest(2)
    @Order(4)
    public void testMaxItemFromCart() {
        assertTrue(cart.verifyMxAddToCart());
    }
}
