package com.example.projetordecustos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class AmacianteActivity extends AppCompatActivity {

    EditText essencia_amaciante_id,
            base_amaciante_id,
            corante_amaciante_id,
            agua_id,
            fixador_amaciante_id,
            galao_2l_id,
            galao_5l_id;

    TextView txt_resultado_id,
            txt_custo_galao_id,
            txt_custo_litro_id;

    Button btn_calcular_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_amaciante);
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

        txt_resultado_id = findViewById(R.id.txt_resultado);
        txt_custo_galao_id = findViewById(R.id.txt_custo_galao);
        txt_custo_litro_id = findViewById(R.id.txt_custo_litro);

        btn_calcular_id = findViewById(R.id.btn_calcular);

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

        btn_calcular_id.performClick();

    }

    public void configuracoesAmaciante(View view) {
        Intent intent = new Intent(getApplicationContext(), ConfiguracaoAmacianteActivity.class);
        startActivity(intent);
    }

    public void calcular(View view) {

        String essencia_amaciante = essencia_amaciante_id.getText().toString();
        String base_amaciante = base_amaciante_id.getText().toString();
        String corante_amaciante = corante_amaciante_id.getText().toString();
        String agua = agua_id.getText().toString();
        String fixador_amaciante = fixador_amaciante_id.getText().toString();
        String galao_2l = galao_2l_id.getText().toString();
        String galao_5l = galao_5l_id.getText().toString();


        double essencia_amaciante_double = Double.parseDouble(essencia_amaciante);
        double base_amaciante_double = Double.parseDouble(base_amaciante);
        double corante_amaciante_double = Double.parseDouble(corante_amaciante);
        double agua_double = Double.parseDouble(agua);
        double fixador_amaciante_double = Double.parseDouble(fixador_amaciante);
        double galao_2l_double = Double.parseDouble(galao_2l);
        double galao_5l_double = Double.parseDouble(galao_5l);


        double total_double = essencia_amaciante_double +
                base_amaciante_double + corante_amaciante_double+
                agua_double + fixador_amaciante_double+
                galao_2l_double + galao_5l_double;


        DecimalFormat decFormat = new DecimalFormat("#,##0.00");
        String total_formatado = decFormat.format(total_double);
        txt_resultado_id.setText("Custo Total: $" + total_formatado);


        double valor_galao = total_double / 4;
        String valor_galao_formatado = decFormat.format(valor_galao);
        txt_custo_galao_id.setText("Custo Galão: $" + valor_galao_formatado);

        double valor_litro = valor_galao / 5;
        String valor_litro_formatado = decFormat.format(valor_litro);
        txt_custo_litro_id.setText("Custo Litro: $" + valor_litro_formatado);

    }


}