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

public class ViewQuoteAdapter extends ArrayAdapter<QuotesModal> {

    Activity activity;
    List<QuotesModal> quotesModals;

    public ViewQuoteAdapter(@NonNull Activity activity, List<QuotesModal> quotesModals) {
        super(activity, R.layout.quotes_list_design, quotesModals);
        this.activity = activity;
        this.quotesModals = quotesModals;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.quotes_list_design, null, true);

        TextView D_QID = convertView.findViewById(R.id.des_quoteid);
        TextView D_Q_ID = convertView.findViewById(R.id.desi_quote_id);
        TextView D_CATID = convertView.findViewById(R.id.desi_quote_cat_id);
        TextView D_CAT = convertView.findViewById(R.id.desi_quote_cat);
        TextView D_QUOTE = convertView.findViewById(R.id.desi_quote_quote);
        TextView D_AUTH = convertView.findViewById(R.id.desi_quote_author);
        TextView D_DESC = convertView.findViewById(R.id.desi_quote_desc);

        QuotesModal quotesModal = quotesModals.get(position);

        D_QID.setText(quotesModal.getId());
        D_Q_ID.setText(quotesModal.getC_id());
        D_CATID.setText(quotesModal.getC_cat_id());
        D_CAT.setText(quotesModal.getC_cat());
        D_QUOTE.setText(quotesModal.getC_quotes());
        D_AUTH.setText(quotesModal.getC_author());
        D_DESC.setText(quotesModal.getC_desc());


        return convertView;
    }
}
