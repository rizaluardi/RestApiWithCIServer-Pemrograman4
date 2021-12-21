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
import com.rizaluardi.ppsdt1184102.model.PostPutDelInstansi;
import com.rizaluardi.ppsdt1184102.rest.ApiClient;
import com.rizaluardi.ppsdt1184102.rest.ApiInterfaceInstansi;

public class InsertActivityInstansi extends AppCompatActivity {
    EditText edtInstansi, edtTelepon;
    Button btInsertInstansi, btBackInstansi;
    ApiInterfaceInstansi mApiInterfaceInstansi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_instansi);
        edtInstansi = (EditText) findViewById(R.id.edtInstansi);
        edtTelepon = (EditText) findViewById(R.id.edtTelepon);
        mApiInterfaceInstansi = ApiClient.getClient().create(ApiInterfaceInstansi.class);
        btInsertInstansi = (Button) findViewById(R.id.btInsertingInstansi);
        btInsertInstansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelInstansi> postInstansiCall =
                        mApiInterfaceInstansi.postInstansi(edtInstansi.getText().toString(),
                                edtTelepon.getText().toString());
                postInstansiCall.enqueue(new Callback<PostPutDelInstansi>()
                {
                    @Override
                    public void onResponse(Call<PostPutDelInstansi> call,
                                           Response<PostPutDelInstansi> response) {
                        MainActivityInstansi.mai.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelInstansi> call,
                                          Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btBackInstansi = (Button) findViewById(R.id.btBackGoInstansi);
        btBackInstansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInstansi.mai.refresh();
                finish();
            }
        });
    }
}
