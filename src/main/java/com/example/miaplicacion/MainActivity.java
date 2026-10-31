package com.example.miaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText etTitular, etMinutos;
    private Button btnCotizar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    });


        etTitular = findViewById(R.id.etTitular);
        etMinutos = findViewById(R.id.etMinutos);
        btnCotizar = findViewById(R.id.btnCotizar);
        tvResultado = findViewById(R.id.tvResultado);


        btnCotizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etTitular.getText().toString();
                String minutosStr = etMinutos.getText().toString();

                if (!minutosStr.isEmpty() && !nombre.isEmpty()) {
                    int minutos = Integer.parseInt(minutosStr);

                    // Instanciamos la clase PlanMovil
                    PlanMovil miPlan = new PlanMovil(nombre, minutos);
                    double total = miPlan.calcularTotal();

                    // Mostramos el resultado en pantalla
                    tvResultado.setText("Titular: " + miPlan.getTitular() + "\nTotal a pagar: $" + total);
                } else {
                    tvResultado.setText("Por favor llena todos los campos.");
                }
            }
        });
    }
}