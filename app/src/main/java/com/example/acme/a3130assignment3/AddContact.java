package com.example.acme.a3130assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acme.a3130assignment3.model.Contact;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {

    private TextView name;
    private TextView email;

    private TextView number;
    private TextView type;
    private TextView address;
    private TextView province;

    private Button addContact;

    FirebaseFirestore database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        name = findViewById(R.id.txtBusinessName);
        email = findViewById(R.id.txtEmail);
        number = findViewById(R.id.txtBusinessNumber);
        type = findViewById(R.id.txtPrimaryBusiness);
        address = findViewById(R.id.txtAddress);
        province = findViewById(R.id.txtProvince);






        addContact = findViewById(R.id.addNew);

        database = FirebaseFirestore.getInstance();

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contact c = new Contact(name.getText().toString(),email.getText().toString());
                c.setBusiness_address(address.getText().toString());
                //c.setBusiness_number(number.getText().toString());
                c.setBusiness_province(province.getText().toString());
                c.setBusiness_type(type.getText().toString());

                if(number.getText().toString().isEmpty())
                {
                    c.setBusiness_num(0);
                }
                else
                {
                    c.setBusiness_num(Integer.parseInt(number.getText().toString()));
                }




                //Here instead of adding directly we are first getting a reference so we save the ID;
                // this is not necessary but it will make life easier latter when editing/deleting.
                DocumentReference ref = database.collection("contacts").document();
                c.id = ref.getId();
                ref.set(c).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddContact.this, "Added Successfully!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddContact.this, "Invalid Information Entered. Please try again!", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

    }
}
