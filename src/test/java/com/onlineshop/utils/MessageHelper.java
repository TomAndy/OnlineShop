package com.onlineshop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MessageHelper {

    private static final Properties prop = new Properties();

    static {
        String pathPropFileName = "src/test/resources/error_codes.properties";
        InputStream input = null;

        try {
            input = new FileInputStream(new File(pathPropFileName));
            prop.load(input);
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

    public static String getMessageByCode(String code) {
        return prop.getProperty(code);
    }


    public static void main(String[] args) {
        System.out.println(MessageHelper.getMessageByCode("DB_ERR_100"));
    }

}
