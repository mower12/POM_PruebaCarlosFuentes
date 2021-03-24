package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Commons;

public class HomePage extends Commons {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    /*********************************ELEMENTOS*************************************/
    By inputBuscar = By.xpath("//input[@name=\"as_word\"]");
    By btnBuscar = By.xpath("//button/div[@aria-label=\"Buscar\"]");
    By productoSeleccionado = By.xpath("(//img[@class=\"ui-search-result-image__element\"])[1]");
    By btnComprarAhora = By.xpath("//span[contains(text(),\"Comprar ahora\")]");
    By btnAgregarAlCarrito = By.xpath("//span[contains(text(),\"Agregar al carrito\")]");
    By btnEntendido = By.xpath("//button[contains(text(),\"Entendido\")]");
    By txtIngresaTuCuenta = By.xpath("//h2[contains(text(),\"¡Hola! Para comprar, ingresa a tu cuenta\")]");
    By txtAgregarAlCarrito = By.xpath("//h2[contains(text(),\"¡Hola! Para agregar al carrito, ingresa a tu cuenta\")]");
    By txtPreguntar = By.xpath("//h2[contains(text(),\"¡Hola! Para preguntar, ingresa a tu cuenta\")]");
    By inputComentario = By.xpath("//textarea[@name=\"question\"]");
    By btnPreguntar = By.xpath("//span[contains(text(),\"Preguntar\")]");





    /*********************************METODOS****************************************/

    public void buscarArticulo(){
        validaElemento(inputBuscar,"Cuadro de texto buscar");
        agregarTexto(inputBuscar,"Accesorio Tunning");
        click(btnBuscar,"Boton Buscar");

    }
    public void seleccionarArticulo(){
        validaElemento(productoSeleccionado,"Seleccionar Articulo");
        click(productoSeleccionado,"Seleccionar Articulo");
    }

    public void comprarAhora(){
        validaElemento(btnComprarAhora,"Comprar ahora");
        click(btnComprarAhora,"Comprar Ahora");
    }
    public void agregarAlCarrito(){
        validaElemento(btnAgregarAlCarrito,"Agregar Al carrito");
        click(btnAgregarAlCarrito,"Agregar Al carrito");
    }
    public String obtenerMensajeIngresaTuCuenta(){
        return obtenerTexto(esperaExplicita(txtIngresaTuCuenta));
    }
    public String obtenerMensajeAgregarAlCarrito(){
        return obtenerTexto(esperaExplicita(txtAgregarAlCarrito));
    }

    public void darClicEntendido(){
        if(validarElemento(btnEntendido,"Entendido")) {
            esperarXSegundos(2000);
            click(btnEntendido, "Entendido");
        }
    }
    public void agregarComentario(){
        validaElemento(inputComentario,"Cuadro de texto comentario");
        agregarTexto(inputComentario,"Accesorio Tunning");
    }
    public void clicPreguntar(){
        validaElemento(btnPreguntar,"Boton Preguntar");
        click(btnPreguntar,"Boton Preguntar");
    }
    public String obtenerMensajeAniadirComentario(){
        return obtenerTexto(esperaExplicita(txtPreguntar));
    }
}
