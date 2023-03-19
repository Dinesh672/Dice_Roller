package com.example.diceroller;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * This method is called when the Activity is created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Button in the layout
        Button rollButton = findViewById(R.id.button);

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener(v -> {
            rollDice();
            Toast.makeText(getApplicationContext(), "Dice Rolled!", Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private void rollDice() {
        // Create new Dice object with 6 sides and roll it
        Dice dice = new Dice(6);
        int diceRoll = dice.roll();

        // Update the screen with the dice roll
        TextView resultTextView = findViewById(R.id.textView);
        resultTextView.setText(Integer.toString(diceRoll));
    }
}

/**
 * Dice with a fixed number of sides.
 */
class Dice {
    private final int numSides;
    private final Random random = new Random();

    /**
     * Constructor for Dice object with a given number of sides.
     */
    public Dice(int numSides) {
        this.numSides = numSides;
    }

    /**
     * Do a random dice roll and return the result.
     */
    public int roll() {
        return random.nextInt(numSides) + 1;
    }
}
