package com.example.gagagugu.createservice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


public class CreateServiceFragmentGgs extends Fragment {

    View view;


    private RecyclerView mRecyclerView;
    public EditText search;
    private List<String> list = new ArrayList<>();
    public RecyclerViewAdapterGgs mAdapter;
    TextView description;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.ggs_createservice_fragment, container, false);
        search = (EditText) view.findViewById( R.id.search);
        description=(TextView)view.findViewById(R.id.description);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        countryList();
        mAdapter = new RecyclerViewAdapterGgs(list,getActivity(),mRecyclerView,search,description);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        addTextListener();

        return view;

    }

    public void countryList(){

        list.add("Afghanistan");
        list.add("Albania");
        list.add("Algeria");
        list.add("Bangladesh");
        list.add("Belarus");
        list.add("Canada");
        list.add("Cape Verde");
        list.add("Central African Republic");
        list.add("Denmark");
        list.add("Dominican Republic");
        list.add("Egypt");
        list.add("France");
        list.add("Germany");
        list.add("Hong Kong");
        list.add("India");
        list.add("Iceland");
    }


    public void addTextListener(){

        search.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                if(s.toString().length() > 0) {
                    search.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {

                    search.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ggs_ic_search_icon, 0, 0, 0);
                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence query, int start, int before, int count) {

               // Toast.makeText(getActivity(),"Searching onTextChanged",Toast.LENGTH_LONG).show();

                query = query.toString().toLowerCase();

                final List<String> filteredList = new ArrayList<>();

                for (int i = 0; i < list.size(); i++) {

                    final String text = list.get(i).toLowerCase();
                    if (text.contains(query)) {

                        filteredList.add(list.get(i));

                    }
                }

                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mAdapter = new RecyclerViewAdapterGgs(filteredList, getActivity(),mRecyclerView,search,description/*,service_title*/);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }
        });
    }




}
