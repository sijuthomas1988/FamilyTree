package com.project.acceptor;

import com.project.person.PersonUtil;

/**
 * Main Class of the Project.Entry point of the Application
 * @author SKR
 */
public class Application {

    public static  void main(String[] args){
        System.out.println("Welcome to your Famity Tree Application");

        /** Loads Data using the utility provided. */
       PersonUtil.loadData();
       /** Accepts Input and provides Output */
       ApplicationHelper.executeProgram();
    }
}
