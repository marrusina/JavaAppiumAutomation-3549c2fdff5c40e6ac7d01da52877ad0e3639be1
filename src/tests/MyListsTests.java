package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";

    @Test
    public void testSaveFirstArticleToMyList()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);

        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

      //  if(Platform.getInstance().isAndroid()){
        //    MyListsPageObject.openFolderByName(name_of_folder);

        //}

        MyListsPageObject.swipeByArticleToDelete(article_title);


    }

    @Test
    public void testSaveAndDeleteSecondArticle()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();

        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        //second article
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForClearMiniButtomToAppear();
        SearchPageObject.clickClearMiniSearch();
        SearchPageObject.waitForClearMiniButtomToDisappear();

        SearchPageObject.typeSearchLine("c++");
        SearchPageObject.clickByArticleWithSubstring("General purpose high-level programming language");

        ArticlePageObject.waitForSecondTitleElement();

        String article_title_first = ArticlePageObject.getSecondArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addSecondArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeSecondArticle();

         NavigationUI NavigationUI = NavigationUIFactory.get(driver);
         NavigationUI.clickMyLists();

         MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDelete(article_title);

        SearchPageObject.clickByArticleWithSubstring("General purpose high-level programming language");

        ArticlePageObject.waitForSecondTitleElement();

        String article_title_second = ArticlePageObject.getSecondArticleTitle();

        assertEquals(
               "Titles are not the same",
               article_title_first,
               article_title_second);

    }

}
