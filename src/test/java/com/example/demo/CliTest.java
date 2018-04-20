package com.example.demo;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wuzhong on 2018/4/20.
 * @version 1.0
 */
public class CliTest {

    @Test
    public void test() throws ParseException {

        String[] args = new String[] {"xxx", "-t", "xxx", "-key", "abc", "123123", "-Dxxafasdd=1231312"};
        // create Options object
        Options options = new Options();
        // add t option
        options.addOption("t", false, "display current time");
        options.addRequiredOption("key", "oss key", true, "get key from command");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        Assert.assertTrue(cmd.hasOption("t"));
        Assert.assertTrue(cmd.getOptionValue("key").equals("abc"));

    }

    @Test
    public void test2() {
        // create the command line parser
        CommandLineParser parser = new DefaultParser();

        // create the Options
        Options options = new Options();
        options.addOption("a", "all", false, "do not hide entries starting with .");
        options.addOption("A", "almost-all", false, "do not list implied . and ..");
        options.addOption("b", "escape", false, "print octal escapes for nongraphic "
            + "characters");
        options.addOption(OptionBuilder.withLongOpt("block-size")
                              .withDescription("use SIZE-byte blocks")
                              .hasArg()
                              .withArgName("SIZE")
                              .create());
        options.addOption("B", "ignore-backups", false, "do not list implied entried "
            + "ending with ~");
        options.addOption("c", false, "with -lt: sort by, and show, ctime (time of last "
            + "modification of file status information) with "
            + "-l:show ctime and sort by name otherwise: sort "
            + "by ctime");
        options.addOption("C", false, "list entries by columns");

        String[] args = new String[] {"--block-size=10"};

        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);

            // validate that block-size has been set
            if (line.hasOption("block-size")) {
                // print the value of block-size
                System.out.println(line.getOptionValue("block-size"));
            }
        } catch (ParseException exp) {
            System.out.println("Unexpected exception:" + exp.getMessage());
        }
    }

}
