package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] customerData(){
        return new Object[][]{
                {"manager1", "12378", "NewYork"},
                {"manager2", "98712", "Tokyo"},
                {"manager3", "56790", "Oslo"}
        };
    }

    @DataProvider
    public Object[][] customerServiceData(){
        return new Object[][]{
                {"Adam", "12345"},
                {"Nancy", "98765"},
                {"John", "56789"}
        };
    }

    @DataProvider
    public Object[][] employeeData(){
        return new Object[][]{
                {"Jake", "65746"},
                {"Bob", "93837"},
                {"Daisy", "02837"}
        };
    }

    @DataProvider
    public Object[][] customerInformation(){
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheet = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sheet);
        return excelUtils.getDataArrayWithoutFirstRow();
    }

}
