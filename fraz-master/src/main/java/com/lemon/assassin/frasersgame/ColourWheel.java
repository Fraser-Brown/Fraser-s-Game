package com.lemon.assassin.frasersgame;

import android.graphics.Color;

import java.util.Random;

public class ColourWheel {
    private int prevRandom = 0;
    public String[] mColours = {
            "#f27980", "#4C96BF", "#4A85A5", "#A54248", "#32A54F", "#A5A342", "#AC79F2"
    };

    public int getColour() {
        String colour = "";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColours.length);
        while (prevRandom == randomNumber) {
            randomNumber = randomGenerator.nextInt(mColours.length);
        }
        colour = mColours[randomNumber];
        prevRandom = randomNumber;
        int colourAsInt = Color.parseColor(colour);
        return  colourAsInt;

    }



}