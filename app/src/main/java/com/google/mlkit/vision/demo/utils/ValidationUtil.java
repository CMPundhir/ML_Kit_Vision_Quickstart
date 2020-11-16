package com.google.mlkit.vision.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    private static final String SERIAL_NO_REGEX = "[N]{1}[0-9]{5}[\\s]?[0-9]{4}";
    public static boolean validateText(String text){
        Pattern pattern = Pattern.compile(SERIAL_NO_REGEX);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
