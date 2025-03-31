package com.example.maiquoctuan63133136_giuaky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class chucnang3 extends AppCompatActivity {

    ListView listJob;
    ArrayList<String> jobList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang3);

        listJob = findViewById(R.id.listJob);

        jobList = new ArrayList<>();
        jobList.add(" Lập Trình C ");
        jobList.add(" Lập Trình Java ");
        jobList.add(" Phát triển ứng dụng Web ");
        jobList.add(" Khai phá dữ liệu lớn ");
        jobList.add(" Internet vạn vật kết nối ");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,jobList);
        listJob.setAdapter(adapter);

        listJob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSong = jobList.get(position);
                Toast.makeText(chucnang3.this, "Bạn chọn môn: " + selectedSong, Toast.LENGTH_SHORT).show();
            }
        });
    }
}