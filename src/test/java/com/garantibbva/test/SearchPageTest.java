package com.garantibbva.test;

import com.garantibbva.base.BaseTest;
import com.garantibbva.page.SearchPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.garantibbva.constans.ConstantLoginPage.*;

public class SearchPageTest extends BaseTest {
    SearchPage searchPage;

    @Before
    public void before() {
        searchPage = new SearchPage(getDriver());
    }

    @Test
    public void loginTest() {
        searchPage.clickElement(POPUP_KAPAT);
        searchPage.writeInput(ARANACAK_URUN);
        searchPage.ClickSearch();
        searchPage.chooseProduct();
        searchPage.addBasket();
        String producktName = searchPage.getText(URUN_ADI);
        searchPage.goBasket();
        String basketName = searchPage.getText(SEPET_ADI);
        System.out.println(producktName + " - " + basketName);
        Assert.assertEquals(basketName, producktName);

    }
}
