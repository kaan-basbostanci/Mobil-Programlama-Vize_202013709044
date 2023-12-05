package com.example.mobilprogramlamavizeproje;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity{

    private EditText etDecimal;
    private Button btnConvert;
    private TextView tvBinary, tvOctal, tvHexadecimal;
    private EditText etMegaByte;
    private Button btnConvertMB;
    private TextView tvKiloByte, tvByte, tvKibiByte, tvBit;
    private EditText etCelsius;
    private Button btnConvertTemperature;
    private TextView tvFahrenheit, tvKelvin;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_activity1);

        etDecimal = findViewById(R.id.etDecimal);
        btnConvert = findViewById(R.id.btnConvert);
        tvBinary = findViewById(R.id.tvBinary);
        tvOctal = findViewById(R.id.tvOctal);
        tvHexadecimal = findViewById(R.id.tvHexadecimal);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v ){convertDecimal();}
        });

        etCelsius = findViewById(R.id.etCelsius);
        btnConvertTemperature = findViewById(R.id.btnConvertTemperature);
        tvFahrenheit = findViewById(R.id.tvFahrenheit);
        tvKelvin = findViewById(R.id.tvKelvin);

        btnConvertTemperature.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){convertTemperature();}
        });

        etMegaByte = findViewById(R.id.etMegaByte);
        btnConvertMB = findViewById(R.id.btnConvertMB);
        tvKiloByte = findViewById(R.id.tvKiloByte);
        tvByte = findViewById(R.id.tvByte);
        tvKibiByte = findViewById(R.id.tvKibiByte);
        tvBit = findViewById(R.id.tvBit);

        btnConvertMB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ convertMegaByte();}
        });

    }
    private void convertDecimal(){
        String decimalStr = etDecimal.getText().toString();

        if (!decimalStr.isEmpty()){
            int decimal = Integer.parseInt(decimalStr);

            String binary = Integer.toBinaryString(decimal);
            String octal = Integer.toBinaryString(decimal);
            String hexadecimal = Integer.toBinaryString(decimal);

            tvBinary.setText("Binary:" + binary);
            tvOctal.setText("Octal"+octal);
            tvHexadecimal.setText("Hexa:" + hexadecimal);
        }
    }

    private void convertMegaByte(){
        String megabyteStr = etMegaByte.getText().toString();

        if (!megabyteStr.isEmpty()) {
            double megaByte = Double.parseDouble(megabyteStr);

            double kiloByte = megaByte * 1024;
            double byteValue = megaByte * 1024*1024;
            double kibiByte = megaByte*8*1024*1024;
            double bit = megaByte *8*8*1024*1024;

            tvKiloByte.setText("Kilo Byte :" + kiloByte);
            tvByte.setText("Byte :" + byteValue);
            tvKibiByte.setText("Kibi Byte :" + kibiByte);
            tvBit.setText("Bit :" + bit);
        }
    }

    private void convertTemperature(){
        String celsiusStr = etCelsius.getText().toString();

        if (!celsiusStr.isEmpty()) {
            double celsius = Double.parseDouble(celsiusStr);

            double fahrenheit = (celsius *9/5)+32;
            double kelvin = celsius + 273.15;

            tvFahrenheit.setText("Fahrenheit:" + fahrenheit);
            tvKelvin.setText("Kelvin:" + kelvin);
        }
    }
}
