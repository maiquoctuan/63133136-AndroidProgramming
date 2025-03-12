package ntu.listbaihatyeuthich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển thị dữ liệu lên list view
        //B1. Chuaarn bị nguồn dữ liệu ( có thể tạo sẵn (hardcode)/Lấy từ tệp/CSDL
        ArrayList<String> nguonDuLieu = new ArrayList<String>();
        nguonDuLieu.add("Nơi này có anh");
        nguonDuLieu.add("lạc trôi");
        nguonDuLieu.add("Chúng ta của hiện tại");
        nguonDuLieu.add("Chắc ai đó sẽ về");
        //B2. Tìm tham chiếu đến ListView
        ListView listViewBH= (ListView) findViewById(R.id.lvDSbaihat);
        //B3. Tạo adapter, 3.1 và gán vs nguồn
        ArrayAdapter<String> baiHat_Adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1,nguonDuLieu);
        //B4. gắn/nạp dữ liệu từ nguồn vào listView
        listViewBH.setAdapter(baiHat_Adapter);

        //Xử lý sự kiện
        listViewBH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position là vị trí của item được chọn/cham/ckicl trên listview
                // lấy giá trị của item vừa chạm
                String value = baiHat_Adapter.getItem(position);
                //xử lý khác theo yeu cầu
                //ví dụ
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
            }
        });
    }
}