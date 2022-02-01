package css.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextBillAmount;
    EditText editTextNumberInParty;
    TextView tvTotalTipAmount;
    TextView tvTipPerPersonAmount;
    Button buttonCalcTip;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        editTextNumberInParty = findViewById(R.id.editTextNumberInParty);
        tvTotalTipAmount = findViewById(R.id.tvTotalTipAmount);
        tvTipPerPersonAmount = findViewById(R.id.tvTipPerPersonAmount);
        buttonCalcTip =  findViewById(R.id.buttonCalcTip);
        checkBox =  findViewById(R.id.checkBox);

        buttonCalcTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double billAmount;
                Double totalTipAmount;
                Double numberInParty;
                Double tipPerPersonAmount;

                if (checkBox.isChecked())
                {
                    billAmount = Double.parseDouble(editTextBillAmount.getText().toString());
                    totalTipAmount = billAmount * 0.20;
                    tvTotalTipAmount.setText(NumberFormat.getCurrencyInstance().format(totalTipAmount));
                    tvTotalTipAmount.setText(totalTipAmount.toString());

                    numberInParty = Double.parseDouble(editTextNumberInParty.getText().toString());
                    tipPerPersonAmount = totalTipAmount / numberInParty;
                    tvTipPerPersonAmount.setText(NumberFormat.getCurrencyInstance().format(tipPerPersonAmount));
                    tvTipPerPersonAmount.setText(tipPerPersonAmount.toString());
                }
                else {
                    billAmount = Double.parseDouble(editTextBillAmount.getText().toString());
                    totalTipAmount = billAmount * 0.15;
                    tvTotalTipAmount.setText(NumberFormat.getCurrencyInstance().format(totalTipAmount));
                    tvTotalTipAmount.setText(totalTipAmount.toString());

                    numberInParty = Double.parseDouble(editTextNumberInParty.getText().toString());
                    tipPerPersonAmount = totalTipAmount / numberInParty;
                    tvTipPerPersonAmount.setText(NumberFormat.getCurrencyInstance().format(tipPerPersonAmount));
                    tvTipPerPersonAmount.setText(tipPerPersonAmount.toString());
                }
            }
        });
    }
}

