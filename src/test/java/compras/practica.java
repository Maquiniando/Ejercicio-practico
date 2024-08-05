package compras;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class practica {
    
    private WebDriver driver;
   /*Definition Variables*/
    
    By clicCart = By.linkText("Laptops");
    By primerProducto = By.linkText("Sony vaio i5");
    By Page =By.xpath("//img[@src='imgs/sony_vaio_5.jpg']");
    By addPrimerproducto = By.linkText("Add to cart");
    By home =By.xpath("//a[@href='index.html']");
    By segundoproducto = By.linkText("Samsung galaxy s6");
    By addSegundoproducto = By.linkText("Add to cart");
    By visualizarcarrito = By.linkText("Cart");
    By productos = By.xpath("//h2[text()='Products']");
    By clicplace = By.cssSelector("button[data-toggle=\"modal\"][data-target=\"#orderModal");
    
    /*Formulario*/
    By name = By.id("name");
    By country = By.id("country");
    By city = By.id("city");
    By card = By.id("card");
    By month = By.id("month");
    By year = By.id("year");
    By botonCompra = By.xpath("//button[text()='Purchase']");

    @Before
    public void setUp() throws Exception {
    	
    	 System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
    	    driver = new ChromeDriver(); 
    	    driver.manage().window().maximize();
    	    driver.get("https://demoblaze.com/");
    }

    @After
    public void tearDown() throws Exception {
       
    }

    @SuppressWarnings("deprecation")
    
	@Test
    public void Agregarproductos() throws InterruptedException {
    
    	driver.findElement(clicCart).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(primerProducto).click();
    	
    	Thread.sleep(2000);
    	if(driver.findElement(Page).isDisplayed()) {
    		
    		/*Primer product*/
    		
    		Thread.sleep(2000);
    		driver.findElement(addPrimerproducto).click();
    		Thread.sleep(2000);
    		
    		 Alert alerta = driver.switchTo().alert();
             alerta.accept();
             driver.navigate().back();
             Thread.sleep(2000);
             driver.findElement(home).click();
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             
             /*Second product*/
             
             driver.findElement(segundoproducto).click();
             Thread.sleep(2000);
             driver.findElement(addSegundoproducto).click();
             Thread.sleep(2000);
    		 Alert alerta1 = driver.switchTo().alert();
             alerta1.accept();
             driver.navigate().back();
             Thread.sleep(2000);           
             
             /*Visualizar Carrito*/
             driver.findElement(visualizarcarrito).click();
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             
             /*Completer Formulario*/
             
             driver.findElement(clicplace).click();
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             driver.findElement(name).sendKeys("Malory");
             driver.findElement(country).sendKeys("Colombia");
             driver.findElement(city).sendKeys("Cali");
             driver.findElement(card).sendKeys("6059994944");
             driver.findElement(month).sendKeys("August");
             driver.findElement(year).sendKeys("2024");
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             /*Finalizar compra*/
             Thread.sleep(2000);    
             driver.findElement(botonCompra).click();
    	}
}
    
} 
