package com.example.salariofamilia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class BeneficiaryAdapter extends ArrayAdapter<Beneficiary> {

    public BeneficiaryAdapter(Context context, List<Beneficiary> beneficiaries) {
        super(context, 0, beneficiaries);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_beneficiary, parent, false);
        }

        Beneficiary beneficiary = getItem(position);

        TextView textViewID = convertView.findViewById(R.id.textViewID);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewCPF = convertView.findViewById(R.id.textViewCPF);

        textViewID.setText("ID: " + beneficiary.getBeneficiarioID());
        textViewName.setText("Nome: " + beneficiary.getNome());
        textViewCPF.setText("CPF: " + beneficiary.getCpf());

        return convertView;
    }
}
