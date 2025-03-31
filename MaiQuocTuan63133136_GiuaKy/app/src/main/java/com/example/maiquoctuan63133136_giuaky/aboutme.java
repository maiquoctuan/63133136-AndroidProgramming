package com.example.maiquoctuan63133136_giuaky;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class aboutme extends AppCompatActivity {
    TextView tvGioiThieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        tvGioiThieu = findViewById(R.id.tvGioiThieu);

    }
}