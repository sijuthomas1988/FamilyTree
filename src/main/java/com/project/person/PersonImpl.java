package com.project.person;


import java.util.ArrayList;
import java.util.List;

/**
 * Person Object Implementation.
 * @author SKR
 */
public class PersonImpl {

    /** wife object of person */
    private PersonPartner wifeOfPerson;

    /** name of the person object. */
    private String name;

    /** list of children object available for person */
    private List<PersonImpl> childrenOfPersonImpls = new ArrayList<>();

    /** reference to the father object of the person */
    private PersonImpl fatherOfPerson;

    /** this documents "Gender" */
    public enum Gender{
        MALE,
        FEMALE;
    }

    /** gender of the person */
    private Gender gender;

    /** gets the gender of the person */
    public Gender getGender() {
        return gender;
    }

    /** sets the gender of the person */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Constructor.
     * @param wifeOfPerson wife of person
     * @param name name of person
     * @param fatherOfPerson father of person
     * @param gender gender of person
     */
    public PersonImpl(PersonPartner wifeOfPerson, String name, PersonImpl fatherOfPerson, Gender gender) {
        this.wifeOfPerson = wifeOfPerson;
        this.name = name;
        this.fatherOfPerson = fatherOfPerson;
        this.gender = gender;
    }

    /**
     * constructor
     * @param name name of person
     * @param gender gender of person
     */
    public PersonImpl(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    /**
     * default constructor
     */
    public PersonImpl(){
        //Do Nothing
    }

    /**
     * gets the wife of person.
     * @return wifeOfPerson
     */
    public PersonPartner getWifeOfPerson() {
        return wifeOfPerson;
    }

    /**
     * sets the wife of person
     * @param wifeOfPerson
     */
    public void setWifeOfPerson(PersonPartner wifeOfPerson) {
        this.wifeOfPerson = wifeOfPerson;
    }

    /**
     * gets the name of person.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of person.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the children of person.
     * @return childrenOfPersonImpl
     */
    public List<PersonImpl> getChildrenOfPersonImpls() {
        return childrenOfPersonImpls;
    }

    /**
     * sets the children of person.
     * @param childrenOfPersonImpls
     */
    public void setChildrenOfPersonImpls(List<PersonImpl> childrenOfPersonImpls) {
        this.childrenOfPersonImpls = childrenOfPersonImpls;
    }

    /**
     * gets the father of person.
     * @return fatherOfPerson
     */
    public PersonImpl getFatherOfPerson() {
        return fatherOfPerson;
    }

    /**
     * sets the father of person.
     * @param fatherOfPerson
     */
    public void setFatherOfPerson(PersonImpl fatherOfPerson) {
        this.fatherOfPerson = fatherOfPerson;
    }

    /**
     * adds the children to the list of childrens in person object and sets them.
     * @param personImpl
     */
    public void addChildren(PersonImpl personImpl){
        List<PersonImpl> addChildernToPerson = personImpl.getChildrenOfPersonImpls();
        addChildernToPerson.add(personImpl);
        personImpl.setChildrenOfPersonImpls(childrenOfPersonImpls);
    }
}
