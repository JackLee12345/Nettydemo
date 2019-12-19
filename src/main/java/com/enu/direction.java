package com.enu;

public enum direction {
    FRONT("front"),BEHINE("behine"),LEFT("left"),RIGHT("right");

    private static direction front;
    private String name;

    direction(String name){
        this.name = name;
        System.out.println(name);
        System.out.println("Hello World!");
    }

    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        direction d = direction.FRONT;
        System.out.println(d.getName());
        System.out.println(direction.valueOf("FRONT"));
    }
}
