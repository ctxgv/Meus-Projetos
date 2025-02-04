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

public class ConfiguracaoLiquidoActivity extends AppCompatActivity {

    EditText oleo_novo_id, soda_id, alcool_id, lauril_id, bicarbonato_id,
            agua_sanitaria_id, essencia_id, agua_id, corante_id, galao_2l_id,
            galao_5l_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_configuracao_liquido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        oleo_novo_id = findViewById(R.id.edt_oleo_novo);
        soda_id = findViewById(R.id.edt_soda);
        alcool_id = findViewById(R.id.edt_alcool);
        lauril_id = findViewById(R.id.edt_lauril);
        bicarbonato_id = findViewById(R.id.edt_bicarbonato);
        agua_sanitaria_id = findViewById(R.id.edt_agua_sanitaria);
        essencia_id = findViewById(R.id.edt_essencia);
        agua_id = findViewById(R.id.edt_agua);
        corante_id = findViewById(R.id.edt_corante);
        galao_2l_id = findViewById(R.id.edt_galao_2l);
        galao_5l_id = findViewById(R.id.edt_galao_5l);
    }

    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasLiquido", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String oleo_novo = sharedPreferences.getString("oleo_novo", "");
        String soda = sharedPreferences.getString("soda", "");
        String alcool = sharedPreferences.getString("alcool", "");
        String lauril = sharedPreferences.getString("lauril", "");
        String bicarbonato = sharedPreferences.getString("bicarbonato", "");
        String agua_sanitaria = sharedPreferences.getString("agua_sanitaria", "");
        String essencia = sharedPreferences.getString("essencia", "");
        String agua = sharedPreferences.getString("agua", "");
        String corante = sharedPreferences.getString("corante", "");
        String galao_2l = sharedPreferences.getString("galao_2l", "");
        String galao_5l = sharedPreferences.getString("galao_5l", "");


        oleo_novo_id.setText(oleo_novo);
        soda_id.setText(soda);
        alcool_id.setText(alcool);
        lauril_id.setText(lauril);
        bicarbonato_id.setText(bicarbonato);
        agua_sanitaria_id.setText(agua_sanitaria);
        essencia_id.setText(essencia);
        agua_id.setText(agua);
        corante_id.setText(corante);
        galao_2l_id.setText(galao_2l);
        galao_5l_id.setText(galao_5l);

    }

    protected void onPause() {
        super.onPause();

        // SALVA DE FORMA AUTOMATICA OS DADOS INCERIDOS

        String oleo_novo = oleo_novo_id.getText().toString();
        String soda = soda_id.getText().toString();
        String alcool = alcool_id.getText().toString();
        String lauril = lauril_id.getText().toString();
        String bicarbonato = bicarbonato_id.getText().toString();
        String agua_sanitaria = agua_sanitaria_id.getText().toString();
        String essencia = essencia_id.getText().toString();
        String agua = agua_id.getText().toString();
        String corante = corante_id.getText().toString();
        String galao_2l = galao_2l_id.getText().toString();
        String galao_5l = galao_5l_id.getText().toString();


        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasLiquido", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("oleo_novo", oleo_novo);
        editor.putString("soda", soda);
        editor.putString("alcool", alcool);
        editor.putString("lauril", lauril);
        editor.putString("bicarbonato", bicarbonato);
        editor.putString("agua_sanitaria", agua_sanitaria);
        editor.putString("essencia", essencia);
        editor.putString("agua", agua);
        editor.putString("corante", corante);
        editor.putString("galao_2l", galao_2l);
        editor.putString("galao_5l", galao_5l);

        editor.apply();

    }

    public void salvar(View view) {

        // SALVA OS DADOS DE FORMA MANUAL

        String oleo_novo = oleo_novo_id.getText().toString();
        String soda = soda_id.getText().toString();
        String alcool = alcool_id.getText().toString();
        String lauril = lauril_id.getText().toString();
        String bicarbonato = bicarbonato_id.getText().toString();
        String agua_sanitaria = agua_sanitaria_id.getText().toString();
        String essencia = essencia_id.getText().toString();
        String agua = agua_id.getText().toString();
        String corante = corante_id.getText().toString();
        String galao_2l = galao_2l_id.getText().toString();
        String galao_5l = galao_5l_id.getText().toString();


        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasLiquido", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("oleo_novo", oleo_novo);
        editor.putString("soda", soda);
        editor.putString("alcool", alcool);
        editor.putString("lauril", lauril);
        editor.putString("bicarbonato", bicarbonato);
        editor.putString("agua_sanitaria", agua_sanitaria);
        editor.putString("essencia", essencia);
        editor.putString("agua", agua);
        editor.putString("corante", corante);
        editor.putString("galao_2l", galao_2l);
        editor.putString("galao_5l", galao_5l);

        editor.apply();

    }

}