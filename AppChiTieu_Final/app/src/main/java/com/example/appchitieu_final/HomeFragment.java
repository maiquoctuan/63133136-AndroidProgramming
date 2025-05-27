package com.example.appchitieu_final;
import com.example.appchitieu_final.AddTransactionFragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DatabaseHelper db = new DatabaseHelper(getContext());
        List<TransactionFragment> list = db.();

        // Hiển thị list bằng RecyclerView

        // Inflate layout cho fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}