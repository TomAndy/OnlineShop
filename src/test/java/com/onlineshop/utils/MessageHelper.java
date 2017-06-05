package com.onlineshop.utils;

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
        return codeToMessages.get(code);
    }

    public MessageHelper() {
        Properties prop = new Properties();
        String propFileName = "error_codes.properties";
        InputStream input = null;

        try {
            input = new FileInputStream(propFileName);
            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println(key+"   "+value);
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
        MessageHelper ms = new MessageHelper();
        System.out.println(MessageHelper.getMessageByCode("DB_ERR_100"));
    }

}
