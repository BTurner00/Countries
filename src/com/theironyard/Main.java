package com.theironyard;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {



    public static ArrayList<Country> parseCountry(String filename) throws FileNotFoundException {
        ArrayList<Country> countries = new ArrayList<>();
        File f = new File(filename);
        Scanner filescanner = new Scanner(f);
        while (filescanner.hasNext()) {
            String line = filescanner.nextLine();
            String[] columns =line.split("\\|");
            Country country  = new Country(columns[1], columns[0]);
            countries.add(country);

        }
        return countries;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, ArrayList<Country>> map = new HashMap<>();

        ArrayList<Country> countries = parseCountry("countries.txt");
        ArrayList<Country> temp = new ArrayList();
        String savedLetter = "a";
        int i = 0;
        for (Country countryByLetter : countries) {

            //getting first letter of country
            char firstLetter = countries.get(i).name.charAt(0);
            String firstLetterStr = Character.toString(firstLetter);


            //placing countries with same letter in hashmap
            if (!(firstLetterStr.equals(savedLetter))) {
                map.put(savedLetter, temp);
                temp = new ArrayList();
                firstLetter = countries.get(i).name.charAt(0);
                savedLetter = Character.toString(firstLetter);
                temp.add(countryByLetter);
            }else  {
                temp.add(countryByLetter);
                firstLetter = countries.get(i).name.charAt(0);
                savedLetter = Character.toString(firstLetter);
            }
            i++;
        }
        map.put(savedLetter, temp);
        System.out.println(map.get("z"));




        //ArrayList<String> arr = map.get()
/*
        System.out.println("Enter a single letter to return all countries beginning with that letter");
        String letter = scanner.nextLine();
        int length = letter.length();

        if ((length == 1)) {

        }
*/



    }
}
