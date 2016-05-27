package com.theironyard;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException {

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






        System.out.println("Enter a single letter to return all countries beginning with that letter");
        String letter = scanner.nextLine();
        int length = letter.length();
        ArrayList<Country> list = map.get(letter);

        if (length == 1) {

            String outFile = (letter + "_countries.txt");

            JsonSerializer serializer = new JsonSerializer();
            String json = serializer.include("*").serialize(list);

            File f = new File(outFile);
            try {
                FileWriter fw = new FileWriter(f);
                fw.write(json);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Entered value not a single character");
        }




        /*

        File countryText = new File(outFile);
        FileWriter fw = new FileWriter(countryText);
        i = 0;
        fw.write(list.name(0));
        for (Country countryByLetter : list) {

        }
        */





    }
}
