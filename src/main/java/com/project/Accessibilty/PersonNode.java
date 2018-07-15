package com.project.Accessibilty;

import com.project.person.PersonImpl;
import com.project.person.PersonPartner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PersonNode {

    private static Map<String, PersonImpl> personMapIndex = new HashMap<>();

    public static NodeImpl<PersonImpl> createFamilytree(PersonImpl personImpl) {
        PersonImpl person = personImpl;
        NodeImpl<PersonImpl> rootNode = new NodeImpl<>(person);
        List<PersonImpl> childrenOfPersonImpls = person.getChildrenOfPersonImpls();
        if (childrenOfPersonImpls == null) {
            return null;
        }
        for (PersonImpl personSet : childrenOfPersonImpls) {
            NodeImpl<PersonImpl> childNode = new NodeImpl<>(personSet);
            rootNode.addChild(childNode);
            childNode.setParent(rootNode);
            createFamilytree(personSet);
        }
        return rootNode.getRoot();
    }

    public static List<PersonImpl> searchBrothers(PersonImpl person) {
        NodeImpl<PersonImpl> rootNode = createFamilytree(person.getFatherOfPerson());
        List<PersonImpl> temQueue = new LinkedList<>();
        if (rootNode.getChildern() == null) {
            return null;
        } else {
            for (NodeImpl<PersonImpl> childernNodes : rootNode.getChildern()) {
                PersonImpl childrenOfPerson = childernNodes.getData();
                if (childrenOfPerson.getGender() == PersonImpl.Gender.MALE && person.getName().equalsIgnoreCase(childrenOfPerson.getName()))
                    temQueue.add(childrenOfPerson);
            }
        }

        return temQueue;
    }

    public static List<PersonImpl> searchSisters(PersonImpl person) {
        NodeImpl<PersonImpl> rootNode = createFamilytree(person.getFatherOfPerson());
        List<PersonImpl> temQueue = new LinkedList<>();
        if (rootNode.getChildern() == null) {
            return null;
        } else {
            for (NodeImpl<PersonImpl> childernNodes : rootNode.getChildern()) {
                PersonImpl childrenOfPerson = childernNodes.getData();
                if (childrenOfPerson.getGender() == PersonImpl.Gender.FEMALE && person.getName().equalsIgnoreCase(childrenOfPerson.getName()))
                    temQueue.add(childrenOfPerson);
            }
        }

        return temQueue;
    }

    public static PersonImpl searchFather(PersonImpl person) {
        if (person.getFatherOfPerson().getGender() == PersonImpl.Gender.MALE) {
            return person.getFatherOfPerson();
        }
        return null;
    }

    public static PersonPartner searchMother(PersonImpl person) {
        if (person.getFatherOfPerson().getWifeOfPerson().getGender() == PersonImpl.Gender.FEMALE) {
            return person.getFatherOfPerson().getWifeOfPerson();
        }
        return null;
    }

    public static List<PersonImpl> searchSons(PersonImpl person) {
        NodeImpl<PersonImpl> rootNode = createFamilytree(person);
        List<PersonImpl> temQueue = new LinkedList<>();
        if (rootNode.getChildern() == null) {
            return null;
        } else {
            for (NodeImpl<PersonImpl> childernNodes : rootNode.getChildern()) {
                PersonImpl childrenOfPerson = childernNodes.getData();
                if (childrenOfPerson.getGender() == PersonImpl.Gender.MALE)
                    temQueue.add(childrenOfPerson);
            }
        }

        return temQueue;
    }

    public static List<PersonImpl> searchDaughters(PersonImpl person) {
        NodeImpl<PersonImpl> rootNode = createFamilytree(person);
        List<PersonImpl> temQueue = new LinkedList<>();
        if (rootNode.getChildern() == null) {
            return null;
        } else {
            for (NodeImpl<PersonImpl> childernNodes : rootNode.getChildern()) {
                PersonImpl childrenOfPerson = childernNodes.getData();
                if (childrenOfPerson.getGender() == PersonImpl.Gender.FEMALE)
                    temQueue.add(childrenOfPerson);
            }
        }

        return temQueue;
    }

    public static List<PersonImpl> searchCousins(PersonImpl person) {
        List<PersonImpl> cousinList = new ArrayList<>();
        List<PersonImpl> personBrothers = searchBrothers(person.getFatherOfPerson());
        List<PersonImpl> personSisters = searchSisters(person.getFatherOfPerson());

        for(PersonImpl personBortherChildren : personBrothers){
            cousinList.addAll(personBortherChildren.getChildrenOfPersonImpls());
        }
        for(PersonImpl personSisterChildren : personSisters){
            cousinList.addAll(personSisterChildren.getChildrenOfPersonImpls());
        }
        return cousinList;
    }

    public static PersonImpl searchGrandFather(PersonImpl person) {
        PersonImpl personFirst = person.getFatherOfPerson();
        PersonImpl personsGrandFather = personFirst.getFatherOfPerson();
        return personsGrandFather;
    }

    public static PersonPartner searchGrandMother(PersonImpl person) {
        PersonImpl personFirst = person.getFatherOfPerson();
        PersonPartner personsGrandMother = personFirst.getFatherOfPerson().getWifeOfPerson();
        return personsGrandMother;
    }

    public static List<PersonImpl> searchGrandSons(PersonImpl person) {
        List<PersonImpl> setSonsOfPerson = searchSons(person);
        List<PersonImpl> tempList = new ArrayList<>();
        for(PersonImpl sonList : setSonsOfPerson){
            List<PersonImpl> grandSonList = sonList.getChildrenOfPersonImpls();
            for(PersonImpl person1 : grandSonList){
                if(person1.getGender() == PersonImpl.Gender.MALE){
                    tempList.add(person1);
                }
            }
        }
        return tempList;
    }

        public static List<PersonImpl> searchGrandDaughters (PersonImpl person) {
            List<PersonImpl> setSonsOfPerson = searchSons(person);
            List<PersonImpl> tempList = new ArrayList<>();
            for(PersonImpl sonList : setSonsOfPerson){
                List<PersonImpl> grandSonList = sonList.getChildrenOfPersonImpls();
                for(PersonImpl person1 : grandSonList){
                    if(person1.getGender() == PersonImpl.Gender.FEMALE){
                        tempList.add(person1);
                    }
                }
            }
            return tempList;
        }

        public static List<PersonImpl> searchAunts (PersonImpl person){
            List<PersonImpl> personAunts = searchSisters(person.getFatherOfPerson());
            return personAunts;
        }

        public  static List<PersonImpl> searchUncles (PersonImpl person){
            List<PersonImpl> personUncles = searchBrothers(person.getFatherOfPerson());
            return personUncles;
        }

    public static void setPersonIndex(PersonImpl person){
        NodeImpl<PersonImpl> rootNode = new NodeImpl<>(person);
        if(rootNode.getData().getName() != null){
            personMapIndex.put(rootNode.getData().getName(), rootNode.getData());
        }if(rootNode.getData().getChildrenOfPersonImpls() != null){
            for(PersonImpl person1 : rootNode.getData().getChildrenOfPersonImpls()){
                setPersonIndex(person1);
            }
        }
    }

    public static Map<String, PersonImpl> getPersonMapIndex() {
        return personMapIndex;
    }

    public static void setPersonMapIndex(Map<String, PersonImpl> personMapIndex) {
        PersonNode.personMapIndex = personMapIndex;
    }

    public static void addPersonToIndex(PersonImpl person){
        for(Map.Entry<String, PersonImpl> map : PersonNode.getPersonMapIndex().entrySet()){
            if(map.getKey().equals(person.getName())){
                map.setValue(person);
            }
        }
    }

}
