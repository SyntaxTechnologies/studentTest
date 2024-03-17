package utils;


import pages.SearchPage;

public class PageInitializer {
    public static SearchPage searchPage;




    public static void initializePageObjects(){
//declaring the object
        searchPage = new SearchPage();

    }
}
