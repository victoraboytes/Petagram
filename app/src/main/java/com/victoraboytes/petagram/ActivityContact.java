package com.victoraboytes.petagram;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ActivityContact extends AppCompatActivity {

    //Declaration of objects
    private Toolbar actionBar;
    private ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //The action bar is defined in the layout file
        this.actionBar = (Toolbar)findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        //Get a support ActionBar corresponding to this toolbar
        this.ab = getSupportActionBar();

        //Enable the up button
        this.ab.setDisplayHomeAsUpEnabled(true);
    }
}
