package mqtuan.appcong;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumber1, edtNumber2;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        txtResult = findViewById(R.id.txtResult);
    }

    // Hàm xử lý sự kiện được gán trong XML
    public void XuLyCong(View view) {
        String strNum1 = edtNumber1.getText().toString();
        String strNum2 = edtNumber2.getText().toString();

        if (!strNum1.isEmpty() && !strNum2.isEmpty()) {
            int num1 = Integer.parseInt(strNum1);
            int num2 = Integer.parseInt(strNum2);
            int sum = num1 + num2;
            txtResult.setText("Kết quả: " + sum);
        } else {
            txtResult.setText("Vui lòng nhập đầy đủ số!");
        }
    }
}
