package com.example.ites.gmail_clone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetalleMensajeActivity extends AppCompatActivity {
    private TextView textViewAsunto;
    private TextView textViewRemitente;
    private TextView textViewMensaje;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_mensaje);

        Bundle params = getIntent().getExtras();

        String strAsunto = params.getString("ASUNTO");
        textViewAsunto = (TextView) findViewById(R.id.textViewAsunto);
        textViewAsunto.setText(strAsunto);

        String strRemitente = params.getString("REMITENTE");
        textViewRemitente = (TextView) findViewById(R.id.textViewRemitente);
        textViewRemitente.setText(strRemitente);

        String strEmail = params.getString("EMAIL");
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewEmail.setText(strEmail);

        String strMensaje = params.getString("DETALLE");
        textViewMensaje = (TextView) findViewById(R.id.textViewMensaje);
        textViewMensaje.setText(strMensaje);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mensaje, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnuVolver:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
