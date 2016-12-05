package app.com.bugdroidbuilder.paulo.icms_st.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import app.com.bugdroidbuilder.paulo.icms_st.R;
import app.com.bugdroidbuilder.paulo.icms_st.model.Valor;

public class CalcActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        iniciarInterfaces();

    }

    View.OnClickListener btnBackClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(CalcActivity.this, MainActivity.class);
            startActivity(intent);

        }
    };

    private void iniciarInterfaces(){
        Toolbar toolbar  = (Toolbar) findViewById(R.id.calc_toolbar);
        toolbar.setNavigationOnClickListener(btnBackClickListener);

        TextView txt = (TextView) findViewById(R.id.valor_text_value);


        String valores = getIntent().getStringExtra("calculo");

        Gson gson = new Gson();

        Valor valor = gson.fromJson(valores, Valor.class);

        txt.setText(Float.toString(valor.getIcmsSt()));
    }


}
