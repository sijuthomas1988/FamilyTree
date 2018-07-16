package com.project.acceptor;

import com.project.person.PersonUtil;

import java.io.File;

public class Application {

    public static  void main(String[] args){
        System.out.println("Welcome to your Famity Tree Application");
     /*   File f = new File("./");
        System.out.println(f.getAbsolutePath())*/;
       PersonUtil.loadData();
        //Map<String, String> inputMap = Application.executeProgram();
        ApplicationHelper.executeProgram();


    }
}
