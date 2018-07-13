package com.project.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Accessibilty.PersonNode;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonUtil{

    public static void createNewPerson(PersonImpl person){
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("familytree.json").toURI()));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
            PersonImpl person1 = objectMapper.readValue(jsonData, PersonImpl.class);
            String jsonString = objectMapper.writeValueAsString(person1);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadData(){
        try{
            System.out.println("Starting to load existing Data....");
            byte[] jsonData = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("familytree.json").toURI()));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
            PersonImpl person = objectMapper.readValue(jsonData, PersonImpl.class);
           /* for(PersonImpl person1 : person.getChildrenOfPersonImpls()){
                System.out.println(person1.getName());
                System.out.println(person1.getFatherOfPerson().getName());
            }*/
            PersonNode.setPersonIndex(person);

        } catch (IOException | URISyntaxException uriSyntaxException) {
            System.out.println("Error Loading Data" + uriSyntaxException.getMessage());

        }
        System.out.println("Loading Data Complete....");
    }
}
