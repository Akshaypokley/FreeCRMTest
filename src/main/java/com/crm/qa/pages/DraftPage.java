package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DraftPage extends TestBase {

    @FindBy(id = "a_28019")
    @CacheLookup
    WebElement DraftMenu;

    @FindBy(id = "btnApplyFor")
    WebElement ApplyFor;

    @FindBy(id = "liBuildingPermission")
    WebElement BPLink;


    @FindBy(id = "liApplicationForm")
    WebElement ApplicaFormtab;

    @FindBy(id = "cboCaseType")
    public WebElement CaseTypo;

    @FindBy(id="cboProjectType")
    WebElement ProjectType;

    @FindBy(id = "cboLocation")
    public WebElement Location;

    @FindBy(id="cboOffice")
    WebElement Office;

    @FindBy(id = "SiteAddress_txtAddress7")
     WebElement Pin;

    @FindBy(id="SiteAddress_txtAddress6")
    WebElement Revnew;

    @FindBy(id = "btnAdd")
    WebElement Add;

    @FindBy(xpath = "//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[4]")
    WebElement AppName;


    @FindBy(xpath = "//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[5]")
    WebElement DevNM;

    @FindBy(xpath = "//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[6]")
    public WebElement email;

    @FindBy(xpath="//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[7]")
    WebElement MOB;

    @FindBy(id = "txtFlat")
    public WebElement Address1;

    @FindBy(id="txtCity")
    WebElement City;

    @FindBy(id = "txtVillage")
    WebElement State;

    @FindBy(id="txtOwnerPin")
    WebElement OwnerPin;

    @FindBy(xpath="//*[@id='TGEdit-0']/input")
    WebElement input;
    // Initializing the Page Objects:
    public DraftPage() {
        PageFactory.initElements(driver, this);
    }

    public void OwnerContDetails(String OwnName,String DepName,String Email,String Mobile)
    {
        Actions actions=new Actions(driver);

        Add.click();

        actions.doubleClick(AppName).build().perform();
        input.sendKeys(OwnName);

        actions.doubleClick(DevNM).build().perform();
        input.sendKeys(DepName);

        actions.doubleClick(email).build().perform();
        input.sendKeys(Email);

        actions.doubleClick(MOB).build().perform();
        input.sendKeys(Mobile);

    }

    public void OwnerAddresDetails(String addres1,String city,String state,String pin)
    {
        Address1.sendKeys(addres1);
        City.sendKeys(city);
        State.sendKeys(state);
        OwnerPin.sendKeys(pin);
    }

    public void SiteADDR(String revneue,String pin)
    {
        Pin.sendKeys(pin);
        Revnew.sendKeys(revneue);
    }

    public void selectProjectType(String proval)
    {
        Select proTy=new Select(ProjectType);
        proTy.selectByVisibleText(proval);
    }

    public void selectOffice(String Officenm)
    {
        Select office=new Select(Office);
        office.selectByVisibleText(Officenm);
    }
    public void selectLocation(String location)
    {
        Select loc=new Select(Location);
        loc.selectByVisibleText(location);
    }

    public void selectCaseTypo(String caseval)
    {
        Select caseTy=new Select(CaseTypo);
        caseTy.selectByVisibleText(caseval);
    }
    public boolean validateform(){
        return ApplicaFormtab.isDisplayed();
    }

    public void  validateGeneraltabs(String tabname){
        for (WebElement webtab:driver.findElements(By.xpath("//*[@id='divTabber']/ul/li/a")))
        {
            String Strtab=webtab.getText();
            if(Strtab.equals(tabname))
                webtab.click();
        }
    }

    public void  validateformpage(String formname){
        for (WebElement webtab:driver.findElements(By.xpath("//*[@id='myTabContent']//a")))
        {
            String Strtab=webtab.getText();
            if(Strtab.equals(formname))
                webtab.click();
        }
    }

    public boolean verifyCorrectDraftMenun(){
        return DraftMenu.isDisplayed();
    }

    public void clickDraftMenu(){
        DraftMenu.click();
        //return new ContactsPage();
    }

    public void clickOnApplyFor(){
        ApplyFor.click();
        //return new ContactsPage();
    }

    public String validatefromTitle(){
        return driver.getTitle();
    }



    public void clickOnBPLink(){
        BPLink.click();

    }
}
