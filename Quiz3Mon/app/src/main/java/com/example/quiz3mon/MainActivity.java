package com.example.quiz3mon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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
