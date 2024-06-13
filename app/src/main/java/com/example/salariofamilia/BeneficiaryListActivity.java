package com.example.salariofamilia;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class BeneficiaryListActivity extends AppCompatActivity {

    private BeneficiaryDataSource dbHelper;
    private ListView listView;
    private Button buttonAnterior, buttonProximo, buttonVoltar;
    private List<Beneficiary> beneficiaries;
    private int currentPage = 0;
    private int itemsPerPage = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary_list);

        dbHelper = new BeneficiaryDataSource(this);
        dbHelper.open();
        beneficiaries = dbHelper.getAllBeneficiaries();
        dbHelper.close();

        listView = findViewById(R.id.listViewBeneficiaries);
        buttonAnterior = findViewById(R.id.buttonAnterior);
        buttonProximo = findViewById(R.id.buttonProximo);
        buttonVoltar = findViewById(R.id.buttonVoltar);
        updateListView();

        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPage > 0) {
                    currentPage--;
                    updateListView();
                }
            }
        });

        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((currentPage + 1) * itemsPerPage < beneficiaries.size()) {
                    currentPage++;
                    updateListView();
                }
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateListView() {
        int start = currentPage * itemsPerPage;
        int end = Math.min(start + itemsPerPage, beneficiaries.size());
        List<Beneficiary> subList = new ArrayList<>(beneficiaries.subList(start, end));

        BeneficiaryAdapter adapter = new BeneficiaryAdapter(this, subList);
        listView.setAdapter(adapter);

        buttonAnterior.setEnabled(currentPage > 0);
        buttonProximo.setEnabled(end < beneficiaries.size());
    }
}
