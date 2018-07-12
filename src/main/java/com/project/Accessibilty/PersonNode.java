package com.project.Accessibilty;

import com.project.person.PersonImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonNode {

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

    public List<PersonImpl> searchSisters(PersonImpl person) {
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

    public PersonImpl searchFather(PersonImpl person) {
        if (person.getFatherOfPerson().getGender() == PersonImpl.Gender.MALE) {
            return person.getFatherOfPerson();
        }
        return null;
    }

    public PersonImpl searchMother(PersonImpl person) {
        if (person.getFatherOfPerson().getGender() == PersonImpl.Gender.FEMALE) {
            return person.getFatherOfPerson();
        }
        return null;
    }

    public List<PersonImpl> searchSons(PersonImpl person) {
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

    public List<PersonImpl> searchDaughters(PersonImpl person) {
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

    public List<PersonImpl> searchCousins(PersonImpl person) {
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

    public PersonImpl searchGrandFather(PersonImpl person) {
        PersonImpl personFirst = person.getFatherOfPerson();
        PersonImpl personsGrandFather = personFirst.getFatherOfPerson();
        return personsGrandFather;
    }

    public PersonImpl searchGrandMother(PersonImpl person) {
        PersonImpl personFirst = person.getFatherOfPerson();
        PersonImpl personsGrandMother = personFirst.getFatherOfPerson().getWifeOfPerson();
        return personsGrandMother;
    }

    public List<PersonImpl> searchGrandSons(PersonImpl person) {
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

        public List<PersonImpl> searchGrandDaughters (PersonImpl person) {
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

        public List<PersonImpl> searchAunts (PersonImpl person){
            List<PersonImpl> personAunts = searchSisters(person.getFatherOfPerson());
            return personAunts;
        }

        public List<PersonImpl> searchUncles (PersonImpl person){
            List<PersonImpl> personUncles = searchBrothers(person.getFatherOfPerson());
            return personUncles;
        }

        public void printHeirarchyTree (PersonImpl person,int level){
            for (int i = 0; i < level; i++) {
                System.out.println("\t");
            }
            System.out.println(person.getName());

            List<PersonImpl> children = person.getChildrenOfPersonImpls();
            for (PersonImpl person1 : children) {
                printHeirarchyTree(person1, level + 1);
            }
        }
    }
