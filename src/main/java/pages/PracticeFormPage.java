package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    /* ================= LOCATORS ================= */

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");

    private By mobile = By.id("userNumber");
    private By dob = By.id("dateOfBirthInput");
    private By subjects = By.id("subjectsInput");

    private By uploadPicture = By.id("uploadPicture");
    private By address = By.id("currentAddress");

    private By state = By.id("react-select-3-input");
    private By city = By.id("react-select-4-input");

    private By submitBtn = By.id("submit");

    /* ================= ACTIONS ================= */

    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }

    public void selectGender(String gender) {
        WebElement genderRadio = driver.findElement(
                By.xpath("//label[text()='" + gender + "']")
        );
        jsClick(genderRadio);
    }

    public void enterMobile(String value) {
        driver.findElement(mobile).sendKeys(value);
    }

    public void setDOB(String value) {
        WebElement dobInput = driver.findElement(dob);
        js.executeScript("arguments[0].value='';", dobInput);
        dobInput.sendKeys(value);
        dobInput.sendKeys(Keys.ENTER);
    }

    public void enterSubject(String subject) {
        WebElement subjectInput = driver.findElement(subjects);
        subjectInput.sendKeys(subject);
        subjectInput.sendKeys(Keys.ENTER);
    }

    public void selectHobby(String hobby) {
        WebElement hobbyCheckbox = driver.findElement(
                By.xpath("//label[text()='" + hobby + "']")
        );
        jsClick(hobbyCheckbox);
    }

    public void uploadPicture(String path) {
        driver.findElement(uploadPicture).sendKeys(path);
    }

    public void enterAddress(String value) {
        driver.findElement(address).sendKeys(value);
    }

    public void selectState(String value) {
        WebElement stateInput = driver.findElement(state);
        stateInput.sendKeys(value);
        stateInput.sendKeys(Keys.ENTER);
    }

    public void selectCity(String value) {
        WebElement cityInput = driver.findElement(city);
        cityInput.sendKeys(value);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        jsClick(driver.findElement(submitBtn));
    }

    /* ================= JS UTILS ================= */

    private void jsClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }
}
