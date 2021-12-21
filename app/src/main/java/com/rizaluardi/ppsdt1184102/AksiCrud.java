package com.rizaluardi.ppsdt1184102;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rizaluardi.ppsdt1184102.activity.MainScreenActivity;


public class AksiCrud extends Fragment {
    Button server,sqlit,upndown;

    private static final String TAG = "AksiCrud";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aksicrud, container, false);

        sqlit = (Button)view.findViewById(R.id.menuju_sqlite);
        sqlit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cv = new Intent(getActivity(), MainScreenActivity.class);
                //berfunngsi untuk melakukan eksekusi dari parameter explicit ke activity berikutnya
                startActivity(cv);
            }
        });

        server = (Button)view.findViewById(R.id.menuju_webserver);
        server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cv = new Intent(getActivity(), HomeWebActivity.class);
                //berfunngsi untuk melakukan eksekusi dari parameter explicit ke activity berikutnya
                startActivity(cv);
            }
        });
        upndown = (Button)view.findViewById(R.id.menuju_downup);
        upndown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cv = new Intent(getActivity(), UploadDownloadFile.class);
                //berfunngsi untuk melakukan eksekusi dari parameter explicit ke activity berikutnya
                startActivity(cv);
            }
        });

        return view;
    }
}