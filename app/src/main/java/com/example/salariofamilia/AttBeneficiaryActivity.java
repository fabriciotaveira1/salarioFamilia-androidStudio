package com.example.salariofamilia;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AttBeneficiaryActivity extends AppCompatActivity {

    private BeneficiaryDataSource dbHelper;
    private EditText editTextBeneficiaryID, editTextNome, editTextCPF, editTextDataNascimento,
            editTextEndereco, editTextTelefone, editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_beneficiary);

        dbHelper = new BeneficiaryDataSource(this);

        editTextBeneficiaryID = findViewById(R.id.editTextBeneficiaryID);
        editTextNome = findViewById(R.id.editTextNome);
        editTextCPF = findViewById(R.id.editTextCPF);
        editTextDataNascimento = findViewById(R.id.editTextDataNascimento);
        editTextEndereco = findViewById(R.id.editTextEndereco);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextEmail = findViewById(R.id.editTextEmail);
        Button buttonAtualizar = findViewById(R.id.buttonAtualizar);

        buttonAtualizar.setOnClickListener(v -> {
            // Obter os novos detalhes do beneficiário
            int beneficiaryID = Integer.parseInt(editTextBeneficiaryID.getText().toString());
            String nome = editTextNome.getText().toString();
            String cpf = editTextCPF.getText().toString();
            String dataNascimento = editTextDataNascimento.getText().toString();
            String endereco = editTextEndereco.getText().toString();
            String telefone = editTextTelefone.getText().toString();
            String email = editTextEmail.getText().toString();

            // Criar um objeto Beneficiary com os novos detalhes
            Beneficiary newBeneficiary = new Beneficiary(beneficiaryID, nome, cpf, dataNascimento, endereco, telefone, email);

            // Atualizar o beneficiário no banco de dados
            dbHelper.updateBeneficiary(newBeneficiary);

            // Exibir mensagem de confirmação
            Toast.makeText(AttBeneficiaryActivity.this, "Beneficiário atualizado com sucesso!", Toast.LENGTH_SHORT).show();

            // Fechar a atividade atual
            finish();
        });
    }
}