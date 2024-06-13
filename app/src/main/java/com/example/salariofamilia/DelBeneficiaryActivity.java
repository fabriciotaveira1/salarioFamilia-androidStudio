package com.example.salariofamilia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DelBeneficiaryActivity extends AppCompatActivity {

    private BeneficiaryDataSource dbHelper;
    private EditText editTextBeneficiaryID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_beneficiary);

        dbHelper = new BeneficiaryDataSource(this);

        editTextBeneficiaryID = findViewById(R.id.editTextBeneficiaryID);
        Button buttonDeletar = findViewById(R.id.buttonDeletar);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);

        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter o ID do beneficiário a ser deletado
                int beneficiaryId = Integer.parseInt(editTextBeneficiaryID.getText().toString());

                dbHelper.open();
                // Verificar se o beneficiário com o ID fornecido existe
                Beneficiary beneficiary = dbHelper.getBeneficiaryById(beneficiaryId);
                if (beneficiary != null) {
                    // Beneficiário encontrado, pode ser deletado
                    dbHelper.deleteBeneficiary(beneficiaryId);
                    Toast.makeText(DelBeneficiaryActivity.this, "Beneficiário deletado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    // Beneficiário não encontrado, exibir mensagem de erro
                    Toast.makeText(DelBeneficiaryActivity.this, "Beneficiário não encontrado!", Toast.LENGTH_SHORT).show();
                }
                dbHelper.close();

                // Fechar a atividade atual
                finish();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
