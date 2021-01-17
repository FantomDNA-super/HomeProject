import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import java.util.logging.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;


public class SampleTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);
    //private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }
    @Test
    public void openPage() {
        //driver.get(cfg.url());
        driver.get("https://otus.ru/");
        logger.info("Открыта страница otus");
        String i = driver.getCurrentUrl();
        String j = driver.getTitle();
        System.out.println("Your page title Is : "+j);
        //for passed
        Assert.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям",driver.getTitle());
        //for failed
        //Assert.assertEquals("Test",driver.getTitle());
        //logger.debug("test");
        //logger.error("test");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер успешно закрыт");
        }
    }
}
