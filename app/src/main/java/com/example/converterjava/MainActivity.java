package com.example.converterjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner fromSpinner;
    Spinner toSpinner;
    TextView display;
    EditText units;
    Button convertButton;

    String message;
    List<String> fromList = Arrays.asList("Kilometers", "Meters", "Centimeters", "Millimeters", "Liters", "Milliliters", "Kilograms", "Grams", "Milligrams");
    List<String> toList = Arrays.asList("Kilometers", "Meters", "Centimeters", "Millimeters", "Liters", "Milliliters", "Kilograms", "Grams", "Milligrams");

    boolean isDefault = false;
    double enteredValue;

    void converter(String from, String to, double value) {
        double result = 0;

        switch (from) {
            case "Kilometers":
                if (to.equals("Meters")) {

                    System.out.println("here");
                    result = value * 1000;
                } else if (to.equals("Centimeters")) {
                    result = value * 100000;
                } else if (to.equals("Millimeters")) {
                    result = value * 1000000;
                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;

            case "Meters":
                if (to.equals("Kilometers")) {
                    result = value / 1000;
                } else if (to.equals("Centimeters")) {
                    result = value * 100;
                } else if (to.equals("Millimeters")) {
                    result = value * 1000;
                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;

            case "Centimeters":
                if (to.equals("Kilometers")) {
                    result = value / 100000;
                } else if (to.equals("Meters")) {
                    result = value / 100;
                } else if (to.equals("Millimeters")) {
                    result = value * 10;
                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;

            case "Millimeters":
                if (to.equals("Kilometers")) {
                    result = value / 1000000;
                } else if (to.equals("Meters")) {
                    result = value / 1000;
                } else if (to.equals("Centimeters")) {
                    result = value / 10;
                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;

            case "Liters":
                if (to.equals("Milliliters")) {
                    result = value * 1000;
                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;

            case "Milliliters":
                if (to.equals("Liters")) {
                    result = value / 1000;
                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;

            case "Kilograms":
                if (to.equals("Grams")) {
                    result = value * 1000;
                } else if (to.equals("Milligrams")) {
                    result = value * 1000000;
                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;

            case "Grams":
                if (to.equals("Kilograms")) {
                    result = value / 1000;
                } else if (to.equals("Milligrams")) {
                    result = value * 1000;
                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;

            case "Milligrams":
                if (to.equals("Kilograms")) {
                    result = value / 1000000;
                } else if (to.equals("Grams")) {
                    result = value / 1000;

                } else {
                    isDefault = true;
                    message = "Conversion not supported for given units.";
                }
                break;


        }

        if (Boolean.TRUE.equals(isDefault)) {

            display.setText(message);

        } else if (Boolean.FALSE.equals(isDefault)) {

            message = value + " " + from + " = " + result + " " + to;
            display.setText(message);

        }
        System.out.println(isDefault);
        System.out.println(value + " " + from + " = " + result + " " + to);
        isDefault = false;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromSpinner = findViewById(R.id.from);
        toSpinner = findViewById(R.id.to);
        display = findViewById(R.id.message);
        convertButton = findViewById(R.id.convertButton);
        units = findViewById(R.id.numberInput);

        ArrayAdapter fromAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, fromList);
        ArrayAdapter toAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, toList);

        fromSpinner.setAdapter(fromAdapter);
        toSpinner.setAdapter(toAdapter);


        convertButton.setOnClickListener(v -> {

            String selectedFrom = (String) fromSpinner.getSelectedItem();
            String selectedTo = (String) toSpinner.getSelectedItem();
            enteredValue = Double.parseDouble(units.getText().toString());
            converter(selectedFrom, selectedTo, enteredValue);
            units.setText("0");

        });


    }
}