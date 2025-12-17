package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PracticeFormPage;
import utils.ExcelUtils;

public class PracticeFormTest extends BaseTest {

    @Test(dataProvider = "practiceFormData")
    public void submitFormTest(
            String firstName,
            String lastName,
            String email,
            String gender,
            String mobile,
            String dob,
            String subject,
            String hobby,
            String picture,
            String address,
            String state,
            String city
    ) {

        driver.get("https://demoqa.com/automation-practice-form");

        PracticeFormPage form = new PracticeFormPage(driver);

        form.enterFirstName(firstName);
        form.enterLastName(lastName);
        form.enterEmail(email);
        form.selectGender(gender);
        form.enterMobile(mobile);
        form.setDOB(dob);
        form.enterSubject(subject);
        form.selectHobby(hobby);
        form.uploadPicture(picture);
        form.enterAddress(address);
        form.selectState(state);
        form.selectCity(city);
        form.submitForm();
    }

    @DataProvider(name = "practiceFormData")
    public Object[][] getData() {

        String path = System.getProperty("user.dir")
                + "/testdata/PracticeFormData.xlsx";

        return ExcelUtils.getTestData(path, "Sheet1");
    }
}
