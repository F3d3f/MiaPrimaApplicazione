package com.example.miaprimaapplicazione;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Collegamento con elementi grafici
        EditText nome = findViewById(R.id.nome);
        EditText cognome = findViewById(R.id.cognome);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        CalendarView calendario = findViewById(R.id.datanascita);
        Button registrazione = findViewById(R.id.registrazione);

        registrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utente utente = new Utente(nome.getText().toString(), cognome.getText().toString(), email.getText().toString(), password.getText().toString(), calendario.getDate());
                //Uso del log
                Log.d("Registrazione",
                        "Nome: " + nome.getText().toString() + ", Cognome: " + cognome.getText().toString() + ", Data di Nascita: " + calendario.getDate() +
                                ", Email: " + email.getText().toString() + ", Password: " + password.getText().toString());
                Toast.makeText(RegistrationActivity.this, nome.getText().toString() + " registrato", Toast.LENGTH_LONG).show();
            }
        });


    }
}