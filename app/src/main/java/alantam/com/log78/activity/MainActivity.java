package alantam.com.log78.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import alantam.com.log78.R;
import alantam.com.log78.fragment.FiveFragment;
import alantam.com.log78.fragment.FourFragment;
import alantam.com.log78.fragment.OneFragment;
import alantam.com.log78.fragment.ThreeFragment;
import alantam.com.log78.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager vip;
    private RadioGroup rg;
    private List<Fragment> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vip = findViewById(R.id.vip);
        rg = findViewById(R.id.rg);

        list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        list.add(new FourFragment());
        list.add(new FiveFragment());

        vip.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vip.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        rg.check(R.id.bt1);
                        break;
                    case 1:
                        rg.check(R.id.bt2);
                        break;
                    case 2:
                        rg.check(R.id.bt3);
                        break;
                    case 3:
                        rg.check(R.id.bt4);
                        break;
                    case 4:
                        rg.check(R.id.bt5);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.bt1:
                        vip.setCurrentItem(0);
                        break;
                    case R.id.bt2:
                        vip.setCurrentItem(1);
                        break;
                    case R.id.bt3:
                        vip.setCurrentItem(2);
                        break;
                    case R.id.bt4:
                        vip.setCurrentItem(3);
                        break;
                    case R.id.bt5:
                        vip.setCurrentItem(4);
                        break;
                }
            }
        });
    }
}
