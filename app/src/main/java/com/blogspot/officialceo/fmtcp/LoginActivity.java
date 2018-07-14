package com.blogspot.officialceo.fmtcp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Intent myIntent;
    private Button loginButton;
    private EditText reg_no, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.login_button);
        reg_no = findViewById(R.id.reg_number_edttxt);
        password = findViewById(R.id.password_edttxt);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reg_no.getText().toString().contains("20131860346") &&
                        password.getText().toString().contains("12345")){
                    myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }else if (reg_no.getText().toString().contains("20131860306") &&
                        password.getText().toString().contains("2468")){
                    myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }else if (reg_no.getText().toString().contains("20131882656") &&
                        password.getText().toString().contains("54321")){
                    myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }else if (reg_no.getText().toString().contains("20131852086") &&
                        password.getText().toString().contains("2222")){
                    myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }else if (reg_no.getText().toString().contains("20131860366") &&
                        password.getText().toString().contains("2468")){
                    myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }
                else if (reg_no.getText().toString().contains("20131860336") &&
                        password.getText().toString().contains("2580")){
                    myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Wrong password or registration number", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
