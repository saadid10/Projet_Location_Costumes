package com.example.costumerental;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.costumerental.adapters.CostumeAdapter;
import com.example.costumerental.models.Costume;
import com.example.costumerental.network.ApiService;
import com.example.costumerental.network.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Use REAL NETWORK CALL
        fetchCostumes();
    }

    private void fetchCostumes() {
        ApiService service = RetrofitClient.getService();
        service.getCostumes().enqueue(new Callback<List<Costume>>() {
            @Override
            public void onResponse(Call<List<Costume>> call, Response<List<Costume>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CostumeAdapter adapter = new CostumeAdapter(response.body());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Server Empty or Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Costume>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connection Error to 10.0.2.2:8000", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
