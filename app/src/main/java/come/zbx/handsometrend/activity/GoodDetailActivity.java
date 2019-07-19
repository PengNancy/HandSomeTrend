package come.zbx.handsometrend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.PopupWindow;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codingending.popuplayout.PopupLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import come.zbx.handsometrend.R;
import come.zbx.handsometrend.adapter.AboutGoodAdapter;
import come.zbx.handsometrend.adapter.CouponsAdapter;
import come.zbx.handsometrend.adapter.GoodAdapter;
import come.zbx.handsometrend.adapter.GoodSizeAdapter;
import come.zbx.handsometrend.entity.Coupons;
import come.zbx.handsometrend.entity.Good;
import come.zbx.handsometrend.entity.GoodSize;
import come.zbx.handsometrend.utils.SharePopDialogUtil;

public class GoodDetailActivity extends BaseActivity {

    @BindView(R.id.recycler_coupons)
    RecyclerView recycler_coupons;
    @BindView(R.id.recycler_aboutgoods)
    RecyclerView recycler_aboutgoods;
    @BindView(R.id.recycler_recom)
    RecyclerView recycler_recom;


    private CouponsAdapter adapter;
    private List<Coupons> datas;
    private AboutGoodAdapter myadapter;
    private List<Good> lists;
    private GoodAdapter goodAdapter;
    private List<Good> goods;
    private GoodSizeAdapter gzadapter;
    private List<GoodSize> gzs;
    private RecyclerView recycler_goodsize;


    private PopupWindow popupWindow;

    private View popupView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        MakeData();
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_coupons.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new CouponsAdapter(R.layout.item_coupons, datas);
        //给RecyclerView设置适配器
        recycler_coupons.setAdapter(adapter);

        //创建布局管理
        recycler_aboutgoods.setLayoutManager(new GridLayoutManager(this, 3));
        //创建适配器
        myadapter = new AboutGoodAdapter(R.layout.item_aboutgood, lists);
        //给RecyclerView设置适配器
        recycler_aboutgoods.setAdapter(myadapter);

        //创建布局管理
        recycler_recom.setLayoutManager(new GridLayoutManager(this, 2));
        //创建适配器
        goodAdapter = new GoodAdapter(R.layout.item_good, goods);
        //给RecyclerView设置适配器
        recycler_recom.setAdapter(goodAdapter);


    }

    private void MakeData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Coupons c = new Coupons();
            c.setPon("满999减少99");
            datas.add(c);
        }

        lists = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Good c = new Good();
            c.setTv_title("名字太长展示不下了只展示两行剩下的用3个点代替名字太长展示不下了只展示两行剩下的用3个点代替");
            c.setPrice("$999");
            c.setImg_url("");
            lists.add(c);
        }

        goods = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Good c = new Good();
            c.setTv_title("名字太长展示不下了只展示两行剩下的用3个点代替名字太长展示不下了只展示两行剩下的用3个点代替");
            c.setPrice("$999");
            c.setBuy_peoplenumber("777人已购买");
            c.setImg_url("");
            goods.add(c);
        }

        gzs = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            GoodSize gdsize = new GoodSize();
            gdsize.setGoodsize("42");
            gdsize.setGoodprice("￥4242");
            gzs.add(gdsize);
        }
//        for (int i = 0; i < 8; i++) {
//            GoodSize gdsize = new GoodSize();
//            gdsize.setGoodsize("43");
//            gdsize.setGoodprice("￥4343");
//            gzs.add(gdsize);
//        }
    }


    @OnClick({R.id.layout_theseller_moregood, R.id.layout_selectsize, R.id.img_share})
    public void OnViewClick(View view) {
        switch (view.getId()) {
            case R.id.layout_theseller_moregood:
                Intent it = new Intent(this, TheSellerMoreGoodActivity.class);
                startActivity(it);
                break;
            case R.id.img_share:
                SharePopDialogUtil popDialog = new SharePopDialogUtil();
                popDialog.showDialog(GoodDetailActivity.this);
                break;

            case R.id.layout_selectsize:
                initpopuwindow();
                popupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 0);
                break;
        }
    }

    private void initpopuwindow() {
        popupView = View.inflate(this, R.layout.window_goodsize, null);
        popupWindow = new PopupWindow(popupView, GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT);
        //设置popupWindow中的item可以被点击，这句话是必须要添加的
        popupWindow.setFocusable(true);
        recycler_goodsize = popupView.findViewById(R.id.recycler_goodsize);
        //创建布局管理
        recycler_goodsize.setLayoutManager(new GridLayoutManager(this, 4));
        //创建适配器
        gzadapter = new GoodSizeAdapter(R.layout.item_goodsize, gzs);
        //给RecyclerView设置适配器
        recycler_goodsize.setAdapter(gzadapter);
//        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
//        popupView.findViewById(R.id.text_cancel).setOnClickListener(v -> {
//            popupWindow.dismiss();
//        });
    }


}
