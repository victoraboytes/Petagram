package com.victoraboytes.petagram;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.victoraboytes.petagram.adapter.PetAdapter;
import com.victoraboytes.petagram.pojo.Pets;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    //Declaration of objects
    private Toolbar actionBar; //Toolbar declared
    private ActionBar ab; // Action bar declared
    private RecyclerView recyclerViewTop5Pets; // Recycler view of pet list
    private ArrayList<Pets> pets; //Array list of pet object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //The action bar is defined in the layout file
        this.actionBar = (Toolbar)findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        //Get a support ActionBar corresponding to this toolbar
        this.ab = getSupportActionBar();

        //Enable the up button
        this.ab.setDisplayHomeAsUpEnabled(true);

        //Recycler view instantiation
        //Recycler view object is defined in the layout file
        this.recyclerViewTop5Pets = (RecyclerView) findViewById(R.id.recyclerviewTop5Pets);
        //Instantiation of linear layout manager object
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //Set orientation of recycler view
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //Set the layout parameters in recycler view
        recyclerViewTop5Pets.setLayoutManager(llm);

        top5PetList(); //Get the information of the pet list
        startAdapter(); //Show the information of the card view in the recycler view
    }

    //Start the pet list with name, photo and likes
    public void top5PetList() {
        this.pets = new ArrayList<Pets>();

        this.pets.add(new Pets(R.drawable.sloth, "0", "sloth"));
        this.pets.add(new Pets(R.drawable.fish, "1", "Fish"));
        this.pets.add(new Pets(R.drawable.german_shepherd, "3", "German Shepherd"));
        this.pets.add(new Pets(R.drawable.rabbit, "8", "Rabbit"));
        this.pets.add(new Pets(R.drawable.duck, "4", "Duck"));
    }

    public void startAdapter(){
        PetAdapter adapter = new PetAdapter(this.pets, this);
        recyclerViewTop5Pets.setAdapter(adapter);
    }
}
