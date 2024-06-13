package com.example.salariofamilia;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddBeneficiaryActivity extends AppCompatActivity {

    private BeneficiaryDataSource dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beneficiary);

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

        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextCPF = findViewById(R.id.editTextCPF);
        EditText editTextDataNascimento = findViewById(R.id.editTextDataNascimento);
        Button buttonSalvar = findViewById(R.id.buttonSalvar);

        buttonSalvar.setOnClickListener(v -> {
            // Obter os dados do novo beneficiário dos campos de texto
            String nome = editTextNome.getText().toString();
            String cpf = editTextCPF.getText().toString();
            String dataNascimento = editTextDataNascimento.getText().toString();

            // Criar um objeto Beneficiary com os dados do novo beneficiário
            Beneficiary newBeneficiary = new Beneficiary();
            newBeneficiary.setNome(nome);
            newBeneficiary.setCpf(cpf);
            newBeneficiary.setDataNascimento(dataNascimento);

            // Inserir o novo beneficiário no banco de dados
            dbHelper.open(); // Abrir conexão com o banco de dados
            // Inserir o novo beneficiário no banco de dados
            long result = dbHelper.insertBeneficiary(newBeneficiary);
            dbHelper.close(); // Fechar conexão com o banco de dados

            if (result != -1) {
                // Exibir mensagem de confirmação
                Toast.makeText(AddBeneficiaryActivity.this, "Beneficiário salvo com sucesso!", Toast.LENGTH_SHORT).show();

                // Fechar a atividade atual
                finish();
            } else {
                // Exibir mensagem de erro
                Toast.makeText(AddBeneficiaryActivity.this, "Erro ao salvar beneficiário!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
