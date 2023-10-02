import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.InvalidTestClassError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DetailPage;
import pages.LoginPage;
import pages.ShopPage;
import utils.WebDriverConfig;

public class TestShopPage extends TestBase{

	private WebDriver driver;
	LoginPage loginPage;
	ShopPage shopPage;
	DetailPage detailPage;
	
	@Before
	public void setUp() throws Exception {
		driver = WebDriverConfig.getDriver();
		loginPage = new LoginPage(driver);
		detailPage = new DetailPage(driver);
		shopPage = new ShopPage(driver);
		loginPage.visit("https://www.saucedemo.com");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
    
    @Test
    public void testImagesItems_01() {		
		try {
			loginPage.login("problem_user","secret_sauce");
			String urlPhotoItem1 = shopPage.getUrlPhotoItem(0);
			String urlPhotoItem2 = shopPage.getUrlPhotoItem(1);
			Assert.assertNotEquals(urlPhotoItem1, urlPhotoItem2);
		} catch (AssertionError err) {
			throw new AssertionError("La imagen de los productos es la misma");
		}catch (Exception e){
			
		}finally {
		}			
    }  
    
    
    @Test
    public void testImagesItems_02() {		
		try {
			loginPage.login("standard_user","secret_sauce");
			String urlPhotoItem1 = shopPage.getUrlPhotoItem(0);
			String urlPhotoItem2 = shopPage.getUrlPhotoItem(1);
			Assert.assertNotEquals(urlPhotoItem1, urlPhotoItem2);
		} catch (AssertionError err) {
			throw new AssertionError("La imagen de los productos es la misma");
		}catch (Exception e){
			
		}finally {
		}			
    }  
    
    @Test
    public void buttonLeft() {		
		try {
			loginPage.login("standard_user","secret_sauce");
			List<WebElement> items = shopPage.getListaMenu();
			Assert.assertEquals(items.get(0).getText(), "All Items");
			Assert.assertEquals(items.get(1).getText(), "About");
			Assert.assertEquals(items.get(2).getText(), "Logout");
			Assert.assertEquals(items.get(3).getText(), "Reset App State");
		} catch (AssertionError err) {
			throw new AssertionError("ASD");
		}catch (Exception e){
			
		}finally {
		}			
    }  
    
    @Test
    public void testImageItem_01() {		
		try {
			loginPage.login("problem_user","secret_sauce");
			String photoItem = shopPage.getUrlPhotoItem(0);
			shopPage.clickItem();
			String photoDetail = detailPage.getUrlImage();
			Assert.assertEquals(photoItem, photoDetail);
		} catch (AssertionError err) {
			throw new AssertionError("La imagen de los productos no es la misma");
		}catch (Exception e){
			
		}finally {
		}			
    }  
    
    @Test
    public void testImageItem_02() {		
		try {
			loginPage.login("standard_user","secret_sauce");
			String photoItem = shopPage.getUrlPhotoItem(0);
			shopPage.clickItem();
			String photoDetail = detailPage.getUrlImage();
			Assert.assertEquals(photoItem, photoDetail);
		} catch (AssertionError err) {
			throw new AssertionError("La imagen de los productos no es la misma");
		}catch (Exception e){
			
		}finally {
		}			
    }  
    
    @Test
    public void checkTextAddToCart() {		
		try {
			loginPage.login("standard_user","secret_sauce");
			
			for (int i = 0; i < shopPage.getNumItems(); i++) {
				Assert.assertEquals("Add to cart", shopPage.getButtonItemText(i));
				shopPage.clickAddToCart(i);
				Assert.assertEquals("Remove", shopPage.getButtonItemText(i));
			}
		} catch (AssertionError err) {
			throw new AssertionError("La imagen de los productos no es la misma");
		}			
    } 
    
    @Test
    public void sorterByDefault() {		
		try {
			loginPage.login("standard_user","secret_sauce");
			Assert.assertEquals("Name (A to Z)", shopPage.getTextSorter());
		} catch (AssertionError err) {
			throw new AssertionError("asd");
		}			
    } 
	
    @Test
    public void checkTextFooter() {		
		try {
			loginPage.login("standard_user","secret_sauce");
			Assert.assertEquals("© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy", shopPage.getTextFooter());
		} catch (AssertionError err) {
			throw new AssertionError("asd");
		}			
    } 
	   
    
}
