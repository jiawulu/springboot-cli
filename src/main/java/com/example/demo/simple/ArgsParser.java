package com.example.demo.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuzhong on 2018/4/20.
 * @version 1.0
 */
public class ArgsParser {

    /**
     * parse command line args to Map
     *
     * @param args --a=b --c
     * @return
     */
    public static Map<String, String> parse(String... args) {
        Map<String, String> map = new HashMap<>(args.length);
        for (String arg : args) {
            if (arg.startsWith("--")) {
                String optionText = arg.substring(2, arg.length());
                String optionName;
                String optionValue = null;
                if (optionText.contains("=")) {
                    optionName = optionText.substring(0, optionText.indexOf('='));
                    optionValue = optionText.substring(optionText.indexOf('=') + 1, optionText.length());
                } else {
                    optionName = optionText;
                }
                if (optionName.isEmpty() || (optionValue != null && optionValue.isEmpty())) {
                    throw new IllegalArgumentException("Invalid argument syntax: " + arg);
                }
                map.put(optionName, optionValue);
            }
        }
        return map;
    }

}
