package com.TasnimAnas.b27_homies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button MainBtn;
    private EditText Roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.showup);

        MainBtn = findViewById(R.id.showupbtn);
        Roll = findViewById(R.id.Inputt);



        MainBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {

                if(Roll.getText().toString().length() == 0){
                    Roll.setText("0");
                }
                int matm = Integer.parseInt(Roll.getText().toString());
                String value = String.format("%d",matm);
                Intent in = new Intent(MainActivity.this, com.TasnimAnas.b27_homies.ShowUpActivity.class);
                in.putExtra("key",value);
                startActivity(in);


            }
        });
    }
}