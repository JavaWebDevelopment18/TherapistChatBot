package com.company.demo;

import java.util.Arrays;
import java.util.Random;

public class Therapist {

    //Eliza class has three variables
    private Random rand = new Random();
    private static String[] Hedges = {"Please tell me more", "Many of my patients tell me the same thing", "It is getting late, maybe we had better quit"};
    private static String[] Qualifiers = {"Why do you say that ", "You seem to think that ", "So, you are concerned that"};

    public String qualifyResponse(String[] userinput){
        String[] orig = {"me", "Me", "my", "My", "I", "i", "am", "Am"};
        String[] rep = {"you", "you", "your", "your", "you", "you", "are", "are"};

        for (int i = 0; i < userinput.length; i++) {
            if (userinput[i].equalsIgnoreCase("me")  || userinput[i].equalsIgnoreCase("my") || userinput[i].equalsIgnoreCase("I") || userinput[i].equalsIgnoreCase("am")) {
                String temp = userinput[i]; //original- pronoun
                int x = Arrays.asList(orig).indexOf(temp);
                userinput[i] = rep[x]; //replacing the word in user input with new one
            }
        }


        String output = "";
        for (String word : userinput){
            output += word + " ";
        }

        int x = rand.nextInt(2);
        return Qualifiers[x] + output;

    }

    public String hedgeResponse(){
        int x = rand.nextInt(2);
        return Hedges[x];

    }

    public String quitChat() {

        return "Have a nice day. See you at your next appointment";
    }
}
