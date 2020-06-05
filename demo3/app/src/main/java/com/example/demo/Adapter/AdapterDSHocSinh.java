package com.example.demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.Model.ObjectClass.hocsinh;
import com.example.demo.R;

import java.util.List;

public class AdapterDSHocSinh extends RecyclerView.Adapter<AdapterDSHocSinh.ViewHolderDsHocSinh> {
    Context context;
    List<hocsinh> hocsinhList;

    public AdapterDSHocSinh(Context context, List<hocsinh> hocsinhs){

        this.context = context;
        this.hocsinhList = hocsinhs;
    }

    public class ViewHolderDsHocSinh extends RecyclerView.ViewHolder{
        TextView txtv_name, txtv_mark;
        ImageButton btn_xoa;
        public ViewHolderDsHocSinh(@NonNull View itemView) {
            super(itemView);
            txtv_name = (TextView) itemView.findViewById(R.id.txtv_name);
            txtv_mark = (TextView) itemView.findViewById(R.id.txtv_mark);
            btn_xoa = (ImageButton) itemView.findViewById(R.id.btn_xoa);
        }
    }
    @NonNull
    @Override
    public AdapterDSHocSinh.ViewHolderDsHocSinh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_hs, parent, false);
        ViewHolderDsHocSinh viewHolderDsHocSinh = new ViewHolderDsHocSinh(view);
        return viewHolderDsHocSinh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDSHocSinh.ViewHolderDsHocSinh holder, int position) {
        final hocsinh hocsinh = hocsinhList.get(position);
        holder.txtv_name.setText(hocsinh.getName());
        holder.txtv_mark.setText(String.valueOf(hocsinh.getMark()));

    }



    @Override
    public int getItemCount() {
        return hocsinhList.size();
    }

}
