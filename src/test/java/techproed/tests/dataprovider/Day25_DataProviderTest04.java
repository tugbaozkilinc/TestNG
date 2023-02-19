package techproed.tests.dataprovider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class Day25_DataProviderTest04 {

    @Test(dataProvider = "customerData", dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String username, String password, String place){
        System.out.println("Username: " + username + " |Password: " + password + " |Place: " + place);
    }

    @Test(dataProvider = "customerServiceData", dataProviderClass = DataProviderUtils.class)
    public void customerServiceTest(String username, String password){
        System.out.println("Username: " + username + " |Password: " + password);
    }

    @Test(dataProvider = "employeeData", dataProviderClass = DataProviderUtils.class)
    public void employeeDataTest(String username, String password){
        System.out.println("Username: " + username + " |Password: " + password);
    }

    @Test(dataProvider = "customerInformation", dataProviderClass = DataProviderUtils.class)
    public void employeeInformationTest(String email, String password){
        System.out.println("Email: " + email + " |Password: " + password);
    }

}
