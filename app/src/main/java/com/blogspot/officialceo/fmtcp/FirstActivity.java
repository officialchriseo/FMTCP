package com.blogspot.officialceo.fmtcp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {
    private Button loginAsStudent, loginAsParent;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        loginAsParent = findViewById(R.id.login_as_parent);
        loginAsStudent = findViewById(R.id.login_as_student);

        loginAsStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(FirstActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });

        loginAsStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "Item clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
