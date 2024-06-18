   //Constructor
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    //Page Methods
    public void provideEmail(String email) {
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);

    }
    public void providePassword (String password) {
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        findElement(submitBtn).click();
    }
    public void login() {
        provideEmail("kristina.sarkisyan@testpro.io");
        providePassword("o8URUDnW");
        clickSubmit();
    }



}
