package com.example.pizza_point;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    ImageView imageView;

    TextView rate;
    TextView price;
    TextView name;
    TextView description;
    AppCompatButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView = findViewById(R.id.profile);
        rate = findViewById(R.id.rate);
        price = findViewById(R.id.price);
        name = findViewById(R.id.name);
        description = findViewById(R.id.details);
        next = findViewById(R.id.next);
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            imageView.setImageResource(bundle.getInt("img"));
            name.setText(getIntent().getExtras().getString("name"));
            rate.setText(getIntent().getExtras().getString("rate"));
            price.setText(getIntent().getExtras().getString("price"));
            description.setText(getIntent().getExtras().getString("more"));
        }
        next.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity5.class);
            startActivity(intent);
        });

    }
}