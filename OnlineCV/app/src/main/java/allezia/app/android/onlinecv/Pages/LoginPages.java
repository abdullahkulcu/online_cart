package allezia.app.android.onlinecv.Pages;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import allezia.app.android.onlinecv.R;
import cz.msebera.android.httpclient.Header;

public class LoginPages extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pages);
        final Button login = (Button) findViewById(R.id.loginRegisterButton);
        final EditText email = (EditText) findViewById(R.id.emailText);
        final EditText password = (EditText) findViewById(R.id.passwordText);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    login.setText("Login");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    login.setText("Login");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = login.getText().toString();
                if(buttonText.equals("Login")){
                    if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                        registerLoginUser(email.getText().toString(),password.getText().toString(),0);
                    }
                }
            }
        });
    }

    private void registerLoginUser(String email ,String password,int register){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams param = new RequestParams();
        param.put("email",email);
        param.put("password",password);
        param.put("register",register);
        client.post("http://192.168.56.1:82/user_register.php", param, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                System.out.println(responseString);
            }
        });
    }
}
