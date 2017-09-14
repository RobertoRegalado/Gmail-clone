package com.example.ites.gmail_clone;

/**
 * Created by Roberto on 10/09/2017.
 */

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MensajeAdapter extends BaseAdapter{

    private List<Mensaje> mensajes;

    public MensajeAdapter(List<Mensaje> mensajes){

        this.mensajes = mensajes;
    }

    @Override
    public int getCount() {
        return mensajes.size();
    }

    @Override
    public Object getItem(int position) {
        return mensajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mensajes.get(position).getId();
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        //optimizacion de reutilizacion de recursos
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linea_mensaje,parent,false);
        }else{
            view = convertView;
        }

        Mensaje mensaje = (Mensaje)getItem(position);

        TextView textViewLetra = (TextView) view.findViewById(R.id.textViewLetra);
        TextView textViewRemitente = (TextView) view.findViewById(R.id.textViewRemitente);
        TextView textViewAsunto = (TextView) view.findViewById(R.id.textViewAsunto);
        TextView textViewMensaje = (TextView) view.findViewById(R.id.textViewMensaje);

        //maximo 50 caracteres
        textViewMensaje.setFilters(new InputFilter[] {new InputFilter.LengthFilter(50)});


        textViewLetra.getBackground().setColorFilter(Color.parseColor(mensaje.getColor()), PorterDuff.Mode.SRC);
        textViewLetra.setText(mensaje.getRemitente().substring(0,1).toUpperCase());

        textViewRemitente.setText(mensaje.getRemitente());
        textViewAsunto.setText(mensaje.getAsunto());
        textViewMensaje.setText(mensaje.getMensaje());

        return view;
    }
}
