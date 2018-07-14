package com.blogspot.officialceo.fmtcp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BillsActivity extends AppCompatActivity {

    private Button cancleButton, proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        cancleButton = findViewById(R.id.cancle_button);
        proceedButton = findViewById(R.id.proceed_button);

        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(BillsActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BillsActivity.this, "Transaction action taken", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
