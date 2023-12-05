package com.example.mobilprogramlamavizeproje;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private Button btnActivity1, btnActivity2, btnActivity3;

protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnActivity1 = findViewById(R.id.btnActivity1);
    btnActivity2 = findViewById(R.id.btnActivity2);
    btnActivity3 = findViewById(R.id.btnActivity3);

    btnActivity1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                Intent intent = new Intent (MainActivity.this, Activity1.class);
                startActivity(intent);
            } catch (Exception e) {e.printStackTrace();}
        }
    });

    btnActivity2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                Intent intent = new Intent (MainActivity.this, Activity2.class);
                startActivity(intent);
            } catch (Exception e) {e.printStackTrace();}
        }
    });

    btnActivity3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                Intent intent = new Intent (MainActivity.this, Activity3.class);
                startActivity(intent);
            } catch (Exception e) {e.printStackTrace();}
        }
    });





}
}