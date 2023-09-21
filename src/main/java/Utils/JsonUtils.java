package Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Utility class for working with JSON data.
 */
public class JsonUtils {

    /**
     * Reads a JSON file and returns a list of JSON objects.
     */
    public static List<JsonNode> provideTestData(String filePath) {
        // Input: File path to a JSON file
        // Processing: Read the file, extract JSON objects under "TestData" key
        // Output: List of JSON objects
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

    /**
     * Converts a Java object to its JSON string representation.
     */
    public static <T> String objectToJSONString(T object) {
        // Input: Java object
        // Processing: Convert the object to a JSON string
        // Output: JSON string representing the object
        String json = null;
        ObjectMapper mapperObj = new ObjectMapper();
        mapperObj.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        try {
            json = mapperObj.writeValueAsString(object);
        } catch (Throwable var4) {
            var4.printStackTrace();
        }

        return json;
    }
}
