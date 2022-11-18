/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.client;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lrosellg
 */
public class Bot {
    private  ArrayList<String> answers = new ArrayList();
    
    public Bot(){
        answers.add("Chandah de 70 pavo");
        answers.add("Camiseta de motocróh");
        answers.add("Caspahr");
        answers.add("Hay una serpiente en mi bota");
        
    }
    
    public  String askBoot(){
        Random rd = new Random();
        int inx = rd.nextInt(answers.size());
        return answers.get(inx);
    }
}
