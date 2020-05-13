package com.example.dataStructure.entity;

/**
 * create by Freedom on 2020/5/12
 */
public class Person implements Comparable {
   private String name;
   private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
