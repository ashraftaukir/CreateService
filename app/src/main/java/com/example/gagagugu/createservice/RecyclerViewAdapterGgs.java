package com.example.gagagugu.createservice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



public class RecyclerViewAdapterGgs extends
        RecyclerView.Adapter<RecyclerViewAdapterGgs.MyViewHolder> {

    private List<String> list_item ;
    private  Context mcontext;
    private  RecyclerView recylerview;
    private  TextView description;
    private  EditText search;
 private Animation  animationUp,animationDown;


    public RecyclerViewAdapterGgs(List<String> list, Context context, RecyclerView rc, EditText src, TextView des) {

        list_item = list;
        mcontext = context;
        recylerview=rc;
        search=src;
        description=des;

    }


    @Override
    public RecyclerViewAdapterGgs.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.ggs_list_item, null);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position ) {

        animationUp = AnimationUtils.loadAnimation(mcontext, R.anim.ggs_slide_up);
        animationDown=AnimationUtils.loadAnimation(mcontext, R.anim.ggs_slide_down);

        viewHolder.country_name.setText(list_item.get(position));

        viewHolder.country_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(mcontext,list_item.get(position),Toast.LENGTH_LONG).show();

                recylerview.setVisibility(View.GONE);
               search.setVisibility(View.GONE);
                description.setVisibility(View.VISIBLE);
                recylerview.startAnimation(animationUp);
                search.startAnimation(animationUp);
                description.startAnimation(animationDown);
            }
        });



       description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(mcontext,"click description",Toast.LENGTH_LONG).show();

                description.setVisibility(View.GONE);
                search.setVisibility(View.VISIBLE);
                recylerview.setVisibility(View.VISIBLE);
                recylerview.startAnimation(animationDown);
                search.startAnimation(animationDown);
                description.startAnimation(animationUp);


            }
        });
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

         TextView country_name;


         MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            country_name = (TextView) itemLayoutView.findViewById(R.id.country_name);


        }
    }

    @Override
    public int getItemCount() {
        return list_item.size();
    }

}
