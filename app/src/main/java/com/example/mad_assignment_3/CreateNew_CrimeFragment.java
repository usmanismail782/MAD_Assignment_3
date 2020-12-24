package com.example.mad_assignment_3;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateNew_CrimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateNew_CrimeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextInputEditText mShowSelectedDateText;
    DatePickerDialog datePickerDialog;
    TextInputLayout policeRequireDropMenue;
    AutoCompleteTextView autoComplete_dropdownText;
    private  Button confirm_Btn;

    public CreateNew_CrimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateNew_CrimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateNew_CrimeFragment newInstance(String param1, String param2) {
        CreateNew_CrimeFragment fragment = new CreateNew_CrimeFragment();
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
        Button btn = ((CrimeActivity)getActivity()).findViewById(R.id.createNew_CrimeBtn);
        btn.setEnabled(false);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_new__crime, container, false);
        mShowSelectedDateText = (TextInputEditText) view.findViewById(R.id.crime_Date_txt);

        policeRequireDropMenue = view.findViewById(R.id.policeRequire_Menu);
        autoComplete_dropdownText = view.findViewById(R.id.autoComplete_dropdownText);


        String[] items = new String[]{ "Yes", "No" };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.police_require_options, items);
        autoComplete_dropdownText.setAdapter(arrayAdapter);

        confirm_Btn = view.findViewById(R.id.confirm_Button);


        datePicker();

        return view;
    }

    private void confirm_Btn_actionListner(){

        confirm_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closefragment();
            }
        });
        }

    private void closefragment() {

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
                datePickerDialog = new DatePickerDialog(getContext(),
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


}




