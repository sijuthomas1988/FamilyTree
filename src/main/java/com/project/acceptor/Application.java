package com.project.acceptor;

import com.project.person.PersonUtil;

public class Application {

    public static  void main(String[] args){
        System.out.println("Welcome to your Famity Tree Application");
        PersonUtil.loadData();
        //Map<String, String> inputMap = Application.executeProgram();
        ApplicationHelper.executeProgram();


    }
}
