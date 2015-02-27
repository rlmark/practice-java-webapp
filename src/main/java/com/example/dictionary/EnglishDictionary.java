package com.example.dictionary;

import java.util.Set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rebeccamark on 2/26/15.
 */
public class EnglishDictionary implements Dictionary{
    // initializes a private variable to be used in the class.
    // Key is a string, to a set of a strings, value.
    private Set<String> words;

    public EnglishDictionary() {

        words = new HashSet<String>();

        try {
            BufferedReader in = new BufferedReader(new FileReader("words"));
            String text;

            // until the end of the file
            while((text = in.readLine()) != null) {
                words.add(text);
            }
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }



    @Override
    public boolean isWord(String s) {
        return words.contains(s);
    }

    @Override
    public Set<String> getAllWords() {
        return words;
    }

    public static void main(String[] args) {
    }
}