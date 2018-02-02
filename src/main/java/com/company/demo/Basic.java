package com.company.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Basic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    @NotNull
    @Size(min = 3)
    private String sentence;


    public Basic(){

    }

    public Basic(String s){
        this.sentence = s;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
