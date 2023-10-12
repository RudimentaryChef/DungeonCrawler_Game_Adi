package com.example.cs2340c_team41.unitTests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.widget.ImageView;

public class PlayerUnitTests {

    Player myPlayer = new Player("Bryan", 100, 10, 35, 0,  randPlayerSprite);

    /**
     * This unit Test tests if the getName() function in Player is working
     */
    @Test
    public void testGetName() {
        String name = myPlayer.getName();
        Assert.assertEquals(name, "Bryan");
    }

    /**
     * This unit test tests if the getHealth() function in Player is working
     */
    @Test
    public void testGetHealth() {
        int health = myPlayer.getHealth();
        Assert.assertEquals(health, 100);
    }
    /**
     * This unit test tests if the getXLoc() function in Player is working
     */
    @Test
    public void testGetXloc() {
        int xloc = myPlayer.getXloc();
        Assert.assertEquals(xloc, 10);
    }
    /**
     * This unit test tests if the getYLoc() function in Player is working
     */
    @Test
    public void testGetYLoc() {
        int yloc = myPlayer.getYLoc();
        Assert.assertEquals(yloc, 35);
    }

}
