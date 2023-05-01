package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConverterActivity extends AppCompatActivity {
    private Button Converter;
     TextView Result;

     EditText  entree;
    private RadioButton dinarToEuro, euroToDinar, R3, R4;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        Converter=(Button) findViewById(R.id.converter);
        Result=(TextView) findViewById(R.id.result);
        entree=(EditText) findViewById(R.id.val);
        dinarToEuro=(RadioButton) findViewById(R.id.radioButton1);
        euroToDinar=(RadioButton) findViewById(R.id.radioButton2);
        builder = new AlertDialog.Builder(this);

        euroToDinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (euroToDinar.isChecked()) {
                    dinarToEuro.setChecked(false);
                }
            }

            public boolean onLongClick(View v) {
                v.showContextMenu();
                return true;
            }
        });


        euroToDinar.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    view.showContextMenu();
                    return true;
                }

        });
        euroToDinar.setOnCreateContextMenuListener (this) ;


        dinarToEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dinarToEuro.isChecked()) {
                    euroToDinar.setChecked(false);
                }
            }

            public boolean onLongClick(View v) {
                v.showContextMenu();
                return true;
            }
        });

        dinarToEuro.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    view.showContextMenu();
                    return true;
                }
        });
        dinarToEuro.setOnCreateContextMenuListener (this) ;


    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,1,0,"conversion euro -> dinar");
        menu.add(0,2,0,"conversion dinar -> euro");
        menu.add(0,3,0,"conversion C <-> F");
        menu.add(0,4,0,"conversion F <-> C");
        menu.add(0,5,0,"Quitter");
    }

    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                Toast.makeText(this,"0.3", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this,"2.9919", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Intent i = new Intent(ConverterActivity.this,ConverterTemprature.class);
                startActivity(i);
                break;
            case 4:
                Intent j = new Intent(ConverterActivity.this,ConverterTemprature.class);
                startActivity(j);
                break;
            case 5:
                this.finish();
                break;
        }
        return super.onContextItemSelected(item);
    }

//***********************************************
    public void convertir0(View v){
       float resultat=0;
        if(entree.getText().toString().equals("")){
            Toast.makeText(this,"0.3", Toast.LENGTH_LONG).show();
            builder.setTitle("champs Manquant")
                    .setMessage("Vous devez inserer une valeur à convertit!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
                    .show();

        }else {
        float valeurInitiale = Float.valueOf(entree.getText().toString());
            if (euroToDinar.isChecked()){
                resultat = euroToDinar(valeurInitiale);
            } else if (dinarToEuro.isChecked()) {
                resultat = dinarToEuro(valeurInitiale);
            }
            Result.setText(String.valueOf(resultat));
        }

    }

    private float euroToDinar(float valeurEuro){return (float) (valeurEuro*2.95);}

    private float dinarToEuro(float valeurDinar){return (float) (valeurDinar*0.34);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
    return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.Temp:
                Intent i = new Intent(ConverterActivity.this,ConverterTemprature.class);
                startActivity(i);
                break;
            case R.id.Monn:
                Intent j = new Intent(ConverterActivity.this,ConverterActivity.class);
                startActivity(j);
                break;
            case R.id.quit:
                this.finish();
                break;
        }
        return super.onContextItemSelected(item);
    }
}