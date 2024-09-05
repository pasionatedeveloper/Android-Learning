package com.ajssoftwares.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    RecyclerView recyclerView;

    ArrayList<User> usersList = new ArrayList<>();


    public HomeFragment() {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getUserData();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new UserAdapter(requireContext(),usersList));

        return view;
    }

    private void getUserData() {
        usersList.add(new User("Ali","03000000000",20));
        usersList.add(new User("Umair","03000000000",20));
        usersList.add(new User("Irfan","03000000000",20));
        usersList.add(new User("Wasi ullah","03000000000",20));
        usersList.add(new User("Sibt ul hussain","03000000000",20));
        usersList.add(new User("Usman Hameed","03000000000",20));
        usersList.add(new User("Attique-ur-rehman","03000000000",20));
    }
}