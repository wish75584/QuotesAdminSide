package com.stubborn.quotesadminside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stubborn.quotesadminside.Adapter.ViewQuoteAdapter;
import com.stubborn.quotesadminside.Modal.QuotesModal;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class QuotesListActivity extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<QuotesModal> quotesModals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);

        listView = findViewById(R.id.list_item);
        databaseReference = FirebaseDatabase.getInstance().getReference("quotes");
        quotesModals = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                quotesModals.clear();
                for (DataSnapshot snap : snapshot.getChildren()) {
                    QuotesModal modal = snap.getValue(QuotesModal.class);
                    quotesModals.add(modal);
                }
                ViewQuoteAdapter adapter = new ViewQuoteAdapter(QuotesListActivity.this, quotesModals);
                listView.setAdapter(adapter);

//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        QuotesModal model = quotesModals.get(position);
//                        Intent intent = new Intent(QuotesListActivity.this, DataActivity.class);
//                        intent.putExtra("idKey", model.getId());
//                        intent.putExtra("nameKey", model.getName());
//                        intent.putExtra("emailKey", model.getEmail());
//                        intent.putExtra("contactKey", model.getContact());
//                        startActivity(intent);
//                    }
//                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
