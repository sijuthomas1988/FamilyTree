package com.project.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Accessibilty.PersonNode;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonUtil{

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
            ClassLoader classLoader = PersonUtil.class.getClassLoader();
            objectMapper.writeValue(new FileOutputStream(classLoader.getResource("/familytree.json").getFile()), person);
            System.out.println("Updated the file successfully");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void loadData(){
        try{
            System.out.println("Starting to load existing Data....");
            //byte[] jsonData = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("familytree.json").toURI()));

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
            PersonImpl person = objectMapper.readValue(new BufferedReader(new InputStreamReader(PersonUtil.class.getResourceAsStream("/familytree.json"))), PersonImpl.class);
           /* for(PersonImpl person1 : person.getChildrenOfPersonImpls()){
                System.out.println(person1.getName());
                System.out.println(person1.getFatherOfPerson().getName());
            }*/
            PersonNode.setPersonIndex(person);

        } catch (IOException  uriSyntaxException) {
            System.out.println("Error Loading Data" + uriSyntaxException.getMessage());

        }
        System.out.println("Loading Data Complete....");
    }
}
