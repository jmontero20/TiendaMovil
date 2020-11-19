package com.example.tiendamovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num;
    private TextView resultado;
    private Spinner comboMaterial,comboDije,comboTipo,comboMoneda;
    private String opciones[];
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.txtCantidad);
        resultado = findViewById(R.id.lblResultado);
        comboMaterial = findViewById(R.id.cmbMaterial);
        comboDije = findViewById(R.id.cmbDije);
        comboTipo = findViewById(R.id.cmbTipo);
        comboMoneda = findViewById(R.id.cmbMoneda);
        //traemos operaciones array
        opciones = getResources().getStringArray(R.array.materiales);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opciones);
        comboMaterial.setAdapter(adapter);
        opciones = getResources().getStringArray(R.array.dijes);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opciones);
        comboDije.setAdapter(adapter);
        opciones = getResources().getStringArray(R.array.tipos);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opciones);
        comboTipo.setAdapter(adapter);
        opciones = getResources().getStringArray(R.array.monedas);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opciones);
        comboMoneda.setAdapter(adapter);
    }
}