package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

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
        System.out.println("result");
    }

}
