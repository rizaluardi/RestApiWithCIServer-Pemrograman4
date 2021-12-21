package com.rizaluardi.ppsdt1184102.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rizaluardi.ppsdt1184102.R;
import com.rizaluardi.ppsdt1184102.adapter.DosenAdapter;
import com.rizaluardi.ppsdt1184102.helper.DBHandler;
import com.rizaluardi.ppsdt1184102.model.Dosen;

import java.util.List;

public class TambahDosenActivity extends AppCompatActivity {

    private EditText et_dosen;
    private EditText et_nik;
    private Button button_tambahdata;

    private DBHandler dbHandler;
    private DosenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_dosen);
        dbHandler = new DBHandler(this);
        initComponents();
    }
    private void initComponents(){
        et_dosen = (EditText) findViewById(R.id.et_dosen);
        et_nik = (EditText) findViewById(R.id.et_nik);
        button_tambahdata = (Button) findViewById(R.id.button_tambahdata);

        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiForm();
            }
        });
    }
    private void validasiForm(){
        String form_dosen = et_dosen.getText().toString();
        String form_nik = et_nik.getText().toString();

        if (form_dosen.isEmpty()){
            et_dosen.setError("Isi dosen dulu");
            et_dosen.requestFocus();
        } if (form_nik.isEmpty()){
            et_nik.setError("Isi nama nik dulu");
            et_nik.requestFocus();
        } else {
            dbHandler.tambahDosen(new Dosen(form_dosen, form_nik));
            List<Dosen> dosenList = dbHandler.getSemuaDosen();
            adapter = new DosenAdapter(dosenList);
            adapter.notifyDataSetChanged();

            Toast.makeText(TambahDosenActivity.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }
    }
}