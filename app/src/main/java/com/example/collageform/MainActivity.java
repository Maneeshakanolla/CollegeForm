package com.example.collageform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    CheckBox checkBox;
    Spinner spinner;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio);
        checkBox = findViewById(R.id.checkbox1);
        spinner = findViewById(R.id.spinner);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        //radio group
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                RadioButton radioButton = findViewById(checkId);
                Toast.makeText(MainActivity.this, "you select", Toast.LENGTH_SHORT).show();
            }
        });

        //check box
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Check box is check", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Check box is unchecked", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //spinner

        String[] course = {"java", "Dart", "python", ".net", "flutter", "React native"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, course);
        spinner.setAdapter(adapter);

        // For Submit Button

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Intent", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

        // button 2

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.carwale.com/?utm_source=google&utm_medium=cpc&utm_campaign=11563520562&utm_term=car%20wala&gad_source=5&gclid=EAIaIQobChMIl7Pg-8-xggMVppVLBR3YdQiOEAAYASAAEgL5H_D_BwE"));
                startActivity(i);
            }
        });




    }
}