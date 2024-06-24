import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFromFactory;
import pageFactory.LoginPageFromFactory;

public class Homework23Test extends BaseTest{

@Test
  public void createNewPlaylist () {
      String expectedCreatedPlaylistMessage = "Created playlist \"Kristina.\"";
      LoginPageFromFactory loginPageFromFactory = new LoginPageFromFactory(getDriver());
      HomePageFromFactory homePageFromFactory = new HomePageFromFactory(getDriver());

      loginPageFromFactory.provideEmail("kristina.sarkisyan@testpro.io")
              .providePassword("o8URUDnW")
              .clickSubmit();
      homePageFromFactory.clickPlaylists()
              .clickNewPlaylist()
              .enterNewPlaylistName();
String actualMsg = homePageFromFactory.getCreatedPlaylistMsg();
      Assert.assertEquals(actualMsg,expectedCreatedPlaylistMessage);
  }





}
