package com.example.mad_assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CreateNewCrime_activity extends AppCompatActivity {


    private TextInputEditText mCrimeTitle;
    private MaterialCheckBox mCheckBox;
    private TextInputEditText mShowSelectedDateText;
    private DatePickerDialog datePickerDialog;
    private AutoCompleteTextView autoComplete_dropdownText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_crime);
        mCrimeTitle = (TextInputEditText) findViewById(R.id.crimeTitle_txt);
        mCheckBox  = findViewById(R.id.checkbox_solved);
        mShowSelectedDateText = (TextInputEditText) findViewById(R.id.crime_Date_txt);
        autoComplete_dropdownText =      findViewById(R.id.autoComplete_dropdownText);
        policeRequireMenu();
        datePicker();

    }


    public void policeRequireMenu(){

        String[] items = new String[]{ "Yes", "No" };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.police_require_options, items);
        autoComplete_dropdownText.setAdapter(arrayAdapter);
    }





    private void datePicker(){

        mShowSelectedDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(CreateNewCrime_activity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                mShowSelectedDateText.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

    }

    public void confirmBtn_Listener(View view)
    {


        String date  = mShowSelectedDateText.getText().toString();
        String title = mCrimeTitle.getText().toString();
        boolean isPoliceRequire = autoComplete_dropdownText.getText().toString().equals("Yes");
        boolean isSolved = mCheckBox.isSelected();


        Crime crime = new Crime(title,date,isSolved,isPoliceRequire);
        Intent intent = new Intent(this,CrimeActivity.class);
        intent.putExtra("crime", crime);
        setResult(RESULT_OK, intent);
        finish();
    }

}
