package com.spring.codes;

import com.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCodes {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(context);
    }
}
