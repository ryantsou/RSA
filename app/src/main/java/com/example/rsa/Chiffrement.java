package com.example.rsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Chiffrement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chiffrement);
        setContentView(R.layout.activity_chiffrement);
        EditText messageBrute = findViewById(R.id.messageBrute),
                e_edit = findViewById(R.id.e_chif),
                n_edit = findViewById(R.id.n_chif),
                hash = findViewById(R.id.messageChiffré);

        Button chiffrer = findViewById(R.id.chiffrer);
        chiffrer.setOnClickListener(view -> {
            if (e_edit.getText().toString().isEmpty())
                Toast.makeText(this, "la première clé publique est vide", Toast.LENGTH_LONG).show();
            else if (n_edit.getText().toString().isEmpty())
                Toast.makeText(this, "la deuxième clé publique est vide", Toast.LENGTH_LONG).show();
            else {
                long exp = Long.parseLong(e_edit.getText().toString());
                long n = Long.parseLong(n_edit.getText().toString());
                int temp;
                StringBuilder mess = new StringBuilder();
                String message = messageBrute.getText().toString();
                for (int i = 0; i < message.length(); i++) {
                    temp = (char) message.charAt(i);
                    mess.append(Algebre.exponention_rapide((long) temp, exp, n)).append(" ");
                }
                hash.setVisibility(View.VISIBLE);
                if (mess.toString().isEmpty())
                    hash.append("aucun message à coder donc aucun message chiffré");
                else
                    hash.setText(mess.toString());
            }
        });
    }
}
