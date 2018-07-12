package com.project.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonIndex {

    private Map<String, PersonImpl> personIndexList = new HashMap<>();

    public void createPerson(String name, PersonImpl wifeOfPerson, PersonImpl fatherOfPerson, PersonImpl.Gender gender){
        if(searchIndex(name) == null) {
            PersonImpl person = new PersonImpl(wifeOfPerson, name, fatherOfPerson, gender);
            person.setName(name);
            person.setWifeOfPerson(wifeOfPerson);
            addPersonToIndex(person);
        }

    }

    public void addPersonToIndex(PersonImpl person){
        personIndexList.put(person.getName(), person);
    }

    public PersonImpl searchIndex(String name){
        for(Map.Entry<String, PersonImpl> searchMap : personIndexList.entrySet()){
            if(searchMap.getKey() == name){
                return searchMap.getValue();
            }
        }
        return null;
    }
}
