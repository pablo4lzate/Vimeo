import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

public class Selenium {
    
    public static void Program(String videoURL){
        System.setProperty("webdriver.chrome.driver", "lib/SeleniumWebDriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(videoURL);
        System.out.println("before");
    
        //XPATH de donde se encuentra la URL del video en VIMEO
        WebElement direccion = driver.findElement(By.cssSelector(".tm-article-content > p:nth-child(1) > iframe:nth-child(1)"));
        
        //Extraer codigo HTML del elemento
        String htmlCode = direccion.getAttribute("outerHTML");
        System.out.println(htmlCode);
        String url = extractUrl(htmlCode);
        System.out.println("Extracted URL: " + url);
    
        //Pagina del boton que redirecciona a VIMEO
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sun\"]/p[2]/a")));
        String href = boton.getAttribute("href");
    
        //Pagina Descarga
        driver.get("https://www.expertsphp.com/vimeo-video-downloader.html");
    
        WebElement barraUrl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"url\"]")));
        barraUrl.sendKeys(href);
        WebElement botonConvertir = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-form\"]/div/span/button")));
        botonConvertir.click();
    
        WebElement botonDescarga = driver.findElement(By.xpath("//*[@id=\"showdata\"]/div[4]/table/tbody/tr[3]/td"));
        Actions actions = new Actions(driver);
        actions.moveToElement(botonDescarga).perform();

        //ResetURL
        videoURL = "0";
        System.out.println(videoURL);

        //reset link en gui
        new MyFrame();

        //Restart User Input
        App.startUserInput(videoURL);
    }

    public static String extractUrl(String input) {

        // Find the starting index of the URL
        int start = input.indexOf("src=\"") + 5;
        
        // Find the ending index of the URL
        int end = input.indexOf("\"", start);
        
        // Extract the URL using substring
        String url = input.substring(start, end);
        
        // Replace any "&amp;" with "&" in the URL
        url = url.replace("&amp;", "&");
        
        return url;
    }
}
