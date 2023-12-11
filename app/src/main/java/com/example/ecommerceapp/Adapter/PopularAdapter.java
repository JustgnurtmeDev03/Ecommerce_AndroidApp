package com.example.ecommerceapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.ecommerceapp.Activities.DetailActivity;
import com.example.ecommerceapp.Domain.PopularDomain;
import com.example.ecommerceapp.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder>{
    // Danh sách các mục dữ liệu
    ArrayList<PopularDomain> items;
    // Context để có thể sử dụng trong các phương thức của Adapter
    Context context;

    // Constructor nhận danh sách mục dữ liệu từ bên ngoài
    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    // Phương thức khởi tạo ViewHolder
    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Lấy context từ ViewGroup cha (thường là Activity hoặc Fragment)
        context = parent.getContext();
        // Inflate layout cho mỗi mục trong RecyclerView
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list, parent, false);
        // Trả về một đối tượng ViewHolder mới
        return new Viewholder(inflate);
    }

    // Phương thức này được gọi khi RecyclerView cần hiển thị dữ liệu cho một ViewHolder cụ thể
    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
        // Thiết lập dữ liệu cho ViewHolder tại vị trí position
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.feeTxt.setText("$" + items.get(position).getPrice());
        holder.scoreTxt.setText("" + items.get(position).getScore());

        // Lấy ID của hình ảnh từ tên hình ảnh
        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable", holder.itemView.getContext().getOpPackageName());
        // Sử dụng thư viện Glide để tải và hiển thị hình ảnh
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30, 30, 0, 0)) // Bo tròn góc hình ảnh
                .into(holder.pic);

        // Đặt lắng nghe sự kiện click cho mỗi mục
        holder.itemView.setOnClickListener(v -> {
            // Mở màn hình chi tiết khi mục được click
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    // Phương thức trả về số lượng mục trong danh sách
    @Override
    public int getItemCount() {
        return items.size();
    }

    // Lớp Viewholder đại diện cho mỗi mục trong RecyclerView
    public class Viewholder extends RecyclerView.ViewHolder {
        // Các thành phần giao diện người dùng
        TextView titleTxt, feeTxt, scoreTxt;
        ImageView pic;

        // Constructor của Viewholder
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ các thành phần giao diện từ layout
            titleTxt = itemView.findViewById(R.id.titleTxt);
            feeTxt = itemView.findViewById(R.id.priceTxt);
            scoreTxt = itemView.findViewById(R.id.scoreTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}

