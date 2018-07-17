package com.project.person;

/**
 * PersonPartner Object Implementation.
 * @author SKR
 */
public class PersonPartner {

    /** name of the personpartner */
    private String name;

    /** gender of the person partner */
    private PersonImpl.Gender gender;

    /**
     * constructor
     * @param name name of the person partner
     * @param gender name of the gender of person partner
     */
    public PersonPartner(String name, PersonImpl.Gender gender){
        this.gender = gender;
        this.name = name;
    }

    /**
     * default constructor
     */
    public PersonPartner(){
        //Do Nothing
    }

    /**
     * gets the name of person partner
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of person partner
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the gender of person partner.
     * @return gender
     */
    public PersonImpl.Gender getGender() {
        return gender;
    }

    /**
     * sets the gender of person partner.
     * @param gender
     */
    public void setGender(PersonImpl.Gender gender) {
        this.gender = gender;
    }
}
