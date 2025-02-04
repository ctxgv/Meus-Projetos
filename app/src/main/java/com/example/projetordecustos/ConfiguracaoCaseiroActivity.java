package com.example.projetordecustos;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfiguracaoCaseiroActivity extends AppCompatActivity {

    EditText oleo_id, soda_id, sabao_po_id, vinagre_id, bicarbonato_id, agua_sanitaria_id,
            acucar_id, agua_id, gas_id, detergente_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_configuracao_caseiro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        oleo_id = findViewById(R.id.edt_oleo);
        soda_id = findViewById(R.id.edt_soda);
        sabao_po_id = findViewById(R.id.edt_sabao_po);
        vinagre_id = findViewById(R.id.edt_vinagre);
        bicarbonato_id = findViewById(R.id.edt_bicarbonato);
        agua_sanitaria_id = findViewById(R.id.edt_agua_sanitaria);
        acucar_id = findViewById(R.id.edt_acucar);
        agua_id = findViewById(R.id.edt_agua);
        gas_id = findViewById(R.id.edt_gas);
        detergente_id = findViewById(R.id.edt_detergente);


    }

    protected void onResume(){
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasCaseiro",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String oleo = sharedPreferences.getString("oleo","");
        String soda = sharedPreferences.getString("soda","");
        String sabao_po = sharedPreferences.getString("sabao_po","");
        String vinagre = sharedPreferences.getString("vinagre","");
        String bicarbonato = sharedPreferences.getString("bicarbonato","");
        String agua_sanitaria = sharedPreferences.getString("agua_sanitaria","");
        String acucar = sharedPreferences.getString("acucar","");
        String agua = sharedPreferences.getString("agua","");
        String gas = sharedPreferences.getString("gas","");
        String detergente = sharedPreferences.getString("detergente","");

        oleo_id.setText(oleo);
        soda_id.setText(soda);
        sabao_po_id.setText(sabao_po);
        vinagre_id.setText(vinagre);
        bicarbonato_id.setText(bicarbonato);
        agua_sanitaria_id.setText(agua_sanitaria);
        acucar_id.setText(acucar);
        agua_id.setText(agua);
        gas_id.setText(gas);
        detergente_id.setText(detergente);
    }

    protected void onPause() {
        super.onPause();

        String oleo = oleo_id.getText().toString();
        String soda = soda_id.getText().toString();
        String sabao_po = sabao_po_id.getText().toString();
        String vinagre = vinagre_id.getText().toString();
        String bicarbonato = bicarbonato_id.getText().toString();
        String agua_sanitaria = agua_sanitaria_id.getText().toString();
        String acucar = acucar_id.getText().toString();
        String agua = agua_id.getText().toString();
        String gas = gas_id.getText().toString();
        String detergente = detergente_id.getText().toString();


        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasCaseiro",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("oleo" , oleo);
        editor.putString("soda" , soda);
        editor.putString("sabao_po" , sabao_po);
        editor.putString("vinagre" , vinagre);
        editor.putString("bicarbonato" , bicarbonato);
        editor.putString("agua_sanitaria" , agua_sanitaria);
        editor.putString("acucar" , acucar);
        editor.putString("agua" , agua);
        editor.putString("gas" , gas);
        editor.putString("detergente" , detergente);

        editor.apply();


    }


    public void salvar(View view) {

        String oleo = oleo_id.getText().toString();
        String soda = soda_id.getText().toString();
        String sabao_po = sabao_po_id.getText().toString();
        String vinagre = vinagre_id.getText().toString();
        String bicarbonato = bicarbonato_id.getText().toString();
        String agua_sanitaria = agua_sanitaria_id.getText().toString();
        String acucar = acucar_id.getText().toString();
        String agua = agua_id.getText().toString();
        String gas = gas_id.getText().toString();
        String detergente = detergente_id.getText().toString();


        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasCaseiro",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("oleo" , oleo);
        editor.putString("soda" , soda);
        editor.putString("sabao_po" , sabao_po);
        editor.putString("vinagre" , vinagre);
        editor.putString("bicarbonato" , bicarbonato);
        editor.putString("agua_sanitaria" , agua_sanitaria);
        editor.putString("acucar" , acucar);
        editor.putString("agua" , agua);
        editor.putString("gas" , gas);
        editor.putString("detergente" , detergente);

        editor.apply();
    }

}