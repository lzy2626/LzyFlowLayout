package com.lzy.flowlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzy.flowlayout.FlowLayoutDialog;
import com.lzy.flowlayout.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Product.Classify> classifies = new ArrayList<>();
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

        FlowLayoutDialog flowLayoutDialog = new FlowLayoutDialog(this, classifies);
        flowLayoutDialog.show();


    }
}
