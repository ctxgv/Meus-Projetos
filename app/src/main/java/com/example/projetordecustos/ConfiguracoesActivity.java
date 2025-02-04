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

public class ConfiguracoesActivity extends AppCompatActivity {

    EditText oleo_id, soda_id, sabao_po_id, vinagre_id, bicarbonato_id, agua_sanitaria_id,
            acucar_id, agua_id, gas_id, detergente_id, oleo_novo_id, alcool_id, lauril_id,
    essencia_id, corante_id, base_amaciante_id, frete_desinfetante_id, desinfetante_id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_configuracoes);
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
        oleo_novo_id = findViewById(R.id.edt_oleo_novo);
        alcool_id = findViewById(R.id.edt_alcool);
        lauril_id = findViewById(R.id.edt_lauril);
        essencia_id = findViewById(R.id.edt_essencia);
        corante_id = findViewById(R.id.edt_corante);
        base_amaciante_id = findViewById(R.id.edt_base_amaciante);
        frete_desinfetante_id = findViewById(R.id.edt_frete_desinfetante);
        desinfetante_id = findViewById(R.id.edt_desinfetante);


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
        String oleo_novo = oleo_novo_id.getText().toString();
        String lauril = lauril_id.getText().toString();
        String alcool = alcool_id.getText().toString();
        String essencia = essencia_id.getText().toString();
        String corante = corante_id.getText().toString();
        String base_amaciante = base_amaciante_id.getText().toString();
        String frete_desinfetante = frete_desinfetante_id.getText().toString();
        String desinfetante = desinfetante_id.getText().toString();


        SharedPreferences sharedPreferences = getSharedPreferences("Preferencias",MODE_PRIVATE);
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
        editor.putString("oleo_novo" , oleo_novo);
        editor.putString("alcool" , alcool);
        editor.putString("lauril" , lauril);
        editor.putString("essencia" , essencia);
        editor.putString("corante" , corante);
        editor.putString("base_amaciante" , base_amaciante);
        editor.putString("frete_desinfetante" , frete_desinfetante);
        editor.putString("desinfetante" , desinfetante);

        editor.apply();

    }

    public void recuperar(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("Preferencias",MODE_PRIVATE);
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
        String oleo_novo = sharedPreferences.getString("oleo_novo","");
        String alcool = sharedPreferences.getString("alcool","");
        String lauril = sharedPreferences.getString("lauril","");
        String essencia = sharedPreferences.getString("essencia","");
        String corante = sharedPreferences.getString("corante","");
        String base_amaciante = sharedPreferences.getString("base_amaciante","");
        String frete_desinfetante = sharedPreferences.getString("frete_desinfetante","");
        String desinfetante = sharedPreferences.getString("desinfetante","");


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
        oleo_novo_id.setText(oleo_novo);
        alcool_id.setText(alcool);
        lauril_id.setText(lauril);
        essencia_id.setText(essencia);
        corante_id.setText(corante);
        base_amaciante_id.setText(base_amaciante);
        frete_desinfetante_id.setText(frete_desinfetante);
        desinfetante_id.setText(desinfetante);

    }
}