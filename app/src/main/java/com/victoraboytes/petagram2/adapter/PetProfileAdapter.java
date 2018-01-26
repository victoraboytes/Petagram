package com.victoraboytes.petagram2.adapter;

/**
 * Created by victoraboytes on 23/01/2018.
 */

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.victoraboytes.petagram2.R;
import com.victoraboytes.petagram2.pojo.Pets;

import java.util.ArrayList;

/**
 * Created by victoraboytes on 21/01/2018.
 */

public class PetProfileAdapter extends RecyclerView.Adapter<PetProfileAdapter.PetViewHolder>{

    //Declaration of objects
    private ArrayList<Pets> pets;
    private Activity activity;

    public PetProfileAdapter(ArrayList<Pets> pets, Activity activity) {
        this.pets       = pets;
        this.activity   = activity;
    }

    //Inflate layout and give view holder to get the views
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_profile_pet,
                parent, false);
        return new PetViewHolder(v);
    }

    //Associate every element of the array list with a view
    @Override
    public void onBindViewHolder(PetViewHolder petViewHolder, int position) {
        final Pets pets = this.pets.get(position);
        petViewHolder.imageviewPet.setImageResource(pets.getPhoto());
        petViewHolder.textviewLikes.setText(pets.getLikes());
    }

    @Override
    public int getItemCount() {
        return this.pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageviewPet;
        private TextView textviewLikes;

        public PetViewHolder(View itemView){
            super(itemView);
            this.imageviewPet = (ImageView) itemView.findViewById(R.id.imageviewPet);
            this.textviewLikes = (TextView) itemView.findViewById(R.id.textviewLikes);
        }
    }
}
