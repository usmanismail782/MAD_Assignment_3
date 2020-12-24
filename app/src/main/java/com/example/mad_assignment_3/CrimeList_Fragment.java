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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrimeList_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrimeList_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CrimeList_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrimeList_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrimeList_Fragment newInstance(String param1, String param2) {
        CrimeList_Fragment fragment = new CrimeList_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime_list_, container, false);
        ArrayList<Crime> arrayList = new ArrayList<Crime>();


        for(int i = 0; i < 100; i++ ) {

            Crime crime = new Crime("Title"+i, new Date(),false, true);
            arrayList.add(crime);


        }


        if(arrayList.size() > 0)
        {

            RecyclerView recyclerView = view.findViewById(R.id.recycle_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new CrimeAdaptor(getContext(),arrayList));
        }
        // Inflate the layout for this fragment
        return view;
    }





}