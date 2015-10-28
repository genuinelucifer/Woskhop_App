package one.workshop.pkg.app_one_workshop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    EditText etNumberOne, etNumberTwo;
    TextView tvResult;
    Button btnPlus, btnMinus, btnMultiply, btnDivide;

    Button nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumberOne = (EditText) findViewById(R.id.etNumberOne);
        etNumberTwo = (EditText) findViewById(R.id.etNumberTwo);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);

        nextActivity = (Button) findViewById(R.id.btnNextActivity);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Proceeding to Next Activity", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, second_activity.class);

                /**Either this */
                //i.putExtra("NumberOne" , etNumberOne.getText().toString());
                /**or this */
                Utilities.setNumOne(etNumberOne.getText().toString());

                startActivity(i);

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numOne = Double.parseDouble(etNumberOne.getText().toString());
                double numTwo = Double.parseDouble(etNumberTwo.getText().toString());
                double result = numOne + numTwo;
                tvResult.setText(Double.toString(result));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numOne = Double.parseDouble(etNumberOne.getText().toString());
                double numTwo = Double.parseDouble(etNumberTwo.getText().toString());
                double result = numOne - numTwo;
                tvResult.setText(Double.toString(result));
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numOne = Double.parseDouble(etNumberOne.getText().toString());
                double numTwo = Double.parseDouble(etNumberTwo.getText().toString());
                double result = numOne * numTwo;
                tvResult.setText(Double.toString(result));
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numOne = Double.parseDouble(etNumberOne.getText().toString());
                double numTwo = Double.parseDouble(etNumberTwo.getText().toString());
                double result = numOne / numTwo;
                tvResult.setText(Double.toString(result));
            }
        });



    }
}
