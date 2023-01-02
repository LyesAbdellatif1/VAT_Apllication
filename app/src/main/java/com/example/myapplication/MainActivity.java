package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final double VAT =1.15 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void ClickOK(View view) {
        TextView textView = findViewById(R.id.textView7);
        TextView textView1 = findViewById(R.id.textView8);
        TextView textView2 = findViewById(R.id.textView9);

        // refferance to interface1
        EditText editText = findViewById(R.id.editTextNumber);
        //get text and convert to number
        String txtStr = editText.getText().toString();


        // refferance to interface2
        EditText editText1 = findViewById(R.id.editTextNumber2);
        //get text and convert to number
        String txtStr1 = editText1.getText().toString();


        if(txtStr.equals("")){
            Toast.makeText(this,"Enter Unit Price",Toast.LENGTH_LONG).show();
            return;
        }
        if(txtStr1.equals("")){
            Toast.makeText(this,"Enter number of units",Toast.LENGTH_LONG).show();
            return;
        }



        RadioButton radioButton = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);

        if(!radioButton.isChecked() && !radioButton2.isChecked()){

            Toast.makeText(this,"select with or without VAT  !",Toast.LENGTH_LONG).show();
            return;

        }


        double NumberOfUnit= Double.parseDouble(txtStr1);
        double UnitPice= Double.parseDouble(txtStr);


        if(radioButton.isChecked()){
            // miles to km
            double UnitPriceWithVAT = UnitPice*VAT*NumberOfUnit;
            double UnitPriceWithoutVAT = UnitPice*NumberOfUnit;
            // set result text
            textView.setText(String.valueOf(VAT));
            textView1.setText(String.valueOf(UnitPriceWithVAT));
            textView2.setText(String.valueOf(""));



        }
        else{
            //km to miles
            double UnitPriceWithoutVAT = UnitPice*NumberOfUnit;
            // set result text
            editText.setText(String.valueOf(UnitPriceWithoutVAT));

            textView.setText(String.valueOf(VAT));
            textView1.setText(String.valueOf(""));
            textView2.setText(String.valueOf(UnitPriceWithoutVAT));



        }

    }

    public void ClickClear(View view) {
        // refferance to interface
        EditText editText = findViewById(R.id.editTextNumber);
        editText.setText("");
        EditText editText1 = findViewById(R.id.editTextNumber2);
        editText1.setText("");
        TextView textView = findViewById(R.id.textView7);
        textView.setText("");
        TextView textView1 = findViewById(R.id.textView8);
        textView1.setText("");
        TextView textView2 = findViewById(R.id.textView9);
        textView2.setText("");

    }

}