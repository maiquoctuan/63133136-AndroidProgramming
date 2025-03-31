package com.example.maiquoctuan63133136_giuaky;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class chucnang2 extends AppCompatActivity {
    private EditText edtQT, edtGK, edtCK;
    private Button btnTinhDiem;
    private TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang2);

        edtQT = findViewById(R.id.edtQT);
        edtGK = findViewById(R.id.edtGK);
        edtCK = findViewById(R.id.edtCK);
        btnTinhDiem = findViewById(R.id.btnTinhDiem);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnTinhDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhDiemTrungBinh();
            }
        });
    }

    private void tinhDiemTrungBinh() {
        try {
            double diemQT = Double.parseDouble(edtQT.getText().toString());
            double diemGK = Double.parseDouble(edtGK.getText().toString());
            double diemCK = Double.parseDouble(edtCK.getText().toString());

            double diemTB = (diemQT * 0.2) + (diemGK * 0.3) + (diemCK * 0.5);
            txtKetQua.setText("Kết quả: " + String.format("%.2f", diemTB));
        } catch (NumberFormatException e) {
            txtKetQua.setText("Vui lòng nhập đầy đủ và đúng định dạng!");
        }
    }
}