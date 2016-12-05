package app.com.bugdroidbuilder.paulo.icms_st.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import app.com.bugdroidbuilder.paulo.icms_st.R;
import app.com.bugdroidbuilder.paulo.icms_st.model.Valor;

public class MainActivity extends AppCompatActivity {



    Toolbar mainToolbar;
    EditText valorTxt, freteTxt, icmsTxt, ipiTxt, valorAgregadoTxt;
    FloatingActionButton buttonNext;
    Valor valor = new Valor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        buttonNext = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        buttonNext.setOnClickListener(this.nextBtnOnClickListener);

    }


    View.OnClickListener nextBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, CalcActivity.class);

            intent.putExtra("calculo", lerValores());
            startActivity(intent);

        }

    };

    private String lerValores(){
        String valorObtido = "";
        valorTxt = (EditText) findViewById(R.id.valor_edit_text);


        freteTxt = (EditText) findViewById(R.id.frete_edit_text);
        icmsTxt = (EditText) findViewById(R.id.icms_edit_text);
        ipiTxt = (EditText) findViewById(R.id.ipi_edit_text);
        valorAgregadoTxt = (EditText) findViewById(R.id.valor_agregado_edit_text);

        Gson gson = new Gson();
        valorObtido = gson.toJson(valor);
        
        return valorObtido;
    }



}
