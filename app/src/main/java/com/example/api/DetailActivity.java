package com.example.api;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    private TextView txtFoodName, txtFoodInformation, txtCalorie, txtSugar, txtCarbo, txtFat, txtProtein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtFoodName = findViewById(R.id.txt_food_name);
        txtFoodInformation = findViewById(R.id.txt_food_information);
        txtCalorie = findViewById(R.id.txt_calorie);
        txtSugar = findViewById(R.id.txt_sugar);
        txtCarbo = findViewById(R.id.txt_carbo);
        txtFat = findViewById(R.id.txt_fat);
        txtProtein = findViewById(R.id.txt_protein);
        // Terima data dari Intent
        String foodName = getIntent().getStringExtra("foodName");
        String foodInformation = getIntent().getStringExtra("foodInformation");
        String calorie = getIntent().getStringExtra("calorie");
        String sugar = getIntent().getStringExtra("sugar");
        String carbohydrate = getIntent().getStringExtra("carbohydrate");
        String fat = getIntent().getStringExtra("fat");
        String protein = getIntent().getStringExtra("protein");

        // Tampilkan data pada TextView
        txtFoodName.setText("Nama Makanan: " + foodName);
        txtFoodInformation.setText("Informasi Makanan: " + foodInformation);
        txtCalorie.setText("Kalori: " + calorie);
        txtSugar.setText("Gula: " + sugar);
        txtCarbo.setText("Karbohidrat: " + carbohydrate);
        txtFat.setText("Lemak: " + fat);
        txtProtein.setText("Protein: " + protein);

    }
}