package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.swing.Action;

// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
public class TestCases {
    ChromeDriver driver;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")
    public WebElement SearchBar;
    public boolean tagCheck(WebElement a){
        return false;
    }
    @Test
    public void testCase01() throws InterruptedException{
        //boolean status = false;
        int count =0;
        driver.get("http://www.flipkart.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        SearchBar.sendKeys("Washing Machine");
        SearchBar.sendKeys(Keys.ENTER);
        wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        Thread.sleep(2000);
        WebElement popularityButton = driver.findElement(By.xpath("//*[text()='Popularity']"));
        popularityButton.click();
        Thread.sleep(1000);
        //*[@id="container"]/div/div[3]/div[1]/div[2]/div
        List<WebElement> searchListElements = driver.findElements(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div/div/div/div/a"));
        for(WebElement a: searchListElements){
            //System.out.println(a.toString());
            Actions action = new Actions(driver);
            action.moveToElement(a).perform();
            WebElement StarredParent;
            try {
                if((a.findElement(By.xpath("./div[1]/div[1]")).getText().length()>0)){
                    StarredParent = a.findElement(By.xpath("./div[3]/div[1]/div[2]/span[1]/div"));
                }
                else{StarredParent = a.findElement(By.xpath("./div[2]/div[1]/div[2]/span[1]/div"));
            }    
              //  System.out.println(StarredParent.getText());
                if(Double.parseDouble(StarredParent.getText())<=4.0){
                    count=count+1;
                }
                //System.out.println(count);
            }catch(Exception e){
                System.out.println("Got a error while accesing");
            }
            Thread.sleep(2000);
        }
        System.out.println(count);
    }
    @Test
    public void testCase02(){
        driver.get("http://www.flipkart.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        SearchBar.clear();
        SearchBar.sendKeys("iPhone");
        SearchBar.sendKeys(Keys.ENTER);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        List<WebElement> TC2Titles= driver.findElements(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div/div/div/div/a"));
        for(WebElement a: TC2Titles){
            int discountValue=0;
            //System.out.println(a.toString());
            Actions action = new Actions(driver);
            action.moveToElement(a).perform();
            WebElement StarredParent;
            try {
                if((a.findElement(By.xpath("./div[1]/div[1]")).getText().length()>0)){
                    StarredParent = a.findElement(By.xpath("./div[3]"));
                }
                else{StarredParent = a.findElement(By.xpath("./div[2]"));
                }  
                String title= StarredParent.findElement(By.xpath("./div[1]/div[1]")).getText();
                //System.out.println(title);
                try{
                    String DiscountText = StarredParent.findElement(By.xpath("./div[2]/div[1]/div/div[3]/span")).getText();
                    //System.out.println(DiscountText);
                    int index = DiscountText.indexOf("%");
                    //System.out.println(index);
                    if(index!=-1){
                        String discount = DiscountText.substring(0,index);
                        //System.out.println(discount);
                        discountValue = Integer.parseInt(discount);
                        //System.out.println(discountValue);
                    }
                    }catch(Exception e){} 
                if(discountValue>17){System.out.println("Ttitle is - " + title+"Discount is - "+ discountValue);}
                
            }catch(Exception e){}
            
        } 
    }
    @Test
    public void testCase03() throws InterruptedException{
        driver.get("http://www.flipkart.com/");
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        SearchBar.clear();
        SearchBar.sendKeys("Coffee Mug");
        SearchBar.sendKeys(Keys.ENTER);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        
        WebElement checkbox4star = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div/div/section[5]/div[2]/div/div[1]/div/label"));
        action.moveToElement(checkbox4star).perform();
        //Thread.sleep(2000);
        wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        if(!checkbox4star.isSelected()){
            checkbox4star.click();
            Thread.sleep(2000);
            wait.until(driver -> ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        }
        List<WebElement> TC3Products= driver.findElements(By.className("slAVV4"));
        for(WebElement a: TC3Products){
            
            action.moveToElement(a).perform();
            //System.out.println(a.toString());
            WebElement Title = a.findElement(By.xpath("./a[2]"));
            String TtileName = Title.getText();
            WebElement urlimage =a.findElement(By.xpath("./a[1]/div[1]/div/div[1]/img"));
            String url = urlimage.getAttribute("src");
            System.out.println("Ttitle is - "+ TtileName + " Url is - "+ url);
        }
        

    }
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @SuppressWarnings("deprecation")
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();
        

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);
        //WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}


/*for(WebElement a: searchListElements){
            WebElement StarredParrent;//div[@class='tUxRFH']//div[@class='UzRoYO CmflSf']
            try{
                WebElement sort = a.findElement(By.xpath("./div[1]/div[1]"));
                String b = sort.getText();
                System.out.println(b);
                System.out.println(b);
                if(b.length()>0){
                    status =true;
                }
                
            }catch(Exception E){}
            if(status){
                StarredParrent = a.findElement(By.xpath("/div[3]"));
                System.out.println("Checking for any tags");
            }
            else{
                StarredParrent = a.findElement(By.xpath("./div[2]"));
                //tarredParrent.click();
                Thread.sleep(10000);
                System.out.println("Without tags");
                Actions actions = new Actions(driver);
                actions.moveToElement(StarredParrent).build().perform();

                System.out.println(StarredParrent.toString());
            }

            String ProductStar = StarredParrent.findElement(By.xpath("./div[1]/div[2]/span[1]/div")).getText();
            System.out.println(ProductStar);
            if(Double.parseDouble(ProductStar)>=4.0){
                count=count+1;
                System.out.println(count);
            }
        } */