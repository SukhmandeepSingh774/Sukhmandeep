package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class userinfo extends AppCompatActivity {
TextView name,email,phone;
ImageView image;
    byte[] byteArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        image=findViewById(R.id.image);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        Bundle bn = getIntent().getExtras();
        String name1 = bn.getString("name");
        String email1 = bn.getString("email");
        String phone1 = bn.getString("phone");
        Bundle extras = getIntent().getExtras();
        byteArray = extras.getByteArray("image");

        name.setText(name1);
        email.setText(email1);
        phone.setText(phone1);
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        image.setImageBitmap(bmp);
    }
}