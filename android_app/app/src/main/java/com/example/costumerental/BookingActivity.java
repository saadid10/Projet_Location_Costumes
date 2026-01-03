package com.example.costumerental;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    private EditText startDate, endDate;
    private TextView totalPrice;
    private int pricePerDay = 80; // Example base price

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        startDate = findViewById(R.id.startDateInput);
        endDate = findViewById(R.id.endDateInput);
        totalPrice = findViewById(R.id.totalPriceText);
        Button confirmBtn = findViewById(R.id.confirmBookingButton);

        TextWatcher dateWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculatePrice();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        startDate.addTextChangedListener(dateWatcher);
        endDate.addTextChangedListener(dateWatcher);

        confirmBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Booking Confirmed! Check your email.", Toast.LENGTH_LONG).show();
            finish();
        });
    }

    private void calculatePrice() {
        // Simple mock calculation logic for demo
        // In real app, parse Dates and get diff
        if (startDate.getText().length() > 0 && endDate.getText().length() > 0) {
            // Mock: assume 2 days diff for simplicity in typing demo
            totalPrice.setText("Total: $" + (pricePerDay * 3));
        }
    }
}
