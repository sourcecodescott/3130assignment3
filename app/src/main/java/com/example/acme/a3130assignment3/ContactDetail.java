package com.example.acme.a3130assignment3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acme.a3130assignment3.model.Contact;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ContactDetail extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView business_number;
    private TextView type;
    private TextView address;
    private TextView province;



    private Button delete;
    private Button update;

    private FirebaseFirestore database;
    private Intent intent;
    private Contact contact;

    private String busID;

    int uuuu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_detail);

        name = findViewById(R.id.txtBusinessName);
        email = findViewById(R.id.txtEmail);
        type = findViewById(R.id.txtPrimaryBusiness);
        address = findViewById(R.id.txtAddress);
        province = findViewById(R.id.txtProvince);

        business_number = findViewById(R.id.txtBusinessNumber);


        delete = findViewById(R.id.deleteButton);
        update = findViewById(R.id.updateButton);

        database = FirebaseFirestore.getInstance();

        intent = getIntent();

        contact = (Contact)intent.getSerializableExtra("contact");
        name.setText(contact.name);
        email.setText(contact.email);




        uuuu = contact.getBusiness_num();


        type.setText(contact.getBusiness_type());
        address.setText(contact.getBusiness_address());
        province.setText(contact.getBusiness_province());

        business_number.setText(Integer.toString(uuuu));

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

        Contact c = new Contact(name.getText().toString(),email.getText().toString());
        c.setBusiness_address(address.getText().toString());
        c.setBusiness_province(province.getText().toString());
        c.setBusiness_type(type.getText().toString());
        c.id = contact.id;

        if(business_number.getText().toString().isEmpty())
        {
            c.setBusiness_num(0);
        }
        else
        {
            c.setBusiness_num(Integer.parseInt(business_number.getText().toString()));
        }

        DocumentReference ref = database.collection("contacts").document(contact.id);

        ref.set(c).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ContactDetail.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ContactDetail.this, "Invalid Information Entered. Please try again!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //TODO: add the logic for deleting an entry
    private void deleteContact()
    {
       DocumentReference ref = database.collection("contacts").document(contact.id);
       ref.delete();
       Toast.makeText(ContactDetail.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
        //finishes the activity
        finish();


    }
}
