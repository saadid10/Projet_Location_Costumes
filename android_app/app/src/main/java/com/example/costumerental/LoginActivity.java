package com.example.costumerental;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.costumerental.models.AuthResponse;
import com.example.costumerental.models.LoginRequest;
import com.example.costumerental.network.ApiService;
import com.example.costumerental.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailStart = findViewById(R.id.emailInput);
        EditText passStart = findViewById(R.id.passwordInput);
        Button btnLogin = findViewById(R.id.loginButton);

        // Add a hidden register link/button for users who need it
        // Since layout was rigid, we simulate the action if login fails

        btnLogin.setOnClickListener(v -> {
            String email = emailStart.getText().toString().trim();
            String password = passStart.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter credentials", Toast.LENGTH_SHORT).show();
                return;
            }

            performLogin(email, password);
        });
    }

    private void performLogin(String email, String password) {
        ApiService service = RetrofitClient.getService();
        LoginRequest request = new LoginRequest(email, password);

        service.login(request).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    AuthResponse auth = response.body();
                    String role = auth.getRole();

                    if ("admin".equals(role)) {
                        startActivity(new Intent(LoginActivity.this, AdminDashboardActivity.class));
                    } else {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    finish();
                } else {
                    // Login Failed (401 or 404)
                    // Requirement: "si le compte nesiste pas afficher la page register"
                    if (response.code() == 401 || response.code() == 404) {
                        Toast.makeText(LoginActivity.this, "Account not found. Redirecting to Register...",
                                Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed: " + response.message(), Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Connection Error. Check Server.", Toast.LENGTH_SHORT).show();
                Log.e("LOGIN", "Error", t);
            }
        });
    }
}
