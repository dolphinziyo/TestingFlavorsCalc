package com.dolphinziyo.android.testingflavorscalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Creado por dolphinziyo el 19/02/2015.
 * http://www.tecnogame.org
 * http://twitter.com/dolphinziyo
 */

public class VentanaCalculadora extends Activity implements View.OnClickListener{
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir;
    EditText etNum1, etNum2;
    TextView tvResultado, tvOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);

        btnSumar = (Button)findViewById(R.id.btn_sumar);
        btnRestar = (Button)findViewById(R.id.btn_restar);

        if(BuildConfig.FLAVOR.equals("pro")){
            btnMultiplicar = (Button)findViewById(R.id.btn_multiplicar);
            btnDividir = (Button)findViewById(R.id.btn_dividir);

            btnMultiplicar.setOnClickListener(this);
            btnDividir.setOnClickListener(this);
        }

        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);

        etNum1 = (EditText)findViewById(R.id.et_num1);
        etNum2 = (EditText)findViewById(R.id.et_num2);
        tvResultado = (TextView)findViewById(R.id.tv_resultado);
        tvOperacion = (TextView)findViewById(R.id.tv_operacion);
    }

    @Override
    public void onClick(View v) {
        double num1, num2;
        if(etNum1 != null && etNum2 != null){
            if(!etNum1.getText().toString().equals("")){
                num1 = Float.parseFloat(etNum1.getText().toString());
            }else{
                num1 = 0;
            }
            if(!etNum2.getText().toString().equals("")){
                num2 = Float.parseFloat(etNum2.getText().toString());
            }else{
                num2 = 0;
            }
        }else{
            num1 = 0;
            num2 = 0;
        }
        Calculadora calc = new Calculadora(num1, num2);
        if(v == btnSumar){
            tvResultado.setText("" + calc.sumar());
            tvOperacion.setText(getResources().getString(R.string.sumar));
        }else if(v == btnRestar){
            tvResultado.setText("" + calc.restar());
            tvOperacion.setText(getResources().getString(R.string.restar));
        }else if(v == btnMultiplicar){
            tvResultado.setText("" + calc.multiplicar());
            tvOperacion.setText(getResources().getString(R.string.multiplicar));
        }else if(v == btnDividir){
            tvResultado.setText("" + calc.dividir());
            tvOperacion.setText(getResources().getString(R.string.dividir));
        }
    }
}
