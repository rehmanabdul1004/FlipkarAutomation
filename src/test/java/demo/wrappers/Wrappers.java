package demo.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    WebDriver driver;
    /*
     * Write your selenium wrappers here
     */
    public static void Wsendkeys(WebElement element,String string){
      element.clear();    // Used to clear the textbox in the given element
      element.sendKeys(string); //Used to sendkeys in the given element 
      System.out.println("string written in element success");
    }
    public static void Wsendbuttons(WebElement element, Keys key){
      element.sendKeys(key);  // Used to Enter Key textbox in the given element
      System.out.println("string written in element success");
    }
    public static void Sync(int value) throws InterruptedException{
      Thread.sleep(value);    // This is used to keep the website in synch with automation..
    }

     //public Wrappers(WebDriver driver){
       // this.driver = driver;
     //}
     //I dont have much time right now regarding this so just leaving here u can check the old codings if u need.
     //I am in working profession right now so not able to make this..
}
