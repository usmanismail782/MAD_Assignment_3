package com.example.mad_assignment_3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {

    private  static  CrimeLab crimeLab_Object;
    private List<Crime> crimeList;

    CrimeLab(){
        
        crimeList = new ArrayList<Crime>();
    }

    public static CrimeLab getCrimeLab_Object() {

        if(crimeLab_Object == null){
            crimeLab_Object = new CrimeLab();
        }
        return crimeLab_Object;
    }

    public List<Crime> getCrimeList() {
        return crimeList;
    }

    public void setCrimeList(List<Crime> crimeList) {
        this.crimeList = crimeList;
    }

    public Crime getCrime(UUID crimeID){

        for(Crime crime : crimeList)
        {
            if(crime.getCrimeID() == crimeID )
                return crime;
        }

        return null;
    }
}
