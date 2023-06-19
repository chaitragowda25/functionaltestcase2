package functionaltestcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Test1 
{
    public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
    	WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.dealsdray.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("mui-1")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.id("mui-2")).sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(3000);
        driver.findElement(By.xpath("//h3[text()='27']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
        Thread.sleep(3000);
       
        WebElement ele = driver.findElement(By.xpath("//input[@class='MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-1imb3v5']"));
  	    FileInputStream fis=new FileInputStream("./demo-data.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        
        Actions a = new Actions(driver);
 	   a.moveToElement(ele).perform();

 	   Thread.sleep(3000);

        
        String SNO = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
        String OrderID= wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
 	    String OrderDate = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
 	    String OrderTimeStamp = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
 	    String OrderStatus = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
 	    
 	   driver.findElement(By.id("1")).sendKeys("SNO"); 
 	   driver.findElement(By.id("mui-613")).sendKeys("OrderID");
       driver.findElement(By.id("mui-614")).sendKeys("OrderDate");
       driver.findElement(By.id("mui-615")).sendKeys("OrderTimeStamp");
       driver.findElement(By.id("mui-616")).sendKeys("OrderStatus");
 	    
 	    
        driver.findElement(By.xpath("//button[text()='Import' ]")).click();
        driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
}
