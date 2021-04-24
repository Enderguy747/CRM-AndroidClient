package com.daniel.crm.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.crm.R;
import com.daniel.crm.model.User;

import java.util.ArrayList;

public  class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textview;

        public ViewHolder(TextView tv) {
            super(tv);
            textview = tv;
        }
    }


    public UserAdapter() {
        mDataSet = new ArrayList<>();

    }

    public void setDataSet(ArrayList<User> dataset){
        mDataSet = dataset;
        notifyDataSetChanged();
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        TextView tv = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_view, parent, false);



        return new ViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.textview.setText(
                "Apellidos: \n"+mDataSet.get(i).getApellidos()+" \n" +
                "Cedula: \n"+mDataSet.get(i).getCedula()+"\n"+
                        "Direccion: \n"+mDataSet.get(i).getDireccion()+"\n"+
                        "Email: \n"+mDataSet.get(i).getEmail()+"\n \n"+
                        "Nacionalidad: \n"+mDataSet.get(i).getNacionalidad()+"\n \n"+
                        "Nombre: \n"+mDataSet.get(i).getNombre()+"\n \n"+
                        "Telefono: \n"+mDataSet.get(i).getTelefono()+"\n \n"
        );
    }

    @Override
    public int getItemCount() {
        return mDataSet.size() ;
    }



}
