package com.example.fragapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragapp.R;
import com.example.fragapp.models.Item;

import java.util.ArrayList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {
    private ArrayList<Item> groceryItems;

    public ShoppingAdapter(ArrayList<Item> groceryItems) {
        this.groceryItems = groceryItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate your item layout here and return a new ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to views in ViewHolder
        Item item = groceryItems.get(position);
        holder.textViewName.setText(item.getName());
        holder.textAmount.setText(String.valueOf(item.getAmount()));

        // Set click listener for the "Add" button
        holder.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increase the quantity of the item by 1
                item.setAmount(item.getAmount() + 1);
                // Notify the adapter of the change
                notifyDataSetChanged();
            }
        });

        // Set click listener for the "Remove" button
        holder.buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increase the quantity of the item by 1
                int currAmount = item.getAmount();
                if (currAmount > 0) {
                    item.setAmount(currAmount - 1);
                    // Notify the adapter of the change
                    notifyDataSetChanged();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return groceryItems.size();
    }

    // ViewHolder class definition
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textAmount;
        Button buttonAdd;
        Button buttonRemove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textAmount = itemView.findViewById(R.id.textAmount);
            buttonAdd = itemView.findViewById(R.id.buttonAdd);
            buttonRemove = itemView.findViewById(R.id.buttonRemove);
        }
    }
}

