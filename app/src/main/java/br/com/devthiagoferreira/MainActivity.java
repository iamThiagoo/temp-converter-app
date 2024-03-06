package br.com.devthiagoferreira;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtCelsius;
    EditText txtFahrenheit;
    Button btnConverter;
    Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtCelsius = findViewById(R.id.txtCelsius);
        EditText txtFahrenheit = findViewById(R.id.txtFahrenheit);

        Button btnConverter = findViewById(R.id.btnConverter);
        Button btnLimpar = findViewById(R.id.btnLimpar);

        btnConverter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                float celsius = 0;
                float far =  0;

                if (txtCelsius.getText().toString().isEmpty()) {
                    if (!txtFahrenheit.getText().toString().isEmpty()) {
                        far = Float.parseFloat(txtFahrenheit.getText().toString());
                        celsius = (far - 32)/(float)1.8;
                        txtCelsius.setText(String.valueOf(celsius));
                    }
                }

                if (txtFahrenheit.getText().toString().isEmpty()) {
                    if (!txtCelsius.getText().toString().isEmpty()) {
                        celsius = Float.parseFloat(txtCelsius.getText().toString());
                        far = (celsius * (float) 1.8) + 32;
                        txtFahrenheit.setText(String.valueOf(far));
                    }
                }

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                txtCelsius.getText().clear();
                txtFahrenheit.getText().clear();
                txtCelsius.requestFocus();
            }
        });
    }
}