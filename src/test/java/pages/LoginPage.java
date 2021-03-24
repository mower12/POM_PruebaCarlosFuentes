package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Commons;

public class LoginPage extends Commons {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /*********************************ELEMENTOS*************************************/
    By btnIngresa = By.xpath("//nav[@id=\"nav-header-menu\"]/a[contains(text(),\"Ingresa\")]");
    By inputUser = By.xpath("//input[@id=\"user_id\"]");
    By btnContinuar = By.xpath("//span[contains(text(),\"Continuar\")]");
    By btnIngresar = By.xpath("//span[contains(text(),\"Ingresar\")]");
    By inputContrasenia = By.xpath("//*[@id=\"password\"]");
    By correoIncorrecto = By.xpath("//div[contains(text(),\"Revisa tu e-mail o usuario.\")]");
    By contraseniaIncorrecta = By.xpath("//div[contains(text(),\"Revisa tu clave.\")]");

    /*********************************METODOS****************************************/
    public void clicIngresa(){
        validaElemento(btnIngresa,"Ingresa");
        click(btnIngresa,"Ingresa");
    }

    public void ingresaUsuario(String usuario,boolean incorrecto){
        validaElemento(inputUser,"Usuario");
        agregarTexto(inputUser,usuario);
        click(btnContinuar,"Continuar");
    }

    public void ingresaContrasenia(String contrasenia){
        validaElemento(inputContrasenia,"Contrasenia");
        agregarTexto(inputContrasenia,contrasenia);
        click(btnIngresar,"Ingresar");
    }

    public String obtenerMensajeEmailIncorrecto(){
        return obtenerTexto(esperaExplicita(correoIncorrecto));
    }

    public String obtenerMensajeContraseniaIncorrecta(){
        return obtenerTexto(esperaExplicita(contraseniaIncorrecta));
    }
}
