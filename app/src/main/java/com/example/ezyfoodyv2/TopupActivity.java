package com.example.ezyfoodyv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

    }

    public void toTopupBalance(View view) {
        EditText balance = (EditText) findViewById(R.id.topup_id);
        String balanceValue = balance.getText().toString();
        String finalValue = "Balance: Rp." + balanceValue;
        displayMessage(finalValue);
    }

    private void displayMessage(String finalValue) {
        TextView Balance = (TextView) findViewById(R.id.balance_id);
        Balance.setText(finalValue);
    }
}
