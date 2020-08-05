package com.stubborn.quotesadminside;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.stubborn.quotesadminside.Adapter.QuotesChildAdapter;
import com.stubborn.quotesadminside.Modal.QuotesModal;

import java.util.ArrayList;
import java.util.List;

public class InspirationActivity extends AppCompatActivity {

    ListView listView;
    Query databaseReference;
    List<QuotesModal> quotesModals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);


        listView = findViewById(R.id.success_list);
        databaseReference = FirebaseDatabase.getInstance().getReference("quotes").orderByChild("c_cat").equalTo("success");
        quotesModals = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                quotesModals.clear();
                for (DataSnapshot snap : snapshot.getChildren()) {
                    QuotesModal modal = snap.getValue(QuotesModal.class);
                    quotesModals.add(modal);
                }
                QuotesChildAdapter adapter = new QuotesChildAdapter(InspirationActivity.this, quotesModals);
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

