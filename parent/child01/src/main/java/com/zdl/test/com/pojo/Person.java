package com.zdl.test.com.pojo;

public class Person {
    public String name;
    private int age;
    private float salary;
    String work;

    public Person(String name){
        this.name = name;
    }

    private Person(int age){
        this.age = age;
    }

    private Person(float salary){
        this.salary =salary;
    }

    private Person(String name, int age, float salary, String work) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void say(String name){
        System.out.println("hello,我是"+name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", work='" + work + '\'' +
                '}';
    }
}
