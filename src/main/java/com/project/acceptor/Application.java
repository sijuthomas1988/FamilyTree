package com.project.acceptor;


import com.project.Accessibilty.PersonNode;
import com.project.person.PersonImpl;
import com.project.person.PersonUtil;
import com.project.relationship.RelationshipType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static  void main(String[] args){
        System.out.println("Welcome to your Famity Tree Application");
        PersonUtil.loadData();
        //Map<String, String> inputMap = Application.executeProgram();
        Application.executeProgram();


    }
    public static void executeProgram(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input : ");
        String string = null;
        try {
            string = bufferedReader.readLine();
        } catch (IOException exception) {
            System.out.println("Error Parsing Information" + exception.getMessage());
        }
        Map<String, String> map = new HashMap<>();
        for(String string2 : string.split("\\s+")){
            map.put(string2.split("=")[0], string2.split("=")[1]);
        }
        Application.determineAction(map);
    }

    public static void determineAction(Map<String, String> map){

    }

    public static Map<String, List<String>> performSearchAction(Map<String, String> map){
        PersonImpl person = null;
        RelationshipType relationshipType = null;
        List<String> strings = new ArrayList<>();
        Map<String, List<String>> stringListMap = new HashMap<>();
        for(Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("Person")) {
                for(Map.Entry<String, PersonImpl> personEntry : PersonNode.getPersonMapIndex().entrySet()){
                    if(personEntry.getKey().equalsIgnoreCase(entry.getValue())){
                        person = personEntry.getValue();
                    }
                }
            }
        }
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(entry.getKey().equalsIgnoreCase("Relation")){
                relationshipType = RelationshipType.valueOf(entry.getValue());
            }
        }

        switch (relationshipType)
        {
            case SONS:
                if(person.getChildrenOfPersonImpls() != null){
                    List<PersonImpl> sonsValue = PersonNode.searchSons(person);
                    for(PersonImpl s : sonsValue) {
                        strings.add(s.getName());
                    }
                }else{
                    System.out.println("No Sons are are added for " + person.getName());
                }
               break;
            case AUNTS:
                List<PersonImpl> auntsValue = PersonNode.searchAunts(person);
                if (auntsValue == null) {
                    System.out.println("No Aunts are added for " + person.getName());
                }
                for(PersonImpl s : auntsValue) {
                    strings.add(s.getName());
                }
                break;
            case FATHER:
                PersonImpl fatherValue = PersonNode.searchFather(person);
                if (fatherValue == null) {
                    System.out.println("No Father is added for " + person.getName());
                }
                strings.add(fatherValue.getName());
                break;
            case MOTHER:
                PersonImpl motherValue = PersonNode.searchMother(person);
                if (motherValue == null) {
                    System.out.println("No Mother is added for " + person.getName());
                }
                strings.add(motherValue.getName());
                break;
            case UNCLES:
            case COUSINS:
            case SISTERS:
            case BROTHERS:
            case DAUGHTERS:
            case GRANDSONS:
            case GRANDFATHER:
            case GRANDMOTHER:
            case GRANDDAUGHTERS:
            default:
        }
        stringListMap.put(relationshipType.toString(), strings);
        return stringListMap;
    }

    public static void addAction(Map<String, String> map){

    }
}
