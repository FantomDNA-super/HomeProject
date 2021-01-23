import org.junit.Test;
import org.openqa.selenium.*;
//import java.util.logging.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SampleTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);
    //private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void openYandex() {
        driver.get("https://yandex.ru");
        driver.manage().window().maximize();
        String i = driver.getCurrentUrl();
        Assert.assertEquals("Яндекс",driver.getTitle());
    }

    @Test
    public void openTele2() throws InterruptedException {
        driver.get("https://msk.tele2.ru/shop/number");

        driver.findElement(By.id("searchNumber")).sendKeys("97");
        driver.findElement(By.id("searchNumber")).sendKeys(Keys.ENTER);
        //System.out.println("явное ожидание");
        //Thread.sleep(3000);

        System.out.println("неявное ожидание");
        waitForElement(driver, driver.findElement(By.xpath("(//*[@class='area-code'])[1]")));

        //2й вариант
        /*
        while(true) {
            boolean flag = driver.findElement(By.className("phone-number")).isDisplayed();
            System.out.println("Я здесь");
            if(flag)
                break;
        }
        //явное ожидание
        Thread.sleep(1000);
        */

    }
    public void waitForElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println("Я подождал" + element);

    }


    //1e ДЗ
    /*@Test
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
    @Test
    public void Size1() {
        driver.get("https://otus.ru/");
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getSize());
    }

    @Test
    public void Size2() {
        driver.manage().window().setSize(new Dimension(800,600));
        driver.get("https://otus.ru/");
        logger.info(driver.manage().window().getPosition());
    }

    @Test
    public void Size3() {
        driver.manage().window().setSize(new Dimension(800,600));
        driver.get("https://otus.ru/");
        logger.info(driver.manage().window().getPosition());
        driver.manage().window().getPosition();
        Point point = driver.manage().window().getPosition();
        driver.manage().window().setPosition(point);
        point.y = point.y + 100;
        driver.manage().window().setPosition(point);
        point.x = point.x - 100;
        driver.manage().window().setPosition(point);
    }
    
    @Test
            public void Lesson6() {
        driver.get("https://otus.ru/");
        auth();


    }

    private void auth()
    {
        String login = "rifibey721@pashter.com";
        String password = "test";
        String locator = "button.header2__auth";
        driver.findElement(By.cssSelector(locator)).click();
        driver.findElement(By.cssSelector("div.new-input-line_slim:nth-child(3) > input:nth-child(1)")).sendKeys(login);
        driver.findElement(By.cssSelector(".js-psw-input")).sendKeys(password);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();
        logger.info("Авторизация прошла успешно");

    }

    private void enterLK() {
        String locator = ".ic-blog-default-avatar";
        WebElement icon = driver.findElement(By.cssSelector(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(icon).build().perform();
        driver.get("https://otus.ru/lk/biography/personal/");

        driver.findElement(By.id("id_fname_latin"));
        driver.findElement(By.id("id_lname_latin"));
        driver.findElement(By.cssSelector(""))

        driver.findElement(By.id(""));
        driver.findElement(By.id(""));
        driver.findElement(By.id(""));

    }
     */


    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер успешно закрыт");
        }
    }
}
