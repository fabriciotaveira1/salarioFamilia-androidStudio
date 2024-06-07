package com.example.salariofamilia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class SeeBeneficiaryActivity extends AppCompatActivity {

    private BeneficiaryDataSource dbHelper;
    private TextView textViewBeneficiaryDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_beneficiary);

        textViewBeneficiaryDetails = findViewById(R.id.textViewBeneficiaryDetails);

        // Inicialize o DBHelper
        dbHelper = new BeneficiaryDataSource(this);

        // Inicialize o EditText para inserir o ID do beneficiário
        EditText editTextBeneficiaryID = findViewById(R.id.editTextBeneficiaryID);

        // Inicialize o botão de Confirmar
        Button buttonConfirmar = findViewById(R.id.buttonConfirmar);

        // Defina o OnClickListener para o botão de Confirmar
        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenha o ID do beneficiário inserido
                int beneficiaryId = Integer.parseInt(editTextBeneficiaryID.getText().toString());

                // Obtenha os dados do beneficiário com o ID inserido
                Beneficiary beneficiary = dbHelper.getBeneficiaryById(beneficiaryId);

                // Se o beneficiário existir, exiba os detalhes
                if (beneficiary != null) {
                    showBeneficiaryDetails(beneficiary);
                } else {
                    // Caso contrário, exiba uma mensagem de erro
                    Toast.makeText(SeeBeneficiaryActivity.this, "Beneficiário não encontrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
    }

    // Método para exibir os detalhes do beneficiário no TextView
    private void showBeneficiaryDetails(Beneficiary beneficiary) {
        StringBuilder detailsBuilder = new StringBuilder();
        detailsBuilder.append("ID: ").append(beneficiary.getBeneficiarioID()).append("\n");
        detailsBuilder.append("Nome: ").append(beneficiary.getNome()).append("\n");
        detailsBuilder.append("CPF: ").append(beneficiary.getCpf()).append("\n");
        detailsBuilder.append("Data de Nascimento: ").append(beneficiary.getDataNascimento()).append("\n");
        detailsBuilder.append("Endereço: ").append(beneficiary.getEndereco()).append("\n");
        detailsBuilder.append("Telefone: ").append(beneficiary.getTelefone()).append("\n");
        detailsBuilder.append("E-mail: ").append(beneficiary.getEmail()).append("\n\n");

        // Exiba os detalhes dos beneficiários no TextView
        textViewBeneficiaryDetails.setText(detailsBuilder.toString());
    }
}
