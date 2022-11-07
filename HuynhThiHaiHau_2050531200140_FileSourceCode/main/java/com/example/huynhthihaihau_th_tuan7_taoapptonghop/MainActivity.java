package com.example.huynhthihaihau_th_tuan7_taoapptonghop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_open,R.string.menu_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        Log.i("MENU_DRAWER_TAG0","Home item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_profile:
                        doOpenProfileActivity();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_list:
                        doOpenListviewActivity();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_sign:
                        doOpenLogoutActivity();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });

        Button Profile = (Button) findViewById(R.id.btProfile);
        Button Listview = (Button) findViewById(R.id.btListview);

        Listview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "LISTVIEW OPEN!", Toast.LENGTH_SHORT).show();
                doOpenListviewActivity();
            }
        });

        Profile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "PROFILE OPEN!", Toast.LENGTH_SHORT).show();
                doOpenProfileActivity();
            }
        });

    }
    public void doOpenProfileActivity()
    {
        Intent myIntent=new Intent(this, ProfileActivity.class);
        startActivity(myIntent);
    }

    public void doOpenListviewActivity()
    {
        Intent myIntent=new Intent(this, ListActivity.class);
        startActivity(myIntent);
    }

    public void doOpenLogoutActivity()
    {
        Intent myIntent=new Intent(this, SignupActivity.class);
        startActivity(myIntent);
    }
}