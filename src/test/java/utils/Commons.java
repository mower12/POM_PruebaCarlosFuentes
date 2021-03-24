package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commons {
    private WebDriver driver;
    private WebDriverWait espera;

    public Commons(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void click(By localizador,String nombreElemento){
        try{
            this.driver.findElement(localizador).click();
            System.out.println("Se da clic al elemento: " + nombreElemento);
        }catch (Exception e){
            System.err.println("[Error] - No se ha podido dar clic al elemento: "+nombreElemento);
        }

    }
    public void maximizarBrowser() {
        this.driver.manage().window().maximize();
    }

    public void cerrarBrowser() {
        this.driver.close();
    }
    public WebElement validaElemento(By localizador,String nombreElemento){
        try{

            driver.findElement(localizador);
            System.out.println("[Exitoso] - Se valida el siguiente elemento: " + nombreElemento);
        }catch (Exception e){
            System.err.println("[Error] - No se ha podido validar el elemento: "+nombreElemento);
        }
        return this.driver.findElement(localizador);
    }
    public void esperarXSegundos(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }
    public String obtenerTexto(WebElement element){
        return element.getText();
    }
    public void agregarTexto(By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }
    public void agregarTexto(WebElement element, String texto){
        element.sendKeys(texto);
    }
    public void cargarSitio(String url){
        this.driver.get(url);
    }

    public WebDriver conexionDriver(String rutaDriver,String propertyDriver,String browser){

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty(propertyDriver,rutaDriver);
            this.driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty(propertyDriver,rutaDriver);
            this.driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("IExplorer")){
            System.setProperty(propertyDriver,rutaDriver);
            this.driver = new ChromeDriver();
        }


        return this.driver;
    }
    public WebElement esperaExplicita(By localizador){
        espera = new WebDriverWait(this.driver,30);
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));

    }
    public boolean validarElemento(By localizador, String nombreElemento){
        try{

            driver.findElement(localizador);
            System.out.println("[Exitoso] - Se da valida el siguiente elemento: " + nombreElemento);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
