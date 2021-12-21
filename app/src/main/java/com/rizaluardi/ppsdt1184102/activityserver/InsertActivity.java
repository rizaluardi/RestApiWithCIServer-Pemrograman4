package com.rizaluardi.ppsdt1184102.activityserver;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rizaluardi.ppsdt1184102.R;
import com.rizaluardi.ppsdt1184102.model.PostPutDelKontak;
import com.rizaluardi.ppsdt1184102.rest.ApiClient;
import com.rizaluardi.ppsdt1184102.rest.ApiInterface;

public class InsertActivity extends AppCompatActivity {

    EditText edtNama, edtNomor;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtNomor = (EditText) findViewById(R.id.edtNomor);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelKontak> postKontakCall =
                        mApiInterface.postKontak(edtNama.getText().toString(),
                                edtNomor.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelKontak>()
                {
                    @Override
                    public void onResponse(Call<PostPutDelKontak> call,
                                           Response<PostPutDelKontak> response) {
                        MainActivityWeb.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelKontak> call,
                                          Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityWeb.ma.refresh();
                finish();
            }
        });
    }
}
