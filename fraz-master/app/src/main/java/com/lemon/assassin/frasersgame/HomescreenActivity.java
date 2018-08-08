package com.lemon.assassin.frasersgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.shanta.michael.thefrasergame.R;

public class HomescreenActivity extends Activity {


    public Button mplayButton;
    public Button mhowToPlayButton;

    public void init() {
        mplayButton = (Button)findViewById(R.id.buttonPlay);
        mhowToPlayButton = (Button)findViewById(R.id.buttonHow);

        mhowToPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HowToPlayDialog howToPlay = new HowToPlayDialog();
                howToPlay.show(getFragmentManager(), "Instructions dialog");
            }
        });

        mplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playGame = new Intent(HomescreenActivity.this,Game1Activity.class);
                startActivity(playGame);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_homescreen);
        init();

    }

}
