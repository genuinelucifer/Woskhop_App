package one.workshop.pkg.app_one_workshop;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class second_activity extends ActionBarActivity {
    EditText etNumber;
    TextView tvResult;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        /**Either this */
        //Intent i = getIntent();
        //String val = i.getStringExtra("NumberOne");
        /**Or this */
        String val = Utilities.getNumOne();

        Toast.makeText(second_activity.this, "You entered : " + val, Toast.LENGTH_SHORT).show();

        etNumber = (EditText) findViewById(R.id.etNumberExp);
        tvResult = (TextView) findViewById(R.id.tvResultExp);
        btnCalc = (Button) findViewById(R.id.btnCalcExp);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /****** Single Thread
                 double num = Double.parseDouble(etNumber.getText().toString());
                 double exp = Utilities.calcExp(num, 100000000);
                 tvResult.setText(Double.toString(exp));
                 ****************************************************/

                /*** Multiple Threads */
                new CalculateExpTask().execute();
            }
        });
    }

    private class CalculateExpTask extends AsyncTask<Void,Void,Double> {
        double numOne;
        @Override
        protected void onPreExecute() {
            numOne = Double.parseDouble(etNumber.getText().toString());
        }
        @Override
        protected Double doInBackground(Void... params) 	{
            Double result = Utilities.calcExp(numOne, 10000);
            return result;
        }
        @Override
        protected void onPostExecute(Double state) {
            tvResult.setText(Double.toString(state));
        }
    }

}
