package com.rizaluardi.ppsdt1184102;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rizaluardi.ppsdt1184102.activityserver.MainActivityAlamat;
import com.rizaluardi.ppsdt1184102.activityserver.MainActivityInstansi;
import com.rizaluardi.ppsdt1184102.activityserver.MainActivityRuangan;
import com.rizaluardi.ppsdt1184102.activityserver.MainActivityWeb;

public class HomeWebActivity extends AppCompatActivity {
    Button kontak,instansi,alamat,ruangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_web);


        kontak = (Button) findViewById(R.id.keKontak);
        kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWebActivity.this, MainActivityWeb.class));
            }
        });
        instansi = (Button) findViewById(R.id.keInstansi);
        instansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWebActivity.this, MainActivityInstansi.class));
            }
        });
        alamat = (Button) findViewById(R.id.keAlamat);
        alamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWebActivity.this, MainActivityAlamat.class));
            }
        });
        ruangan = (Button) findViewById(R.id.keRuangan);
        ruangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWebActivity.this, MainActivityRuangan.class));
            }
        });
    }
}