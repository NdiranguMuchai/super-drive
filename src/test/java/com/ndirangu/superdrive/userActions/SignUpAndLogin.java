package com.ndirangu.superdrive.userActions;

import com.ndirangu.superdrive.templatePages.HomePage;
import com.ndirangu.superdrive.templatePages.LoginPage;
import com.ndirangu.superdrive.templatePages.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SignUpAndLogin {
    @LocalServerPort
    private int port;

    private WebDriver driver;
    public String BASE_URL;


    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new ChromeDriver();
        BASE_URL = "http://localhost:" + port;



    }

    @AfterEach
    public void afterEach() {
        if (this.driver != null) {
            driver.quit();
        }
    }
    @Test
    public void getLoginPage() {
        driver.get(BASE_URL + "/login");

        //can be accessed by anyone
        assertEquals("Login", driver.getTitle());
    }

    @Test
    public void userSignup(){
        String username = "uleMsee";
        String password = "kipassword";

        driver.get(BASE_URL + "/signup");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signup("Robert", "Lewandowski", username, password);


        driver.get(BASE_URL +"/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        driver.get(BASE_URL +"/home");

        //only users who have successfully logged in can access home page
        assertEquals("Home", driver.getTitle());
    }

    @Test
    public void userLogout(){
        String username = "uleMsee";
        String password = "kipassword";

        driver.get(BASE_URL + "/signup");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signup("Robert", "Lewandowski", username, password);


        driver.get(BASE_URL +"/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        driver.get(BASE_URL +"/home");
        HomePage homePage = new HomePage(driver);
        homePage.logout();

        //once logged out user can no longer access the home page
        assertEquals("Login", driver.getTitle());

    }
}
