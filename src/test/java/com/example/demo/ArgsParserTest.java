package com.example.demo;

import java.util.Map;

import com.example.demo.simple.ArgsParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wuzhong on 2018/4/20.
 * @version 1.0
 */
public class ArgsParserTest {

    @Test
    public void parse() {

        String[] args = new String[] {"xxx", "--t=123", "xxx", "--key", "abc", "123123", "-Dxxafasdd=1231312"};

        Map<String, String> parse = ArgsParser.parse(args);

        Assert.assertEquals("123", parse.get("t"));
        Assert.assertTrue(parse.containsKey("key"));
        Assert.assertNull(parse.get("key"));

        Assert.assertTrue(parse.size() == 2);

    }

}