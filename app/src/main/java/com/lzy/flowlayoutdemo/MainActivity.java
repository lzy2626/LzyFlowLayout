package com.lzy.flowlayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lzy.flowlayout.CateBean;
import com.lzy.flowlayout.FlowLayoutDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<CateBean> cateBeanList = new ArrayList<>();
        CateBean cateBean = new CateBean();
        cateBean.setCcid(1);
        cateBean.setIdx(1);
        cateBean.setName("年级");

        List<CateBean.ChildcatelistBean> childcatelist = new ArrayList<>();
        CateBean.ChildcatelistBean childcatelistBean = new CateBean.ChildcatelistBean();
        childcatelistBean.setCccid(1);
        childcatelistBean.setIdx(1);
        childcatelistBean.setName("一年级");
        childcatelist.add(childcatelistBean);

        cateBean.setChildcatelist(childcatelist);
        cateBeanList.add(cateBean);


        FlowLayoutDialog flowLayoutDialog = new FlowLayoutDialog(this, cateBeanList);
        flowLayoutDialog.setChooseResultListenner(new FlowLayoutDialog.ChooseResultListenner() {
            @Override
            public void onChooseResult(String cateids) {
                Log.e("cateids", cateids);
            }
        });
        flowLayoutDialog.show();


    }
}
