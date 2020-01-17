package bidorbuy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;

public class Takelot {

	private static String getData(int rowNo, int cellno) throws Throwable {
		String v = null;
		File loc = new File("C:\\Users\\DELL\\Desktop1project\\bidorbuy\\testdata\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellno);
		v = c.getStringCellValue();
		return v;
	}


	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop1project\\bidorbuy\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		driver.get("https://www.takealot.com/");
		driver.manage().window().maximize();

		//screenshot
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File s = tk.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\DELL\\Desktop1project\\bidorbuy\\Screenshot\\img.png");
		FileUtils.copyFile(s, d);

		//options.addArguments("-disable-notifications");

		// closing the popup

		//WebElement close = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div"));
		//close.click();

		WebElement txtBox = driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/header/div/div/div[2]/form/div/div[1]/input"));
		txtBox.sendKeys(getData(1,0));

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		WebElement rclick = driver.findElement(By.xpath("//*[@id=\"pos_link_0\"]"));
		Actions acc = new Actions(driver);
		acc.contextClick(rclick).perform();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Set<String> all = driver.getWindowHandles();
		List <String> li = new ArrayList();
		li.addAll(all);
		String sa = li.get(1);
		driver.switchTo().window(sa);
		
		TakesScreenshot tk1 = (TakesScreenshot)driver;
		File s1 = tk1.getScreenshotAs(OutputType.FILE);
		File d1 = new File("C:\\Users\\DELL\\Desktop1project\\bidorbuy\\Screenshot\\img1.png");
		FileUtils.copyFile(s1, d1);

		driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/button/div/img")).click();

		Thread.sleep(3000);
		
		TakesScreenshot tk5 = (TakesScreenshot)driver;
		File s5 = tk5.getScreenshotAs(OutputType.FILE);
		File d5= new File("C:\\Users\\DELL\\Desktop1project\\bidorbuy\\Screenshot\\img1.1.png");
		FileUtils.copyFile(s, d);

		driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/div[2]/div[1]/div[2]/aside/div/div[2]/div/div/div[2]/button")).click();

		Thread.sleep(3000);
		
		TakesScreenshot tk2 = (TakesScreenshot)driver;
		File s2 = tk2.getScreenshotAs(OutputType.FILE);
		File d2 = new File("C:\\Users\\DELL\\Desktop1project\\bidorbuy\\Screenshot\\img2.png");
		FileUtils.copyFile(s2, d2);

		driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/div[1]/div/div/div[2]/div/div[2]/div/div/div/button")).click();

		Thread.sleep(1000);
		
		TakesScreenshot tk3 = (TakesScreenshot)driver;
		File s3 = tk3.getScreenshotAs(OutputType.FILE);
		File d3 = new File("C:\\Users\\DELL\\Desktop1project\\bidorbuy\\Screenshot\\img3.png");
		FileUtils.copyFile(s3, d3);

		driver.findElement(By.xpath("//*[@id=\"inline2\"]")).click();

		WebElement t = driver.findElement(By.xpath("//*[@id=\"email\"]"));

		t.sendKeys(getData(0,0));

		WebElement tx = driver.findElement(By.xpath("//*[@id=\"password\"]"));

		tx.sendKeys(getData(0,1));

		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
		
		TakesScreenshot tk4 = (TakesScreenshot)driver;
		File s4 = tk4.getScreenshotAs(OutputType.FILE);
		File d4 = new File("C:\\Users\\DELL\\Desktop1project\\bidorbuy\\Screenshot\\img4.png");
		FileUtils.copyFile(s4, d4);



	}

}
