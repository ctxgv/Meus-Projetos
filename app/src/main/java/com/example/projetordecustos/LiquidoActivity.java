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

public class LiquidoActivity extends AppCompatActivity {

    EditText oleo_novo_id, soda_id, alcool_id, lauril_id, bicarbonato_id,
            agua_sanitaria_id, essencia_id, agua_id, corante_id, galao_2l_id,
            galao_5l_id;

    TextView txt_resultado_id, txt_custo_forma_id, txt_custo_itens_id;

    Button btn_calcular_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_liquido);
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

        txt_resultado_id = findViewById(R.id.txt_resultado);
        txt_custo_forma_id = findViewById(R.id.txt_custo_forma);
        txt_custo_itens_id = findViewById(R.id.txt_custo_itens);

        btn_calcular_id = findViewById(R.id.btn_calcular);

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

        btn_calcular_id.performClick();

    }

    public void configuracoesLiquido(View view) {
        Intent intent = new Intent(getApplicationContext(), ConfiguracaoLiquidoActivity.class);
        startActivity(intent);
    }

    public void calcular(View view) {


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


        double oleo_novo_double = Double.parseDouble(oleo_novo);
        double soda_double = Double.parseDouble(soda);
        double alcool_double = Double.parseDouble(alcool);
        double lauril_double = Double.parseDouble(lauril);
        double bicarbonato_double = Double.parseDouble(bicarbonato);
        double agua_sanitaria_double = Double.parseDouble(agua_sanitaria);
        double essencia_double = Double.parseDouble(essencia);
        double agua_double = Double.parseDouble(agua);
        double corante_double = Double.parseDouble(corante);
        double galao_2l_double = Double.parseDouble(galao_2l);
        double galao_5l_double = Double.parseDouble(galao_5l);


        double total = oleo_novo_double + soda_double + alcool_double + lauril_double +
                bicarbonato_double + agua_sanitaria_double + essencia_double + agua_double +
                corante_double + galao_2l_double + galao_5l_double;


        DecimalFormat df = new DecimalFormat("#,##0.00");

        String total_formatado = df.format(total);
        txt_resultado_id.setText("Custo Total: $" + total_formatado);

        double valor_forma = total / 4;
        String valor_forma_formatado = df.format(valor_forma);
        txt_custo_forma_id.setText("Custo Forma: $" + valor_forma_formatado);

        double valor_itens = valor_forma / 15;
        String valor_itens_formatado = df.format(valor_itens);
        txt_custo_itens_id.setText("Custo Itens: $" + valor_itens_formatado);

    }
}