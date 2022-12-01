package com.example.laborator5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText myGuess;
    Button btnVerify, btnStart, btnNew;
    TextView status;
    int random, min = 1, max = 20, result;
    boolean castigator = false;

    private final Handler mainHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGuess = findViewById(R.id.myGuess);
        btnVerify = findViewById(R.id.btnVerify);
        btnStart = findViewById(R.id.btnStart);
        btnNew = findViewById(R.id.btnNew);
        status = findViewById(R.id.status);
        random = getRandomNumber(max, min);
        System.out.println("First number is:" + random);


    }

    static int getRandomNumber(int max, int min) {
        return (int) ((Math.random()
                * (max - min)) + min);
    }

    public void makeToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    public void onVerify(View view) {
        result = Integer.parseInt(myGuess.getText().toString());
        if (result < random) {
            makeToast("Think of Higher Number, Try Again");
        } else if (result > random) {
            makeToast("Think of Lower Number, Try Again");
        } else {
            makeToast("Congratulations," + " You Got the Number");
            status.setText("Congratulations! You win!" + " Numeber was " + random);
            castigator = true;
        }
    }


    public void onStartGame(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!castigator) {
                    int randomPC = getRandomNumber(max, min);
                    System.out.println(randomPC);

                    if (randomPC == random) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                status.setText("Thread win!" + " Numeber was " + random);
                            }
                        });
                        castigator = true;
                    } else {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public void onNewGame(View view) {
        castigator = false;
        status.setText("Nobady win yet...");
        random = getRandomNumber(max, min);
        System.out.println("New number is: " + random);
    }
}