package com.example.costumerental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.costumerental.models.AuthResponse;
import com.example.costumerental.models.RegisterRequest;
import com.example.costumerental.network.ApiService;
import com.example.costumerental.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Re-using login layout but ideally create a new one with 'Name' field

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passInput = findViewById(R.id.passwordInput);
        Button btn = findViewById(R.id.loginButton);
        btn.setText("Confirm Registration");

        btn.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String pass = passInput.getText().toString();
            // Hardcoding name for simplicity as layout lacks field, user can fix layout
            // later
            String name = "New Client";

            ApiService service = RetrofitClient.getService();
            service.register(new RegisterRequest(name, email, pass)).enqueue(new Callback<AuthResponse>() {
                @Override
                public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Account Created! Please Login.", Toast.LENGTH_LONG)
                                .show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Error Creating Account", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AuthResponse> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
