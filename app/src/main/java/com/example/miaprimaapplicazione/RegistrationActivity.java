package com.example.miaprimaapplicazione;

import android.content.Intent;
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

import com.google.gson.Gson;

import java.text.SimpleDateFormat;

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
        Button registrazione = findViewById(R.id.registrazione);
        CalendarView dataNascita = findViewById(R.id.datanascita);

        final String[] dataFormattata = new String[1];

        dataNascita.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Formatta la data
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(year, month, dayOfMonth);
                dataFormattata[0] = sdf.format(cal.getTime());
            }
        });

        registrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utente utente = new Utente(nome.getText().toString(), cognome.getText().toString(), email.getText().toString(), password.getText().toString(), dataFormattata[0]);

                //Converte l'oggetto utente in una stringa JSON
                Gson gson = new Gson();
                String utenteJson = gson.toJson(utente);
                Log.d("utenteJson", utenteJson);

                //Invio dei dati dell'utente alla min activity
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                intent.putExtra("utente", utenteJson);
                startActivity(intent);

                //Uso del log
                Log.d("Registrazione",
                        "Nome: " + nome.getText().toString() + ", Cognome: " + cognome.getText().toString() + ", Data di Nascita: " + dataFormattata[0] +
                                ", Email: " + email.getText().toString() + ", Password: " + password.getText().toString());
                Toast.makeText(RegistrationActivity.this, "Utente: " + nome.getText().toString() + " registrato", Toast.LENGTH_LONG).show();

            }
        });
    }
}