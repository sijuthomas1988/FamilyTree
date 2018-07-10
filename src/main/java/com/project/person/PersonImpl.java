package com.project.person;


import java.util.ArrayList;
import java.util.List;

public class PersonImpl {

    private PersonImpl wifeOfPerson;

    private String name;

    private List<PersonImpl> childrenOfPersonImpls = new ArrayList<>();

    private PersonImpl fatherOfPerson;

    public PersonImpl(PersonImpl wifeOfPerson, String name, PersonImpl fatherOfPerson) {
        this.wifeOfPerson = wifeOfPerson;
        this.name = name;
        this.fatherOfPerson = fatherOfPerson;
    }

    public PersonImpl getWifeOfPerson() {
        return wifeOfPerson;
    }

    public void setWifeOfPerson(PersonImpl wifeOfPerson) {
        this.wifeOfPerson = wifeOfPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonImpl> getChildrenOfPersonImpls() {
        return childrenOfPersonImpls;
    }

    public void setChildrenOfPersonImpls(List<PersonImpl> childrenOfPersonImpls) {
        this.childrenOfPersonImpls = childrenOfPersonImpls;
    }

    public PersonImpl getFatherOfPerson() {
        return fatherOfPerson;
    }

    public void setFatherOfPerson(PersonImpl fatherOfPerson) {
        this.fatherOfPerson = fatherOfPerson;
    }

    public void addChildren(PersonImpl personImpl){
        List<PersonImpl> addChildernToPerson = personImpl.getChildrenOfPersonImpls();
        addChildernToPerson.add(personImpl);
        personImpl.setChildrenOfPersonImpls(childrenOfPersonImpls);
    }
}