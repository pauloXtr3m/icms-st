package app.com.bugdroidbuilder.paulo.icms_st.model;

import android.text.TextUtils;
import android.widget.EditText;

/**
 * Created by paulo on 05/12/16.
 */

public class Valor {

    private float valorProduto, valorAgregado, icms, frete;

    public Valor(float valorProduto, float valorAgregado){
        this.valorProduto = valorProduto;
        this.valorAgregado = valorAgregado;
        this.icms = 0;
        this.frete = 0;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public float getValorAgregado() {
        return valorAgregado;
    }

    public void setValorAgregado(float valorAgregado) {
        this.valorAgregado = valorAgregado;
    }

    public float getIcms() {
        return icms;
    }

    public void setIcms(float icms) {
        this.icms = icms;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public static boolean isCampoPreenchido(EditText textField){

        boolean isCampoValido;
        String valorCampo = textField.getText().toString();
        if(TextUtils.isEmpty(valorCampo)){

            textField.setError("Campo obrigatório");
            isCampoValido = false;

        }else{

            isCampoValido = true;

        }
        return isCampoValido;
    }


}
