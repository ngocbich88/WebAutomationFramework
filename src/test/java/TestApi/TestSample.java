package TestApi;

import static org.testng.Assert.assertEquals;
import base.TestBase;
import libs.Common;
import libs.Config;
import objects.SampleObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestSample extends TestBase {

    @Test
    public void sample() {

        driver.get(Config.getConfig("BASEURL"));
        Common _common = new Common();
        SampleObjects _sampleObjects = new SampleObjects();
        PageFactory.initElements(driver, _sampleObjects);
//        _common.selectRadioButton(driver, _sampleObjects.radioBtnMale);
//        _common.selectCheckbox(driver, _sampleObjects.checkboxOption1);
//        _common.selectDropdownlistByValue(driver, _sampleObjects.multipleSelect, "Saturday");
//        _common.selectDropdownlistByValue(driver, _sampleObjects.selectjquery, "Denmark");
//        _common.selectDropdownlistByValue(driver, _sampleObjects.selectwithcatergorized, "Java");
//        _common.selectGroupedDropdownListByValue(driver, _sampleObjects.selectwithcatergorized, "Java");
//        _common.selectGroupedDropdownDynamicListByValue(driver,_sampleObjects.groupedDropdownListXpath, "Java");
//        System.out.println(_common.selectMultipleItemByValues(driver, _sampleObjects.multipleSelect, "California,Florida,New Jersey", ","));

//        _common.tableToList(driver, _sampleObjects.tablePagnition);
//        _common.tableToArrayWithPagination(driver, _sampleObjects.tablePagnition);
        
//        _common.tableToArrayWithPagination(driver,_sampleObjects.tablePagnition);
          
//        _common.clickObject(driver, _sampleObjects.btnClickforPrompt1);
//        _common.acceptAlert(driver);
//        _common.dismissAlert(driver);
        
        // Window handler
//        String handlerID = _common.getCurrentWindowHandler(driver);
//        _common.clickObject(driver, _sampleObjects.btnLikeUsOnFacebook);
//        _common.windowHandlerSwitch(driver, false);        
//        _common.setText(driver, _sampleObjects.txtEmail, "ngoc email ...");       
//        _common.closeDriver(driver);
//        _common.switchToWindowHandler(driver, handlerID);
//        _common.clickObject(driver, _sampleObjects.btnLikeUsOnFacebook);
        
        
        // download
//        _common.clickObject(driver, _sampleObjects.lnkDownload);
        
        // take screenshot after failure        
        assertEquals(true, false);
    }
    
    @Test
    public void sample2() {
    	assertEquals(true, false);
    }
    
    @Test
    public void sample3() {
    	assertEquals(true, false);
    }
    
    @Test
    public void sample4() {
    	assertEquals(true, true);
    }

}
