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

public class CaseiroActivity extends AppCompatActivity {

    EditText oleo_id, soda_id, sabao_po_id, vinagre_id, bicarbonato_id, agua_sanitaria_id,
            acucar_id, agua_id, gas_id, detergente_id;

    TextView txt_resultado_id, txt_custo_forma_id,txt_custo_itens_id;

    Button btn_calcular_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caseiro);
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

        txt_resultado_id = findViewById(R.id.txt_resultado);
        txt_custo_forma_id = findViewById(R.id.txt_custo_forma);
        txt_custo_itens_id = findViewById(R.id.txt_custo_itens);

        btn_calcular_id = findViewById(R.id.btn_calcular);


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

        btn_calcular_id.performClick();
    }

    public void configuracoesCaseiro(View view) {
        Intent intent = new Intent(getApplicationContext(),ConfiguracaoCaseiroActivity.class);
        startActivity(intent);
    }

    public void calcular(View view) {

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

        double oleo_double = Double.parseDouble(oleo);
        double soda_double = Double.parseDouble(soda);
        double sabao_po_double = Double.parseDouble(sabao_po);
        double vinagre_double = Double.parseDouble(vinagre);
        double bicarbonato_double = Double.parseDouble(bicarbonato);
        double agua_sanitaria_double = Double.parseDouble(agua_sanitaria);
        double acucar_double = Double.parseDouble(acucar);
        double agua_double = Double.parseDouble(agua);
        double gas_double = Double.parseDouble(gas);
        double detergente_double = Double.parseDouble(detergente);

        double total = oleo_double + soda_double + sabao_po_double + vinagre_double +
                bicarbonato_double + agua_sanitaria_double + acucar_double + agua_double +
                gas_double + detergente_double;

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