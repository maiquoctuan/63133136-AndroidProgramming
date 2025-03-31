package mqtuan.luyentap;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class Cau3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3); // Đảm bảo có activity_cau3.xml

        RecyclerView recyclerView = findViewById(R.id.recyclerViewPlayers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Player> players = new ArrayList<>();
        players.add(new Player("Thibaut Courtois", "Thủ môn"));
        players.add(new Player("Dani Carvajal", "Hậu vệ phải"));
        players.add(new Player("Antonio Rüdiger", "Trung vệ"));
        players.add(new Player("David Alaba", "Trung vệ"));
        players.add(new Player("Ferland Mendy", "Hậu vệ trái"));
        players.add(new Player("Luka Modrić", "Tiền vệ trung tâm"));
        players.add(new Player("Toni Kroos", "Tiền vệ trung tâm"));
        players.add(new Player("Jude Bellingham", "Tiền vệ công"));
        players.add(new Player("Vinícius Júnior", "Tiền đạo trái"));
        players.add(new Player("Rodrygo", "Tiền đạo phải"));
        players.add(new Player("Joselu", "Tiền đạo cắm"));

        PlayerAdapter adapter = new PlayerAdapter(players);
        recyclerView.setAdapter(adapter);
    }
}
