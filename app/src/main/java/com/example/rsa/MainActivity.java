package com.example.rsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton help = findViewById(R.id.help);
        Button chiffrement = findViewById(R.id.chiffrement),
                dechiffrement = findViewById(R.id.déchiffrement),
                generation = findViewById(R.id.génération);

        help.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, Help.class)));
        chiffrement.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, Chiffrement.class)));
        dechiffrement.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, Dechiffrement.class)));
        generation.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, Generation.class)));
    }
}