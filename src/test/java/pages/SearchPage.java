package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class SearchPage extends CommonMethods {
    @FindBy(xpath = "//ul[@id='awesomplete_list_2']/preceding-sibling::input")
    public WebElement searchBar;

    @FindBy(xpath = "(//button[@value='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@id='product_listing']/div/div/a/span")
    public List<WebElement> searchResultTable;

    @FindBy(xpath = "//a[@aria-label='go to page 2']")
    public WebElement nextButton;

    @FindBy(xpath = "//a[contains(@aria-label,'last page')]")
    public  WebElement lastPage;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }
}
