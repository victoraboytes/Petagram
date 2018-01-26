package com.victoraboytes.petagram.adapter;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.victoraboytes.petagram.pojo.Pets;
import com.victoraboytes.petagram.R;

import java.util.ArrayList;

/**
 * Created by victoraboytes on 21/01/2018.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{

    //Declaration of objects
    private ArrayList<Pets> pets;
    private Activity activity;

    public PetAdapter(ArrayList<Pets> pets, Activity activity) {
        this.pets       = pets;
        this.activity   = activity;
    }

    //Inflate layout and give view holder to get the views
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pets,
                parent, false);
        return new PetViewHolder(v);
    }

    //Associate every element of the array list with a view
    @Override
    public void onBindViewHolder(PetViewHolder petViewHolder, int position) {
        final Pets pets = this.pets.get(position);
        petViewHolder.imageviewPet.setImageResource(pets.getPhoto());
        petViewHolder.textviewPetName.setText(pets.getName());
        petViewHolder.textviewLikes.setText(pets.getLikes());

        petViewHolder.imagebuttonLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*Toast.makeText(activity,"Diste like a " + pets.getName(),
                        Toast.LENGTH_SHORT).show();*/
                Snackbar.make(v, v.getResources().getString(R.string.toast_pet_like) +
                        " " + pets.getName(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageviewPet;
        private TextView textviewPetName, textviewLikes;
        private ImageButton imagebuttonLike;

        public PetViewHolder(View itemView){
            super(itemView);
            this.imageviewPet = (ImageView) itemView.findViewById(R.id.imageviewPet);
            this.textviewPetName = (TextView) itemView.findViewById(R.id.textviewPetName);
            this.textviewLikes = (TextView) itemView.findViewById(R.id.textviewLikes);
            this.imagebuttonLike = (ImageButton) itemView.findViewById(R.id.imageButtonLike);
        }
    }
}
