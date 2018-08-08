package com.example.android.authentication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    EditText t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button b1=(Button)findViewById(R.id.RegisterButton);
        t1=(EditText)findViewById(R.id.Email);
         t2=(EditText)findViewById(R.id.Password);
         t3=(EditText)findViewById(R.id.ConfirmPassword);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1=t1.getText().toString();
                    String s2=t2.getText().toString();
                    String s3=t3.getText().toString();

                    if(s3.equals(s2))

                    {

                        SQLiteDatabase db = getApplicationContext().openOrCreateDatabase("shoppingdb", MODE_PRIVATE, null);
                        db.execSQL("CREATE TABLE IF NOT Exists user(id Integer Primary Key AUTOINCREMENT NOT NULL,email VARCHAR NOT NULL,password VARCHAR NOT NULL)");
                        db.execSQL("INSERT INTO user(email,password) values('"+s1+"','"+s2+"')");
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);




                    }
                    else
                    {
                        Toast t;
                        t=new Toast(getApplicationContext());
                        t.makeText(getApplicationContext(),"Password are not same",Toast.LENGTH_SHORT).show();


                    }
                } catch (Exception ex) {
                    ex.getStackTrace();
                }
            }
        });


}
    }