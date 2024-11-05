package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor
     *
     * @param driver
     */

    public CartPage(WebDriver driver) {
        this.driver =driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    private By btnAddToCart = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[1]/div/p/a");
    private By btnAddToCart2 = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[2]/div/p/a");
    private By btnAddToCart3 = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/p/a");
    private By btnAddToCart4 = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[4]/div/p/a");
    private By txtCheckout = By.cssSelector("div[class='col-md-10 offset-md-1 col-sm-12'] input[value='1']");
    private By btnCheckout = By.xpath("//*[@id=\"cart\"]/div[2]/div/a");

    private By txtCantElementCart = By.xpath("//*[@id=\"cart-count\"]");
    private By btnCart = By.xpath("//*[@id=\"navbarText\"]/ul/li[2]/a");
    private By txtTotalCart = By.xpath("//*[@id=\"total-cart-amount\"]");
    private By btnDeleteToCart2 = By.xpath("//*[@id=\"cart\"]/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[3]/button");
    private By txtValueProduct2 = By.xpath("//*[@id=\"cart\"]/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[4]/strong");
    private By btnCloseCart = By.xpath("//*[@id=\"cart\"]/div[1]/div/button");
    private By txtPriceProduct3 = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/h4");
    private By txtCartCant = By.xpath("//*[@id=\"cart\"]/div[1]/div/div[1]/div/div/div/div[2]/div/div[2]/div/input");
    private By notifyCartCant = By.xpath("//*[@id=\"notify_message\"]");

    public boolean clickAddToCart (){
        boolean result = false;
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
            Thread.sleep(2000);
            int cantElementCart = Integer.parseInt(driver.findElement(txtCantElementCart).getText());
            result= cantElementCart == 1;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteAddToCart (){
        boolean result = false;
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart2)).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(btnCart)).click();
            //estraemos texto del total inicial
            String initialTotalText = wait.until(ExpectedConditions.visibilityOfElementLocated(txtTotalCart)).getText();
            double totalI = extractPrice(initialTotalText);

            String valueProduct2  = wait.until(ExpectedConditions.visibilityOfElementLocated(txtValueProduct2)).getText();
            double valueProduct2I = extractPrice(valueProduct2);
            Thread.sleep(3000);

            wait.until(ExpectedConditions.elementToBeClickable(btnDeleteToCart2)).click();

            Thread.sleep(3000);
            String afterRemoval = wait.until(ExpectedConditions.visibilityOfElementLocated(txtTotalCart)).getText();
            double afterRemovalI = extractPrice(afterRemoval);

            Thread.sleep(2500);

            result = totalI-valueProduct2I ==afterRemovalI;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean verifyAddToCart(){
        boolean result = false;
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart2)).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(btnCart)).click();
            //estraemos texto del total inicial
            String initialTotalText = wait.until(ExpectedConditions.visibilityOfElementLocated(txtTotalCart)).getText();
            double totalI = extractPrice(initialTotalText);
            wait.until(ExpectedConditions.elementToBeClickable(btnCloseCart)).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart3)).click();


            String valueProduct3  = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPriceProduct3)).getText();
            double valueProduct3I = extractPrice(valueProduct3);


            driver.findElement(btnCart).click();
            String afterRemoval = wait.until(ExpectedConditions.visibilityOfElementLocated(txtTotalCart)).getText();
            double afterRemovalI = extractPrice(afterRemoval);

            Thread.sleep(2500);

            result = totalI+valueProduct3I ==afterRemovalI;


            Thread.sleep(2500);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean verifyMxAddToCart(){
        boolean result = false;
        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnCart)).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
            wait.until(ExpectedConditions.elementToBeClickable(txtCheckout)).click();

            WebElement inputField = driver.findElement(txtCheckout);
            inputField.click();


            // Usar Actions para escribir "126"
            Actions actions = new Actions(driver);
            actions.sendKeys(inputField, "26").perform(); // Enviar las teclas directamente al campo

            String notify = wait.until(ExpectedConditions.visibilityOfElementLocated(notifyCartCant)).getText();


            if (notify.equals("Exceeds maximum quantity: 25")) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }





    public static double extractPrice(String priceText) throws NumberFormatException {
        // Remover cualquier símbolo que no sea un dígito o un punto decimal
        String cleanedPrice = priceText.replace("$", "");

        // Convertir el texto numérico en un valor decimal (double)
        return Double.parseDouble(cleanedPrice);
    }

}
