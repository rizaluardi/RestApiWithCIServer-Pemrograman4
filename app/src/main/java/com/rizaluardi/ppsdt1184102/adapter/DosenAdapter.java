package com.rizaluardi.ppsdt1184102.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rizaluardi.ppsdt1184102.R;
import com.rizaluardi.ppsdt1184102.model.Dosen;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.DosenViewHolder> {
    private List<Dosen> dosenList = new ArrayList<>();
    public DosenAdapter(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    @Override
    public DosenAdapter.DosenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_dosen, parent, false);
        DosenViewHolder dosenViewHolder = new DosenViewHolder(view);
        return dosenViewHolder;
    }

    @Override
    public void onBindViewHolder(DosenAdapter.DosenViewHolder holder, int position) {
        holder.txt_resultdosen.setText(dosenList.get(position).getDosen());
        holder.txt_resultnik.setText(dosenList.get(position).getNik());
    }

    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public static class DosenViewHolder extends RecyclerView.ViewHolder {

        TextView txt_resultdosen;
        TextView txt_resultnik;

        public DosenViewHolder(View itemView) {
            super(itemView);

            txt_resultdosen = (TextView) itemView.findViewById(R.id.txt_resultdosen);
            txt_resultnik = (TextView) itemView.findViewById(R.id.txt_resultnik);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
