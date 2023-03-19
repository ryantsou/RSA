package com.example.rsa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Generation extends AppCompatActivity {
    int p, q, n, phi, inv, e;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generation);
        TextView e_text = findViewById(R.id.gen_e),
                auto = findViewById(R.id.auto);
        EditText q_edit = findViewById(R.id.q_edit),
                p_edit = findViewById(R.id.p_edit),
                affichage = findViewById(R.id.affichage),
                e_gen = findViewById(R.id.e_gen);
        Button suivant = findViewById(R.id.suivant),
                generer = findViewById(R.id.générer);

        suivant.setOnClickListener(view -> {
            p = Integer.parseInt(p_edit.getText().toString());
            q = Integer.parseInt(q_edit.getText().toString());
            if (p_edit.getText().toString().isEmpty()||!Algebre.isPremier(p))
                Toast.makeText(this,"le premier nombre est vide ou n'est pas premier",Toast.LENGTH_LONG).show();
            else if(q_edit.getText().toString().isEmpty()|| !Algebre.isPremier(q))
                Toast.makeText(this,"le deuxième nombre est vide ou n'est pas premier",Toast.LENGTH_LONG).show();
            else {
                n = p * q; phi = (p - 1) * (q - 1);
                e_text.setVisibility(View.VISIBLE);
                e_text.append(" phi = (p - 1) * (q - 1) = " + phi);
                e_gen.setVisibility(View.VISIBLE);
                auto.setVisibility(View.VISIBLE);
                generer.setVisibility(View.VISIBLE);
                suivant.setVisibility(View.INVISIBLE);
            }
        });
        generer.setOnClickListener(view -> {
            e = Integer.parseInt(e_gen.getText().toString());
            if(e_gen.getText().toString().isEmpty() || !((Algebre.pgcd(e, phi) == 1)))
                Toast.makeText(this,"ce nombre est vide ou n'est pas premier entre eux avec" + phi,Toast.LENGTH_LONG).show();
            else{
                inv = Algebre.inverse(phi, e);
                affichage.setVisibility(View.VISIBLE);
                affichage.setText("\n\nLa clé publique est : (e, n) = (" + e + ", " + n +")" +
                        "\n\nLa clé privée est : (inv, n) = (" + inv + ", " + n + ")");
            }
        });
    }
}

