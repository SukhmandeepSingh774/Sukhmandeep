package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {
    Button btn;
    EditText name,email,phone;
    String name1,email1,phone1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1=name.getText().toString();
                email1=email.getText().toString();
                phone1=phone.getText().toString();
                if (name1.equals("") || email1.equals("") || phone1.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(CreateAccount.this,Pictures.class);
                    intent.putExtra("name", name1);
                    intent.putExtra("email", email1);
                    intent.putExtra("phone", phone1);
                    startActivity(intent);
                }


            }
        });
    }
}