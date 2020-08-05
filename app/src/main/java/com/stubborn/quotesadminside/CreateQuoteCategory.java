package com.stubborn.quotesadminside;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.stubborn.quotesadminside.Modal.ChildQuotesModal;
import com.stubborn.quotesadminside.Modal.QuotesModal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CreateQuoteCategory extends AppCompatActivity {

    private EditText create_quote_id, create_quotes_quotes, create_quotes_author, create_quote_description, create_quote_tmptxt;
    private Button create_quote_btn;
    ProgressBar progressBar;
    Spinner insert_quotes_cat_id, insert_quotes_cat;
    DatabaseReference databaseReference;
    String[] string = {"success", "inspiration", "Love", "Failure", "Education", "Motivation", "Happiness", "Life"};
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quote_category);

        create_quote_id = findViewById(R.id.create_quotes_id);
        create_quotes_quotes = findViewById(R.id.create_quotes_quotes);
        create_quotes_author = findViewById(R.id.create_quotes_author);
        create_quote_description = findViewById(R.id.create_quote_description);
        create_quote_tmptxt = findViewById(R.id.create_quote_tmptxt);

        create_quote_btn = findViewById(R.id.create_quote_btn);
        progressBar = findViewById(R.id.create_quote_progressBar);

        insert_quotes_cat_id = findViewById(R.id.create_quote_catid);
        insert_quotes_cat = findViewById(R.id.create_quote_cat);

        adapter = new ArrayAdapter<>(CreateQuoteCategory.this, android.R.layout.simple_list_item_1, string);
        insert_quotes_cat.setAdapter(adapter);


        insert_quotes_cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (insert_quotes_cat.getSelectedItem().equals("success")) {
                    create_quote_tmptxt.setText("1");
                }
                if (insert_quotes_cat.getSelectedItem().equals("inspiration")) {
                    create_quote_tmptxt.setText("2");
                }
                if (insert_quotes_cat.getSelectedItem().equals("Love")) {
                    create_quote_tmptxt.setText("3");
                }
                if (insert_quotes_cat.getSelectedItem().equals("Failure")) {
                    create_quote_tmptxt.setText("4");
                }
                if (insert_quotes_cat.getSelectedItem().equals("Education")) {
                    create_quote_tmptxt.setText("5");
                }
                if (insert_quotes_cat.getSelectedItem().equals("Happiness")) {
                    create_quote_tmptxt.setText("6");
                }
                if (insert_quotes_cat.getSelectedItem().equals("Life")) {
                    create_quote_tmptxt.setText("7");
                }
                if (insert_quotes_cat.getSelectedItem().equals("success")) {
                    create_quote_tmptxt.setText("8");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        databaseReference = FirebaseDatabase.getInstance().getReference("quotes");

        create_quote_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                create_quote_btn.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);

                final String Q_ID = create_quote_id.getText().toString().trim();
                String Q_CAT_ID = insert_quotes_cat_id.getSelectedItem().toString();
                String Q_CAT = insert_quotes_cat.getSelectedItem().toString();
                final String Q_QUOTES = create_quotes_quotes.getText().toString().trim();
                final String Q_AUTHOR = create_quotes_author.getText().toString();
                final String Q_DESC = create_quote_description.getText().toString().trim();

                String ID = databaseReference.push().getKey();


                QuotesModal quotesModal = new QuotesModal(ID, Q_ID, Q_CAT_ID, Q_CAT, Q_QUOTES, Q_AUTHOR, Q_DESC);

                databaseReference.child(ID).setValue(quotesModal).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CreateQuoteCategory.this, "Quotes Added", Toast.LENGTH_SHORT).show();

                            create_quote_btn.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);

                            create_quote_id.setText(Q_ID);
                            create_quotes_quotes.setText(Q_QUOTES);
                            create_quotes_author.setText(Q_AUTHOR);
                            create_quote_description.setText(Q_DESC);

                        }
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(CreateQuoteCategory.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                create_quote_btn.setVisibility(View.VISIBLE);
                                progressBar.setVisibility(View.GONE);
                            }
                        });

            }
        });


    }
}

