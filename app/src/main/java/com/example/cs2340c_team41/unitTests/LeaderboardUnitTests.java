package com.example.cs2340c_team41.unitTests;

import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
public class LeaderboardUnitTests {

    /**
     * This unit test test the organization of scores
     * @param scores a list of 5 high scores
     * @return true if the the scores are listed from highest value to lowest value
     */
    @Test
    public boolean isLeaderboardInOrder(List<Integer> scores){
        boolean inOrder = true;
        for (int i = 0; i < scores.size() - 1; i++) {
            if (scores.get(i) < scores.get(i + 1)){
                inOrder &= true;
            } else {
                inOrder&= false;
            }
        }
        return inOrder;
    }

    /**
     * This is a unit test to see if the user entry is soley letters
     * @param name is the name of the user
     * @return result, is the result of whether or not the name entered is composed only of numbers
     */
    @Test
    public boolean isAllLetters(String name) {
        char[] letters = name.toCharArray();
        boolean result = true;
        for(char c: letters) {
            if(Character.isLetter(c)){
                 result &= true;
            } else {
                result &= false;
            }
        }
        return result;
    }
}
