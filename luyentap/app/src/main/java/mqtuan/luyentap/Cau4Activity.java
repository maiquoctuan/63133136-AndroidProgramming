package mqtuan.luyentap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Cau4Activity extends AppCompatActivity {
    TextView tvGioiThieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);

        tvGioiThieu = findViewById(R.id.tvGioiThieu);
        // ... Bổ sung thêm nội dung khác tuỳ ý
    }
}