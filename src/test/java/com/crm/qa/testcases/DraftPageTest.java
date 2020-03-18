package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DraftPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraftPageTest extends TestBase {
    DraftPage draftPage;
    LoginPage loginPage;
    TestUtil testUtil;


    @BeforeClass
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(priority=1)
    public void DraftPageDesigTest(){
        String title = loginPage.validateAuthority();
        Assert.assertEquals(title, "[ARCHITECT]");
    }

    @Test(priority=2)
    public void DraftPageMenuTest(){
        draftPage=new DraftPage();
        boolean title = draftPage.verifyCorrectDraftMenun();
        Assert.assertEquals(title, true);
    }

    @Test(priority=3)
    public void DraftcaseCration(){
        draftPage=new DraftPage();
        draftPage.clickDraftMenu();
        testUtil=new TestUtil();
        testUtil.switchTolistingFrame();
        draftPage.clickOnApplyFor();
        draftPage.clickOnBPLink();
        testUtil.switchToIframeAddProposalFrame();
        draftPage.selectCaseTypo("New");
        draftPage.selectProjectType("Sub Division");
        draftPage.selectLocation("SILVASSA");
        draftPage.selectOffice("SILVASSA");
        draftPage.SiteADDR("HGDBYD ","123456");
        draftPage.validateGeneraltabs("Applicants Information");
        draftPage.OwnerContDetails("Akshay","Pokley","aksh@gmail.com","8983675455");
        draftPage.OwnerAddresDetails("pune","pune","MH","12345");

    }


}
