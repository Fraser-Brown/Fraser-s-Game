package com.lemon.assassin.frasersgame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;

import com.shanta.michael.thefrasergame.R;

public class Game1Activity extends AppCompatActivity {

    private ChallengeBook mChallengeBook = new ChallengeBook();
    private ColourWheel mColourWheel = new ColourWheel();

    public Button forward;
    public Button backward;
    public Button timer;
    public TextView timerCount;
    public CountDownTimer cdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game1);

        final TextView challenges = (TextView) findViewById(R.id.txtChallenge);
        //final Button nextChallengeButton = (Button) findViewById(R.id.one);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        forward = (Button)findViewById(R.id.buttonForward);
        backward = (Button)findViewById(R.id.buttonBackward);

        forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String challenge = mChallengeBook.getChallenge(Boolean.TRUE);
                challenges.setText(challenge);
                int colour = mColourWheel.getColour();
                relativeLayout.setBackgroundColor(colour);
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String challenge = mChallengeBook.getChallenge(Boolean.FALSE);
                challenges.setText(challenge);
                int colour = mColourWheel.getColour();
                relativeLayout.setBackgroundColor(colour);
            }
        });

    }

}
