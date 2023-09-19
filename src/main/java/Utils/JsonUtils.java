package Utils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;


public class JsonUtils {



    public static List<JsonNode> provideTestData(String filePath) {
        List<JsonNode> dataObjects = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            JsonNode testDataNode = rootNode.get("TestData");

            if (testDataNode != null && testDataNode.isArray()) {
                Iterator<JsonNode> testDataIterator = testDataNode.elements();
                while (testDataIterator.hasNext()) {
                    JsonNode item = testDataIterator.next();
                    dataObjects.add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataObjects;
    }


}
