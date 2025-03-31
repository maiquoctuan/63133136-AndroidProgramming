package mqtuan.luyentap;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cau1Activity extends AppCompatActivity {

    EditText edtSo1, edtSo2;
    Button btnTinhTong;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);

        // Ánh xạ
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        btnTinhTong = findViewById(R.id.btnTinhTong);
        tvKetQua = findViewById(R.id.tvKetQua);

        // Xử lý nút Tính Tổng
        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy giá trị từ EditText
                String s1 = edtSo1.getText().toString().trim();
                String s2 = edtSo2.getText().toString().trim();

                if (!s1.isEmpty() && !s2.isEmpty()) {
                    int so1 = Integer.parseInt(s1);
                    int so2 = Integer.parseInt(s2);
                    int tong = so1 + so2;

                    tvKetQua.setText("Kết quả là: " + tong);
                } else {
                    tvKetQua.setText("Vui lòng nhập đủ 2 số!");
                }
            }
        });
    }
}
