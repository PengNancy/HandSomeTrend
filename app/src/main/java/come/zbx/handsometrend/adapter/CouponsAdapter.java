package come.zbx.handsometrend.adapter;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import come.zbx.handsometrend.R;
import come.zbx.handsometrend.entity.Coupons;

public class CouponsAdapter extends BaseQuickAdapter<Coupons, BaseViewHolder> {

    public CouponsAdapter(@LayoutRes int layoutResId, @Nullable List<Coupons> data){
        super(layoutResId,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Coupons item) {
        //可链式调用赋值
        helper.setText(R.id.tv_pons, item.getPon());

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
