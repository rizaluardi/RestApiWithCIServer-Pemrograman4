package com.rizaluardi.ppsdt1184102.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rizaluardi.ppsdt1184102.R;
import com.rizaluardi.ppsdt1184102.activityserver.EditActivity;
import com.rizaluardi.ppsdt1184102.model.Kontak;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class KontakAdapter extends
        RecyclerView.Adapter<KontakAdapter.MyViewHolder>{
    List<Kontak> mKontakList;
    public KontakAdapter(List <Kontak> KontakList) {
        mKontakList = KontakList;
    }
    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int
            viewType){
        View mView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.kontak_list,parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder (MyViewHolder holder,final int
            position){
        holder.mTextViewId.setText("Id = " + mKontakList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mKontakList.get(position).getNama());
        holder.mTextViewNomor.setText("Nomor = " + mKontakList.get(position).getNomor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mKontakList.get(position).getId());
                mIntent.putExtra("Nama", mKontakList.get(position).getNama());
                mIntent.putExtra("Nomor", mKontakList.get(position).getNomor());
                view.getContext().startActivity(mIntent); }
        });
    }
    @Override
    public int getItemCount () {
        return mKontakList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView)
                    itemView.findViewById(R.id.tvNama);
            mTextViewNomor = (TextView)
                    itemView.findViewById(R.id.tvNomor);
        }
    }
}