package com.example.quiz3mon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Fragment quizFragment = new QuizFragment();
    Fragment scoreFragment = new ScoreFragment();
    Fragment adminFragment = new AdminFragment();

    String role; // Lưu role lấy từ SharedPreferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        // Lấy role từ SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        role = prefs.getString("role", "user"); // Mặc định là "user"

        // Nếu không phải admin, ẩn menu Admin
        if (!role.equals("admin")) {
            Menu menu = bottomNavigationView.getMenu();
            MenuItem adminItem = menu.findItem(R.id.nav_admin);
            if (adminItem != null) {
                adminItem.setVisible(false); // Ẩn menu Admin
            }
        }

        // Load mặc định là QuizFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, quizFragment)
                .commit();

        // Navigation điều hướng
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();
            if (id == R.id.nav_quiz) {
                selectedFragment = quizFragment;
            } else if (id == R.id.nav_score) {
                selectedFragment = scoreFragment;
            } else if (id == R.id.nav_admin && role.equals("admin")) {
                selectedFragment = adminFragment;
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });
    }
}
