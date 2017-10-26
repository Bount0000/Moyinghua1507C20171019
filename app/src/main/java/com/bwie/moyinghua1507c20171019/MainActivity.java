package com.bwie.moyinghua1507c20171019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.setsum {
    private RecyclerView rc;
    private TextView tv_sum;
    private Button pay;
    private CheckBox allselect;
    private MyAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
            }
        });

        allselect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    myadapter.setSelect(true);
                }else{
                    myadapter.setSelect(false);
                }
            }
        });
    }

    private void initData() {
        List<ShopBean> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ShopBean(R.mipmap.ic_launcher,"购物车里第"+i+"件商品",10+i,false));
        }
        LinearLayoutManager lm=new LinearLayoutManager(this);
        rc.setLayoutManager(lm);
        myadapter = new MyAdapter(this,list);
        myadapter.setSetsum(this);
        rc.setAdapter(myadapter);
    }

    private void initView() {
        rc = (RecyclerView) findViewById(R.id.rc);
        tv_sum = (TextView) findViewById(R.id.sum);
        pay = (Button) findViewById(R.id.pay);
        allselect = (CheckBox) findViewById(R.id.allselect);

    }

    @Override
    public void setsum(double sum) {
        tv_sum.setText(sum+"");
    }
}
