package com.onlineshop.utils;

import java.util.HashMap;
import java.util.Map;

public class MessageHelper {

    // TODO populate map from message property file or use Properties
    private static final Map<String, String> codeToMessages = new HashMap<String, String>();

    public static String getMessageByCode(String code) {

        return codeToMessages.get(code);
    }

}
