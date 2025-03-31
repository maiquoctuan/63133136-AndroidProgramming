package mqtuan.luyentap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class Cau2Activity extends AppCompatActivity {

    ListView listViewSongs;
    ArrayList<String> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);

        // Ánh xạ ListView từ layout
        listViewSongs = findViewById(R.id.listViewSongs);

        // Tạo danh sách các bài hát của Sơn Tùng M-TP
        songList = new ArrayList<>();
        songList.add("Có chắc yêu là đây");
        songList.add("Chúng ta không thuộc về nhau");
        songList.add("Hãy trao cho anh");
        songList.add("Nơi này có anh");
        songList.add("Lạc trôi");
        songList.add("Nắng ấm xa dần");
        songList.add("Em của ngày hôm qua");
        songList.add("Đừng làm trái tim anh đau");
        songList.add("Chúng ta của hiện tại");
        songList.add("Chúng ta của tương lai");

        // Tạo ArrayAdapter để hiển thị danh sách
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                songList
        );
        listViewSongs.setAdapter(adapter);

        // Xử lý sự kiện click vào từng bài hát
        listViewSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSong = songList.get(position);
                Toast.makeText(Cau2Activity.this, "Bạn chọn bài: " + selectedSong, Toast.LENGTH_SHORT).show();
            }
        });
    }
}