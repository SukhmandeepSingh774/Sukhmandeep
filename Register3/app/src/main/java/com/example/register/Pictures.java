package com.example.register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class Pictures extends AppCompatActivity {
    ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9;
    ImageView loadpics, dp,dp1,dp2,dp3,dp4,dp5,dp6;
    int reload=0;
    int count=0;
    ImageView finaluri;
    Button verify;
    CheckBox checkBox;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        checkBox=findViewById(R.id.checkbox);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        img5=findViewById(R.id.img5);
        img6=findViewById(R.id.img6);
        img7=findViewById(R.id.img7);
        img8=findViewById(R.id.img8);
        img9=findViewById(R.id.img9);
        dp=findViewById(R.id.dp);
        dp1=findViewById(R.id.dp1);
        dp2=findViewById(R.id.dp2);
        dp3=findViewById(R.id.dp3);
        dp4=findViewById(R.id.dp4);
        dp5=findViewById(R.id.dp5);
        dp6=findViewById(R.id.dp6);
        finaluri=findViewById(R.id.finaluri);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        loadpics=findViewById(R.id.loadpics);
        verify=findViewById(R.id.btn);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.check);
                count=count+1;
               // android:layout_alignTop="@+id/image1"
                img1.setImageDrawable(getResources().getDrawable(R.drawable.layer1));


            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img2.setImageDrawable(getResources().getDrawable(R.drawable.layer2));
                count=count+1;

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img3.setImageDrawable(getResources().getDrawable(R.drawable.layer3));
                count=count+1;

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img4.setImageDrawable(getResources().getDrawable(R.drawable.layer4));
                count=count+1;

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img5.setImageDrawable(getResources().getDrawable(R.drawable.layer5));

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img6.setImageDrawable(getResources().getDrawable(R.drawable.layer6));

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img7.setImageDrawable(getResources().getDrawable(R.drawable.layer7));

            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img8.setImageDrawable(getResources().getDrawable(R.drawable.layer8));

            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img9.setImageDrawable(getResources().getDrawable(R.drawable.layer9));

            }
        });
        loadpics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                Intent intent1=new Intent(Pictures.this,Pictures1.class);
                intent1.putExtra("name", name);
                intent1.putExtra("email", email);
                intent1.putExtra("phone", phone);
                startActivity(intent1);
                Toast.makeText(Pictures.this, "Pictures has been Reloaded", Toast.LENGTH_SHORT).show();

            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==4) {
                    if (checkBox.isChecked())
                    {
                        count=0;
                        Drawable myDrawable = getResources().getDrawable(R.drawable.icon01_01);
                        dp.setImageDrawable(myDrawable);
                        Drawable myDrawable1 = getResources().getDrawable(R.drawable.icon01_02);
                        dp1.setImageDrawable(myDrawable1);
                        Drawable myDrawable2 = getResources().getDrawable(R.drawable.icon01_03);
                        dp2.setImageDrawable(myDrawable2);
                        Drawable myDrawable3 = getResources().getDrawable(R.drawable.icon01_04);
                        dp3.setImageDrawable(myDrawable2);
                        Drawable myDrawable4 = getResources().getDrawable(R.drawable.icon01_05);
                        dp4.setImageDrawable(myDrawable4);
                        Drawable myDrawable5 = getResources().getDrawable(R.drawable.icon01_06);
                        dp5.setImageDrawable(myDrawable5);
                        Drawable myDrawable6 = getResources().getDrawable(R.drawable.icon01_07);
                        dp6.setImageDrawable(myDrawable6);
                        int foo1,foo2,foo3,foo4,foo5,foo6,foo7;
                        try {
                            foo1 = Integer.parseInt(String.valueOf(dp));
                        }
                        catch (NumberFormatException e) {
                            foo1 = 0;
                        }
                        try {
                            foo2 = Integer.parseInt(String.valueOf(dp1));
                        }
                        catch (NumberFormatException e) {
                            foo2 = 1;
                        }
                        try {
                            foo3 = Integer.parseInt(String.valueOf(dp2));
                        }
                        catch (NumberFormatException e) {
                            foo3 = 2;
                        }
                        try {
                            foo4 = Integer.parseInt(String.valueOf(dp3));
                        }
                        catch (NumberFormatException e) {
                            foo4 = 3;
                        }
                        try {
                            foo5 = Integer.parseInt(String.valueOf(dp4));
                        }
                        catch (NumberFormatException e) {
                            foo5 = 3;
                        }
                        try {
                            foo6 = Integer.parseInt(String.valueOf(dp5));
                        }
                        catch (NumberFormatException e) {
                            foo6 = 4;
                        }
                        try {
                            foo7 = Integer.parseInt(String.valueOf(dp6));
                        }
                        catch (NumberFormatException e) {
                            foo7 = 5;
                        }

                        Random r = new Random();
                        int low = 0;
                        int high = 6;
                        int result = r.nextInt(high-low) + low;
                        if(result==0)
                        {

                            finaluri.setImageDrawable(myDrawable);
                        }
                        if(result==1)
                        {
                            finaluri.setImageDrawable(myDrawable1);
                        }
                        if(result==2)
                        {
                            finaluri.setImageDrawable(myDrawable2);
                        }
                        if(result==3)
                        {
                            finaluri.setImageDrawable(myDrawable3);
                        }
                        if(result==4)
                        {
                            finaluri.setImageDrawable(myDrawable4);
                        }
                        if(result==5)
                        {
                            finaluri.setImageDrawable(myDrawable5);
                        }
                        if(result==6)
                        {
                            finaluri.setImageDrawable(myDrawable6);
                        }

                        byte[] finalimage = getBitmapAsByteArray(finaluri);

                        ContentValues values = new ContentValues();
                        values.put(DatabaseContract.Users.COL_NAME, name);
                        values.put(DatabaseContract.Users.COL_PHONE, phone);
                        values.put(DatabaseContract.Users.COL_EMAIL, email);
                        values.put(DatabaseContract.Users.COL_IMAGE, finalimage);
                        long newRowId = db.insert(DatabaseContract.Users.TABLE_NAME, null, values);
                        if (newRowId > 0) {
                            Toast.makeText(Pictures.this, "Data is saved in database", Toast.LENGTH_LONG).show();
                        }
                        db.close();

                        // Toast.makeText(Pictures.this, "uri " + finalimage+ "is saved", Toast.LENGTH_SHORT).show();
                        // Toast.makeText(Pictures.this, "name is" +name, Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder alert = new AlertDialog.Builder(Pictures.this);
                        alert.setTitle("Verified");
                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent intent = new Intent(Pictures.this, MainActivity.class);
                                startActivity(intent);
                            }});
                        alert.show();

                    }

                }

                else
                {
                    // Toast.makeText(Pictures.this, "Not Verified", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder alert = new AlertDialog.Builder(Pictures.this);
                    alert.setTitle("Not Verified");
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Intent intent = new Intent(Pictures.this, Pictures.class);
                            startActivity(intent);
                        }});
                    alert.show();


                }
            }

        });

    }
    public static byte[] getBitmapAsByteArray(ImageView bitmap1) {
        Bitmap bitmap = ((BitmapDrawable) bitmap1.getDrawable()).getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();


    }
}