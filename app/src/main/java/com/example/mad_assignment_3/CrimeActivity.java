package com.example.mad_assignment_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class CrimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        Fragment fragment = new CrimeList_Fragment();
        loadFragment(fragment);


        for(int i = 0; i < 11; i++ )
        {
            boolean requirePolice = (5 * i) % 2 == 0;
            boolean isSolve =  (7*i+1) % 2  == 0;
            Crime crime = new Crime("Title"+i, "24\\12\\2020",true,  requirePolice );
            CrimeLab.getCrimeLab_Object().getCrimeList().add(crime);
        }


    }



    public void loadFragment(Fragment fragment)
    {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragmentExist = fragmentManager.findFragmentById(R.id.frameLayout);
        if(fragmentExist != null)
        {
            fragmentTransaction.remove(fragmentExist);
        }
        fragmentTransaction.replace(R.id.frameLayout, fragment).addToBackStack(null).commit();


    }


    public void crimeList_BtnListener(View view)
    {
        Fragment fragment = new CrimeList_Fragment();
        loadFragment(fragment);
    }

    public void createNewCrime_BtnListener(View view)
    {
        Intent intent = new Intent(this,CreateNewCrime_activity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1)
        {
            assert data != null;
            Crime crime = (Crime) data.getSerializableExtra("crime");
            if(crime != null){

                CrimeLab.getCrimeLab_Object().getCrimeList().add(crime);



            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }




}