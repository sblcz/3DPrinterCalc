package com.android.test.a3dprintercalc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tyDJ = 0.0;
        var tyQD = 0.0;
        var tyNum = 0.0;
        buttonGT.setOnClickListener {
            var gtJJ = 0.0;
            var gtCS = 0.0;
            tyDJ = editTextGT1.text.toString().toDouble();
            tyQD = editTextGT2.text.toString().toDouble();
            gtJJ = editTextGT3.text.toString().toDouble();
            gtCS = editTextGT4.text.toString().toDouble();
            tyNum = 360 / tyDJ * tyQD / (gtJJ * gtCS);
            editTextGT5.setText(tyNum.toBigDecimal().setScale(6, BigDecimal.ROUND_HALF_UP).toString());
        }
        buttonSG.setOnClickListener {
            var sgDC = 0.0;
            tyDJ = editTextSG1.text.toString().toDouble();
            tyQD = editTextSG2.text.toString().toDouble();
            sgDC = editTextSG3.text.toString().toDouble();
            tyNum = 360 / tyDJ * tyQD / sgDC;
            editTextSG4.setText(tyNum.toBigDecimal().setScale(6, BigDecimal.ROUND_HALF_UP).toString());
        }
        buttonJC.setOnClickListener {
            var jcZJ = 0.0;
            tyDJ = editTextJC1.text.toString().toDouble();
            tyQD = editTextJC2.text.toString().toDouble();
            jcZJ = editTextJC3.text.toString().toDouble();
            tyNum = 360 / tyDJ * tyQD / (jcZJ * Math.PI.toDouble());
            editTextJC4.setText(tyNum.toBigDecimal().setScale(6, BigDecimal.ROUND_HALF_UP).toString());
        }
        imageView.setOnClickListener {
            startActivity(Intent().setClass(this, activity_img::class.java));
        }
        fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
            if (keyCode == KeyEvent.KEYCODE_BACK) {//当返回按键被按下
                onBackPressed();
            }
            return false;
        }
    }

    var lastBack = 0L;
    override fun onBackPressed() {
        if (lastBack == 0L || System.currentTimeMillis() - lastBack > 2000) {
            Toast.makeText(this, R.string.toastText, Toast.LENGTH_SHORT).show();
            lastBack = System.currentTimeMillis();
            return;
        } else {
            finish();
        }
        super.onBackPressed();
    }


}
