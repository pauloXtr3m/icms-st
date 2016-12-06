package app.com.bugdroidbuilder.paulo.icms_st.model;

import android.text.TextUtils;
import android.widget.EditText;

/**
 * Created by paulo on 05/12/16.
 */

public class Valor {

    private float valorProduto, valorAgregado, valorEstado;

    private float icmsSt, totalMva, baseIcmsSt;


    public Valor(float valorProduto, float valorAgregado, float valorIcmsDestacado, float valorEstado){
        this.valorProduto = valorProduto;
        this.valorAgregado = valorAgregado;
        this.valorEstado = valorEstado;
        this.totalMva = valorProduto*(valorAgregado/100);
        this.baseIcmsSt = valorProduto + totalMva;
        this.icmsSt = (this.baseIcmsSt*(valorEstado/100)) - valorIcmsDestacado;
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

    public float getIcmsSt() {
        return icmsSt;
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
