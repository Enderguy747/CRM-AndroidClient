package com.daniel.crm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.daniel.crm.io.UserApiAdapter;
import com.daniel.crm.model.User;
import com.daniel.crm.ui.adapter.UserAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<User>> {
    private UserAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_user) ;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager  mLayoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutmanager);

        mAdapter = new UserAdapter();
        recyclerView.setAdapter(mAdapter);


        Call<ArrayList<User>> call = UserApiAdapter.getApiService().getClientes();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
        if (response.isSuccessful()) {
            ArrayList<User> users = response.body();
            Log.d("onResponse user","tamaño =>"+users.size());
            mAdapter.setDataSet(users);
        }

    }

    @Override
    public void onFailure(Call<ArrayList<User>> call, Throwable t) {

    }
}