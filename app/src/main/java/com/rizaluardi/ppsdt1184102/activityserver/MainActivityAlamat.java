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
import com.rizaluardi.ppsdt1184102.adapter.AlamatAdapter;
import com.rizaluardi.ppsdt1184102.model.Alamat;
import com.rizaluardi.ppsdt1184102.model.GetAlamat;
import com.rizaluardi.ppsdt1184102.rest.ApiClient;
import com.rizaluardi.ppsdt1184102.rest.ApiInterfaceAlamat;

import java.util.List;

public class MainActivityAlamat extends AppCompatActivity {

    ApiInterfaceAlamat mApiInterfaceAlamat;
    private RecyclerView mRecyclerViewAlamat;
    private RecyclerView.Adapter mAdapterAlamat;
    private RecyclerView.LayoutManager mLayoutManagerAlamat;
    public static MainActivityAlamat maa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alamat);
        Button btIns;
        btIns = (Button) findViewById(R.id.btInsAlamat);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityAlamat.this,
                        InsertActivityAlamat.class));
            }
        });
        mRecyclerViewAlamat = (RecyclerView) findViewById(R.id.recyclerViewAlamat);
        mLayoutManagerAlamat = new LinearLayoutManager(this);
        mRecyclerViewAlamat.setLayoutManager(mLayoutManagerAlamat);
        mApiInterfaceAlamat = ApiClient.getClient().create(ApiInterfaceAlamat.class);
        maa=this;
        refresh();
    }
    public void refresh() {
        Call<GetAlamat> alamatCall = mApiInterfaceAlamat.getAlamat();
        alamatCall.enqueue(new Callback<GetAlamat>() {
            @Override
            public void onResponse(Call<GetAlamat> call,
                                   Response<GetAlamat>
                                           response) {
                List<Alamat> AlamatList =
                        response.body().getListDataAlamat();
                Log.d("Retrofit Get", "Jumlah data Alamat: " +
                        String.valueOf(AlamatList.size()));
                mAdapterAlamat = new AlamatAdapter(AlamatList);
                mRecyclerViewAlamat.setAdapter(mAdapterAlamat);
            }
            @Override
            public void onFailure(Call<GetAlamat> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}