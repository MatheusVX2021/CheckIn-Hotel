package Activities;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.checkinhotel.Controller;
import com.example.checkinhotel.R;
import android.widget.Toast;

public class Add_Activity extends AppCompatActivity
{

    private Button btnEstandar;
    private Button btnSuite;
    private Button btnDeluxe;
    private Button btnHecho;
    private EditText E_tarifa;
    private EditText E_nombre;
    private EditText E_fecha;
    private EditText E_noches;
    private EditText E_Dato1;
    private EditText E_Dato2;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_booking);

        btnEstandar = findViewById(R.id.btn_Estandar);
        btnSuite = findViewById(R.id.btn_Suite);
        btnDeluxe = findViewById(R.id.btn_Deluxe);
        btnHecho = findViewById(R.id.btn_Hecho);
        E_tarifa = findViewById(R.id.E_tarifa);
        E_nombre = findViewById(R.id.E_nombre);
        E_fecha = findViewById(R.id.E_fecha);
        E_noches = findViewById(R.id.E_noches);
        E_Dato1 = findViewById(R.id.E_Dato1);
        E_Dato2 = findViewById(R.id.E_Dato2);

        btnEstandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = 1;
                E_Dato1.setVisibility(View.VISIBLE);
                E_Dato2.setVisibility(View.INVISIBLE);
                E_Dato1.setHint("Costo del desayuno");
                E_Dato1.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        } );

        btnDeluxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = 2;
                E_Dato1.setVisibility(View.VISIBLE);
                E_Dato2.setVisibility(View.VISIBLE);
                E_Dato1.setHint("Has Lounge");
                E_Dato2.setHint("Servicio gourmet");
                E_Dato1.setInputType(InputType.TYPE_CLASS_TEXT);
                E_Dato2.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        });

        btnSuite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=3;
                E_Dato1.setVisibility(View.VISIBLE);
                E_Dato2.setVisibility(View.VISIBLE);
                E_Dato1.setHint("Numero de salas");
                E_Dato2.setHint("Servicio personalizado");
                E_Dato1.setInputType(InputType.TYPE_CLASS_NUMBER);
                E_Dato2.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
       });

        btnHecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x==1)
                    if (!E_tarifa.getText().toString().trim().isEmpty() && !E_fecha.getText().toString().trim().isEmpty() && !E_noches.getText().toString().trim().isEmpty() && !E_nombre.getText().toString().trim().isEmpty() && !E_Dato1.getText().toString().trim().isEmpty()){
                        MainActivity.c.add_Estandar(E_nombre.getText().toString(), E_fecha.getText().toString(), Integer.parseInt(E_noches.getText().toString()), Double.parseDouble(E_tarifa.getText().toString()), "Estandar", Double.parseDouble(E_Dato1.getText().toString()));
                        Toast.makeText(getApplicationContext(), "Su reserva a sido registrada", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Llene todo los espacios", Toast.LENGTH_SHORT).show();
                    }
                if (x==2)
                    if (!E_tarifa.getText().toString().trim().isEmpty() && !E_fecha.getText().toString().trim().isEmpty() && !E_noches.getText().toString().trim().isEmpty() && !E_nombre.getText().toString().trim().isEmpty() && !E_Dato1.getText().toString().trim().isEmpty() && !E_Dato2.getText().toString().trim().isEmpty()){
                        MainActivity.c.add_Deluxe(E_nombre.getText().toString(), E_fecha.getText().toString(), Integer.parseInt(E_noches.getText().toString()), Double.parseDouble(E_tarifa.getText().toString()), "Deluxe", Boolean.parseBoolean(E_Dato1.getText().toString()), Double.parseDouble(E_Dato2.getText().toString()));
                        Toast.makeText(getApplicationContext(), "Su reserva a sido registrada", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Llene todo los espacios", Toast.LENGTH_SHORT).show();
                    }
                if (x==3)
                    if (!E_tarifa.getText().toString().trim().isEmpty() && !E_fecha.getText().toString().trim().isEmpty() && !E_noches.getText().toString().trim().isEmpty() && !E_nombre.getText().toString().trim().isEmpty() && !E_Dato1.getText().toString().trim().isEmpty() && !E_Dato2.getText().toString().trim().isEmpty()){
                        MainActivity.c.add_Suite(E_nombre.getText().toString(), E_fecha.getText().toString(), Integer.parseInt(E_noches.getText().toString()), Double.parseDouble(E_tarifa.getText().toString()), "Suite", Integer.parseInt(E_Dato1.getText().toString()), Double.parseDouble(E_Dato2.getText().toString()));
                        Toast.makeText(getApplicationContext(), "Su reserva a sido registrada", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Llene todo los espacios", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    void limpiar()
    {
        E_tarifa.setText("");
        E_nombre.setText("");
        E_fecha.setText("");
        E_noches.setText("");
        E_Dato1.setText("");
        E_Dato2.setText("");
    }
}
