package com.example.quadraticcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculateBtn = (Button) findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText aValueEditTxt = (EditText) findViewById(R.id.aValueEditTxt);
                EditText bValueEditTxt = (EditText) findViewById(R.id.bValueEditTxt);
                EditText cValueEditTxt = (EditText) findViewById(R.id.cValueEditTxt);
                TextView xintResultTxtView = (TextView) findViewById(R.id.xintsResultTxtView);
                TextView vertextResultTxtView = (TextView) findViewById(R.id.vertexResultTxtView);
                TextView discriminantResultTxtView = (TextView) findViewById(R.id.discriminantResultTxtView);
                TextView invalidTxtView = (TextView) findViewById(R.id.invalidTxtView);

                try{
                    double aValue = Double.parseDouble(aValueEditTxt.getText().toString());
                    double bValue = Double.parseDouble(bValueEditTxt.getText().toString());
                    double cValue = Double.parseDouble(cValueEditTxt.getText().toString());
                    invalidTxtView.setVisibility(View.INVISIBLE);
                    xintResultTxtView.setText(Calculations.xint(aValue, bValue, cValue));
                    vertextResultTxtView.setText(Calculations.vertex(aValue, bValue, cValue));
                    discriminantResultTxtView.setText(Calculations.discriminant(aValue, bValue,cValue));
                } catch (NumberFormatException e){
                    invalidTxtView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
class Calculations {
    public static String xint(double a, double b, double c) {
        NumberFormat decimal = NumberFormat.getNumberInstance();
        decimal.setMinimumFractionDigits(2);
        decimal.setMaximumFractionDigits(2);

        double x_int, x1_int, x2_int;
        String result = "";

        x_int = b * b - 4 * a * c;

        if (x_int == 0) {
            x1_int = (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
            result = decimal.format(x1_int);
        } else if (x_int < 0) {
            result = "None";
        }else{
            x1_int = (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
            x2_int = (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);
            result = decimal.format(x1_int) + ", " + decimal.format(x2_int);
        }

        return result;
    }

    public static String vertex(double a, double b, double c){
        NumberFormat decimal = NumberFormat.getNumberInstance();
        decimal.setMinimumFractionDigits(2);
        decimal.setMaximumFractionDigits(2);

        double x, y;
        String result = "";

        x = -b / (2 * a);
        y = a * (x * x) + b * x + c;
        result = decimal.format(x) + ", " + decimal.format(y);

        return result;
    }

    public static String discriminant(double a, double b, double c){
        NumberFormat decimal = NumberFormat.getNumberInstance();
        decimal.setMinimumFractionDigits(2);
        decimal.setMaximumFractionDigits(2);

        double d;
        String result = "";

        d = b * b - 4 * a * c;
        result = decimal.format(d);

        return result;
    }
}