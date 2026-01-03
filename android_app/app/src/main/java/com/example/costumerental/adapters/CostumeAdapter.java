package com.example.costumerental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.costumerental.DetailActivity;
import com.example.costumerental.R;
import com.example.costumerental.models.Costume;
import java.util.List;

public class CostumeAdapter extends RecyclerView.Adapter<CostumeAdapter.ViewHolder> {

    private List<Costume> costumes;

    public CostumeAdapter(List<Costume> costumes) {
        this.costumes = costumes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_costume, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Costume costume = costumes.get(position);
        holder.titleView.setText(costume.getName());
        holder.priceView.setText(costume.getPrice());

        // Handle click to go to Detail page
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            // In real app, pass ID: intent.putExtra("id", costume.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return costumes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView priceView;

        public ViewHolder(View view) {
            super(view);
            titleView = view.findViewById(R.id.itemTitle);
            priceView = view.findViewById(R.id.itemPrice);
        }
    }
}
