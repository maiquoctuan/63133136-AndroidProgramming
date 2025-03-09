package mqtuan.ex6_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtResult = findViewById(R.id.txtResult);

        String name = getIntent().getStringExtra("key_name");
        txtResult.setText("Xin chào: " + name);
    }
}

