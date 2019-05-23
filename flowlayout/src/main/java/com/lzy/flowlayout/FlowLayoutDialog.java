package com.lzy.flowlayout;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

public class FlowLayoutDialog extends AlertDialog {
    private Context context;
    private List<CateBean> cateBeanList;
    private ProductAdapter productAdapter;
    private ChooseResultListenner chooseResultListenner;

    public FlowLayoutDialog(Context context, List<CateBean> cateBeanList) {
        super(context);
        this.context = context;
        this.cateBeanList = cateBeanList;
    }

    protected FlowLayoutDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected FlowLayoutDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_flow_layout, null);
        setContentView(view);
        setCancelable(true);
        setCanceledOnTouchOutside(true);

        view.findViewById(R.id.ll_buttom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cateIds = productAdapter.getSelectedCateIds();
                chooseResultListenner.onChooseResult(cateIds);
            }
        });

        Window window = this.getWindow();
        window.setBackgroundDrawableResource(R.color.gray);
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = dp2px(375);
        window.setAttributes(params);

        RecyclerView productView = (RecyclerView) findViewById(R.id.product_view);
        productView.setLayoutManager(new LinearLayoutManager(context));
        productAdapter = new ProductAdapter(context, cateBeanList);
        productView.setAdapter(productAdapter);

    }

    private int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    public void setChooseResultListenner(ChooseResultListenner chooseResultListenner) {
        this.chooseResultListenner = chooseResultListenner;
    }

    public interface ChooseResultListenner {
        void onChooseResult(String cateids);
    }
}
