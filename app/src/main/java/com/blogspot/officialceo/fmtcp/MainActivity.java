package com.blogspot.officialceo.fmtcp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.officialceo.fmtcp.Data.TranzactionsContract;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SQLiteDatabase mDB;

    private boolean doubleBackToExitPressedOnce = false;

    private ImageView headImage;
    private TextView dateText, dialogTitle;
    private AppBarLayout mAppBarLayout;
    private List<Tranzactions> tranzactionsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TranzactionsAdapter mAdapter;
    private TextView amount, date;
    private Button billsButton;
    private EditText pMethod, fUsage, pAmount, tPin;
    private Intent myIntent;

    public TextView available, incomeAmount, expenseAmount;

    public Button dialogeCancel, dialogeProceed;

    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mAppBarLayout = findViewById(R.id.mAppBarLayout);
        mAppBarLayout.setElevation(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       // headImage = (ImageView) findViewById(R.id.head_pic);
        dateText = findViewById(R.id.date_id);

        available = findViewById(R.id.avail_balance);
        available.setText("N" + 350000);

        incomeAmount = findViewById(R.id.income);
        incomeAmount.setText("N" + 78000);

        expenseAmount = findViewById(R.id.spent_amount);
        expenseAmount.setText("N" + 15000);



        String currentDate = DateFormat.getDateInstance().format(new Date());
        dateText.setText(currentDate);

        ImageView navImage = findViewById(R.id.imageView);

//        Glide.with(this).load(getImage("chris")).into(navImage);



        billsButton = findViewById(R.id.bills_button);
        billsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, BillsActivity.class);
                startActivity(myIntent);
//               final Dialog openDialog = new Dialog(MainActivity.this);
//               openDialog.setContentView(R.layout.custom_dialogue);
//               dialogTitle = findViewById(R.id.dialog_title);
              // dialogTitle.setText("Proceed with bill payment");
               pMethod = findViewById(R.id.method_edttxt);
               fUsage = findViewById(R.id.usage_edttxt);
               pAmount = findViewById(R.id.amount_edttxt);
              // tPin = findViewById(R.id.pin_edttxt);
                
             //  openDialog.show();

            }
        });

//        dialogeCancel = findViewById(R.id.cancle_button);
//        dialogeProceed = findViewById(R.id.proceed_button);
//
//        dialogeProceed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String paying = pAmount.getText().toString();
//
//                TextView availableBalance = findViewById(R.id.avail_balance);
//                availableBalance.setText(paying);
//            }
//        });



        recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new TranzactionsAdapter(tranzactionsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

//        TranzactionsDBHelper dbHelper = new TranzactionsDBHelper(this);
//        mDB =dbHelper.getWritableDatabase();

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareTranzactionsData();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (doubleBackToExitPressedOnce){

            finishAffinity();
            System.exit(0);

//            super.onBackPressed();
//            return;

        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about_app) {
            Toast.makeText(this, "Info about the app is here", Toast.LENGTH_LONG).show();
        } else if (id == R.id.group_members) {
            Toast.makeText(this, "Group members info is here", Toast.LENGTH_LONG).show();

        }else if (id == R.id.results){
            myIntent = new Intent(MainActivity.this, ResultsActivity.class);
            startActivity(myIntent);
            Toast.makeText(this, "This is to check result", Toast.LENGTH_LONG).show();
        }else if (id == R.id.nav_school_level){
            Toast.makeText(this, "This is to check school dues", Toast.LENGTH_LONG).show();
        }else if (id == R.id.nav_department_level){
            Toast.makeText(this, "This is to check department dues", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private int getImage (String imageName){

        int drawableResourceId = getResources().getIdentifier(imageName, "drawable", this.getPackageName());

        return drawableResourceId;
    }

    private void prepareTranzactionsData(){
        Tranzactions tranzaction = new Tranzactions("Bank Transfer", "Text book", 5000, "Jun,26");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Bank Transfer", "Text book", 7000, "Jun,23");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("DTH Recharge", "Free charge in", 4000, "Jun,17");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Online Shopping", "Clothings", 9000, "Jun,11");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Taxify Payment", "Transport", 2000, "Jun,7");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Bank Transfer", "Course sorting", 10000, "May,30");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Bank Transfer", "Course sorting", 12000, "May,22");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Cash Withdrawal", "Babe flexing", 6000, "May,20");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Bank Transfer", "Zenith bank", 30000, "May,17");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Bank Transfer", "Text book", 5000, "May,11");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Bank Transfer", "Text book", 5000, "May,2");
        tranzactionsList.add(tranzaction);

        tranzaction = new Tranzactions("Bank Transfer", "Text book", 5000, "Apr,13");
        tranzactionsList.add(tranzaction);
    }

    public void addToTranzactions(View v){
        if(pMethod.getText().length() == 0 ||
                fUsage.getText().length() == 0 ||
                pAmount.getText().length() == 0){
            return;
        }

        int amountToPay = 0;
        String fundUsage = "";

        try {
            amountToPay = Integer.parseInt(pAmount.getText().toString());
        }catch (Exception ex){
            Log.e(LOG_TAG, "Failed to parse amount text to number: " + ex.getMessage());
        }

        addNewTranzaction(pMethod.getText().toString(), fundUsage, amountToPay);

    }

    public long addNewTranzaction(String method, String usage, int amount){

        ContentValues cv = new ContentValues();

        cv.put(TranzactionsContract.TranzactionsEntry.COLUMN_PAYMENT_METHOD, method);
        cv.put(TranzactionsContract.TranzactionsEntry.COLUMN_FUND_USAGE, usage);
        cv.put(TranzactionsContract.TranzactionsEntry.COLUMN_AMOUNT, amount);

        return mDB.insert(TranzactionsContract.TranzactionsEntry.TABLE_NAME, null, cv);

    }

    public void dialogueBoxCalculations(){



    }



}
