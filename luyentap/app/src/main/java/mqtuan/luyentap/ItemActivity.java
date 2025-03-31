package mqtuan.luyentap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    TextView tvItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        tvItemDetail = findViewById(R.id.tvItemDetail);

        // Lấy dữ liệu từ Intent
        String data = getIntent().getStringExtra("keyEditText");
        // Hoặc "keyItem" tùy trường hợp

        if(data != null){
            tvItemDetail.setText("Nội dung nhận được: " + data);
        }
    }
}
