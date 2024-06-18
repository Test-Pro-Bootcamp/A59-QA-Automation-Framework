
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Locators
    By userAvatarIcon = By.cssSelector("img[class='avatar']");

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }
}
