package com.example.mad_assignment_3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrimeList_Fragment extends Fragment {



    public CrimeList_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime_list_, container, false);
        ArrayList<Crime> arrayList = (ArrayList<Crime>) CrimeLab.getCrimeLab_Object().getCrimeList();


        if(arrayList.size() > 0)
        {

            RecyclerView recyclerView = view.findViewById(R.id.recycle_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new CrimeAdaptor(getContext(),arrayList));
        }

        return view;
    }







}