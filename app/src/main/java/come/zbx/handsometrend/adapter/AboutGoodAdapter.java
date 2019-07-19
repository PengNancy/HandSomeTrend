package come.zbx.handsometrend.adapter;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import come.zbx.handsometrend.R;
import come.zbx.handsometrend.entity.Good;

public class AboutGoodAdapter extends BaseQuickAdapter<Good, BaseViewHolder> {

    public AboutGoodAdapter(@LayoutRes int layoutResId, @Nullable List<Good> data){
        super(layoutResId,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Good item) {
        //可链式调用赋值
        helper.setText(R.id.good_title, item.getTv_title())
                .setText(R.id.good_price, item.getPrice())
                .setImageResource(R.id.good_img, R.mipmap.classify_one);

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
