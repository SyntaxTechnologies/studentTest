package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

public class SearchAndCartManagement extends CommonMethods {

    @Given("user is on WebstaurantStore homepage")
    public void user_is_on_webstaurant_store_homepage() {
       openBrowserAndLaunchApplication();
    }
    @When("the user searches for {string}")
    public void the_user_searches_for(String searchContext) {
       sendText( searchContext,searchPage.searchBar);
       click(searchPage.searchButton);
    }
    @Then("they should see only items with {string} in the title")
    public void they_should_see_only_items_with_in_the_title(String searchButton) {
        String noOfPages = searchPage.lastPage.getText();
        boolean end=false;
        while(!end){
            List<WebElement> allData = searchPage.searchResultTable;
            for (WebElement data:allData){
                System.out.println( data.getText());

            }
            if(!end){
                click(searchPage.nextButton);
            }

        }

    }

}
