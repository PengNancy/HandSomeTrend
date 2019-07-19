package come.zbx.handsometrend.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import come.zbx.handsometrend.R;
import come.zbx.handsometrend.activity.AllTypeActivity;
import come.zbx.handsometrend.activity.GoodDetailActivity;
import come.zbx.handsometrend.adapter.ClassifyAdapter;
import come.zbx.handsometrend.adapter.GoodAdapter;
import come.zbx.handsometrend.entity.Classify;
import come.zbx.handsometrend.entity.Good;

public class aFragment extends Fragment {


    @BindView(R.id.recycler_classify)
    RecyclerView recycler_classify;
    @BindView(R.id.recycler_goods)
    RecyclerView recycler_goods;

    private View view;
    private ClassifyAdapter myadapter;
    private GoodAdapter adapter;
    private List<Classify> datas;
    private List<Good> lists;

    final private String TGA="aFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = View.inflate(getActivity(), R.layout.fragment_a, null);
            ButterKnife.bind(this, view);
            init();
        }
        return view;
    }


    private void init(){
        datas=new ArrayList<>();
        lists=new ArrayList<>();
        MakeDatas();
        //创建布局管理
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_classify.setLayoutManager(new GridLayoutManager(getActivity(),4));
        //创建适配器
        myadapter = new ClassifyAdapter(R.layout.item_classify, datas);
        //给RecyclerView设置适配器
        recycler_classify.setAdapter(myadapter);

        myadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(),"点击了第"+position+"个",Toast.LENGTH_SHORT).show();
                Intent it=new Intent(getActivity(), GoodDetailActivity.class);
                startActivity(it);
            }
        });


        recycler_goods.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter=new GoodAdapter(R.layout.item_good,lists);
        recycler_goods.setAdapter(adapter);
    }

    private void MakeDatas(){
        for (int i = 0; i <8 ; i++) {
            Classify cy=new Classify();
            cy.setTv_title("NIKE");
            cy.setImg_url("");
            datas.add(cy);
        }


        for (int i = 0; i <20 ; i++) {
            Good gd=new Good();
            gd.setTv_title("名字太长展示不下了只展示两行剩下的用3个点代替名字太长展示不下了只展示两行剩下的用3个点代替");
            gd.setPrice("$999");
            gd.setBuy_peoplenumber("666人已购买");
            gd.setImg_url("");
            lists.add(gd);
        }
    }

    @OnClick({R.id.layout_all})
    public void OnViewClick(View view) {
        switch (view.getId()) {
            case R.id.layout_all:
               Intent it=new Intent(getActivity(), AllTypeActivity.class);
               startActivity(it);
                break;

        }
    }
}
