package mqtuan.luyentap;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCau1, btnCau2, btnCau3, btnCau4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        btnCau1 = findViewById(R.id.btnCau1);
        btnCau2 = findViewById(R.id.btnCau2);
        btnCau3 = findViewById(R.id.btnCau3);
        btnCau4 = findViewById(R.id.btnCau4);

        // Xử lý nút Câu 1
        btnCau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cau1Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý nút Câu 2
        btnCau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cau2Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý nút Câu 3
        btnCau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cau3Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý nút Câu 4
        btnCau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cau4Activity.class);
                startActivity(intent);
            }
        });
    }
}
