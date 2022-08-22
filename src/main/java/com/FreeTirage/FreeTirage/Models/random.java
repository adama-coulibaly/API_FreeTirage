package com.FreeTirage.FreeTirage.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class random {

    public static void main(String[] args) {
        Random aleatoire = new Random();
      //  Scanner src = new Scanner();



        List<String> postulants = new ArrayList<>();
        postulants.add("Adama");
        postulants.add("Ousmane");
        postulants.add("Oumar");
        postulants.add("Aliou");
        postulants.add("Papi");
        postulants.add("Adama");
        postulants.add("Ousmane");
        postulants.add("Oumar");
        postulants.add("Aliou");
        postulants.add("Papi");

        int id = postulants.size();

        for (int i = 1; i < 5; i++)
        {
            System.out.println(aleatoire.nextInt(id));


        }
    }
}
