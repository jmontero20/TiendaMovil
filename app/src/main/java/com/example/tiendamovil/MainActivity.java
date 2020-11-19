package com.example.tiendamovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    private int cambio = 3200;
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

    public void calcularResultado(View v){
        if(validar()) {

            int n = Integer.parseInt(num.getText().toString());
            int res = 0;
            int opMaterial = comboMaterial.getSelectedItemPosition();
            int opDije = comboDije.getSelectedItemPosition();
            int opTipo = comboTipo.getSelectedItemPosition();
            int opMoneda = comboMoneda.getSelectedItemPosition();

            int valor = valorManilla(opMaterial,opDije,opTipo);

            switch (opMoneda){
                case 0:
                    res = n*valor*cambio;
                    break;
                case 1:
                    res = n*valor;
                    break;



            }
            resultado.setText("$"+res);
        }
    }

    public boolean validar(){
        if(num.getText().toString().isEmpty()){
            num.setError(getString(R.string.error_ingrese_valor));
            num.requestFocus();
            return false;
        }
        int n =  Integer.parseInt(num.getText().toString());
        if(n <= 0){
            num.setError(getString(R.string.error_ingrese_valor_mayor));
            num.requestFocus();
            return false;
        }


        return true;
    }

    public void limpiar(View v){
        num.setText("");
        resultado.setText("");
        num.requestFocus();
        comboMoneda.setSelection(0);
        comboTipo.setSelection(0);
        comboDije.setSelection(0);
        comboMaterial.setSelection(0);
    }

    public  int valorManilla(int material, int dije, int tipo){
       if(material == 0 && dije == 0 ){
               if( tipo == 0 || tipo == 1){
                   return 100;
               }

               if( tipo == 2){
                   return 80;
               }

               if(tipo == 3 ){
                   return 70;
               }
       }

        if(material == 0 && dije == 1 ){
            if( tipo == 0 || tipo == 1){
                return 120;
            }

            if( tipo == 2){
                return 100;
            }

            if(tipo == 3 ){
                return 90;
            }
        }

        if(material == 1 && dije == 0 ){
            if( tipo == 0 || tipo == 1){
                return 90;
            }

            if( tipo == 2){
                return 70;
            }

            if(tipo == 3 ){
                return 50;
            }
        }

        if(material == 1 && dije == 1 ){
            if( tipo == 0 || tipo == 1){
                return 110;
            }

            if( tipo == 2){
                return 90;
            }

            if(tipo == 3 ){
                return 80;
            }
        }

        return  0;

    }

}