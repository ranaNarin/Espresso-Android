package com.soft.espresso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity.class";
    private Button btnLogin;
    private EditText edtPassword;
    private EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);

     /*   edtEmail.setText("rana.narin@gmail.com");
        edtPassword.setText("password");*/

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==btnLogin)
        {
            String email=edtEmail.getText().toString().trim();
            String password=edtPassword.getText().toString().trim();

            if(!Comm.isEmailInvalid(email))
            {
                edtEmail.setError("Invalid Email");
                return;
            }
            if(password.isEmpty())
            {
                edtPassword.setError("Invalid Password");
                return;
            }

            if(email.equals("rana.narin@gmail.com") && password.equals("password"))
            {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "invalid email and password", Toast.LENGTH_LONG).show();
            }

        }


    }

}
