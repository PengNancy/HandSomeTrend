package come.zbx.handsometrend.adapter;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import come.zbx.handsometrend.R;
import come.zbx.handsometrend.entity.Good;
import come.zbx.handsometrend.entity.GoodSize;

public class GoodSizeAdapter extends BaseQuickAdapter<GoodSize, BaseViewHolder> {

    public GoodSizeAdapter(@LayoutRes int layoutResId, @Nullable List<GoodSize> data){
        super(layoutResId,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodSize item) {
        //可链式调用赋值
        helper.setText(R.id.tv_goodsize, item.getGoodsize())
                .setText(R.id.tv_goodprice, item.getGoodprice());

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
