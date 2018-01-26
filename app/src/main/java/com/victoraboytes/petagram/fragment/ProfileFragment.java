package com.victoraboytes.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.victoraboytes.petagram.R;
import com.victoraboytes.petagram.adapter.PetProfileAdapter;
import com.victoraboytes.petagram.pojo.Pets;

import java.util.ArrayList;

/**
 * Created by victoraboytes on 22/01/2018.
 */

public class ProfileFragment extends Fragment{

    private ArrayList<Pets> pets; //Array list of pet object
    private RecyclerView recyclerViewProfilePet; // Recycler view of pet list

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_fragment, container, false);

        //Recycler view instantiation
        this.recyclerViewProfilePet = (RecyclerView) v.findViewById(R.id.recyclerviewProfilePet); //Instantiated recycler view object
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity()); //Instantiation of linear layout manager object
        //llm.setOrientation(LinearLayoutManager.VERTICAL); //Set orientation of recycler view
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        recyclerViewProfilePet.setLayoutManager(glm); //Set the layout parameters in recycler view

        startPetList(); //Get the information of the pet list
        startAdapter(); //Show the information of the card view in the recycler view

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void startAdapter(){
        PetProfileAdapter adapter = new PetProfileAdapter(this.pets, getActivity());
        recyclerViewProfilePet.setAdapter(adapter);
    }
    //Start the pet list with name, photo and likes
    public void startPetList() {
        pets = new ArrayList<Pets>();

        pets.add(new Pets(R.drawable.german_shepherd, "1", "German Shepherd"));
        pets.add(new Pets(R.drawable.german_shepherd, "2", "German Shepherd"));
        pets.add(new Pets(R.drawable.german_shepherd, "8", "German Shepherd"));
        pets.add(new Pets(R.drawable.german_shepherd, "9", "German Shepherd"));
        pets.add(new Pets(R.drawable.german_shepherd, "12", "German Shepherd"));
        pets.add(new Pets(R.drawable.german_shepherd, "10", "German Shepherd"));
        pets.add(new Pets(R.drawable.german_shepherd, "3", "German Shepherd"));
    }
}
