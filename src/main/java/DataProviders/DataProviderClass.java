package DataProviders;

import Utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;

public class DataProviderClass {
    JsonUtils jsonUtils = new JsonUtils();
    String baseDir = System.getProperty("user.dir");
    @DataProvider(name = "testdata")
    public static Object[][] testData() {
        return new Object[][] {
                {"data1", 10},
                {"data2", 20},
                {"data3", 30}
        };
    }

    @DataProvider(name = "CareerDetails")
    public static Object[] zoomInfoData(){
        return new Object[]{
"test1"
        };
    }

    @DataProvider(name = "chatBotTestDataSet")
    public Object[][] chatBotTestDataSet() {
        System.out.println("base directory is "+baseDir);
        List<JsonNode> dataObjects = jsonUtils.provideTestData(baseDir+"/src/test/resources/jsontestdata/ZoomInfo/ChatBot/chatBotScenarioData.json");

        Object[][] testData = new Object[dataObjects.size()][1];
        for (int i = 0; i < dataObjects.size(); i++) {
            testData[i][0] = dataObjects.get(i);
        }

        return testData;
    }
    @DataProvider(name = "chatBotSourceDataSet")
    public Object[][] chatBotSourceDataSet() {
        System.out.println("base directory is "+baseDir);
        List<JsonNode> dataObjects = jsonUtils.provideTestData(baseDir+"/src/test/resources/jsontestdata/ZoomInfo/ChatBot/chatBotSourceData.json");

        Object[][] testData = new Object[dataObjects.size()][1];
        for (int i = 0; i < dataObjects.size(); i++) {
            testData[i][0] = dataObjects.get(i);
        }

        return testData;
    }
}
