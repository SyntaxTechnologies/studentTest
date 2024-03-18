package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.SearchResultPage;
import utils.CommonMethods;

import java.util.List;

public class SearchAndCartManagement extends CommonMethods {

    @Given("user is on WebstaurantStore homepage")
    public void user_is_on_webstaurant_store_homepage() {
        openBrowserAndLaunchApplication();
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String searchContext) {
        sendText(searchContext, searchPage.searchBar);
        click(searchPage.searchButton);
    }

    @Then("they should see only items with {string} in the title")
    public void they_should_see_only_items_with_in_the_title(String searchButton) {
        boolean isLastPage = false;
        while (!isLastPage) {
            // Perform the check for the current page
            List<WebElement> searchResults = searchResultPage.searchResultTable;
            for (WebElement item : searchResults) {
                String itemTitle = item.getText();
                Assert.assertTrue("The item title does not contain the word Table.", itemTitle.contains("Table"));
            }

            try {

                if (searchResultPage.nextButton.isEnabled() && searchResultPage.nextButton.isDisplayed()) {
                   click(searchResultPage.nextButton);
//               talk about wait
                } else {
                    isLastPage = true;
                }
            } catch (NoSuchElementException e) {
                isLastPage = true;
            }

        }
    }
    @When("the user navigates to the last page")
    public void the_user_navigates_to_the_last_page() {
        click(searchResultPage.lastPage);
    }

    @When("the user adds the last item found to the cart")
    public void the_user_adds_the_last_item_found_to_the_cart() {
        List<WebElement> searchResult = searchResultPage.searchResultTable;
        WebElement lastElement = searchResult.get(searchResult.size() - 1);
        click(lastElement);
        click(productDescPage.addToCartBtn);
    }
    @When("the user clicks on view cart button")
    public void the_user_clicks_on_view_cart_button() {
        click(productDescPage.viewCartBtn);
    }
    @Then("the last item should be in the cart")
    public void the_last_item_should_be_in_the_cart() {
        boolean itemAdded=false;
        int noOfItemsInCart = cartPage.cartItems.size();
        if(noOfItemsInCart==1){
            itemAdded=true;
        }
        Assert.assertTrue(itemAdded);
    }
    @When("the user empties the cart")
    public void the_user_empties_the_cart() {
      click(cartPage.emptyCarButton);
      click(cartPage.emptyCartPopup);
    }
    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        String emptyCartMsg = cartPage.emptyCartMessage.getText();
        Assert.assertEquals(emptyCartMsg,"Your cart is empty.");
    }

}
