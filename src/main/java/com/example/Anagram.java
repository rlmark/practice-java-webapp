package com.example;

import com.example.anagramsolver.AnagramSolver;
import com.example.dictionary.Dictionary;
import com.example.dictionary.EnglishDictionary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * Created by rebeccamark on 2/26/15.
 */
@Path("anagram/{word}")
public class Anagram {

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public MyJaxbBean returnWord(@PathParam("word") String word) {

        Dictionary dictionary = new EnglishDictionary();
        AnagramSolver solver = new AnagramSolver(dictionary);
        Set<String> myAnagrams = solver.getAnagrams(word);

        return new MyJaxbBean(word, myAnagrams.toString());

    }

}
