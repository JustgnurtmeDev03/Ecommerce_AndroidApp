package com.example.ecommerceapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.Adapter.PopularAdapter;
import com.example.ecommerceapp.Domain.PopularDomain;
import com.example.ecommerceapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo và cấu hình RecyclerView
        initRecyclerView();
        initRecyclerView2();
        bottomNavigation();
    }


    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivities(new Intent[]{new Intent(MainActivity.this, MainActivity.class)}));
        cartBtn.setOnClickListener(v -> startActivities(new Intent[]{new Intent(MainActivity.this, CartActivity.class)}));
    }

    private void initRecyclerView() {
        // Tạo danh sách các mục dữ liệu (trong trường hợp này là danh sách sản phẩm phổ biến)
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Áo thun đen", "Chất vải thun cotton 100% 2 chiều cao cấp dày dặn đã được làm sạch lông nên không bị xù lông khi giặt.\n" +
                "Vải mặc mát thoáng khí chứ không bị bí nóng vì không pha poly như những áo thun giá rẻ nơi khác.\n" +
                "Đường may cao cấp 2 kim viền cổ, vai chạy móc xích. Nâng tầm chiếc áo thun thêm tinh tế và cao cấp đến người mặc từ chất lượng bên trong cả ngoại hình bên ngoài.\n" +
                "Bo cổ rip cotton chống gin hay bị nhão sau khi giặt. Ôm cổ dày dặn đẹp chuẩn hàng hiệu.\n" +
                "Form dáng áo thun tay lỡ, form rộng oversize. Đảm bảo độ lên form áo chuẩn đẹp như local brand.\n" +
                "Không dư chỉ thừa, hàng không bị bẩn dơ hoặc rách.","item_1",15, 4.5, 25));
        items.add(new PopularDomain("Đồng hồ thông minh", "","item_2",10, 4.8, 210));
        items.add(new PopularDomain("Iphone 15 256gb", "","item_3",25, 4.3, 1200));
        items.add(new PopularDomain("PlayStation 5", "","pic2",25, 4.3, 600));
        // Ánh xạ RecyclerView từ layout
        recyclerViewPopular=findViewById(R.id.view1);
        // Cấu hình LayoutManager cho RecyclerView (trong trường hợp này là LinearLayoutManager ngang)
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Khởi tạo Adapter và thiết lập cho RecyclerView
        adapterPopular = new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }

    private void initRecyclerView2() {
        // Tạo danh sách các mục dữ liệu (trong trường hợp này là danh sách sản phẩm phổ biến)
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Áo hoodie nỉ bông", "Chất liệu: Nỉ bông cao cấp\n" +
                "Màu: Sand, Iron stone, Charcoal\n" +
                "Chất niệu nỉ thoải mái, đứng form. Phần túi được làm dọc thân áo.\n" +
                "Mũ siêu to và đứng form.\n" +
                "Giá thành nhỉnh hơn so với mặt bằng nhưng đổi lại bạn có một món đồ đi theo năm tháng.","cloth_1",12, 5.0, 15.7));
        items.add(new PopularDomain("Quần Jean nam ống xuông", "","cloth_2",10, 4.8, 11));
        items.add(new PopularDomain("Giày derby", "Square toe derby:\n" +
                "Order không có sẵn\n" +
                "Da PU dày, độ bóng nhẹ\n" +
                "Đế 5cm\n" +
                "- Size: 38 - 39- 40 - 41 - 42 - 43 \n" +
                "Update: Đã có thêm sz 44 cho ae chân bè \uD83E\uDD27\n" +
                "Lưu ý: Mẫu này mn mang giống với size sneaker ( mn kiểm tra số cm ở phần tag giày để chuẩn nhất). Chân bè có thể mang tăng 1 size để thoải mái hơn nhé.\n" +
                "Mix đồ thì cháy phố luôn \uD83D\uDD25","cloth_5",319, 4.9, 23.05));
        items.add(new PopularDomain("Áo khoác crop gakuran", "Áo Gakuran form crop cực chiến, có đệm vai.\n" +
                "Size: M, L, XL, XXL, XXXL\n" +
                "form nhỏ và crop mọi người nên up 1 size hoặc hơn. \n" +
                "mẫu m72-55kg mặc XL","cloth_4",219, 4.9, 11.98));
        // Ánh xạ RecyclerView từ layout
        recyclerViewPopular=findViewById(R.id.clothesview);
        // Cấu hình LayoutManager cho RecyclerView (trong trường hợp này là LinearLayoutManager ngang)
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Khởi tạo Adapter và thiết lập cho RecyclerView
        adapterPopular = new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }

}