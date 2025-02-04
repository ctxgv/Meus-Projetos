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

public class ConfiguracaoDesinfetanteActivity extends AppCompatActivity {

    EditText base_desinfetante_id,
            agua_id,
            frete_desinfetante_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_configuracao_desinfetante);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        base_desinfetante_id = findViewById(R.id.edt_base_desinfetante);
        agua_id = findViewById(R.id.edt_agua);
        frete_desinfetante_id = findViewById(R.id.edt_frete_desinfetante);

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

    }

    protected void onPause() {
        super.onPause();

        String base_desinfetante = base_desinfetante_id.getText().toString();
        String agua = agua_id.getText().toString();
        String frete_desinfetante = frete_desinfetante_id.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasDesinfetante",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("base_desinfetante" , base_desinfetante);
        editor.putString("agua" , agua);
        editor.putString("frete_desinfetante" , frete_desinfetante);
        editor.apply();

    }

    public void salvar(View view) {

        String base_desinfetante = base_desinfetante_id.getText().toString();
        String agua = agua_id.getText().toString();
        String frete_desinfetante = frete_desinfetante_id.getText().toString();


        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasDesinfetante",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString("base_desinfetante" , base_desinfetante);
        editor.putString("agua" , agua);
        editor.putString("frete_desinfetante" , frete_desinfetante);
        editor.apply();



//        SharedPreferences sharedPreferences = getSharedPreferences("PreferenciasDesinfetante", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        String base_desinfetante = sharedPreferences.getString("base_desinfetante", "");
//        String agua = sharedPreferences.getString("agua", "");
//        String frete_desinfetante = sharedPreferences.getString("frete_desinfetante", "");
//
//
//        base_desinfetante_id.setText(base_desinfetante);
//        agua_id.setText(agua);
//        frete_desinfetante_id.setText(frete_desinfetante);

    }

}