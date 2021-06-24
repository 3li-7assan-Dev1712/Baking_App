package com.example.bakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.Entries.IngredientEntry;

import java.util.ArrayList;
import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientViewHolder> {
    private Context mContext;
    private List<IngredientEntry> ingredientsList;
    public IngredientsAdapter(Context mContext) {
        this.mContext = mContext;
        ingredientsList = new ArrayList<>();
        ingredientsList.add(new IngredientEntry("CUB", "Graham Cracker crumbs", 2, 8));
        ingredientsList.add(new IngredientEntry("TBLSP", "unsalted butter, melted", 5, 8));
        ingredientsList.add(new IngredientEntry("CUB", "Graham Cracker crumbs",  0.5f, 8));
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ingredients_view_holder, parent, false);
        return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        String ingredient = ingredientsList.get(position).getIngredient();
        String measure = ingredientsList.get(position).getMeasure();
        float quantity = ingredientsList.get(position).getQuantity();
        holder.ingredient.setText(ingredient);
        holder.measure.setText(measure);
        holder.quantity.setText(String.valueOf(quantity));
    }

    @Override
    public int getItemCount() {
        if (ingredientsList == null) return 0;
        else return ingredientsList.size();
    }

    static class IngredientViewHolder extends RecyclerView.ViewHolder{
        private TextView ingredient;
        private TextView measure;
        private TextView quantity;
        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredient = itemView.findViewById(R.id.ingredientTextView);
            measure = itemView.findViewById(R.id.measureTextView);
            quantity = itemView.findViewById(R.id.quantityTextView);
        }
    }
}
