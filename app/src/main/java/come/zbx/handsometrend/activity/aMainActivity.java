package come.zbx.handsometrend.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import come.zbx.handsometrend.R;
import come.zbx.handsometrend.adapter.HomeFragmentPagerAdapter;
import come.zbx.handsometrend.fragment.aFragment;
import come.zbx.handsometrend.fragment.bFragment;
import come.zbx.handsometrend.fragment.cFragment;
import come.zbx.handsometrend.fragment.dFragment;
import come.zbx.handsometrend.view.ViewPagerFixed;

public class aMainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.vpContent)
    ViewPagerFixed mVpContent;

    private List<Fragment> mFragmentList = new ArrayList<>(4);

    private aFragment fristFragment;
    private bFragment secondFragment;
    private cFragment threeFragment;
    private dFragment fourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_a);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //设置ViewPager的最大缓存页面
        mVpContent.setOffscreenPageLimit(3);

        fristFragment = new aFragment();
        secondFragment = new bFragment();
        threeFragment = new cFragment();
        fourFragment = new dFragment();
        mFragmentList.add(fristFragment);
        mFragmentList.add(secondFragment);
        mFragmentList.add(threeFragment);
        mFragmentList.add(fourFragment);
        mVpContent.setAdapter(new HomeFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList));
        mVpContent.setOnPageChangeListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bm_home:
                    mVpContent.setCurrentItem(0);
                    break;
                case R.id.bm_sell:
                    mVpContent.setCurrentItem(1);
                    break;
                case R.id.bm_msg:
                    mVpContent.setCurrentItem(2);
                    break;
                case R.id.bm_my:
                    mVpContent.setCurrentItem(3);
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.bm_home);
                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.bm_sell);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.bm_msg);
                break;
            case 3:
                bottomNavigationView.setSelectedItemId(R.id.bm_my);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
