package com.spring.codes;

import com.spring.Config;
import com.spring.bean.Feature;
import com.spring.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(context.getBean(Person.class));

        Person person = context.getBean(Person.class);
        System.out.println(person.getName());

        Feature f = context.getBean(Feature.class);
        String name = f.getName();
        System.out.println(name);
    }
}
