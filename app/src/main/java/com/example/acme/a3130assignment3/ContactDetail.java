package com.example.acme.a3130assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acme.a3130assignment3.model.Contact;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ContactDetail extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private Button delete;
    private Button update;

    private FirebaseFirestore database;
    private Intent intent;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_detail);

        name = findViewById(R.id.nameEdit);
        email = findViewById(R.id.emailEdit);
        delete = findViewById(R.id.deleteButton);
        update = findViewById(R.id.updateButton);

        database = FirebaseFirestore.getInstance();

        intent = getIntent();

        contact = (Contact)intent.getSerializableExtra("contact");
        name.setText(contact.name);
        email.setText(contact.email);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });



    }

    //TODO: add the logic for updating an entry
    private void updateContact()
    {

        finish();
    }

    //TODO: add the logic for deleting an entry
    private void deleteContact()
    {

        //finishes the activity
        finish();

    }
}
