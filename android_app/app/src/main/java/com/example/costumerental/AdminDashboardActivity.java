package com.example.costumerental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        findViewById(R.id.btnContextAdd).setOnClickListener(v -> {
            startActivity(new Intent(this, AddCostumeActivity.class));
        });

        findViewById(R.id.btnViewReservations).setOnClickListener(v -> {
            // Placeholder for Reservations List
            Toast.makeText(this, "Opening Reservations...", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnViewClients).setOnClickListener(v -> {
            // Placeholder for Clients List
            Toast.makeText(this, "Opening Client List...", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnViewCostumes).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class)); // Share view with store
        });
    }
}
