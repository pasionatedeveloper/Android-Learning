package com.ajssoftwares.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    BottomNavigationView bottomNavigationView;


    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        Snackbar.make(this.getCurrentFocus(),"Welcome",Snackbar.LENGTH_LONG).show();


        //toggle buttton for drawer
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // open home fragment by default
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new HomeFragment()).commit();




        navigationView.setNavigationItemSelectedListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.homeItem){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new HomeFragment()).commit();
        }
        else if(id == R.id.searchItem){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new SearchFragment()).commit();

        }
        else if(id == R.id.favouritesItem){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new FavouriteFragment()).commit();
        }

        else if(id == R.id.logoutNavItem){
            drawerLayout.closeDrawer(GravityCompat.START);
            showAlertDialog();
        }

        else{

        }
        return true;
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to log out");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                 SharedPreferences sp = getSharedPreferences("registration", Context.MODE_PRIVATE);
                 SharedPreferences.Editor editor = sp.edit();
                 editor.putString("isUserLogin","NotLoggedIn");
                 editor.apply();

                 Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                 startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }
}