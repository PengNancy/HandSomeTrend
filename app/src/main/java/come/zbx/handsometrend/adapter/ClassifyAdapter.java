package come.zbx.handsometrend.adapter;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import come.zbx.handsometrend.R;
import come.zbx.handsometrend.entity.Classify;

public class ClassifyAdapter extends BaseQuickAdapter<Classify, BaseViewHolder> {

    public ClassifyAdapter(@LayoutRes int layoutResId, @Nullable List<Classify> data){
        super(layoutResId,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Classify item) {
        //可链式调用赋值
        helper.setText(R.id.cls_title, item.getTv_title())
                .setImageResource(R.id.cls_img, R.mipmap.classify_one);

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
