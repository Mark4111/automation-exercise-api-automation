package Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Helper class for common utilities used across the framework.
 */
public class JsonHelper {

    // Reuse a single ObjectMapper instance (recommended by Jackson)
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads a specific key from a JSON file and returns its value as String.
     *
     * @param filePath Path of the JSON file
     * @param key      Key to retrieve
     * @return Value associated with the key as String
     */
    public static String getValueFromJson(String filePath, String key) {

        try {
            // Step 1: Read the JSON file as a tree structure
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Step 2: Get the node corresponding to the provided key
            JsonNode targetNode = rootNode.get(key);

            // Step 3: Validate key existence
            if (targetNode == null) {
                throw new RuntimeException(
                        "Key '" + key + "' not found in JSON file."
                );
            }

            // Step 4: Return value as String
            return targetNode.asText();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error reading JSON file: " + e.getMessage(),
                    e
            );
        }
    }

    /**
     * Generic method to read a JSON file and map it to any Java object.
     *
     * @param filePath Path of the JSON file
     * @param clazz    Target class type
     * @param <T>      Generic type
     * @return Object mapped from the JSON file
     */
    public static <T> T readJsonAsObject(String filePath, Class<T> clazz) {

        try {
            // Step 1: Read JSON file and map it directly to the provided class
            return objectMapper.readValue(new File(filePath), clazz);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error mapping JSON to object: " + e.getMessage(),
                    e
            );
        }
    }
    public static String convertObjectToJson(Object object) {

        try {

            return objectMapper.writeValueAsString(object);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Error converting object to JSON: "
                            + e.getMessage(),
                    e
            );
        }
    }
    public static Map<String, Object> convertObjectToMap(Object object) {

        return objectMapper.convertValue(
                object,
                new com.fasterxml.jackson.core.type.TypeReference<Map<String, Object>>() {}
        );
    }
}