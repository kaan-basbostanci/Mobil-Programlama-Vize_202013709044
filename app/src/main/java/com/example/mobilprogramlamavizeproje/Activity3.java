package com.example.mobilprogramlamavizeproje;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity{

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        EditText editTextMessage = findViewById(R.id.editTextMessage);
        Button buttonSendSMS = findViewById(R.id.buttonSendSMS);

        buttonSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v) {
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String message = editTextMessage.getText().toString();

                if (!phoneNumber.isEmpty() && !message.isEmpty()) {
                    sendSMS(phoneNumber, message);
                }else {Toast.makeText(Activity3.this,"Lütfen telefon numarası ve mesajı girin", Toast.LENGTH_SHORT).show();}
            }
        });
    }

     private void sendSMS (String phoneNumber, String message) {
        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("sms"+ phoneNumber));
        intent.putExtra("sms_body", message);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, PendingIntent.FLAG_IMMUTABLE);
        SmsManager smsManager = SmsManager.getDefault();
         smsManager.sendTextMessage(phoneNumber, null, message, pendingIntent, null);

        Toast.makeText(this,"SMS Gönderildi", Toast.LENGTH_SHORT).show();
     }
}
