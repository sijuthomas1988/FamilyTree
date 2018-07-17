package com.project.person;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Accessibilty.PersonNode;
import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * PersonUtility Class
 * @author SKR
 */
public class PersonUtil{

    /**
     * updates json used to load the existing data of persons and person partners.
     */
    public static void updateData(){
      Map<String, PersonImpl> personMap = PersonNode.getPersonMapIndex();
      PersonImpl person = null;
        Iterator iterator = personMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, PersonImpl> personEntry = (Map.Entry<String, PersonImpl>) iterator.next();
            if(personEntry.getValue().getFatherOfPerson() == null){
                person = personEntry.getValue();
                break;
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new BufferedWriter(new FileWriter("../config/familytree.json")), person);
            System.out.println("Updated the file successfully");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * loads the json data into JVM creating all existing person and partner objects.
     */
    public static void loadData(){
        try{
            System.out.println("Starting to load existing Data....");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
            PersonImpl person = objectMapper.readValue(new BufferedReader(new FileReader("../config/familytree.json")), PersonImpl.class);
            PersonNode.setPersonIndex(person);

        } catch (IOException  uriSyntaxException) {
            System.out.println("Error Loading Data" + uriSyntaxException.getMessage());

        }
        System.out.println("Loading Data Complete....");
    }
}
