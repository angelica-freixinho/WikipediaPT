package simples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Compras {
    String url;
    WebDriver driver;  // Objeto do selenium WebDriver


    @Before
    public void iniciar () {
        url = "https://www.magalu.com.br";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/88/chromedriver.exe");
        driver = new ChromeDriver(); // Instnciar o selenium como Chrome Driver

        driver.manage().window().maximize(); // maximizar a janela do navegador
        //Define uma espera implicita de 1 minuto, verificando o carregamento a cada milesegundos
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

    }

    @Test
    public void consultarProduto () {
        //Abrir o site
        driver.get(url);
        //String searchString  = new String("Fogão".getBytes(), "UTF-8");

        //driver.findElement(By.id("inpHeaderSearch")).sendKeys(searchString);
        driver.findElement(By.id("inpHeaderSearch")).sendKeys("Fogão");
        driver.findElement(By.id("btnHeaderSearch")).click(); // clica na lupa

//        String expectedTitle = new String("Fogão em Promoção no Magazine Luiza".getBytes(), "UTF-8");
//        String title = driver.getTitle();

        //Vlidar o titulo da pagina de retorno
//        assertEquals(expectedTitle, title);
        //assertTrue(driver.getTitle().contains("Ovo de Páscoa"));

        assertEquals("Fogão em Promoção no Magazine Luiza", driver.getTitle());

    }

    @After
    public void finalizar () {
        driver.quit();
    }
}

