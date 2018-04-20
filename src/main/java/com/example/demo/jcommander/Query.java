package com.example.demo.jcommander;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.internal.Lists;

/**
 * @author wuzhong on 2018/4/20.
 * @version 1.0
 */
public class Query {

    @Parameter
    public List<String> parameters = Lists.newArrayList();

    @Parameter(names = {"-type"}, description = "the type of the command")
    public String type;

    @Parameter(names = "-query", required = true, description = "the query data")
    public String groups;

    @Parameter(names = "-debug", description = "Debug mode", required = false)
    public boolean debug = false;

    @DynamicParameter(names = "-D", description = "Dynamic parameters go here")
    public Map<String, String> dynamicParams = new HashMap<String, String>();

    @Parameter(names = "-help", help = true)
    public boolean help = false;

    @Override
    public String toString() {
        return "Query{" +
            "parameters=" + parameters +
            ", type='" + type + '\'' +
            ", groups='" + groups + '\'' +
            ", debug=" + debug +
            ", dynamicParams=" + dynamicParams +
            ", help=" + help +
            '}';
    }
}
