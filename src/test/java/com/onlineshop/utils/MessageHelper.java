package com.onlineshop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MessageHelper {

    // TODO populate map from message property file or use Properties
    private static final Map<String, String> codeToMessages = new HashMap<String, String>();

    public static String getMessageByCode(String code) {
        populateMapWithErrCodes();
        return codeToMessages.get(code);
    }

    public static void populateMapWithErrCodes() {
        Properties prop = new Properties();
        String pathPropFileName = "src/test/resources/error_codes.properties";
        InputStream input = null;

        try {
            input = new FileInputStream(new File(pathPropFileName));
            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                codeToMessages.put(key, value);
            }

        } catch(IOException e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(MessageHelper.getMessageByCode("DB_ERR_100"));
    }

}
