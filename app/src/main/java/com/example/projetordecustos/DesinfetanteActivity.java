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

public class DesinfetanteActivity extends AppCompatActivity {

    EditText base_desinfetante_id,
             agua_id,
             frete_desinfetante_id;

    TextView txt_resultado_id,
             txt_custo_itens_id;

    Button btn_calcular_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_desinfetante);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        base_desinfetante_id = findViewById(R.id.edt_base_desinfetante);
        agua_id = findViewById(R.id.edt_agua);
        frete_desinfetante_id = findViewById(R.id.edt_frete_desinfetante);

        txt_resultado_id = findViewById(R.id.txt_resultado);
        txt_custo_itens_id = findViewById(R.id.txt_custo_itens);

        btn_calcular_id = findViewById(R.id.btn_calcular);

    }

    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasDesinfetante", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String base_desinfetante = sharedPreferences.getString("base_desinfetante", "");
        String agua = sharedPreferences.getString("agua", "");
        String frete_desinfetante = sharedPreferences.getString("frete_desinfetante", "");


        base_desinfetante_id.setText(base_desinfetante);
        agua_id.setText(agua);
        frete_desinfetante_id.setText(frete_desinfetante);

        btn_calcular_id.performClick();

    }

    public void configuracoesDesinfetante(View view) {
        Intent intent = new Intent(getApplicationContext(), ConfiguracaoDesinfetanteActivity.class);
        startActivity(intent);
    }

    public void calcular(View view) {

        String base_desinfetante = base_desinfetante_id.getText().toString();
        String agua = agua_id.getText().toString();
        String frete_desinfetante = frete_desinfetante_id.getText().toString();


        double base_desinfetante_double = Double.parseDouble(base_desinfetante);
        double agua_double = Double.parseDouble(agua);
        double frete_desinfetante_double = Double.parseDouble(frete_desinfetante);


        double total_double = base_desinfetante_double + agua_double + frete_desinfetante_double;


        DecimalFormat decFormat = new DecimalFormat("#,##0.00");
        String total_formatado = decFormat.format(total_double);
        txt_resultado_id.setText("Custo Total: $" + total_formatado);


        double valor_itens = total_double / 150;
        String valor_intens_formatado = decFormat.format(valor_itens);
        txt_custo_itens_id.setText("Custo Itens: $" + valor_intens_formatado);


    }
}