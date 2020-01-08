package com.bawei.demo0108;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ProjectName: Demo0108
 * PackageName: com.bawei.demo0108
 * ClassName:   RvAdapter
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/8_8:48
 */
public class RvProductAdapter extends RecyclerView.Adapter<RvProductAdapter.VH> {

    private final Context context;

    private List<Entity.ResultBean.ShoppingCartListBean> result;


    public RvProductAdapter(Context context, List<Entity.ResultBean.ShoppingCartListBean> result) {

        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(View.inflate(context, R.layout.item_rvproduct, null));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Entity.ResultBean.ShoppingCartListBean list = result.get(position);
        holder.tvName.setText(list.getCommodityName());
        holder.tvPrice.setText("￥:" + list.getPrice());

        Glide.with(context).load(list.getPic()).into(holder.ivPic);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_pic)
        ImageView ivPic;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
