package ex42;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Kieran Jimenez
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonArrayTest {
    @Test
    public void format_String1() {
        PersonArray myPArray = new PersonArray();

        String answer = myPArray.formatProperLength("123456789", 9 + 1);
        String expected = "123456789 ";

        assertEquals(expected, answer);
    }

    @Test
    public void format_String2() {
        PersonArray myPArray = new PersonArray();

        String answer = myPArray.formatProperLength("1", 9 + 1);
        String expected = "1         ";

        assertEquals(expected, answer);
    }

    @Test
    public void longest_fname1() {
        PersonArray myPArray = new PersonArray();

        Person man1 = new Person();
        man1.fName = "David";
        Person man2 = new Person();
        man2.fName = "David+2";

        int numpeople = 2;
        myPArray.EmployeeRecord = new Person[numpeople];
        myPArray.EmployeeRecord[0] = man1;
        myPArray.EmployeeRecord[1] = man2;
        myPArray.numEmployees = 2;

        int answer = myPArray.findLongestString(myPArray.EmployeeRecord, "fname", myPArray.numEmployees);

        assertEquals(man2.fName.length(), answer);
    }

}