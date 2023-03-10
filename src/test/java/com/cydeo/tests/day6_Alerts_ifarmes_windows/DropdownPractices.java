package com.cydeo.tests.day6_Alerts_ifarmes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    public WebDriver driver;


    @BeforeMethod
     public void setupMethod(){
    //2. Go to http://practice.cybertekschool.com/dropdown
     driver= WebDriverFactory.getDriver("chrome");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("http://practice.cybertekschool.com/dropdown");
}


    @Test
    public void dropdown_task5() throws InterruptedException {

        //1. Open Chrome browser





        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));



        //3. Select Illinois
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Delaware");



       // 4. Select Virginia
        Thread.sleep(2000);
        stateDropdown.selectByValue("ID");


        //5. Select California
        Thread.sleep(2000);
        stateDropdown.selectByIndex(6);

       //6. Verify final selected option is California.
        String expectedOptionText="California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText,expectedOptionText);

    }
    @Test
    public void dropdown_Task6(){
   // 3. Select “December 1st, 1923” and verify it is selected.

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));




        // Select year using  : visible text
        yearDropdown.selectByVisibleText("1924");


         // Select month using   : value attribute

           monthDropdown.selectByValue("11");


           //Select day using : index number

           dayDropdown.selectByIndex(0);



           //creating expecter values
        String expectedYear="1924";
        String expectedMonth="December";
        String expectedDay="1";

        //getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertTrue(actualMonth.equals(expectedMonth));
        Assert.assertTrue(actualDay.equals(expectedDay));



    }



@AfterMethod
    public void teardownMethod(){
//driver.close();
}

}
/*TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)

TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using  : visible text
Select month using   : value attribute
Select day using : index number






*/