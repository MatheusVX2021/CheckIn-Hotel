package Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_bookings);

        edt_nombre = findViewById(R.id.edt_nombre);
        result = findViewById(R.id.txt_result);

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


    }
}
