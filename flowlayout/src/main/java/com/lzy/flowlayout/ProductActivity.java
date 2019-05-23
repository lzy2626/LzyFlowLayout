package com.lzy.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiangcheng on 17/9/26.
 */

public class ProductActivity extends AppCompatActivity {
    private static final String TAG = ProductActivity.class.getSimpleName();
    //    private TextView suspension;
    protected RecyclerView productView;
    protected List<Product.Classify> classifies = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_flow_layout);
        productView = (RecyclerView) findViewById(R.id.product_view);
        productView.setLayoutManager(new LinearLayoutManager(this));

        classifies.add(new Product.Classify("年级", Arrays.asList(
                new Product.Classify.Des("一年级"),
                new Product.Classify.Des("二年级"),
                new Product.Classify.Des("三年级"),
                new Product.Classify.Des("四年级"),
                new Product.Classify.Des("五年级"),
                new Product.Classify.Des("六年级"))));
        classifies.add(new Product.Classify("科目", Arrays.asList(new Product.Classify.Des("180"),
                new Product.Classify.Des("175"),
                new Product.Classify.Des("170"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("160"),
                new Product.Classify.Des("155"),
                new Product.Classify.Des("150"))));
        classifies.add(new Product.Classify("科目", Arrays.asList(new Product.Classify.Des("180"),
                new Product.Classify.Des("175"),
                new Product.Classify.Des("170"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("160"),
                new Product.Classify.Des("155"),
                new Product.Classify.Des("150"))));
        classifies.add(new Product.Classify("科目", Arrays.asList(new Product.Classify.Des("180"),
                new Product.Classify.Des("175"),
                new Product.Classify.Des("170"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("160"),
                new Product.Classify.Des("155"),
                new Product.Classify.Des("150"))));
        classifies.add(new Product.Classify("款式",
                Arrays.asList(new Product.Classify.Des("男款"), new Product.Classify.Des("语文"),
                        new Product.Classify.Des("数学"),
                        new Product.Classify.Des("英语"))));

        productView.setAdapter(new ProductAdapter(this, classifies));
    }

}
