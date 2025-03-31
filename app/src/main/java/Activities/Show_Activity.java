package Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.checkinhotel.Deluxe;
import com.example.checkinhotel.Estandar;
import com.example.checkinhotel.R;
import com.example.checkinhotel.Reserva;
import com.example.checkinhotel.Suite;

public class Show_Activity extends AppCompatActivity
{
    private EditText edt_nombre;
    private TextView result;
    private Button showAll;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_bookings);

        edt_nombre = findViewById(R.id.edt_nombre);
        result = findViewById(R.id.txt_result);
        showAll = findViewById(R.id.btn_showAll);

        edt_nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Reserva reserva = MainActivity.c.buscarReserva(edt_nombre.getText().toString());
                if (reserva!=null)
                {
                    if (reserva instanceof Estandar)
                    {
                        Estandar estandar = (Estandar) reserva;
                        result.setText(result.getText().toString() + "\n\n" + estandar.mostrarDetalles());
                    }
                    if (reserva instanceof Deluxe)
                    {
                        Deluxe deluxe = (Deluxe) reserva;
                        result.setText(result.getText().toString() + "\n\n" + deluxe.mostrarDetalles());
                    }
                    if (reserva instanceof Suite)
                    {
                        Suite suite = (Suite) reserva;
                        result.setText(result.getText().toString() + "\n\n" + suite.mostrarDetalles());
                    }
                    Toast.makeText(getApplicationContext(), "Resultado encontrado", Toast.LENGTH_SHORT).show();
                }
                else{
                    result.setText("Resultados de busqueda:");
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "Resultados de busqueda:\n\n";
                Double IT = 0.0;
                for (int i = 0; i < MainActivity.c.reservas.size(); i++) {
                    s+= MainActivity.c.reservas.get(i).nombreHuesped + "___: ";
                    if (MainActivity.c.reservas.get(i) instanceof Estandar)
                    {
                        Estandar estandar = (Estandar) MainActivity.c.reservas.get(i);
                        s+= estandar.calcularCostoTotal() + "\n";
                        IT += estandar.calcularCostoTotal();
                    }
                    if (MainActivity.c.reservas.get(i) instanceof Deluxe)
                    {
                        Deluxe deluxe = (Deluxe) MainActivity.c.reservas.get(i);
                        s+= deluxe.calcularTotal() + "\n";
                        IT += deluxe.calcularTotal();
                    }
                    if (MainActivity.c.reservas.get(i) instanceof Suite)
                    {
                        Suite suite = (Suite) MainActivity.c.reservas.get(i);
                        s+= suite.calcularTotal() + "\n";
                        IT += suite.calcularTotal();
                    }
                }
                s+="\n\n" + "Ingreso total: " + IT;
                result.setText(s);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        result.setText("Resultados de búsqueda:\n");
    }
}