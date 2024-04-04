package com.example.and103_thanghtph31577_lab5.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.and103_thanghtph31577_lab5.R;
import com.example.and103_thanghtph31577_lab5.adapter.ImageAdapter;
import com.example.and103_thanghtph31577_lab5.databinding.ActivityFruitDetailBinding;
import com.example.and103_thanghtph31577_lab5.model.Fruit;

public class FruitDetailActivity extends AppCompatActivity {
    ActivityFruitDetailBinding binding;
    Fruit fruit;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityFruitDetailBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        setContentView(binding.getRoot());

        showData();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void showData() {
        //get data object intent
        Intent intent = getIntent();
        fruit = (Fruit) intent.getSerializableExtra("fruit");

        binding.tvName.setText("Tên sản phẩm: " + fruit.getName());
        binding.tvPrice.setText("Giá sản phẩm: " + fruit.getPrice());
        binding.tvDescription.setText("Mô tả: " + fruit.getDescription());
        binding.tvQuantity.setText("Số lượng: " + fruit.getQuantity());
        binding.tvStatus.setText("Trạng thái: " + (Integer.parseInt(fruit.getStatus()) == 0 ? "Còn hàng" : "Hết hàng"));

        adapter = new ImageAdapter(this, fruit.getImage());
        binding.rcvImg.setAdapter(adapter);

    }
}