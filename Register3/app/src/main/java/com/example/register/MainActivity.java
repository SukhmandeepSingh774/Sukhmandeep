package com.example.register;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button btn;
    GridView gridView;
    ArrayList<Items> list;
    ListAdapter1 adapter;
    DatabaseHelper dbh;
    SQLiteDatabase db;
    String id, name, email, phone;
    Bitmap bmp;
    byte[] image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        gridView=findViewById(R.id.gridView1);
        dbh = new DatabaseHelper(this);
        db = dbh.getReadableDatabase();
        list = new ArrayList<>();
        adapter = new ListAdapter1(this, R.layout.items, list);
        gridView.setAdapter(adapter);
        List<Items> articles= dbh.getAllItems();
        String log=null;
        String [] articles_array = new String[articles.size()];
        int i=0;
        for (Items cn : articles) {
            articles_array[i] = cn.getName();
            i++;


        }
        String[] colm = {DatabaseContract.Users.COL_ID, DatabaseContract.Users.COL_NAME, DatabaseContract.Users.COL_EMAIL, DatabaseContract.Users.COL_PHONE, DatabaseContract.Users.COL_IMAGE};
        Cursor cursor = db.query(DatabaseContract.Users.TABLE_NAME, colm, null, null
                , null, null, null, null);

        list.clear();
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String email= cursor.getString(2);
            String phone = cursor.getString(3);
            byte[] image = cursor.getBlob(4);

            list.add(new Items(name, email, phone, image));
        }
        adapter.notifyDataSetChanged();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view,
                                    int position, long id) {


                Items articles1 = articles.get(position);
                Cursor c = db.rawQuery("select * from Users", null);

                if (c.moveToFirst())
                {


                    byte[] byteArray;
                    do{
                        byte[] image = articles1.getImage();
                        bmp= BitmapFactory.decodeByteArray(image, 0 , image.length);
                        // dummy.setImageBitmap(bmp);
                        //coverting bitmap to bitarray
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byteArray = stream.toByteArray();
                        name= articles1.getName();
                        email= articles1.getEmail();
                        phone= articles1.getPhone();
                    }while (c.moveToNext());

                    //  Toast.makeText(SalespersonHomePage.this, person + check, Toast.LENGTH_SHORT).show();



                    Intent intent1=new Intent(MainActivity.this, userinfo.class);
                    intent1.putExtra("image",byteArray);
                    intent1.putExtra("name",name);
                    intent1.putExtra("email", email);
                    intent1.putExtra("phone",phone);
                    startActivity(intent1);

                }


            }

        });

       // Toast.makeText(MainActivity.this, "Welcome to app", Toast.LENGTH_SHORT).show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CreateAccount.class);
                startActivity(intent);
            }
        });
    }
}