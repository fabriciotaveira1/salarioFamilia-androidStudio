package com.example.salariofamilia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button buttonAdicionar = findViewById(R.id.buttonAdicionar);
        Button buttonRemover = findViewById(R.id.buttonRemover);
        Button buttonAtualizar = findViewById(R.id.buttonAtualizar);
        Button buttonConsultar = findViewById(R.id.buttonConsultar);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);

        buttonAdicionar.setOnClickListener(v -> {
            // Iniciar AddBeneficiaryActivity
            Intent intent = new Intent(MenuActivity.this, AddBeneficiaryActivity.class);
            startActivity(intent);
        });

        buttonRemover.setOnClickListener(v -> {
            // Iniciar DelBeneficiaryActivity
            Intent intent = new Intent(MenuActivity.this, DelBeneficiaryActivity.class);
            startActivity(intent);
        });

        buttonAtualizar.setOnClickListener(v -> {
            // Iniciar AttBeneficiaryActivity
            Intent intent = new Intent(MenuActivity.this, AttBeneficiaryActivity.class);
            startActivity(intent);
        });

        buttonConsultar.setOnClickListener(v -> {
            // Iniciar SeeBeneficiaryActivity
            Intent intent = new Intent(MenuActivity.this, BeneficiaryListActivity.class);
            startActivity(intent);
        });

        buttonVoltar.setOnClickListener(v -> {
            // Voltar para MainActivity
            finish();
        });
    }
}
