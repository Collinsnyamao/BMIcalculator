package ke.co.comsterhomes.www.bmicalculator;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result,result2;
    EditText height,weight;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.resulttxt);
        result2 = (TextView) findViewById(R.id.resulttxt2);
        height = (EditText) findViewById(R.id.heightinput);
        weight = (EditText) findViewById(R.id.weightinput);

        calculate = (Button) findViewById(R.id.calculatebtn);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String heightvar = height.getText().toString();
                final double heightvar1 = Double.parseDouble(heightvar);

                String weightvar = weight.getText().toString();
                final double weightvar2 = Double.parseDouble(weightvar);
                double resultvalue = weightvar2/(heightvar1*heightvar1);

                final String resultstring = Double.toString(resultvalue);


                result.setText(resultstring);

                String result_verdict;
                if (resultvalue<16){
                    result_verdict = "Severely underweight";
                }
                else if (resultvalue<18.5 ){
                    result_verdict = "Underweight";
                }else if (resultvalue < 25 ){
                    result_verdict = "Normal ";
                }else if (resultvalue < 30 ){
                    result_verdict = "Overweight";
                }else if (resultvalue < 35 ){
                    result_verdict = "Obese class 1: Moderately Obese";
                }else if (resultvalue < 40 ){
                    result_verdict = "Obese class 3: Severely Obese";
                }
                else {
                    result_verdict = "Obese class 3: Very Severely Obese";
                }

                result2.setText(result_verdict);
            }
        });

    }
}
