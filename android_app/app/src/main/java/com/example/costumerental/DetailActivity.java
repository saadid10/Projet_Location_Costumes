package com.example.costumerental;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button rentButton = findViewById(R.id.rentButton);
        rentButton.setOnClickListener(v -> {
            // Show a professional dialog confirming the order
            new AlertDialog.Builder(this)
                    .setTitle("Booking Confirmation")
                    .setMessage(
                            "Your request for 'Grey Luxury Suit' has been successfully processed.\n\nDate: 03/01/2026\nStatus: Pending Approval")
                    .setPositiveButton("OK", (dialog, which) -> {
                        Toast.makeText(this, "Order #1024 Confirmed!", Toast.LENGTH_SHORT).show();
                        finish(); // Go back to list
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        });
    }
}
