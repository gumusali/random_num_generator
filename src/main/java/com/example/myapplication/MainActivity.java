package com.example.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buton;
    private TextView txt;
    private EditText from;
    private EditText to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* elements */
        from  = (EditText) findViewById(R.id.from);
        to  = (EditText) findViewById(R.id.to);
        buton = (Button) findViewById(R.id.new_random);
        txt   = (TextView) findViewById(R.id.random_area);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gint_from = from.getText().toString();
                String gint_to = to.getText().toString();

                try {
                    int int_from = Integer.parseInt(gint_from);
                    int int_to   = Integer.parseInt(gint_to);

                    if(int_from >= int_to) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        alertDialogBuilder.setTitle(R.string.warning0);
                        alertDialogBuilder.setPositiveButton("Ok", null);
                        alertDialogBuilder.setMessage(R.string.warning1);
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    } else {
                        Random rnd = new Random();
                        int number = rnd.nextInt((int_to - int_from) + 1) + int_from;

                        txt.setText(""+ number +"");
                    }
                } catch(NumberFormatException ex) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setTitle(R.string.warning0);
                    alertDialogBuilder.setPositiveButton("Ok", null);
                    alertDialogBuilder.setMessage(R.string.warning2);
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }
        });
    }
}
