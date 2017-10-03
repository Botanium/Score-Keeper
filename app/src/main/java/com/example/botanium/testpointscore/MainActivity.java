package com.example.botanium.testpointscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int blueScore = 0;
    int redScore = 0;
    int blueSetScore = 0;
    int redSetScore = 0;

    TextView bluePoint;
    TextView redPoint;
    TextView blueSet;
    TextView redSet;
    Button blueBackPoint;
    Button redBackPoint;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View binding for text views
        bluePoint = (TextView) findViewById(R.id.points_blue_text_view);
        redPoint = (TextView) findViewById(R.id.points_red_text_view);
        blueSet = (TextView) findViewById(R.id.sets_blue_text_view);
        redSet = (TextView) findViewById(R.id.sets_red_text_view);
        blueBackPoint = (Button) findViewById(R.id.back_points_blue_btn);
        redBackPoint = (Button) findViewById(R.id.back_points_red_btn);
        reset = (Button) findViewById(R.id.reset_btn);
    }

    public void displaySetForBlue(int score) {
        blueSet.setText(String.valueOf(score));
    }

    public void displaySetForRed(int score) {
        redSet.setText(String.valueOf(score));
    }

    //Display function for both Red & Blue team
    public void displayForBlue(int score) {
        bluePoint.setText(String.valueOf(score));
    }

    public void displayForRed(int score) {
        redPoint.setText(String.valueOf(score));
    }

    //Adds one point to blue team
    public void addToBlue(View view) {
        if (blueScore < 11) {
            blueScore = blueScore + 1;
            displayForBlue(blueScore);
        } else {
            if (blueSetScore < 2) {
                blueSetScore = blueSetScore + 1;
                blueScore = 0;
                redScore = 0;
                displayForBlue(blueScore);
                displayForRed(redScore);
                displaySetForBlue(blueSetScore);
            } else {
                blueSetScore = 3;
                displaySetForBlue(blueSetScore);
                bluePoint.setText("Winner");
                redPoint.setText("Loser");
                redPoint.setTextSize(33);
                bluePoint.setTextSize(33);
                bluePoint.setEnabled(false);
                redPoint.setEnabled(false);
                blueBackPoint.setEnabled(false);
                redBackPoint.setEnabled(false);
            }
        }
    }

    //Adds one point to red team
    public void addToRed(View view) {
        if (redScore < 11) {
            redScore = redScore + 1;
            displayForRed(redScore);
        } else {
            if (redSetScore < 2) {
                redSetScore = redSetScore + 1;
                redScore = 0;
                blueScore = 0;
                displayForBlue(blueScore);
                displayForRed(redScore);
                displaySetForRed(redSetScore);
            } else {
                redSetScore = 3;
                displaySetForRed(redSetScore);
                bluePoint.setText("Loser");
                redPoint.setText("Winner");
                redPoint.setTextSize(33);
                bluePoint.setTextSize(33);
                bluePoint.setEnabled(false);
                redPoint.setEnabled(false);
                blueBackPoint.setEnabled(false);
                redBackPoint.setEnabled(false);
            }
        }
    }

    //subtracts one point from blue team
    public void backPointBlue(View view) {
        if (blueScore > 0)
            blueScore = blueScore - 1;
        else
            blueScore = 0;
        displayForBlue(blueScore);
    }

    //subtracts one point from red team
    public void backPointRed(View view) {
        if (redScore > 0)
            redScore = redScore - 1;
        else
            redScore = 0;
        displayForRed(redScore);
    }

    //Reset all values to Zero
    public void reset(View view) {
        recreate();
    }
}
