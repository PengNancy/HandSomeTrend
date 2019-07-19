package come.zbx.handsometrend.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import come.zbx.handsometrend.R;
import come.zbx.handsometrend.adapter.GoodAdapter;
import come.zbx.handsometrend.entity.Good;

public class TheSellerMoreGoodActivity extends BaseActivity{
    
    @BindView(R.id.recycler_moregood)
    RecyclerView recycler_moregood;


    private GoodAdapter goodAdapter;
    private List<Good> goods;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_sellermoregood);
        ButterKnife.bind(this);
        init();
    }
    
    private void init(){
        MakeData();
        //创建布局管理
        recycler_moregood.setLayoutManager(new GridLayoutManager(this, 2));
        //创建适配器
        goodAdapter = new GoodAdapter(R.layout.item_good, goods);
        //给RecyclerView设置适配器
        recycler_moregood.setAdapter(goodAdapter);
    }
    
    private void MakeData(){
        goods=new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Good c = new Good();
            c.setTv_title("名字太长展示不下了只展示两行剩下的用3个点代替名字太长展示不下了只展示两行剩下的用3个点代替");
            c.setPrice("$999");
            c.setBuy_peoplenumber("777人已购买");
            c.setImg_url("");
            goods.add(c);
        }
    }
}
