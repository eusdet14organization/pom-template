package com.eurotech.pages;

import com.eurotech.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends BasePage{
    public InternalPage(TestContext context) {
        super(context);
    }

    @FindBy(css = ".footer_copy")
    public WebElement footer;

    @FindBy(css = ".shopping_cart_link")
    public WebElement shoppingCartLink;

    public String getFooterText() {
        return footer.getText();
    }

    public int getShoppingCartItemsAmount(){
        return shoppingCartLink.getText().length() > 0 ? Integer.parseInt(shoppingCartLink.getText()) : 0;
    }

}
