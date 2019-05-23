package com.lzy.flowlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by xiangcheng on 17/9/26.
 */

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = ProductAdapter.class.getSimpleName();
    private List<CateBean> cateBeanList;
    private Context context;

    public ProductAdapter(Context context, List<CateBean> cateBeanList) {
        this.context = context;
        this.cateBeanList = cateBeanList;
    }

    public String getSelectedCateIds() {
        String cateids = "";
        for (int i = 0; i < cateBeanList.size(); i++) {
            CateBean cateBean = cateBeanList.get(i);

            for (CateBean.ChildcatelistBean childcatelistBean : cateBean.getChildcatelist())
                if (childcatelistBean.isSelect()) {
                    cateids += cateBean.getCcid() + ":" + childcatelistBean.getCccid() + ",";
                    Log.d("isel", childcatelistBean.getName() + "");
                }
        }
        cateids = cateids.substring(0, cateids.length() - 1);
        return cateids;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductHolder(View.inflate(context, R.layout.product_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ProductHolder productHolder = (ProductHolder) holder;
        CateBean cateBean = cateBeanList.get(position);

        final FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        productHolder.title.setText(cateBean.getName());
        if (productHolder.itemView.getTag() == null) {
            productHolder.des.addItemDecoration(new SpaceItemDecoration(dp2px(7)));
            productHolder.itemView.setTag("item");
        }
//        productHolder.des.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        productHolder.des.setLayoutManager(flowLayoutManager);
        FlowAdapter flowAdapter = new FlowAdapter(cateBean.getChildcatelist());
        productHolder.des.setAdapter(flowAdapter);
    }

    public String getTitle(int position) {
        return cateBeanList.get(position).getName();
    }

    @Override
    public int getItemCount() {
        return cateBeanList.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private RecyclerView des;

        public ProductHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            des = (RecyclerView) itemView.findViewById(R.id.des);
        }
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<CateBean.ChildcatelistBean> childcatelistBeanList;


        private CateBean.ChildcatelistBean selectCate;

        public FlowAdapter(List<CateBean.ChildcatelistBean> childcatelistBeanList) {
            this.childcatelistBeanList = childcatelistBeanList;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(context, R.layout.flow_item, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            TextView textView = ((MyHolder) holder).text;

            final CateBean.ChildcatelistBean childcatelistBean = childcatelistBeanList.get(position);
            if (childcatelistBean.isSelect()) {
                textView.setTextColor(context.getResources().getColor(R.color.text_select_color));
                textView.setBackground(context.getResources().getDrawable(R.drawable.product_item_select_back));
            } else {
                textView.setTextColor(context.getResources().getColor(R.color.text_normal_color));
                textView.setBackground(context.getResources().getDrawable(R.drawable.product_item_back));
            }
            textView.setText(childcatelistBean.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (childcatelistBean != selectCate) {
                        if (selectCate != null) {
                            selectCate.setSelect(false);
                        }
                    }
                    childcatelistBean.setSelect(true);
                    selectCate = childcatelistBean;
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return childcatelistBeanList.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            private TextView text;

            public MyHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.flow_text);
            }
        }

        public CateBean.ChildcatelistBean getSelectCate() {
            return selectCate;
        }
    }


    private int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }
}
