package com.example.ites.gmail_clone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listaMensajes;
    private SwipeRefreshLayout sflLista;
    private Context context;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuRefresh:
                // Refresca la lista
                sflLista.setRefreshing(true);
                //espera 3 seg y lo para
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cargarLista();
                        sflLista.setRefreshing(false);
                    }
                }, 3000);
                return true;
            case R.id.mnuBuscar:
                Toast.makeText(context,"Buscando !!!",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnuTools:
                Toast.makeText(context,"Abre Herramientas",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnuCerrar:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    private void cargarLista(){
        final List<Mensaje> mensajes = new ArrayList<>();

        mensajes.add(new Mensaje(1, "Juan Perez","juanperez@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#E91E63"));
        mensajes.add(new Mensaje(2, "Juanita Perez","lamaspetisa@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FF6600"));
        mensajes.add(new Mensaje(3, "Jorge Garcia","jorgito.alfajor@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#673AB722"));
        mensajes.add(new Mensaje(4, "Carlos Germino","atupartes.germino@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FF6600"));
        mensajes.add(new Mensaje(5, "Graciela Fernandez","grachufernandez345@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FF0000"));
        mensajes.add(new Mensaje(6, "Jose Martinez","jose.martinez234@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#00FF00"));
        mensajes.add(new Mensaje(7, "Marcela Moreno","marcelita.moreno@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FFFF00"));
        mensajes.add(new Mensaje(8, "John Smith","extra.2345@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#E91E3363"));
        mensajes.add(new Mensaje(9, "Magali Romero","magui.romero@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#0000CC"));
        mensajes.add(new Mensaje(10, "Cecilia Perez","ceci1932@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FF6600"));
        mensajes.add(new Mensaje(11, "Juan Partuzi","partuzijuan@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#E91E63"));
        mensajes.add(new Mensaje(12, "Raul Carione","raulito321@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FF6600"));
        mensajes.add(new Mensaje(13, "Rodrigo Romero","rromero@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#0000CC"));
        mensajes.add(new Mensaje(14, "Juan Perez","juancho2003@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FF6600"));
        mensajes.add(new Mensaje(15, "Maria Nowak","marianwk@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#66FFFF"));
        mensajes.add(new Mensaje(16, "Silvia Crespo","s.crespo@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FF6600"));
        mensajes.add(new Mensaje(17, "Ivan Garcia","ivangarcia@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#00FF00"));
        mensajes.add(new Mensaje(18, "Carlos Fernandez","carlos1974@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#00FFFF"));
        mensajes.add(new Mensaje(19, "Bautista Bermudez","bau.bermu@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FF0000"));
        mensajes.add(new Mensaje(20, "Esteban Quito","estebanq@gmail.com", "Hola Mundo", "Aca estoy Mundo", "#FFFF00"));
        mensajes.add(new Mensaje(21, "Mauricio Scheffer","m.schefferz@gmail.com", "Hola Mundo", "1) Pantalla de lista de mensajes, implementada por medio de listview.\n" +
                "2) Para cada item de la lista se debe incluir icono de color con la primera letra del\n" +
                "nombre del remitente, asunto y una sección del mensaje no superior a los 50\n" +
                "caracteres.\n" +
                "2) Implementar menú de opciones, que permite salir de la aplicación y un botón para\n" +
                "refrescar la lista de mensajes.\n" +
                "3) Implementar funcionalidad que permite al seleccionar un mensaje de la lista, pasar\n" +
                "a una pantalla que muestre contenido completo de dicho mensaje.", "#00FF00"));

        listaMensajes.setAdapter(new MensajeAdapter(mensajes));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        listaMensajes = (ListView) findViewById(R.id.listaMensajes);
        sflLista = (SwipeRefreshLayout) findViewById(R.id.sflLista);

        cargarLista();

        listaMensajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mensaje item = (Mensaje) listaMensajes.getItemAtPosition(position);

                String remitente = item.getRemitente();
                String email = item.getEmail();
                String asunto =item.getAsunto();
                String detalle =item.getMensaje();
                abrirActividad(remitente, email, asunto, detalle);
            }
        });
        sflLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cargarLista();
                sflLista.setRefreshing(false);
            }
        });
    }
    private void abrirActividad(String remitente, String email, String asunto, String detalle){
        Intent pantalla = new Intent(this, DetalleMensajeActivity.class);
        pantalla.putExtra("REMITENTE", remitente);
        pantalla.putExtra("EMAIL", email);
        pantalla.putExtra("ASUNTO", asunto);
        pantalla.putExtra("DETALLE", detalle);

        startActivity(pantalla);
    }

}
