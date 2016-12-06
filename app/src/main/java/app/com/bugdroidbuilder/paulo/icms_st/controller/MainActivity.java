package app.com.bugdroidbuilder.paulo.icms_st.controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import app.com.bugdroidbuilder.paulo.icms_st.R;
import app.com.bugdroidbuilder.paulo.icms_st.model.Valor;

public class MainActivity extends AppCompatActivity {


    private Spinner estados;
    private Toolbar mainToolbar;
    private EditText valorTxt, valorAgregadoTxt, valorIcmsTxt;
    private FloatingActionButton buttonNext;
    private TextView icmsTxt, icmsResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarInterfaces();

        buttonNext.setOnClickListener(this.nextBtnOnClickListener);

    }

    protected void onResume(){
        super.onResume();
        this.buttonNext.show();
    }


    View.OnClickListener nextBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Valor valorObtido = lerCampos();

            if(valorObtido != null){
                icmsTxt.setVisibility(View.VISIBLE);
                icmsResultado.setText(Float.toString(valorObtido.getIcmsSt()));
            }else{
                System.out.println("erro");
            }


        }

    };

    private void iniciarInterfaces(){
        this.mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        this.buttonNext = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        this.valorTxt = (EditText) findViewById(R.id.valor_edit_text);
        this.valorAgregadoTxt = (EditText) findViewById(R.id.valor_agregado_edit_text);
        this.valorIcmsTxt = (EditText) findViewById(R.id.icms_edit_text);
        this.icmsTxt = (TextView) findViewById(R.id.icms_txt);
        this.icmsResultado = (TextView) findViewById(R.id.icms_resultado);

        estados = (Spinner) findViewById(R.id.estados_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.estados_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        estados.setAdapter(adapter);

    }

    private Valor lerCampos(){

        Valor valor = null;

        if(Valor.isCampoPreenchido(valorTxt)
                && Valor.isCampoPreenchido(valorAgregadoTxt)
                && Valor.isCampoPreenchido(valorIcmsTxt)){

            float valorEstado = pegarValorEstado(estados.getSelectedItemPosition());
            float valorProduto = Float.parseFloat(valorTxt.getText().toString());
            float valorAgregado = Float.parseFloat(valorAgregadoTxt.getText().toString());
            float valorIcms = Float.parseFloat(valorIcmsTxt.getText().toString());
            valor = new Valor(valorProduto, valorAgregado,valorIcms, valorEstado);
        }

        return valor;

    }

    private float pegarValorEstado(int posicao){
        float valorEstado = 0;

        switch (posicao){

            case 0 :
                valorEstado = 7;
                break;
            case 1 :
                valorEstado = 7;
                break;
            case 2 :
                valorEstado = 12;
                break;
            case 3 :
                valorEstado = 7;
                break;


        }

        return valorEstado;
    }




}
