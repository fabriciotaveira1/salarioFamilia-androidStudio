package com.example.salariofamilia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AttBeneficiaryActivity extends AppCompatActivity {

    private BeneficiaryDataSource dbHelper;
    private EditText editTextBeneficiaryID, editTextNome, editTextCPF, editTextDataNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_beneficiary);

        dbHelper = new BeneficiaryDataSource(this);

        editTextBeneficiaryID = findViewById(R.id.editTextBeneficiaryID);
        editTextNome = findViewById(R.id.editTextNome);
        editTextCPF = findViewById(R.id.editTextCPF);
        editTextDataNascimento = findViewById(R.id.editTextDataNascimento);
        Button buttonAtualizar = findViewById(R.id.buttonAtualizar);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);

        buttonAtualizar.setOnClickListener(v -> {
            // Obter os detalhes do beneficiário a ser atualizado
            int beneficiaryID;
            try {
                beneficiaryID = Integer.parseInt(editTextBeneficiaryID.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(AttBeneficiaryActivity.this, "ID inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHelper.open();
            Beneficiary existingBeneficiary = dbHelper.getBeneficiaryById(beneficiaryID);
            dbHelper.close();

            if (existingBeneficiary == null) {
                Toast.makeText(AttBeneficiaryActivity.this, "Beneficiário não encontrado!", Toast.LENGTH_SHORT).show();
            } else {
                String nome = editTextNome.getText().toString();
                String cpf = editTextCPF.getText().toString();
                String dataNascimento = editTextDataNascimento.getText().toString();

                // Criar um objeto Beneficiary com os novos detalhes
                Beneficiary newBeneficiary = new Beneficiary();
                newBeneficiary.setBeneficiarioID(beneficiaryID);
                newBeneficiary.setNome(nome);
                newBeneficiary.setCpf(cpf);
                newBeneficiary.setDataNascimento(dataNascimento);

                dbHelper.open();
                dbHelper.updateBeneficiary(newBeneficiary);
                dbHelper.close();

                // Exibir mensagem de confirmação
                Toast.makeText(AttBeneficiaryActivity.this, "Beneficiário atualizado com sucesso!", Toast.LENGTH_SHORT).show();

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
