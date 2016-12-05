package app.com.bugdroidbuilder.paulo.icms_st.Controller;

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

    Spinner estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Toolbar toolbar  = (Toolbar) findViewById(R.id.calc_toolbar);
        toolbar.setNavigationOnClickListener(btnBackClickListener);
        estados = (Spinner) findViewById(R.id.estados_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.estados_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        estados.setAdapter(adapter);

        iniciarInterface();
    }

    View.OnClickListener btnBackClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(CalcActivity.this, MainActivity.class);
            startActivity(intent);

        }
    };

    private void iniciarInterface(){
        TextView txt = (TextView) findViewById(R.id.valor_text_value);


        String valores = getIntent().getStringExtra("calculo");

        Gson gson = new Gson();

        Valor valor = gson.fromJson(valores, Valor.class);

        txt.setText(Float.toString(valor.getValorProduto()));
    }


}
