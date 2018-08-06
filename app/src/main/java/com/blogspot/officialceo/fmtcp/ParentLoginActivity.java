package com.blogspot.officialceo.fmtcp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ParentLoginActivity extends AppCompatActivity {

    private Button parentLoginButton;
    private EditText parentUsername, parentPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);

        parentUsername = findViewById(R.id.parent_username);
        parentLoginButton = findViewById(R.id.parent_login_button);
        parentPassword = findViewById(R.id.parent_password);

        parentLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
