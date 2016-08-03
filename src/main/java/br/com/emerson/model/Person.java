package br.com.emerson.model;

public class Person {

    private String name;
    private int age;
    private String career;

    public Person() {}

    public Person(String name, int age, String career) {
        this.name = name;
        this.age = age;
        this.career = career;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

}
