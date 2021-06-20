package ex41;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Kieran Jimenez
 */

class NameListTest {
    @Test
    public void order_List_array_names() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Cathy, Jen", "Armstrong, David", "Alan, Just"));

        NameList myNList = new NameList();

        ArrayList<String> answer = myNList.alphabetize(names);

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Alan, Just", "Armstrong, David", "Cathy, Jen"));

        assertArrayEquals(new ArrayList[]{expected}, new ArrayList[]{answer});

    }
    @Test
    public void read_path_to_array() {

        NameList myNList = new NameList();

        //ex41/namesTest.txt
        ArrayList<String> answer = myNList.readNames("src/main/java/ex41/namesTest.txt");

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Ling, Mai", "Johnson, Jim", "Zarnecki, Sabrina"));

        assertEquals(expected, answer);
    }
}