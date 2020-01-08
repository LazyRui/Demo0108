package com.bawei.demo0108;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.VH> {

    private final Context context;
    private final List<Entity.ResultBean> result;


    public RvAdapter(Context context, List<Entity.ResultBean> result) {

        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(View.inflate(context, R.layout.item_rv, null));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Entity.ResultBean list = result.get(position);
        holder.tvName.setText(list.getCategoryName());
        holder.rvProduct.setLayoutManager(new LinearLayoutManager(context));
        RvProductAdapter rvProductAdapter = new RvProductAdapter(context, list.getShoppingCartList());
        holder.rvProduct.setAdapter(rvProductAdapter);

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.rv_product)
        RecyclerView rvProduct;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
