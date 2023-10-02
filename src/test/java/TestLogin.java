import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DetailPage;
import pages.LoginPage;
import pages.ShopPage;
import utils.WebDriverConfig;

public class TestLogin{

	private WebDriver driver;
	LoginPage loginPage;
	ShopPage shopPage;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mario\\eclipse-workspace\\prueba-selenium\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		shopPage = new ShopPage(driver);
		loginPage.visit("https://www.saucedemo.com");
	}
		
    @Test
    public void testLoginError() {
			loginPage.loginError("user","user");			
			Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }
    
    @Test
    public void testLoginBloqueado() {		
			loginPage.loginError("locked_out_user","secret_sauce");			
			Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out."
					+ "");
    }    
    
    @Test
    public void testLoginStandard() {
			loginPage.login("standard_user","secret_sauce");			
			shopPage = new ShopPage(driver);
			Assert.assertEquals(shopPage.getLogoName(), "Swag Labs");
    }
    
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}
