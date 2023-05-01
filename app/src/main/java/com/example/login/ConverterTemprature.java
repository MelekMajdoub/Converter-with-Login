package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class ConverterTemprature extends AppCompatActivity {
    private Button Converter;
    private TextView entree, Result;
    private RadioButton FtoC, CtoF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_temprature);

        Converter=(Button) findViewById(R.id.converter);
        Result=(TextView) findViewById(R.id.result);
        entree=(TextView) findViewById(R.id.val);
        FtoC=(RadioButton) findViewById(R.id.CtoF);
        CtoF=(RadioButton) findViewById(R.id.FtoC);

        CtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CtoF.isChecked()) {
                    FtoC.setChecked(false);
                }
            }
        });

        FtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FtoC.isChecked()) {
                    CtoF.setChecked(false);
                }
            }
        });
    }


    public void convertir(View v){
        float valeurInitiale = Float.valueOf(entree.getText().toString());
        float resultat=0;

        if(entree.getText().toString().equals("")){
            AlertDialog alertDialog;
            AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(ConverterTemprature.this);
            alertDialogbuilder.setTitle("champs Manquant");
            alertDialogbuilder.setMessage("Vous devez inserer une valeur à convertit!");
            alertDialogbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog= alertDialogbuilder.create();
            alertDialog.show();

        }else {
            if (CtoF.isChecked()){
                resultat = CtoF(valeurInitiale);
            } else if (FtoC.isChecked()) {
                resultat = FtoC(valeurInitiale);
            }
        }
        Result.setText(String.valueOf(resultat));
    }

    private float CtoF(float C){return (float) ( (9/5)*(C+32) );}

    private float FtoC(float F){return (float) ( (5/9)*(F-32) );}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.Temp:
                Intent i = new Intent(ConverterTemprature.this,ConverterTemprature.class);
                startActivity(i);
                break;
            case R.id.Monn:
                Intent j = new Intent(ConverterTemprature.this,ConverterActivity.class);
                startActivity(j);
                break;
            case R.id.quit:
                this.finish();
                break;
        }
        return super.onContextItemSelected(item);
    }
}