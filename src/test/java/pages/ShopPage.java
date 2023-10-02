package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ShopPage extends Base{
	
	@FindBy(className = "app_logo")
	private WebElement logo;
	@FindBy(xpath = "//img[@class='inventory_item_img']")
	private WebElement photoItem;
	@FindBy(id = "react-burger-menu-btn")
	private WebElement btnBurger;
	@FindBy(xpath = "//*[@class='bm-item menu-item']")
	private WebElement btnMenu;
	@FindBy(className = "btn_inventory")
	private WebElement addButtons;
	@FindBy(xpath = "//option[1]")
	private WebElement sorter;
	@FindBy(className = "footer_copy")
	private WebElement footer;
	
	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public String getUrlPhotoItem(int item) {
		return findElements(photoItem).get(item).getAttribute("src");
	}
	
	public String getLogoName() {
		return getText(logo);
	}
	
	public String getButtonItemText(int item) {
		return findElements(addButtons).get(item).getText();
	}
	
	public int getNumItems() {
		return findElements(addButtons).size();
	}


	public void clickItem() {
		findElements(photoItem).get(0).click();		
	}
	
	public void clickAddToCart(int item) {
		findElements(addButtons).get(item).click();		
	}
	
	public List<WebElement> getListaMenu() {
		click(btnBurger);
		return findElements(btnMenu);		
	}
	
	public String getTextSorter() {
		return getText(sorter);
	}
	
	public String getTextFooter() {
		return getText(footer);
	}
	
	
	
}
