package com.frxs.order;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.MaterialHeader;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;

/**
 * Created by ewu on 2016/3/11.
 */
public abstract class MaterialStyleActivity extends FrxsActivity {

    protected PtrFrameLayout mPtrFrameLayout;

    @Override
    protected void initViews() {

        mPtrFrameLayout = (PtrFrameLayout)findViewById(getPtrFrameLayoutId());
        // header
        final MaterialHeader header = new MaterialHeader(this);
        int[] colors = getResources().getIntArray(R.array.google_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, PtrLocalDisplay.dp2px(50), 0, PtrLocalDisplay.dp2px(10));
        header.setPtrFrameLayout(mPtrFrameLayout);

        mPtrFrameLayout.setLoadingMinTime(1000);
        mPtrFrameLayout.setDurationToCloseHeader(1500);
        mPtrFrameLayout.setHeaderView(header);
        mPtrFrameLayout.addPtrUIHandler(header);
        mPtrFrameLayout.autoRefresh(true);
    }

    protected void refreshComplete()
    {
        if (null != mPtrFrameLayout && mPtrFrameLayout.isRefreshing()) {
            mPtrFrameLayout.refreshComplete();
        }
    }

    public abstract int getPtrFrameLayoutId();
}
