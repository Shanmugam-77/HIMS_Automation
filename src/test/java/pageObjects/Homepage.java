package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@data-testid='MenuOpenIcon']")

	WebElement menuOpen;

	@FindBy(xpath = "//a[@id='2_list_btn_sn_id']")
	WebElement patCateOpen;

	@FindBy(xpath = "//*[@id='2_list_child_text_sn_id']/span[text()='UHID Registration']")
	WebElement clkUHIDpage;

	// Admin

	@FindBy(xpath = "//a[@id='1_list_btn_sn_id']")
	WebElement adminCateOpen;

	@FindBy(xpath = "//*[@id='1_list_child_sn_id']/div[1]")
	WebElement clkMasterListmenu;

	public void clkMenuopen() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='MenuOpenIcon']")));
	    menuButton.click();
	}

	public void clkCategoryOpen() {
		patCateOpen.click();
	}

	public void clkUHIDReg() {
		clkUHIDpage.click();
	}

	public void clkAdmincategory() {
		adminCateOpen.click();
		clkMasterListmenu.click();
	}
}
