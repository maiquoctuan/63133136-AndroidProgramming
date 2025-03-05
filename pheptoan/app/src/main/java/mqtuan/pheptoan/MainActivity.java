package mqtuan.pheptoan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    public void TimDieuKhien() {
        editTextSo1 = (EditText) findViewById(R.id.edtSO1);
        editTextSo2 = (EditText) findViewById(R.id.edtSO2);
        editTextKQ = (EditText) findViewById(R.id.edtKetQua);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        //Gan bo lang nghe
        View.OnClickListener boLangNgheCong = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_CONG();
            }
        };
        nutCong.setOnClickListener(boLangNgheCong);

        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_TRU();

            }
        });

        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_NHAN();
            }
        });

        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_CHIA();
            }
        });
    }

    void XULY_CONG(){
        //b1 tìm edittext số 1 và số 2
        //b2 Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //Chuyển dữ liệu từ chuỗi sang số
        float soA =  Float.parseFloat(soThu1);
        float soB =  Float.parseFloat(soThu2);
        // tính toán
        float Tong = soA + soB;
        String chuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(chuoiKQ);
    }
    void XULY_TRU(){
        //b1 tìm edittext số 1 và số 2
        //b2 Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //Chuyển dữ liệu từ chuỗi sang số
        float soA =  Float.parseFloat(soThu1);
        float soB =  Float.parseFloat(soThu2);
        // tính toán
        float Hieu = soA - soB;
        String chuoiKQ = String.valueOf(Hieu);
        editTextKQ.setText(chuoiKQ);

    }
    void XULY_NHAN(){
        //b1 tìm edittext số 1 và số 2
        //b2 Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //Chuyển dữ liệu từ chuỗi sang số
        float soA =  Float.parseFloat(soThu1);
        float soB =  Float.parseFloat(soThu2);
        // tính toán
        float Tich = soA * soB;
        String chuoiKQ = String.valueOf(Tich);
        editTextKQ.setText(chuoiKQ);

    }
    void XULY_CHIA(){
        //b1 tìm edittext số 1 và số 2
        //b2 Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //Chuyển dữ liệu từ chuỗi sang số
        float soA =  Float.parseFloat(soThu1);
        float soB =  Float.parseFloat(soThu2);
        // tính toán
        float Chia = soA / soB;
        String chuoiKQ = String.valueOf(Chia);
        editTextKQ.setText(chuoiKQ);
    }
}