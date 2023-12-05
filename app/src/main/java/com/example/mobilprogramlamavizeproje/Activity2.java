package com.example.mobilprogramlamavizeproje;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private LinearLayout linearLayout;
    private EditText et_adet, et_min, et_maks;
    private Button buttonUret;

    private static final int MARGIN_BETWEEN_BARS_DP = 16;

    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        linearLayout = findViewById(R.id.linearLayout);
        et_adet = findViewById(R.id.et_adet);
        et_min = findViewById(R.id.et_min);
        et_maks = findViewById(R.id.et_maks);
        Button uretButton = findViewById(R.id.buttonUret);
        uretButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                linearLayout.removeAllViews();
                generateAndDisplayRandomNumbers();
            }
        });

    }

    private void generateAndDisplayRandomNumbers(){

        int adet = getAdet();
        int minUserInput = getMinUserInput();
        int maxUserInput = getMaxUserInput();

        for (int i =0; i<adet;i++) {
            int minRandom, maxRandom;

            do{
                minRandom = generateRandomValueInRange(minUserInput, maxUserInput);
                maxRandom = generateRandomValueInRange(minUserInput, maxUserInput);
            } while (minRandom >=maxRandom);

            int randomValue = generateRandomValueInRange(minRandom, maxRandom);

            int percentage = calcutePercentage(randomValue, minRandom, maxRandom);

            displayProgressBar(minRandom, maxRandom, randomValue, percentage);
        }
    }

    public int convertedAdet;
    public int convertedMin;
    public int convertedMaks;

    private int getAdet(){
        String Adet = et_adet.getText().toString();
        try{
            convertedAdet = Integer.parseInt(Adet);
        } catch (NumberFormatException e) {}
        return convertedAdet;
    }
    private int getMinUserInput(){
        String Min = et_min.getText().toString();
        try{
            convertedMin = Integer.parseInt(Min);
        } catch (NumberFormatException e) {}
        return convertedMin;
    }
    private int getMaxUserInput(){
        String Maks = et_maks.getText().toString();
        try{
            convertedMaks = Integer.parseInt(Maks);
        } catch (NumberFormatException e) {}
        return convertedMaks;
    }

    private int generateRandomValueInRange(int min, int max) {
        return new Random().nextInt(max-min +1)+ min;
    }
    private int calcutePercentage(int value, int min, int max) {
        return (int)((float) (value-min)/(max-min)*100);
    }

    private void displayProgressBar (int min, int max, int value, int percentage){
        ProgressBar progressBar = createProgressBar(percentage);
        TextView textview = createTextView(progressBar, min, max, value);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, dpToPx(MARGIN_BETWEEN_BARS_DP));

        linearLayout.addView(textview, layoutParams);
        linearLayout.addView(progressBar, layoutParams);
    }

    private ProgressBar createProgressBar (int percentage) {
        ProgressBar progressBar = new ProgressBar(this,null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        progressBar.setMax(100);
        progressBar.setProgress(percentage);
        return progressBar;
    }

    private TextView createTextView (ProgressBar progressBar, int min, int max, int value){
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(min + "                           " + value + "= %"+ progressBar.getProgress()+"                         "+max);

        return textView;
    }

    private int dpToPx(int dp){
        return Math.round(dp*getResources().getDisplayMetrics().density);
    }
}
