package com.example.ecommerceapp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.ecommerceapp.Domain.PopularDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(PopularDomain item) {
        ArrayList<PopularDomain> listpop = getListCart();
        boolean existAlready = false;
        int position = -1;

        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        for (int i = 0; i < listpop.size(); i++) {
            if (listpop.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                position = i;
                break;
            }
        }

        if (existAlready) {
            // Nếu sản phẩm đã tồn tại, cập nhật số lượng
            listpop.get(position).setNumberInCart(item.getNumberInCart());
            Toast.makeText(context, "Đã được cập nhật trong giỏ hàng", Toast.LENGTH_SHORT).show();
        } else {
            // Nếu sản phẩm chưa tồn tại, thêm vào giỏ hàng
            listpop.add(item);
            Toast.makeText(context, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
        }

        // Lưu danh sách giỏ hàng vào TinyDB
        tinyDB.putListObject("CartList", listpop);
    }


    public ArrayList<PopularDomain>getListCart(){
        return tinyDB.getListObject("CartList");
    }

    public Double getTotalFee(){
        ArrayList<PopularDomain> listItem = getListCart();
        double fee = 0;
        for (int i=0; i <listItem.size() ; i ++) {
            fee = fee + (listItem.get(i).getPrice()*listItem.get(i).getNumberInCart());
        }
        return fee;
    }

    public void minusNumberItem (ArrayList<PopularDomain> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if(listItem.get(position).getNumberInCart()==1){
            listItem.remove(position);
        }else {
            listItem.get(position).setNumberInCart(listItem.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList", listItem);
        changeNumberItemsListener.change();
    }

    public void plusNumberItem(ArrayList<PopularDomain> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listItem.get(position).setNumberInCart(listItem.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList",listItem);
        changeNumberItemsListener.change();
    }
}
