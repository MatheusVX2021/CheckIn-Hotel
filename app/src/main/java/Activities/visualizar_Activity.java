package Activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.checkinhotel.R;
import com.example.checkinhotel.Reserva;

public class visualizar_Activity extends AppCompatActivity
{
    private TextView salida;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar_all_names);
        salida.findViewById(R.id.txt_listado);
        salida.setText(mostrarTodo());
    }

    public String mostrarTodo()
    {
        String s = "";
        for (int i = 0; i<MainActivity.c.reservas.size(); i++)
        {
            s += (i+1) + ". " + MainActivity.c.reservas.get(i).nombreHuesped + "\n";
        }
        return s;
    }
}
