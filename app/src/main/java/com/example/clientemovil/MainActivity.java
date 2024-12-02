package com.example.clientemovil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private TextView txtResq; // Variable para el TextView que muestra la respuesta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el TextView y el botón
        txtResq = findViewById(R.id.txtResq);
        Button sendRequestButton = findViewById(R.id.bttComunicacion);

        // Configurar el botón para realizar la solicitud al hacer clic
        sendRequestButton.setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {
        // URL del servidor para la solicitud
        String url = "http://10.10.13.47:3000/mensaje";

        // Crear la solicitud GET usando Volley
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    // Actualizar la interfaz de usuario con la respuesta del servidor
                    txtResq.setText(response);
                },
                error -> {
                    // Mostrar un mensaje de error en el TextView si la solicitud falla
                    txtResq.setText("Error en la solicitud: " + error.getMessage());
                });

        // Crear una cola de solicitudes y agregar la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
