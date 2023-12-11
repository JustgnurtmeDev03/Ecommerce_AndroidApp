package com.example.ecommerceapp.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.Domain.PopularDomain;
import com.example.ecommerceapp.Helper.ManagementCart;
import com.example.ecommerceapp.R;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, reviewTxt, scoreTxt;
    private ImageView picItem, backBtn;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Khởi tạo đối tượng quản lý giỏ hàng
        managementCart = new ManagementCart(this);

        // Khởi tạo giao diện người dùng và lấy dữ liệu từ Intent
        initView();
        getBundle();
    }

    private void getBundle() {
        // Lấy đối tượng PopularDomain từ Intent
        object = (PopularDomain) getIntent().getSerializableExtra("object");

        // Lấy ID tài nguyên hình ảnh từ tên hình ảnh
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());

        // Sử dụng Glide để tải và hiển thị hình ảnh từ ID tài nguyên
        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);

        // Hiển thị thông tin chi tiết của sản phẩm trên giao diện
        titleTxt.setText(object.getTitle());
        feeTxt.setText("$" + object.getPrice());
        descriptionTxt.setText(object.getDescription());
        reviewTxt.setText(String.valueOf(object.getReview()));
        scoreTxt.setText(String.valueOf(object.getScore()));

        // Xử lý sự kiện khi nhấn nút "Thêm vào giỏ hàng"
        addToCartBtn.setOnClickListener(v -> {
            object.setNumberInCart(numberOrder);
            managementCart.insertFood(object);
        });

        // Xử lý sự kiện khi nhấn nút "Quay lại"
        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        // Ánh xạ các thành phần giao diện từ layout
        backBtn = findViewById(R.id.backBtn);
        addToCartBtn = findViewById(R.id.addToCartBtn);
        feeTxt = findViewById(R.id.priceTxt);
        titleTxt = findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        picItem = findViewById(R.id.itemPic);
        reviewTxt = findViewById(R.id.reviewTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
    }
}
