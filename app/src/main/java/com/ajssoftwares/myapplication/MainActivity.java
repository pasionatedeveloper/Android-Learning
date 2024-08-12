package com.ajssoftwares.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.homeNavItem){
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
        }
        else if(id == R.id.profileNavItem){
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
        }
        else if(id == R.id.settingsNavItem){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
        }
        else if(id == R.id.logoutNavItem){
            Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}