package com.lemon.assassin.frasersgame;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.shanta.michael.thefrasergame.R;

public class HowToPlayDialog extends DialogFragment {
    public TextView mRules;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_howtoplay, container, false);
        mRules = (TextView)view.findViewById(R.id.textViewRules);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        mRules.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }
}
