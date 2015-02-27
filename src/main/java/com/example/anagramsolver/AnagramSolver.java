package com.example.anagramsolver;

import com.example.dictionary.Dictionary;
import com.example.dictionary.EnglishDictionary;

import java.util.*;

/**
 * Created by rebeccamark on 2/26/15.
 */
public class AnagramSolver {
    // private member variable called dictionary
    private Dictionary dictionary;
    private Map<String, Set<String>> signatureMap;


    public AnagramSolver(Dictionary dictionary) {
        this.dictionary = dictionary;
        // creating the signature map
        signatureMap = new HashMap<String, Set<String>>();

        for(String word : dictionary.getAllWords()) {
            String wordSignature = signature(word);
            if(!signatureMap.containsKey(wordSignature)){
                signatureMap.put(wordSignature, new HashSet<String>());
            }
            // now we're adding the new word
            // get the key of wordSignature and add the text.
            signatureMap.get(wordSignature).add(word);
        }
    }

    public Set<String> getAnagrams(String s){
        String signature = signature(s);

        if (signatureMap.containsKey(signature)) {
            return signatureMap.get(signature);
        }
        return new HashSet<String>();

    }

    private static String signature(String s) {
        char[] characters = s.toLowerCase().toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new EnglishDictionary();
        // because it takes in a dictionary it is agnostic to dict
        AnagramSolver solver = new AnagramSolver(dictionary);
        Set<String> myAnagrams = solver.getAnagrams("trap");
        for(String s : myAnagrams) {
            System.out.println(s);
        }
    }



}
