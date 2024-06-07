package com.example.salariofamilia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DelBeneficiaryActivity extends AppCompatActivity {

    private BeneficiaryDataSource dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_beneficiary);

        dbHelper = new BeneficiaryDataSource(this);

        // Inicialize o botão de Voltar
        Button buttonVoltar = findViewById(R.id.buttonVoltar);

        // Defina o OnClickListener para o botão de Voltar
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volte para a activity anterior
                finish();
            }
        });

        EditText editTextBeneficiaryID = findViewById(R.id.editTextBeneficiaryID);
        Button buttonDeletar = findViewById(R.id.buttonDeletar);

        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter o ID do beneficiário a ser deletado
                int beneficiaryId = Integer.parseInt(editTextBeneficiaryID.getText().toString());

                // Deletar o beneficiário do banco de dados
                dbHelper.deleteBeneficiary(beneficiaryId);

                // Exibir mensagem de confirmação
                Toast.makeText(DelBeneficiaryActivity.this, "Beneficiário deletado com sucesso!", Toast.LENGTH_SHORT).show();

                // Fechar a atividade atual
                finish();
            }
        });
    }
}
