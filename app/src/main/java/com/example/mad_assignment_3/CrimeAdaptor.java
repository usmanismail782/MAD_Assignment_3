package com.example.mad_assignment_3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class CrimeAdaptor extends RecyclerView.Adapter<CrimeAdaptor.ContactViewHolder> {

    private Context context;
    private ArrayList<Crime> crimeList = new ArrayList<>();

    public CrimeAdaptor(Context context, ArrayList<Crime> arrayList) {
        this.context = context;
        this.crimeList = arrayList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_crime_item,parent, false);

        return new ContactViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return crimeList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {


        String title = crimeList.get(position).getCrimeTitle();
        Date date = crimeList.get(position).getCrimeDate();
        boolean isSolved = crimeList.get(position).isCrimeSolved();
        boolean isPoliceRequire = crimeList.get(position).isRequirePolice();

        holder.item_crimeTitle.setText(title);
        holder.item_crimeDate.setText("23\\12\\2020");
        holder.item_check_Image.setVisibility(isSolved? View.VISIBLE : View.GONE);
        holder.item_callPolice_Btn.setVisibility(isPoliceRequire? View.VISIBLE : View.GONE);






    }

 public class ContactViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView item_crimeTitle,item_crimeDate;
        Button  item_callPolice_Btn;
        ImageView item_check_Image;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);


            itemView.setOnClickListener(this);
            item_crimeTitle = (TextView) itemView.findViewById(R.id.item_crimeTitle);
            item_crimeDate = (TextView) itemView.findViewById(R.id.item_crimeDate);
            item_check_Image= (ImageView) itemView.findViewById(R.id.item_check_Image);
            item_callPolice_Btn = (Button) itemView.findViewById(R.id.item_callPolice_Btn);
        }

        @Override
        public void onClick(View v) {
                                                  /*     int position = this.getAdapterPosition();
          Crime crime =(Crime) contactsList.get(position);


            Intent intent;
            intent = new Intent(context,View_Contact.class);
            intent.putExtra("crimeDetails",crime);
            context.startActivity(intent);
*/
                                    }
    }

}
