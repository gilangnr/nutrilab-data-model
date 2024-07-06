package com.example.api;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.api.model.FoodRequest;
import com.example.api.model.FoodResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editFood;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFood = findViewById(R.id.edit_food);
        btnSend = findViewById(R.id.btn_send);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = editFood.getText().toString();
                trackFood(foodName);
            }
        });
    }

    private void trackFood(String foodName) {
        FoodRequest foodRequest = new FoodRequest(foodName);
        ApiService apiService = RetrofitClient.getApiService();
        Call<FoodResponse> call = apiService.trackFood(foodRequest);

        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                if (response.isSuccessful()) {
                    FoodResponse.FoodData foodData = response.body().getData();
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("foodName", foodData.getFoodName());
                    intent.putExtra("foodInformation", foodData.getFoodInformation());
                    intent.putExtra("calorie", foodData.getCalorie());
                    intent.putExtra("sugar", foodData.getSugar());
                    intent.putExtra("carbohydrate", foodData.getCarbohydrate());
                    intent.putExtra("fat", foodData.getFat());
                    intent.putExtra("protein", foodData.getProtein());

                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to retrieve food information", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                Log.e("FoodTrackerActivity", "onFailure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}