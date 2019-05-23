package com.lzy.flowlayout;

import java.util.List;

/**
 * Created by xiangcheng on 17/9/26.
 */

public class CateBean {
    /**
     * ccid : 1
     * name : 颜色
     * childcatelist : [{"name":"红","idx":1,"cccid":1},{"name":"黄","idx":2,"cccid":2}]
     * idx : 1
     */

    private int ccid;
    private String name;
    private int idx;
    private List<ChildcatelistBean> childcatelist;

    public int getCcid() {
        return ccid;
    }

    public void setCcid(int ccid) {
        this.ccid = ccid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public List<ChildcatelistBean> getChildcatelist() {
        return childcatelist;
    }

    public void setChildcatelist(List<ChildcatelistBean> childcatelist) {
        this.childcatelist = childcatelist;
    }

    public static class ChildcatelistBean {
        /**
         * name : 红
         * idx : 1
         * cccid : 1
         */

        private String name;
        private int idx;
        private int cccid;
        private boolean isSelect;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getCccid() {
            return cccid;
        }

        public void setCccid(int cccid) {
            this.cccid = cccid;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }
    }
}
