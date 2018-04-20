package com.example.demo;

import com.beust.jcommander.JCommander;
import com.example.demo.jcommander.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {

        log.debug("application started");
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
            .sources(DemoApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .logStartupInfo(false)
            .run(args);

        DemoApplication app = context.getBean(DemoApplication.class);
        app.start(args);
        //SpringApplication.run(DemoApplication.class, args);
    }

    //-query 1234 -help true
    public void start(String[] args) {

        Query arg = new Query();
        JCommander jCommander = JCommander.newBuilder()
            .addObject(arg)
            .build();

        jCommander.parse(args);

        if (arg.help){
            jCommander.usage();
            return;
        }

        System.out.println(arg.toString());

    }

}
