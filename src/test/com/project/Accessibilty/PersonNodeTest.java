package com.project.Accessibilty;

import com.project.person.PersonImpl;
import com.project.person.PersonPartner;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;

public class PersonNodeTest {

    @Test
    public void createFamilytree() {
        Assert.assertNotNull(PersonNodeTest.stubPersonObject());
        mock(PersonNode.class);
        NodeImpl<PersonImpl> nodeResult = PersonNode.createFamilytree(PersonNodeTest.stubPersonObject());
        Assert.assertEquals("George", nodeResult.getData().getName());

    }

    @Test
    public void searchBrothers() {
        Assert.assertNotNull(PersonNodeTest.stubPersonObject());
        PersonImpl person = PersonNodeTest.stubPersonObject();
        PersonImpl person1 = null;
        List<PersonImpl> personList = person.getChildrenOfPersonImpls();
        for (PersonImpl person3 : personList){
            if (person3.getName().equalsIgnoreCase("Gregory1")) {
                person1 = person3;
            }
        }
        mock(PersonNode.class);
        List<PersonImpl> brothersValue = PersonNode.searchBrothers(person1);
        for (PersonImpl person3 : brothersValue){
            if (person3.getName().equalsIgnoreCase("Gregory2")) {
                Assert.assertEquals("Gregory2", person3.getName());
            }
        }
    }

        @Test
        public void searchSisters () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            PersonImpl person = PersonNodeTest.stubPersonObject();
            PersonImpl person1 = null;
            List<PersonImpl> personList = person.getChildrenOfPersonImpls();
            for (PersonImpl person3 : personList){
                if (person3.getName().equalsIgnoreCase("Gregory1")) {
                    person1 = person3;
                }
            }
            mock(PersonNode.class);
            List<PersonImpl> sistersValue = PersonNode.searchSisters(person1);
            if(sistersValue.isEmpty()){
                    Assert.assertEquals(0, sistersValue.size());
                }
            }

        @Test
        public void searchFather () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            PersonImpl person = PersonNodeTest.stubPersonObject();
            PersonImpl person1 = null;
            List<PersonImpl> personList = person.getChildrenOfPersonImpls();
            for (PersonImpl person3 : personList){
                if (person3.getName().equalsIgnoreCase("Gregory1")) {
                    person1 = person3;
                }
            }
            mock(PersonNode.class);
            PersonImpl fatherOfPerson = PersonNode.searchFather(person1);
            Assert.assertEquals("George", fatherOfPerson.getName());
        }

        @Test
        public void searchMother () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            PersonImpl person = PersonNodeTest.stubPersonObject();
            PersonImpl person1 = null;
            List<PersonImpl> personList = person.getChildrenOfPersonImpls();
            for (PersonImpl person3 : personList){
                if (person3.getName().equalsIgnoreCase("Gregory1")) {
                    person1 = person3;
                }
            }
            mock(PersonNode.class);
            PersonPartner motherOfPerson = PersonNode.searchMother(person1);
            Assert.assertEquals("Amy", motherOfPerson.getName());
        }

        @Test
        public void searchSons () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            List<PersonImpl> listOfSons = PersonNode.searchSons(PersonNodeTest.stubPersonObject());
            for (PersonImpl person3 : listOfSons){
                if (person3.getName().equalsIgnoreCase("Gregory2")) {
                    Assert.assertEquals("Gregory2", person3.getName());
                }
            }
        }

        @Test
        public void searchDaughters () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            List<PersonImpl> listOfDaughters = PersonNode.searchDaughters(PersonNodeTest.stubPersonObject());
            if(listOfDaughters.isEmpty()){
                Assert.assertEquals(0, listOfDaughters.size());
            }
        }

        @Test
        public void searchCousins () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            PersonImpl person2 = null;
            PersonImpl person3 = null;
            PersonImpl person = PersonNodeTest.stubPersonObject();
            List<PersonImpl> personList = person.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList){
                if(person1.getName().equalsIgnoreCase("Gregory2")){
                    person2 = person1;
                }
            }
            List<PersonImpl> personList1 = person2.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList1){
                if(person1.getName().equalsIgnoreCase("Gregory2Child1")){
                    person3 = person1;
                }
            }
            List<PersonImpl> listOfCousins = PersonNode.searchCousins(person3);
            for(PersonImpl person1 : listOfCousins){
                if(person1.getName().equalsIgnoreCase("Gregory1Child1")){
                    Assert.assertEquals("Gregory1Child1", person1.getName());
                }
            }
        }

        @Test
        public void searchGrandFather () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            PersonImpl person2 = null;
            PersonImpl person3 = null;
            PersonImpl person = PersonNodeTest.stubPersonObject();
            List<PersonImpl> personList = person.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList){
                if(person1.getName().equalsIgnoreCase("Gregory2")){
                    person2 = person1;
                }
            }
            List<PersonImpl> personList1 = person2.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList1){
                if(person1.getName().equalsIgnoreCase("Gregory2Child1")){
                    person3 = person1;
                }
            }
            PersonImpl person1 = PersonNode.searchGrandFather(person3);
            Assert.assertEquals("George", person1.getName());
        }

        @Test
        public void searchGrandMother () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            PersonImpl person2 = null;
            PersonImpl person3 = null;
            PersonImpl person = PersonNodeTest.stubPersonObject();
            List<PersonImpl> personList = person.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList){
                if(person1.getName().equalsIgnoreCase("Gregory2")){
                    person2 = person1;
                }
            }
            List<PersonImpl> personList1 = person2.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList1){
                if(person1.getName().equalsIgnoreCase("Gregory2Child1")){
                    person3 = person1;
                }
            }
            PersonImpl person1 = PersonNode.searchGrandFather(person3);
            Assert.assertEquals("Amy", person1.getWifeOfPerson().getName());
        }

        @Test
        public void searchGrandSons () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            NodeImpl<PersonImpl> nodeResult = PersonNode.createFamilytree(PersonNodeTest.stubPersonObject());
            PersonImpl person = nodeResult.getData();
            List<PersonImpl> personList = PersonNode.searchGrandSons(person);
            for(PersonImpl person1 : personList){
                if(person1.getName().equalsIgnoreCase("Gregory2Child1")){
                    Assert.assertEquals("Gregory2Child1", person1.getName());
                }
            }

        }

        @Test
        public void searchGrandDaughters () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            NodeImpl<PersonImpl> nodeResult = PersonNode.createFamilytree(PersonNodeTest.stubPersonObject());
            PersonImpl person = nodeResult.getData();
            List<PersonImpl> personList = PersonNode.searchGrandDaughters(person);
            if(personList.isEmpty()){
                Assert.assertEquals(0, personList.size());
            }

        }

        @Test
        public void searchAunts () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            PersonImpl person2 = null;
            PersonImpl person3 = null;
            PersonImpl person = PersonNodeTest.stubPersonObject();
            List<PersonImpl> personList = person.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList){
                if(person1.getName().equalsIgnoreCase("Gregory2")){
                    person2 = person1;
                }
            }
            List<PersonImpl> personList1 = person2.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList1){
                if(person1.getName().equalsIgnoreCase("Gregory2Child1")){
                    person3 = person1;
                }
            }
            List<PersonImpl> personList2 = PersonNode.searchAunts(person3);
            if(personList2.isEmpty()){
                Assert.assertEquals(0, personList2.size());
            }
        }

        @Test
        public void searchUncles () {
            Assert.assertNotNull(PersonNodeTest.stubPersonObject());
            mock(PersonNode.class);
            PersonImpl person2 = null;
            PersonImpl person3 = null;
            PersonImpl person = PersonNodeTest.stubPersonObject();
            List<PersonImpl> personList = person.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList){
                if(person1.getName().equalsIgnoreCase("Gregory2")){
                    person2 = person1;
                }
            }
            List<PersonImpl> personList1 = person2.getChildrenOfPersonImpls();
            for(PersonImpl person1 : personList1){
                if(person1.getName().equalsIgnoreCase("Gregory2Child1")){
                    person3 = person1;
                }
            }
            List<PersonImpl> personList2 = PersonNode.searchUncles(person3);
            for (PersonImpl person1 : personList2){
                if (person3.getName().equalsIgnoreCase("Gregory1")) {
                    Assert.assertEquals("Gregory2", person1.getName());
                }
            }

        }

        public static PersonImpl stubPersonObject () {
            PersonImpl person = new PersonImpl();
            PersonPartner personPartner = new PersonPartner();
            personPartner.setGender(PersonImpl.Gender.FEMALE);
            List<PersonImpl> childrenOfPerson = new ArrayList<>();
            PersonImpl firstChildOfPerson = new PersonImpl();
            PersonImpl secondChildOfPerson = new PersonImpl();
            childrenOfPerson.add(firstChildOfPerson);
            childrenOfPerson.add(secondChildOfPerson);
            person.setChildrenOfPersonImpls(childrenOfPerson);
            person.setGender(PersonImpl.Gender.MALE);
            person.setWifeOfPerson(personPartner);
            person.setName("George");
            personPartner.setName("Amy");
            firstChildOfPerson.setFatherOfPerson(person);
            firstChildOfPerson.setName("Gregory1");
            firstChildOfPerson.setGender(PersonImpl.Gender.MALE);
            List<PersonImpl> firstGenChildren = new ArrayList<>();
            PersonImpl firstChildOfFirstChildOfPerson = new PersonImpl();
            PersonImpl secondChildOfFirstChildOfPerson = new PersonImpl();
            firstGenChildren.add(firstChildOfFirstChildOfPerson);
            firstGenChildren.add(secondChildOfFirstChildOfPerson);
            firstChildOfPerson.setChildrenOfPersonImpls(firstGenChildren);
            PersonPartner personPartner1 = new PersonPartner();
            personPartner1.setName("Gorge1");
            personPartner1.setGender(PersonImpl.Gender.FEMALE);
            firstChildOfPerson.setWifeOfPerson(personPartner1);
            firstChildOfFirstChildOfPerson.setName("Gregory1Child1");
            firstChildOfFirstChildOfPerson.setFatherOfPerson(firstChildOfPerson);
            firstChildOfFirstChildOfPerson.setGender(PersonImpl.Gender.FEMALE);
            secondChildOfFirstChildOfPerson.setName("Gregory1Child2");
            secondChildOfFirstChildOfPerson.setFatherOfPerson(firstChildOfPerson);
            secondChildOfPerson.setFatherOfPerson(person);
            secondChildOfPerson.setName("Gregory2");
            secondChildOfPerson.setGender(PersonImpl.Gender.MALE);
            List<PersonImpl> secondGenChildren = new ArrayList<>();
            PersonImpl firstChildOfSecondChildOfPerson = new PersonImpl();
            PersonImpl secondChildOfSecondChildOfPerson = new PersonImpl();
            secondGenChildren.add(firstChildOfSecondChildOfPerson);
            secondGenChildren.add(secondChildOfSecondChildOfPerson);
            secondChildOfPerson.setChildrenOfPersonImpls(secondGenChildren);
            PersonPartner personPartner2 = mock(PersonPartner.class);
            personPartner2.setName("Gorge2");
            personPartner2.setGender(PersonImpl.Gender.FEMALE);
            secondChildOfPerson.setWifeOfPerson(personPartner2);
            firstChildOfSecondChildOfPerson.setName("Gregory2Child1");
            firstChildOfSecondChildOfPerson.setFatherOfPerson(secondChildOfPerson);
            firstChildOfSecondChildOfPerson.setGender(PersonImpl.Gender.FEMALE);
            secondChildOfSecondChildOfPerson.setName("Gregory2Child2");
            secondChildOfSecondChildOfPerson.setFatherOfPerson(secondChildOfPerson);
            return person;
        }
    }