package com.daniel.crm.io;

import com.daniel.crm.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("clientes")
    Call<ArrayList<User>> getClientes();
}
