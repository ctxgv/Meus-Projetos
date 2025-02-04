package com.example.projetordecustos;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfiguracaoAmacianteActivity extends AppCompatActivity {

    EditText essencia_amaciante_id,
            base_amaciante_id,
            corante_amaciante_id,
            agua_id,
            fixador_amaciante_id,
            galao_2l_id,
            galao_5l_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_configuracao_amaciante);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        essencia_amaciante_id = findViewById(R.id.edt_essencia);
        base_amaciante_id = findViewById(R.id.edt_base);
        corante_amaciante_id = findViewById(R.id.edt_corante);
        agua_id = findViewById(R.id.edt_agua);
        fixador_amaciante_id = findViewById(R.id.edt_fixador);
        galao_2l_id = findViewById(R.id.edt_galao_2l);
        galao_5l_id = findViewById(R.id.edt_galao_5l);

    }

    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasAmaciante", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String essencia_amaciante = sharedPreferences.getString("essencia_amaciante", "");
        String base_amaciante = sharedPreferences.getString("base_amaciante", "");
        String corante_amaciante = sharedPreferences.getString("corante_amaciante", "");
        String agua = sharedPreferences.getString("agua", "");
        String fixador_amaciante = sharedPreferences.getString("fixador_amaciante", "");
        String galao_2l = sharedPreferences.getString("galao_2l", "");
        String galao_5l = sharedPreferences.getString("galao_5l", "");

        essencia_amaciante_id.setText(essencia_amaciante);
        base_amaciante_id.setText(base_amaciante);
        corante_amaciante_id.setText(corante_amaciante);
        agua_id.setText(agua);
        fixador_amaciante_id.setText(fixador_amaciante);
        galao_2l_id.setText(galao_2l);
        galao_5l_id.setText(galao_5l);

    }

    @Override
    protected void onPause() {
        super.onPause();

        String essencia_amaciante = essencia_amaciante_id.getText().toString();
        String base_amaciante = base_amaciante_id.getText().toString();
        String corante_amaciante = corante_amaciante_id.getText().toString();
        String agua = agua_id.getText().toString();
        String fixador_amaciante = fixador_amaciante_id.getText().toString();
        String galao_2l = galao_2l_id.getText().toString();
        String galao_5l = galao_5l_id.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences
                ("PreferenciasAmaciante", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("essencia_amaciante", essencia_amaciante);
        editor.putString("base_amaciante", base_amaciante);
        editor.putString("corante_amaciante", corante_amaciante);
        editor.putString("agua", agua);
        editor.putString("fixador_amaciante", fixador_amaciante);
        editor.putString("galao_2l", galao_2l);
        editor.putString("galao_5l", galao_5l);

        editor.apply();

    }

    public void salvar(View view) {

        String essencia_amaciante = essencia_amaciante_id.getText().toString();
        String base_amaciante = base_amaciante_id.getText().toString();
        String corante_amaciante = corante_amaciante_id.getText().toString();
        String agua = agua_id.getText().toString();
        String fixador_amaciante = fixador_amaciante_id.getText().toString();
        String galao_2l = galao_2l_id.getText().toString();
        String galao_5l = galao_5l_id.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences
                ("PreferenciasAmaciante", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("essencia_amaciante", essencia_amaciante);
        editor.putString("base_amaciante", base_amaciante);
        editor.putString("corante_amaciante", corante_amaciante);
        editor.putString("agua", agua);
        editor.putString("fixador_amaciante", fixador_amaciante);
        editor.putString("galao_2l", galao_2l);
        editor.putString("galao_5l", galao_5l);

        editor.apply();

    }

}