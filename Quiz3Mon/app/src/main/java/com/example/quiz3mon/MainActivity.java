package com.example.quiz3mon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Fragment quizFragment = new QuizFragment();
    Fragment scoreFragment = new ScoreFragment();
    Fragment adminFragment = new AdminFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Lấy role từ SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String role = prefs.getString("role", "");

        // Ẩn menu admin nếu không phải admin
        Menu menu = bottomNavigationView.getMenu();
        if (!"admin".equalsIgnoreCase(role)) {
            menu.findItem(R.id.nav_admin).setVisible(false);
        }

        // Load mặc định là QuizFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, quizFragment)
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();
            if (id == R.id.nav_quiz) {
                selectedFragment = quizFragment;
            } else if (id == R.id.nav_score) {
                selectedFragment = scoreFragment;
            } else if (id == R.id.nav_admin) {
                if ("admin".equalsIgnoreCase(role)) {
                    selectedFragment = adminFragment;
                } else {
                    Toast.makeText(MainActivity.this, "Bạn không có quyền truy cập chức năng này", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
                return true;
            }

            return false;
        });
    }
}
