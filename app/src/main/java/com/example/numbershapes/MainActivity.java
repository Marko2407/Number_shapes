package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number {
        int number;
        public boolean isSquar(){
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)){
                return true;
            }else {
                return false;
            }
        }
        public boolean IsTrian(){
            int x = 1;
            int trian = 1;


            while (trian < number){
                x++;
                trian = trian + x;
            }
            if ( trian == number){
                return true;
            } else{
                return false;
            }

        }
    }
    public void testNumber(View view){

        Log.i("info", "button pressed");
        EditText editText = (EditText) findViewById(R.id.editTextCheck);
        String message;
        if (editText.getText().toString().isEmpty()){
            message = "please enter a number";
        } else {

        Number num = new Number();
        num.number = Integer.parseInt((editText.getText().toString()));
        message = editText.getText().toString();

        if(num.isSquar() && num.IsTrian()){
            message +=  " is square and triangular";
        } else if (num.isSquar()){
            message += " is square but not triangular";
        } else if (num.IsTrian()){
            message += " is triangular but not square";

        } else {
            message += " is neither triangular or square";
        }

        }
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}