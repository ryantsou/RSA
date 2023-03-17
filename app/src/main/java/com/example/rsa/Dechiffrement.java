package com.example.rsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dechiffrement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dechiffrement);
        EditText hash = findViewById(R.id.messageCodé),
                messageOriginal = findViewById(R.id.messageDéchiffré),
                n_edit = findViewById(R.id.n_dechi),
                inv = findViewById(R.id.inv);
        Button dechiffrer = findViewById(R.id.déchiffrer);
        dechiffrer.setOnClickListener(view -> {

            if (inv.getText().toString().isEmpty())
                Toast.makeText(this,"la première clé privée est vide", Toast.LENGTH_LONG).show();
            else if (n_edit.getText().toString().isEmpty())
                Toast.makeText(this,"la deuxième clé privée est vide", Toast.LENGTH_LONG).show();
            else {
                String message = hash.getText().toString();
                String[] tab = message.split(" ");
                long in = Long.parseLong(inv.getText().toString());
                long n = Long.parseLong(n_edit.getText().toString());

                StringBuilder temp = new StringBuilder();

                for (String s : tab) {
                    temp.append((char) Algebre.exponention_rapide(Long.parseLong(s), in, n));
                }
                messageOriginal.setVisibility(View.VISIBLE);
                if (temp.toString().isEmpty())
                    messageOriginal.append("aucun message à décoder donc aucun message déchiffré");
                else
                    messageOriginal.setText(temp.toString());
            }
        });
    }
}