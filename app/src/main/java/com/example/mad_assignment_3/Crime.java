package com.example.mad_assignment_3;

import java.io.Serializable;
import java.util.UUID;

public class Crime implements Serializable {

    private UUID crimeID;
    private String crimeTitle;
    private String crimeDate;
    private boolean crimeSolved;
    private boolean requirePolice;

    public Crime() {

        crimeID = UUID.randomUUID();
    }

    public Crime( String crimeTitle, String crimeDate, boolean crimeSolved, boolean requirePolice) {
        this.crimeID = UUID.randomUUID();
        this.crimeTitle = crimeTitle;
        this.crimeDate = crimeDate;
        this.crimeSolved = crimeSolved;
        this.requirePolice = requirePolice;
    }

    public UUID getCrimeID() {
        return crimeID;
    }

    public void setCrimeID(UUID crimeID) {
        this.crimeID = crimeID;
    }

    public String getCrimeTitle() {
        return crimeTitle;
    }

    public void setCrimeTitle(String crimeTitle) {
        this.crimeTitle = crimeTitle;
    }

    public String getCrimeDate() {
        return crimeDate;
    }

    public void setCrimeDate(String crimeDate) {
        this.crimeDate = crimeDate;
    }

    public boolean isCrimeSolved() {
        return crimeSolved;
    }

    public void setCrimeSolved(boolean crimeSolved) {
        this.crimeSolved = crimeSolved;
    }

    public void setRequirePolice(boolean requirePolice) {
        this.requirePolice = requirePolice;
    }
    public boolean isRequirePolice() {
        return requirePolice;
    }
}
