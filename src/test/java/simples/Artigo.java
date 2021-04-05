package simples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Artigo {
    String url;
    WebDriver driver;  // Objeto do selenium WebDriver


    @Before
    public void iniciar () {
        url = "https://pt.wikipedia.org/";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/88/chromedriver.exe");
        driver = new ChromeDriver(); // Instnciar o selenium como Chrome Driver

        driver.manage().window().maximize(); // maximizar a janela do navegador
        //Define uma espera implicita de 1 minuto, verificando o carregamento a cada milesegundos
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

    }

    @Test
    public void consultarArtigo () throws UnsupportedEncodingException {
        //Abrir o site
        driver.get(url);
        String searchString  = new String("Ovo de Páscoa".getBytes(), "UTF-8");

        driver.findElement(By.id("searchInput")).sendKeys(searchString);
        driver.findElement(By.id("searchButton")).click(); // clica na lupa

        String expectedTitle = new String("Ovo de Páscoa – Wikipédia, a enciclopédia livre".getBytes(), "UTF-8");
        String title = driver.getTitle();

        //Vlidar o titulo da pagina de retorno
        assertEquals(expectedTitle, title);
        //assertTrue(driver.getTitle().contains("Ovo de Páscoa"));


    }

    @After
    public void finalizar () {
        driver.quit();
    }
}
