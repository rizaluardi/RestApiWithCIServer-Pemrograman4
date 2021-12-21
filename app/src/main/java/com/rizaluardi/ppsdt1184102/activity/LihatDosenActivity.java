package com.rizaluardi.ppsdt1184102.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rizaluardi.ppsdt1184102.R;
import com.rizaluardi.ppsdt1184102.adapter.DosenAdapter;
import com.rizaluardi.ppsdt1184102.helper.DBHandler;
import com.rizaluardi.ppsdt1184102.helper.RecyclerItemClickListener;
import com.rizaluardi.ppsdt1184102.model.Dosen;

import java.util.ArrayList;
import java.util.List;

public class LihatDosenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DosenAdapter adapter;
    private DBHandler dbHandler;
    private TextView txt_resultadapter;
    private List<Dosen> dosenList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_dosen);
        initComponents();
        initRecyclerView();
        cekDataRecyclerView();
    }
    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.rv_dosen);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHandler = new DBHandler(LihatDosenActivity.this);
        dosenList = dbHandler.getSemuaDosen();
        adapter = new DosenAdapter(dosenList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void initComponents(){
        txt_resultadapter = (TextView) findViewById(R.id.txt_resultadapter);
    }

    private void cekDataRecyclerView(){
        if (adapter.getItemCount() == 0){
            txt_resultadapter.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            // TODO Handle item click
                            Dosen dsn = dosenList.get(position);
                            String dosen = dsn.getDosen();

                            Toast.makeText(LihatDosenActivity.this, "Klik di " + dosen, Toast.LENGTH_SHORT).show();
                        }
                    })
            );
        }
    }
}