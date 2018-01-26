package com.victoraboytes.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.victoraboytes.petagram.R;
import com.victoraboytes.petagram.adapter.PetAdapter;
import com.victoraboytes.petagram.pojo.Pets;

import java.util.ArrayList;

/**
 * Created by victoraboytes on 22/01/2018.
 */

public class HomeFragment extends Fragment {

    private ArrayList<Pets> pets; //Array list of pet object
    private RecyclerView recyclerViewPets; // Recycler view of pet list

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);

        //Recycler view instantiation
        this.recyclerViewPets = (RecyclerView) v.findViewById(R.id.recyclerviewPets); //Instantiated recycler view object
        LinearLayoutManager llm = new LinearLayoutManager(getActivity()); //Instantiation of linear layout manager object
        llm.setOrientation(LinearLayoutManager.VERTICAL); //Set orientation of recycler view
        recyclerViewPets.setLayoutManager(llm); //Set the layout parameters in recycler view

        startPetList(); //Get the information of the pet list
        startAdapter(); //Show the information of the card view in the recycler view

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void startAdapter(){
        PetAdapter adapter = new PetAdapter(this.pets, getActivity());
        recyclerViewPets.setAdapter(adapter);
    }
    //Start the pet list with name, photo and likes
    public void startPetList() {
        pets = new ArrayList<Pets>();

        pets.add(new Pets(R.drawable.bird, "5", "Bird"));
        pets.add(new Pets(R.drawable.bull, "1", "Bull"));
        pets.add(new Pets(R.drawable.chicken, "3", "Chicken"));
        pets.add(new Pets(R.drawable.cow, "8", "Cow"));
        pets.add(new Pets(R.drawable.duck, "4", "Duck"));
        pets.add(new Pets(R.drawable.fish, "9", "Fish"));
        pets.add(new Pets(R.drawable.german_shepherd, "2", "German Shepherd"));
        pets.add(new Pets(R.drawable.pig, "12", "Pig"));
        pets.add(new Pets(R.drawable.rabbit, "0", "Rabbit"));
        pets.add(new Pets(R.drawable.sloth, "13", "Sloth"));
        pets.add(new Pets(R.drawable.turtle, "15", "Turtle"));
    }
}
