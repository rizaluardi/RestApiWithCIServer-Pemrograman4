package com.rizaluardi.ppsdt1184102.activityserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rizaluardi.ppsdt1184102.R;
import com.rizaluardi.ppsdt1184102.adapter.RuanganAdapter;
import com.rizaluardi.ppsdt1184102.model.GetRuangan;
import com.rizaluardi.ppsdt1184102.model.Ruangan;
import com.rizaluardi.ppsdt1184102.rest.ApiClient;
import com.rizaluardi.ppsdt1184102.rest.ApiInterfaceRuangan;

import java.util.List;

public class MainActivityRuangan extends AppCompatActivity {
    Button btInsRuangan;
    ApiInterfaceRuangan mApiInterfaceRuangan;
    private RecyclerView mRecyclerViewRuangan;
    private RecyclerView.Adapter mAdapterRuangan;
    private RecyclerView.LayoutManager mLayoutManagerRuangan;
    public static MainActivityRuangan mar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ruangan);
        btInsRuangan = (Button) findViewById(R.id.btInsRuangan);
        btInsRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityRuangan.this,
                        InsertActivityRuangan.class));
            }
        });
        mRecyclerViewRuangan = (RecyclerView) findViewById(R.id.recyclerViewRuangan);
        mLayoutManagerRuangan = new LinearLayoutManager(this);
        mRecyclerViewRuangan.setLayoutManager(mLayoutManagerRuangan);
        mApiInterfaceRuangan = ApiClient.getClient().create(ApiInterfaceRuangan.class);
        mar=this;
        refresh();
    }
    public void refresh() {
        Call<GetRuangan> ruanganCall = mApiInterfaceRuangan.getRuangan();
        ruanganCall.enqueue(new Callback<GetRuangan>() {
            @Override
            public void onResponse(Call<GetRuangan> call,
                                   Response<GetRuangan>
                                           response) {
                List<Ruangan> RuanganList =
                        response.body().getListDataRuangan();
                Log.d("Retrofit Get", "Jumlah data Ruangan: " +
                        String.valueOf(RuanganList.size()));
                mAdapterRuangan = new RuanganAdapter(RuanganList);
                mRecyclerViewRuangan.setAdapter(mAdapterRuangan);
            }
            @Override
            public void onFailure(Call<GetRuangan> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}