package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Commons;

public class CategoryPage extends Commons {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    /*********************************ELEMENTOS*************************************/
    By btnCategoria = By.xpath("//a[contains(text(),\"Categorías\")]");
    By opcionInmuebles = By.xpath("//a[contains(text(),\"Inmuebles\")]");
    By opcionVenta = By.xpath("//select[@id=\"searchOperations\"]");
    By opcionDepartamentos = By.xpath("//select[@id=\"searchCategories\"]");
    By inputCiudad = By.xpath("(//input[@name=\"as_word\"])[2]");
    By btnBuscar = By.xpath("//main[@id=\"root-app\"]/section/form/div/button");
    By primerResultado = By.xpath("(//img[@alt=\"Casa en arriendo\"])[1]");
    By btnQuieroQueMeLlamen = By.xpath("//label[contains(text(),\"Quiero que me llamen\")]");
    By inputNombre = By.xpath("//input[@data-link=\"callme-name\"]");
    By inputNumero = By.xpath("//input[@data-link=\"callme-phone\"]");
    By btnEnviarMisDatos = By.xpath("//input[@value=\"Enviar mis datos\"]");


    By mensajeTelefonoCorrecto = By.xpath("(//span[contains(text(),'El número ingresado no es un número de teléfono.')])[1]");

    /*********************************METODOS****************************************/
    public void seleccionaCategoria(){
        esperarXSegundos(2000);
        validaElemento(btnCategoria,"Categoria");
        click(btnCategoria,"Categoria");
        esperarXSegundos(2000);
        validaElemento(opcionInmuebles,"Inmuebles");
        click(opcionInmuebles,"Inmuebles");
    }

    public void seleccionaOpcionDeVenta(String opcion){
        validaElemento(opcionVenta,"Categoria");
        click(opcionVenta,"Categoria");

        By opcionDeVenta = By.xpath("//option[contains(text(),'"+opcion+"')]");
        validaElemento(opcionDeVenta,"Categoria: "+opcion);
        click(opcionDeVenta,"Categoria: "+opcion);
    }

    public void seleccionaTipoDeVivienda(String opcion){
        validaElemento(opcionDepartamentos,"Tipo de vivienda");
        click(opcionDepartamentos,"Tipo de vivienda");

        By opcionDeVenta = By.xpath("//option[contains(text(),'"+opcion+"')]");
        validaElemento(opcionDeVenta,"Categoria: "+opcion);
        click(opcionDeVenta,"Categoria: "+opcion);
    }

    public void buscar(){
        validaElemento(btnBuscar,"Boton buscar");
        click(btnBuscar,"Boton buscar");
    }
    public void ingresaCiudad(String ciudad){
        validaElemento(inputCiudad,"Cuadro de texto buscar");
        agregarTexto(inputCiudad,ciudad);
    }
    public void seleccionaPrimerResultado(){
        esperarXSegundos(2000);
        validaElemento(primerResultado,"Primer resultado");
        click(primerResultado,"Primer resultado");

    }

    public void seleccionarQuieroQueMeLlamen(){
        esperarXSegundos(2000);
        validaElemento(btnQuieroQueMeLlamen,"Quiero que me llamen");
        click(btnQuieroQueMeLlamen,"Quiero que me llamen");

    }
    public void ingresarNombre(String nombre){
        validaElemento(inputNombre,"Cuadro de texto nombre");
        agregarTexto(inputNombre,nombre);
    }

    public void ingresarNumero(String numero){
        validaElemento(inputNumero,"Cuadro de texto numero");
        agregarTexto(inputNumero,numero);
    }
    public void seleccionarEnviarMisDatos(){
        validaElemento(btnEnviarMisDatos,"Enviar mis datos");
        click(btnEnviarMisDatos,"Enviar mis datos");
    }

    public String obtenerMensajeNumeroIncorrecto(){
        return obtenerTexto(esperaExplicita(mensajeTelefonoCorrecto));
    }

}
