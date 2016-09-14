package allezia.app.android.onlinecv.Pages;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Date;

import allezia.app.android.onlinecv.R;

public class ProfilePages extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_profile_pages, container, false);
        final Button dateTime = (Button)view.findViewById(R.id.setBhirtday);
        final DatePicker picker = (DatePicker) view.findViewById(R.id.datePicker);
        dateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (picker.getVisibility() == View.INVISIBLE) {
                   picker.setVisibility(View.VISIBLE);
                   dateTime.setText("Get Date");
               }else{
                   dateTime.setText("Set a Bhirtday");
                   String data = String.valueOf(picker.getMonth())+"-"
                           +String.valueOf(picker.getYear());
                   picker.setVisibility(View.INVISIBLE);
                   System.out.println(data);


               }


            }
        });
        return view;
    }
}
