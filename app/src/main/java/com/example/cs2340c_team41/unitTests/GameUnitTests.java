package com.example.cs2340c_team41.unitTests;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.widget.ImageView;
public class GameUnitTests {
    /**
     * Checks if the player name inputted into the text box is valid (not null)
     * @param name the text contained within the Textbox with the name field
     * @return truth value on if the player name is not null
     */
    @Test
    public boolean isPlayerNameNotNull(String name) {
        boolean result = true;
        if (name == null) {
            result &= false;
        } else {
            result &= true;
        }
        return result;
    }

    /**
     * Checks if the difficulty level corresponds to the correct label
     * @param difficultyLevel difficulty level taken from diffTracker
     * @param difficultyName the text contained within the textView containing difficulty
     * @return truth on if the difficulty matches the label
     */
    @Test
    public boolean isCorrectDifficulty(int difficultyLevel, String difficultyName) {
        boolean matching = true;
        if (difficultyLevel == 1) {
            if (difficultyName.equals("Easy")) {
                matching &= true;
                return matching;
            }
        }
        if (difficultyLevel == 2) {
            if (difficultyName.equals("Medium")) {
                matching &= true;
                return matching;
            }
        }
        if (difficultyLevel == 3) {
            if (difficultyName.equals("Hard")) {
                matching &= true;
                return matching;
            }
        }
        matching &= false;
        return matching;
    }

    /**
     * Checks if the character index corresponds to the correct sprite
     * @param difficultyLevel difficulty level taken from diffTracker
     * @param spriteLabel the name of the sprite
     * @return truth on if the character index matches the sprite label
     */
    @Test
    public boolean isCorrectDifficulty(int characterIndex, String spriteLabel) {
        boolean matching = true;
        if (characterIndex == 1) {
            if (spriteLabel.equals("sprite_1.png")) {
                matching &= true;
                return matching;
            }
        }
        if (characterIndex == 2) {
            if (spriteLabel.equals("sprite_2.png")) {
                matching &= true;
                return matching;
            }
        }
        if (characterIndex == 3) {
            if (spriteLabel.equals("sprite_3.png")) {
                matching &= true;
                return matching;
            }
        }
        matching &= false;
        return matching;
    }
}
