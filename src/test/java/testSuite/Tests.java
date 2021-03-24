package testSuite;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.CategoryPage;
import utils.DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Tests {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CategoryPage categoryPage;
    private Properties parametrosProyecto;
    private FileInputStream rutaProperties;
    private DataDriven data;
    private ArrayList<String> datosCP;


    @BeforeTest
    public void preparacionTests() throws IOException {
        data = new DataDriven();
        loginPage = new LoginPage(driver);
        parametrosProyecto = new Properties();
        rutaProperties = new FileInputStream("C:\\POM_CarlosFuentes\\src\\test\\resources\\properties.properties");
        parametrosProyecto.load(rutaProperties);
        data.prepararExcel(parametrosProyecto.getProperty("rutaArchivoExcel"),parametrosProyecto.getProperty("nombreHojaConDatos"),parametrosProyecto.getProperty("tituloCampoCasosDePrueba"));
        datosCP = new ArrayList<String>();
        loginPage.conexionDriver(parametrosProyecto.getProperty("rutaChromeDriver"),parametrosProyecto.getProperty("propertyChromeDriver"),parametrosProyecto.getProperty("browser"));
        homePage = new HomePage(loginPage.getDriver());
        categoryPage = new CategoryPage(loginPage.getDriver());

    }
    @BeforeMethod
    public void cargarBrowser(){
        loginPage.cargarSitio(parametrosProyecto.getProperty("urlSitio"));
        loginPage.maximizarBrowser();
    }
    @Test
    public void Cp001_IngresoLoginConContraseniaIncorrecta() throws IOException {
        datosCP = data.getData("Cp001_IngresoLoginConContraseniaIncorrecta");
        loginPage.clicIngresa();
        loginPage.ingresaUsuario(datosCP.get(1),false);
        loginPage.ingresaContrasenia(datosCP.get(2));


        Assert.assertEquals(loginPage.obtenerMensajeContraseniaIncorrecta(),datosCP.get(3));

    }

    @Test
    public void Cp002_IngresoLoginConEmailIncorrecto() throws IOException {
        datosCP = data.getData("Cp002_IngresoLoginConEmailIncorrecto");
        loginPage.clicIngresa();
        loginPage.ingresaUsuario(datosCP.get(1),true);


        Assert.assertEquals(loginPage.obtenerMensajeEmailIncorrecto(),datosCP.get(2));

    }

    @Test
    public void Cp003_IntentarComprarArticuloSinIniciarSesion() throws IOException, InterruptedException {
        datosCP = data.getData("Cp003_IntentarComprarArticuloSinIniciarSesion");
        homePage.buscarArticulo();
        homePage.seleccionarArticulo();
        homePage.darClicEntendido();
        homePage.comprarAhora();


        Assert.assertEquals(homePage.obtenerMensajeIngresaTuCuenta(),datosCP.get(1));

    }

    @Test
    public void Cp004_IntentarAgregarAlCarritoDeComprasSinIniciarSesion() throws IOException {
        datosCP = data.getData("Cp004_IntentarAgregarAlCarritoDeComprasSinIniciarSesion");
        homePage.buscarArticulo();
        homePage.seleccionarArticulo();
        homePage.darClicEntendido();
        homePage.agregarAlCarrito();


        Assert.assertEquals(homePage.obtenerMensajeAgregarAlCarrito(),datosCP.get(1));


    }

    @Test
    public void Cp005_IntentarRegistrarUsuarioConContraseniaInvalida() throws IOException {
        datosCP = data.getData("Cp005_IntentarRegistrarUsuarioConContraseniaInvalida");
        homePage.buscarArticulo();
        homePage.seleccionarArticulo();
        homePage.agregarComentario();
        homePage.clicPreguntar();


        Assert.assertEquals(homePage.obtenerMensajeAniadirComentario(),datosCP.get(1));


    }

    @Test
    public void Cp006_IngresarAcategoriaViviendaGenerandoUnaBusqueda() throws IOException {
        datosCP = data.getData("Cp006_IngresarAcategoriaViviendaGenerandoUnaBusqueda");
        categoryPage.seleccionaCategoria();
        categoryPage.seleccionaOpcionDeVenta(datosCP.get(1));
        categoryPage.seleccionaTipoDeVivienda(datosCP.get(2));
        categoryPage.ingresaCiudad(datosCP.get(3));
        categoryPage.buscar();
        categoryPage.seleccionaPrimerResultado();
    }

    @Test
    public void Cp007_ContactarConVendedorConNumeroIncorrectoAlGenerarUnaBusquedaPorVivienda() throws IOException {
        datosCP = data.getData("Cp007_ContactarConVendedorConNumeroIncorrectoAlGenerarUnaBusquedaPorVivienda");
        categoryPage.seleccionaCategoria();
        categoryPage.seleccionaOpcionDeVenta(datosCP.get(1));
        categoryPage.seleccionaTipoDeVivienda(datosCP.get(2));
        categoryPage.ingresaCiudad(datosCP.get(3));
        categoryPage.buscar();
        categoryPage.seleccionaPrimerResultado();
        homePage.darClicEntendido();
        categoryPage.seleccionarQuieroQueMeLlamen();
        categoryPage.ingresarNombre(datosCP.get(4));
        categoryPage.ingresarNumero(datosCP.get(5));
        categoryPage.seleccionarEnviarMisDatos();

        Assert.assertEquals(categoryPage.obtenerMensajeNumeroIncorrecto(),datosCP.get(6));

    }

    @Test
    public void Cp008_ContactarConVendedorSinAverIniciadoSesionAlGenerarBusquedaDeVivienda() throws IOException {
        datosCP = data.getData("Cp008_ContactarConVendedorSinAverIniciadoSesionAlGenerarBusquedaDeVivienda");
        categoryPage.seleccionaCategoria();
        categoryPage.seleccionaOpcionDeVenta(datosCP.get(1));
        categoryPage.seleccionaTipoDeVivienda(datosCP.get(2));
        categoryPage.ingresaCiudad(datosCP.get(3));
        categoryPage.buscar();
        categoryPage.seleccionaPrimerResultado();
        homePage.darClicEntendido();
        categoryPage.seleccionarQuieroQueMeLlamen();
        categoryPage.ingresarNombre(datosCP.get(4));
        categoryPage.ingresarNumero(datosCP.get(5));
        categoryPage.seleccionarEnviarMisDatos();

        Assert.assertEquals(homePage.obtenerMensajeAniadirComentario(),datosCP.get(6));

    }


    @AfterTest
    public void postTests(){
        loginPage.cerrarBrowser();
    }
}
