package com.example.projetordecustos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public TextView caseiro_id, liquido_id, amaciante_id, desinfetante_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void caseiro(View view) {
        Intent intent = new Intent(getApplicationContext(),CaseiroActivity.class);
        startActivity(intent);
    }

    public void desinfetante(View view) {
        Intent intent = new Intent(getApplicationContext(),DesinfetanteActivity.class);
        startActivity(intent);
    }

    public void liquido(View view) {
        Intent intent = new Intent(getApplicationContext(),LiquidoActivity.class);
        startActivity(intent);
    }

    public void amaciante(View view) {
        Intent intent = new Intent(getApplicationContext(),AmacianteActivity.class);
        startActivity(intent);
    }

    public void configuracoes(View view) {
        Intent intent = new Intent(getApplicationContext(),ConfiguracoesActivity.class);
        startActivity(intent);
    }

}