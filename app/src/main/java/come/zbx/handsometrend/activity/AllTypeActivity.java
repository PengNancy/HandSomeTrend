package come.zbx.handsometrend.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import come.zbx.handsometrend.R;
import come.zbx.handsometrend.adapter.ClassifyAdapter;
import come.zbx.handsometrend.adapter.CouponsAdapter;
import come.zbx.handsometrend.entity.Classify;
import come.zbx.handsometrend.entity.Coupons;

public class AllTypeActivity extends BaseActivity{

    @BindView(R.id.recycler_typename)
    RecyclerView recycler_typename;

    @BindView(R.id.recycler_typedetail)
    RecyclerView recycler_typedetail;

    private CouponsAdapter adapter;
    private List<Coupons> datas;


    private ClassifyAdapter myadapter;
    private List<Classify> lists;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_alltype);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        MakeData();
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_typename.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new CouponsAdapter(R.layout.item_typename, datas);
        //给RecyclerView设置适配器
        recycler_typename.setAdapter(adapter);

        //创建布局管理
        recycler_typedetail.setLayoutManager(new GridLayoutManager(this, 3));
        //创建适配器
        myadapter = new ClassifyAdapter(R.layout.item_typedetail, lists);
        //给RecyclerView设置适配器
        recycler_typedetail.setAdapter(myadapter);
    }


    private void MakeData(){
        datas = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Coupons c = new Coupons();
            c.setPon("休闲");
            datas.add(c);
        }

        lists = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Classify cy=new Classify();
            cy.setTv_title("NIKE");
            cy.setImg_url("");
            lists.add(cy);
        }

    }


}
