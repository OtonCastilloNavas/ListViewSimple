package com.cam.listviewsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener, ListView.OnItemLongClickListener {

    private List<String> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //control para mostrar los datos
        ListView lvDatos = (ListView) findViewById(R.id.lvDatos);


        //origen de datos, fuente de informacion
        datos = new ArrayList<>();
        datos.add("Juan");
        datos.add("Ana");
        datos.add("Rina");
        datos.add("Denis");
        datos.add("Rebeca");
        datos.add("Marisol");
        datos.add("Santiago");
        datos.add("Valeria");
        datos.add("Esteban");
        datos.add("Marcia");
        datos.add("Roberto");
        datos.add("Carlos");
        datos.add("Estefania");
        datos.add("Mauricio");
        datos.add("Saida");
        datos.add("Mario");
        datos.add("Alondra");
        datos.add("Orlando");

        //Adaptador
        //enlace entre datos y control
        ArrayAdapter arrayAdapter =  new ArrayAdapter(this,android.R.layout.simple_list_item_1,datos);

        //asignar adaptador a control
        lvDatos.setAdapter(arrayAdapter);

        //Evento para manejar el oprimir uno de los items de la lista
        //this especifica que esta misma clase manejara el click del item
        //por lo que esta clase necesita implementar ese manejador
        lvDatos.setOnItemClickListener(this);
        //utilizaremos el click extendido o long press para activar el borrado de uno de los items
        //asignado el manejador
        lvDatos.setOnItemLongClickListener(this);
    }


    //evento obligatorio para ese manejador del click en item del listview
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //adapterview corresponde a la vista del padre, en ese caso el listview
        //view corresponde a la vista del item que fue oprimido
        //i o en ocaciones position, corresponde a la posicion del item en el listview
        //l o en ocaciones id, corresponde a un identificador del item dentro del listview
        Toast.makeText(this, datos.get(i), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v)
    {
        //obtener el contenido del edittext al momento que se oprima click en el boton
        EditText etNombre = (EditText) findViewById(R.id.etNombre);

        //lo obtenido lo guardamos en la lista
        datos.add(etNombre.getText().toString());

        //ademas de agregarlo a lista debemos decirle al adaptador que hay que actualizar
        //entre una de las formas de hacer esto, se puede hacer obteniendo el adaptador del control listview
        ListView lvDatos = (ListView) findViewById(R.id.lvDatos);
        //adaptador que retorna es uno generico, hay que convertirlo al adaptador que utilizamos
        ArrayAdapter arrayAdapter= (ArrayAdapter)lvDatos.getAdapter();
        //este metodo notifica cuando se realizaron cambios en los datos
        arrayAdapter.notifyDataSetChanged();

    }

    //recibe parametros iguales al evento anterior
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        //remove elimina un valor de la lista
        datos.remove(i);
        //una vez eliminado actualizamos el adaptador
        ListView lvDatos= (ListView) findViewById(R.id.lvDatos);
        ArrayAdapter arrayAdapter = (ArrayAdapter) lvDatos.getAdapter();
        arrayAdapter.notifyDataSetChanged();
        return false;
    }
}
