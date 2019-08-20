package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    Button btnGuess;
    EditText etNumber;

    public void generateRandomNos(){
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGuess = findViewById(R.id.btnGuess);
        etNumber = findViewById(R.id.etNumber);

        generateRandomNos();


        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etNumber.getText().toString().equals("")) {
                    int guessValue = Integer.parseInt(etNumber.getText().toString());
                    String message;

                    if (guessValue > randomNumber) {
                        message = "Lower !";
                        etNumber.setText("");
                        
                    } else if (guessValue < randomNumber) {
                        message = "Higher !";
                        etNumber.setText("");
                        
                    } else {
                        message = "You got it right. GG ";
                        etNumber.setText("");
                        generateRandomNos();
                    }

                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }});

    }
}
