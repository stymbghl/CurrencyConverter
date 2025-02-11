package com.satyam.currencyconverter;

import static com.satyam.currencyconverter.R.id.calBtn;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Reference the Spinner
        Spinner dropDown = findViewById(R.id.currDropDown);
        final String[] selectedCurrency = {""};
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCurrency[0] = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected currency: " + selectedCurrency[0], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });


        Button button = findViewById(calBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText textField = findViewById(R.id.curr1);
                String inrValue = textField.getText().toString().trim();
                String result = "";
                if(selectedCurrency[0].equals("USD")){
                    result = String.valueOf(Float.parseFloat(inrValue) / 80);
                }

                Toast.makeText(getApplicationContext(), "Value in " + selectedCurrency[0] + "= " + result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}