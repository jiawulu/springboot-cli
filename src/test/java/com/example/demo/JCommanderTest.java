package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.internal.Lists;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wuzhong on 2018/4/20.
 * @version 1.0
 *
 * http://jcommander.org/
 */
public class JCommanderTest {

    @Test
    public void test() {
        JCommanderArg jct = new JCommanderArg();
        String[] argv = {"-log", "2", "-groups", "unit1,unit2,unit3",
            "-debug", "-Doption=value", "a", "b", "c"};
        JCommander.newBuilder()
            .addObject(jct)
            .build()
            .parse(argv);



        Assert.assertEquals(2, jct.verbose.intValue());
        Assert.assertEquals("unit1,unit2,unit3", jct.groups);
        Assert.assertEquals(true, jct.debug);
        Assert.assertEquals("value", jct.dynamicParams.get("option"));
        Assert.assertEquals(Arrays.asList("a", "b", "c"), jct.parameters);
    }

    @Test
    public void testHelp() {
        String[] argv = {"--help","true","-xafsdga","abc"};

        JCommanderArg arg = new JCommanderArg();
        JCommander.newBuilder()
            .addObject(arg)
            .build()
            .parse(argv);

        //JCommander.newBuilder()
        //    .addObject(arg)
        //    .build().usage();

        System.out.println(arg);
    }

    public static class JCommanderArg {
        @Parameter
        public List<String> parameters = Lists.newArrayList();

        @Parameter(names = {"-log", "-verbose"}, description = "Level of verbosity")
        public Integer verbose = 1;

        @Parameter(names = "-groups", required = true, description = "Comma-separated list of group names to be run")
        public String groups;

        @Parameter(names = "-debug", description = "Debug mode" , required = true)
        public boolean debug = false;

        @DynamicParameter(names = "-D", description = "Dynamic parameters go here")
        public Map<String, String> dynamicParams = new HashMap<String, String>();

        @Parameter(names = "--help", help = true)
        private boolean help = true;
    }
}
