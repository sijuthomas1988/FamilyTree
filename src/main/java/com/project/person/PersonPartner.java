package com.project.person;

public class PersonPartner {

    private String name;

    private PersonImpl.Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonImpl.Gender getGender() {
        return gender;
    }

    public void setGender(PersonImpl.Gender gender) {
        this.gender = gender;
    }
}
