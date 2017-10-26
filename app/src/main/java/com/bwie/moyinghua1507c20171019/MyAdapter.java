package com.bwie.moyinghua1507c20171019;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mo on 2017/10/19.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<ShopBean> list;
    private double sum;
    public MyAdapter(Context context, List<ShopBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.select.setOnCheckedChangeListener(null);
         //然后设置CheckBox状态
        if(list.get(holder.getLayoutPosition()).isSelect()) {
            holder.select.setChecked(true);
        } else {
            holder.select.setChecked(false);
        }
        holder.title.setText(list.get(holder.getLayoutPosition()).getTitle());
        holder.price.setText("¥  "+list.get(holder.getLayoutPosition()).getPrice());
        holder.iv.setImageResource(list.get(holder.getLayoutPosition()).getImg());
        holder.select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sum+=list.get(holder.getLayoutPosition()).getPrice();
                }else{
                    sum-=list.get(holder.getLayoutPosition()).getPrice();
                }
                list.get(holder.getLayoutPosition()).setSelect(b);
                setsum.setsum(sum);
            }
        });
    }

    private setsum setsum;
    public void setSetsum(MyAdapter.setsum setsum) {
        this.setsum = setsum;
    }

    public void setSelect(boolean b) {
        sum=0;
        if(b){
                for (ShopBean shopBean : list) {
                    shopBean.setSelect(b);
                    sum+=shopBean.getPrice();
                }
        }else{
            for (ShopBean shopBean : list) {
                shopBean.setSelect(b);
                sum=0;
            }
        }
        notifyDataSetChanged();
        setsum.setsum(sum);
    }

    public interface setsum{
        void setsum(double sum);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private CheckBox select;
        private ImageView iv;
        private TextView title;
        private TextView price;
        public MyViewHolder(View itemView) {
            super(itemView);
            select=itemView.findViewById(R.id.select);
            iv=itemView.findViewById(R.id.iv);
            title=itemView.findViewById(R.id.title1);
            price=itemView.findViewById(R.id.price);
        }
    }
}
