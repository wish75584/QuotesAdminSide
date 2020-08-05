package com.stubborn.quotesadminside.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.stubborn.quotesadminside.Modal.QuotesModal;
import com.stubborn.quotesadminside.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class QuotesChildAdapter extends ArrayAdapter<QuotesModal> {

    Activity activity;
    List<QuotesModal> quotesModals;

    public QuotesChildAdapter(@NonNull Activity activity, List<QuotesModal> quotesModals) {
        super(activity, R.layout.design_success, quotesModals);
        this.activity = activity;
        this.quotesModals = quotesModals;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.design_success, null, true);
        TextView C_DESC = convertView.findViewById(R.id.desi_succ_desc);
        QuotesModal quotesModal = quotesModals.get(position);

        C_DESC.setText(quotesModal.getC_desc());
        return convertView;
    }

}
