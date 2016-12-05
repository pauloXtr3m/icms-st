package app.com.bugdroidbuilder.paulo.icms_st.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import app.com.bugdroidbuilder.paulo.icms_st.R;
import app.com.bugdroidbuilder.paulo.icms_st.model.Valor;

public class MainActivity extends AppCompatActivity {



    private Toolbar mainToolbar;
    private EditText valorTxt, freteTxt, icmsTxt, ipiTxt, valorAgregadoTxt;
    private FloatingActionButton buttonNext;
    private Valor valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNext = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        buttonNext.setOnClickListener(this.nextBtnOnClickListener);

    }


    View.OnClickListener nextBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            String valorObtido = lerCampos();

            if(!TextUtils.isEmpty(valorObtido)){

                Intent intent = new Intent(MainActivity.this, CalcActivity.class);
                intent.putExtra("calculo", valorObtido);
                startActivity(intent);
            }


        }

    };

    private String lerCampos(){

        String valorObtido = "";
        this.valorTxt = (EditText) findViewById(R.id.valor_edit_text);
        this.freteTxt = (EditText) findViewById(R.id.frete_edit_text);
        this.icmsTxt = (EditText) findViewById(R.id.icms_edit_text);
        this.ipiTxt = (EditText) findViewById(R.id.ipi_edit_text);
        this.valorAgregadoTxt = (EditText) findViewById(R.id.valor_agregado_edit_text);

        if(Valor.isCampoPreenchido(valorTxt) &&
                Valor.isCampoPreenchido(valorAgregadoTxt)){


            float valorProduto = Float.parseFloat(valorTxt.getText().toString());
            float valorAgregado = Float.parseFloat(valorAgregadoTxt.getText().toString());
            valor = new Valor(valorProduto, valorAgregado);

            Gson gson = new Gson();
            valorObtido = gson.toJson(valor);

        }

        return valorObtido;

    }




}
