package com.project.acceptor;

import com.project.Accessibilty.PersonNode;
import com.project.person.PersonImpl;
import com.project.person.PersonPartner;
import com.project.person.PersonUtil;
import com.project.relationship.AcceptedInput;
import com.project.relationship.RelationshipType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Application Helper Class with all Utility Methods to accept Input and Provide Output.
 * @author SKR
 */
public class ApplicationHelper {

    /**
     * Method call to accept Input from Console and save it into map of values.
     */
    public static void executeProgram() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input : ");
        String string = null;
        try {
            string = bufferedReader.readLine();
        } catch (IOException exception) {
            System.out.println("Error Parsing Information" + exception.getMessage());
        }
        Map<String, String> map = new LinkedHashMap<>();
        for (String string2 : string.split("\\s+")) {
            map.put(string2.split("=")[0], string2.split("=")[1]);
        }
        ApplicationHelper.determineAction(map);
        System.out.println("Do You Want to Exit the program? Press Y for Exit and N to continue");
        try {
            string = bufferedReader.readLine();
            if ("Y".equalsIgnoreCase(string)) {
                System.exit(0);
            } else if ("N".equalsIgnoreCase(string)) {
                executeProgram();
            }
        } catch (IOException e) {
            System.out.println("Error Parsing Information" + e.getMessage());
        }
    }

    /**
     * Determines which action to be performed based on Input. Either Search or Add.
     * @param map Values Obtained from Console.
     */
    public static void determineAction(Map<String, String> map) {
        boolean getAcceptedInput = false;
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        for (AcceptedInput acceptedInput : AcceptedInput.values()) {
            if (entry.getKey().equalsIgnoreCase(acceptedInput.toString())) {
                getAcceptedInput = true;
            }
        }
        if (!getAcceptedInput) {
            ApplicationHelper.performSearchAction(map);
        } else {
            ApplicationHelper.addPersonAction(map);
            PersonUtil.updateData();
        }


    }

    /**
     * Performs search Action depending on the parameter passed.
     * @param map Values Obtained from Console.
     */
    public static void performSearchAction(Map<String, String> map) {
        PersonImpl person = null;
        RelationshipType relationshipType = null;
        List<String> strings = new ArrayList<>();
        String string1 = new String();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("Person")) {
                for (Map.Entry<String, PersonImpl> personEntry : PersonNode.getPersonMapIndex().entrySet()) {
                    if (personEntry.getKey().equalsIgnoreCase(entry.getValue())) {
                        person = personEntry.getValue();
                    }
                }
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("Relation")) {
                relationshipType = RelationshipType.valueOf(entry.getValue().toUpperCase());
            }
        }

        switch (relationshipType) {
            case SONS:
                if (person.getChildrenOfPersonImpls() != null) {
                    List<PersonImpl> sonsValue = PersonNode.searchSons(person);
                    for (PersonImpl s : sonsValue) {
                        strings.add(s.getName());
                    }
                } else {
                    System.out.println("No Sons are are added for " + person.getName());
                }
                break;
            case AUNTS:
                List<PersonImpl> auntsValue = PersonNode.searchAunts(person);
                if (auntsValue == null) {
                    System.out.println("No Aunts are added for " + person.getName());
                }
                for (PersonImpl s : auntsValue) {
                    strings.add(s.getName());
                }
                break;
            case FATHER:
                PersonImpl fatherValue = PersonNode.searchFather(person);
                if (fatherValue == null) {
                    System.out.println("No Father is added for " + person.getName());
                }
                string1 = fatherValue.getName();
                break;
            case MOTHER:
                PersonPartner motherValue = PersonNode.searchMother(person);
                if (motherValue == null) {
                    System.out.println("No Mother is added for " + person.getName());
                }
                string1 = motherValue.getName();
                break;
            case UNCLES:
                List<PersonImpl> unclesValue = PersonNode.searchUncles(person);
                if (unclesValue == null) {
                    System.out.println("No Uncles are added for " + person.getName());
                }
                for (PersonImpl s : unclesValue) {
                    strings.add(s.getName());
                }
                break;
            case COUSINS:
                List<PersonImpl> cousinsValue = PersonNode.searchCousins(person);
                if (cousinsValue == null) {
                    System.out.println("No Cousins are added for " + person.getName());
                }
                for (PersonImpl s : cousinsValue) {
                    strings.add(s.getName());
                }
                break;
            case SISTERS:
                List<PersonImpl> sistersValue = PersonNode.searchSisters(person);
                if (sistersValue == null) {
                    System.out.println("No Sisters are added for " + person.getName());
                }
                for (PersonImpl s : sistersValue) {
                    strings.add(s.getName());
                }
                break;
            case BROTHERS:
                List<PersonImpl> brothersValue = PersonNode.searchBrothers(person);
                if (brothersValue == null) {
                    System.out.println("No Brothers are added for " + person.getName());
                }
                for (PersonImpl s : brothersValue) {
                    strings.add(s.getName());
                }
                break;
            case DAUGHTERS:
                List<PersonImpl> daughtersValue = PersonNode.searchDaughters(person);
                if (daughtersValue == null) {
                    System.out.println("No Daughters are added for " + person.getName());
                }
                for (PersonImpl s : daughtersValue) {
                    strings.add(s.getName());
                }
                break;
            case GRANDSONS:
                List<PersonImpl> grandSonsValue = PersonNode.searchGrandSons(person);
                if (grandSonsValue == null) {
                    System.out.println("No Aunts are added for " + person.getName());
                }
                for (PersonImpl s : grandSonsValue) {
                    strings.add(s.getName());
                }
                break;
            case GRANDFATHER:
                PersonImpl grandFatherValue = PersonNode.searchFather(person);
                if (grandFatherValue == null) {
                    System.out.println("No GrandFather is added for " + person.getName());
                }
                string1 = grandFatherValue.getName();
                break;
            case GRANDMOTHER:
                PersonPartner grandMotherValue = PersonNode.searchGrandMother(person);
                if (grandMotherValue == null) {
                    System.out.println("No GrandMother is added for " + person.getName());
                }
                string1 = grandMotherValue.getName();
                break;
            case GRANDDAUGHTERS:
                List<PersonImpl> grandDaughtersValue = PersonNode.searchGrandDaughters(person);
                if (grandDaughtersValue == null) {
                    System.out.println("No GrandDaughters are added for " + person.getName());
                }
                for (PersonImpl s : grandDaughtersValue) {
                    strings.add(s.getName());
                }
                break;
            case WIFE:
                PersonPartner personPartnerValue = PersonNode.searchWife(person);
                if(personPartnerValue == null){
                    System.out.println("You are not married Yet" + person.getName());
                }else {
                    string1 = personPartnerValue.getName();
                }


            default:
        }
        if (string1.isEmpty()) {
            System.out.println("Output : " + relationshipType.toString() + " = " + strings);
        } else {
            System.out.println("Output : " + relationshipType.toString() + " = " + string1);
        }

    }

    /**
     * Performs Add Action depending on the parameter passed.
     * @param map Values Obtained from Console.
     */
    public static void addPersonAction(Map<String, String> map) {
        AcceptedInput acceptedInput = null;
        PersonImpl person = null;
        String s = new String();
        RelationshipType relationshipType = null;
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        for (AcceptedInput acceptedInput1 : AcceptedInput.values()) {
            if(entry.getKey().toUpperCase().equalsIgnoreCase(acceptedInput1.toString())) {
                acceptedInput = acceptedInput1;
            }
        }
        for (Map.Entry<String, PersonImpl> personEntry : PersonNode.getPersonMapIndex().entrySet()) {
            if (personEntry.getKey().equalsIgnoreCase(entry.getValue())) {
                person = personEntry.getValue();
            }
        }

        Object keyForRelationShipAddition = map.keySet().toArray()[1];
        Object valueForRelationShipAddition = map.get(keyForRelationShipAddition);
        String string = (String) keyForRelationShipAddition;
        String addition = (String) valueForRelationShipAddition;
        for (RelationshipType relationshipType1 : RelationshipType.values()) {
            if(string.toUpperCase().equalsIgnoreCase(relationshipType1.toString())) {
                relationshipType = relationshipType1;
            }
        }

        switch (acceptedInput) {
            case MOTHER:
                if (relationshipType.equals(RelationshipType.SONS)) {
                    List<PersonImpl> personList = person.getChildrenOfPersonImpls();
                    personList.add(new PersonImpl(addition, PersonImpl.Gender.MALE));
                    person.setChildrenOfPersonImpls(personList);
                    PersonNode.addPersonToIndex(person);
                    System.out.println("Welcome to the Family " + addition);
                } else {
                    if (relationshipType.equals(RelationshipType.DAUGHTERS)) {
                        List<PersonImpl> personList = person.getChildrenOfPersonImpls();
                        personList.add(new PersonImpl(addition, PersonImpl.Gender.MALE));
                        person.setChildrenOfPersonImpls(personList);
                        PersonNode.addPersonToIndex(person);
                        System.out.println("Welcome to the Family " + addition);
                    }
                    break;

                }
            case FATHER:
                if (relationshipType.equals(RelationshipType.SONS)) {
                    List<PersonImpl> personList = person.getChildrenOfPersonImpls();
                    personList.add(new PersonImpl(addition, PersonImpl.Gender.MALE));
                    person.setChildrenOfPersonImpls(personList);
                    PersonNode.addPersonToIndex(person);
                    System.out.println("Welcome to the Family " + addition);
                } else {
                    if (relationshipType.equals(RelationshipType.DAUGHTERS)) {
                        List<PersonImpl> personList = person.getChildrenOfPersonImpls();
                        personList.add(new PersonImpl(addition, PersonImpl.Gender.MALE));
                        person.setChildrenOfPersonImpls(personList);
                        PersonNode.addPersonToIndex(person);
                        System.out.println("Welcome to the Family " + addition);
                    }
                    break;

                }
            case HUSBAND:
                if(relationshipType.equals(RelationshipType.WIFE)){
                    person.setWifeOfPerson(new PersonPartner(addition, PersonImpl.Gender.FEMALE));
                    PersonNode.addPersonToIndex(person);
                    System.out.println("Welcome to the Family " + person.getWifeOfPerson().getName());
                }
                break;
            case WIFE:
                if(relationshipType.equals(RelationshipType.HUSBAND)){
                    person.setWifeOfPerson(new PersonPartner(string, PersonImpl.Gender.MALE));
                    PersonNode.addPersonToIndex(person);
                    System.out.println("Welcome to the Family " + person.getWifeOfPerson().getName());
                }
                break;
            default:
        }
    }
}
