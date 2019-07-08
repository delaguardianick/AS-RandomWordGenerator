package ipe.test.thirdapp;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class RandomWordGenerator {
    File mostCommonWords;
    ArrayList<String> list;
    Random rand;

    public RandomWordGenerator() {
        list = new ArrayList<String>();
        rand = new Random();
    }

    //Reads the parameter InputSteam and adds it to a list, then randomizes a number from
    // the list size and generates a random word
    public String generateRandomWord(InputStream is) throws IOException, FileNotFoundException {

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String aux;
        while ((aux = br.readLine()) != null) {
            list.add(aux);
        }

        br.close();
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) throws IOException, FileNotFoundException
    {

    }
}

