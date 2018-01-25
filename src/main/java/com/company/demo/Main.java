package com.company.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Scanner;
import java.util.*;

@RestController
public class Main {
    public static int active = 1;
    public String convo = "Good Day. What is troubling you today?" + "<br>";

    @RequestMapping("/")
    public String therapy (String[] args) {
        Therapist Eliza = new Therapist();
        System.out.println(convo);
        do convo = convo + "<br>" + getResponse(Eliza); while(active == 1);
        return convo;
    }

    public String getResponse(Therapist thisEliza){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your response here or Q to quit");
        String temp = reader.nextLine();

        if(temp.equalsIgnoreCase("q")){
            active = 0;
            System.out.println(thisEliza.quitChat());
            return thisEliza.quitChat() + "<br>";
        }
        String userinput[] = temp.split("\\s+");
        for (String word : userinput) {
            if (word.equalsIgnoreCase("me") || word.equalsIgnoreCase("my") || word.equalsIgnoreCase("I") || word.equalsIgnoreCase("am")) {
                System.out.println(thisEliza.qualifyResponse(userinput));
                return thisEliza.qualifyResponse(userinput)+ "<br>";
            }
        }
        System.out.println(thisEliza.hedgeResponse());
        return thisEliza.hedgeResponse()+ "<br>";

    }
}


