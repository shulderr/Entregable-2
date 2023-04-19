package com.movilespascual.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ListaElementos> misDatos;
    private LayoutInflater myInflater;
    private Context myContext;


    public ListAdapter(List<ListaElementos> itemList, Context context) {
        this.misDatos = itemList;
        this.myInflater = LayoutInflater.from(context);
        this.myContext = context;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = myInflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(misDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return misDatos.size();
    }

    //public void setItems(List<ListaElementos> items){ misDatos= items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;

        RelativeLayout layout;
        TextView name, city, status, mail, Letra;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mail = itemView.findViewById(R.id.mailTextView);
            iconImage = itemView.findViewById(R.id.iconoImageView);
            name = itemView.findViewById(R.id.nameTextView);
            city = itemView.findViewById(R.id.cityTextView);
            status = itemView.findViewById(R.id.statusTextView);
            Letra = itemView.findViewById(R.id.initial);
            layout = itemView.findViewById(R.id.relative);
        }

        void bindData(final ListaElementos item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            mail.setText("Correo: " + item.getMail());
            name.setText(item.getName());
            city.setText("Ciudad: " +item.getCiudad());
            status.setText("Estado: " +item.getEstado());
            Letra.setText(item.getLetra());
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    general(item);
                }
            });
        }

        public void general(ListaElementos item){
            Intent intent = new Intent(myContext, GeneralView.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("ciudad",item.getCiudad());
            intent.putExtra("estado",item.getEstado());
            intent.putExtra("correo",item.getMail());
            myContext.startActivity(intent);
        }
    }

}
