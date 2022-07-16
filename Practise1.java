import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Practise1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "H:\\desktop\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.get("https://www.india.gov.in/");
		d.manage().window().maximize();
		String Title_of_website=d.getTitle();
		System.out.println(Title_of_website);
		String actualTitle="National Portal of India";
		if(Title_of_website.equalsIgnoreCase(actualTitle)) {
			System.out.println(" user navigate to correct website");
		}else
		{
			System.out.println("user navigate to wrong website");
		}
		d.navigate().refresh();
		 //search box on website 
	WebElement search_Normal=	d.findElement(By.xpath("//*[@class='form-text searchText ui-autocomplete-input']"));
	search_Normal.sendKeys("vaccine update");
	WebElement search_button=d.findElement(By.xpath("//*[@class='form-submit' and @name='op']"));
	search_button.click();
	d.navigate().back();
	Thread.sleep(2000);
	search_Normal.clear();
    
	
//	Actions act=new Actions(d);
//    act.keyDown(search_Normal, Keys.SHIFT);
//    act.sendKeys("ujwala").keyUp(search_Normal, Keys.SHIFT).build().perform();
//    act.sendKeys(search_button, Keys.ENTER);
//    Thread.sleep(2000);
//   d.navigate().back();
//   
//   Thread.sleep(2000);
//   search_Normal.clear();
   
  //  d.findElement(By.xpath("//*[@class='form-submit' and @name='op']")).click();
    System.out.println(" various testcases ");
    
    JavascriptExecutor js= (JavascriptExecutor)d;
    js.executeScript("arguments[0].value='Adarsh Grams'", search_Normal);
    js.executeScript("arguments[0].click()",search_button );
    d.navigate().back();
    
    
   WebElement advance_Search= d.findElement(By.xpath("//*[text()='Advanced Search']"));
   
   String but_name=advance_Search.getText();
   System.out.println(but_name);
   advance_Search.click();
   Select any=new Select(advance_Search);
   any.selectByVisibleText("-- Agricultural Licence");
   
    



	}

}
