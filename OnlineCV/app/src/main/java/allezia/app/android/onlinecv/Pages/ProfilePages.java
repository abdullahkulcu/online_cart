package allezia.app.android.onlinecv.Pages;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.Date;

import allezia.app.android.onlinecv.R;
import cz.msebera.android.httpclient.Header;

public class ProfilePages extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_profile_pages, container, false);
        Button saveButton = (Button) view.findViewById(R.id.saveDataButton);
        EditText firstName = (EditText) view.findViewById(R.id.nameText);
        EditText lastName = (EditText) view.findViewById(R.id.surnameText);
        EditText title = (EditText) view.findViewById(R.id.titleText);
        EditText information = (EditText) view.findViewById(R.id.informationText);

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

    private void sendUserData(){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams param = new RequestParams();
        //param.put("email");
        client.post("https://www.google.com", param, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

            }
        });
    }
}
