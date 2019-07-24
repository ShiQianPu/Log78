package alantam.com.log78.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import alantam.com.log78.activity.DizhiActivity;
import alantam.com.log78.R;
import alantam.com.log78.base.BaseFragment;

public class FiveFragment extends BaseFragment {
    @Override
    protected void loadData() {

    }

    @Override
    protected void initView(View view) {
         view.findViewById(R.id.fivetext).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getActivity(), "请先登录，如无账号请先注册", Toast.LENGTH_SHORT).show();
             }
         });
         view.findViewById(R.id.daishouhuo).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getActivity(), FourFragment.class);
                 startActivity(intent);
             }
         });
         view.findViewById(R.id.daifukuan).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getActivity(), "无待付款的商品", Toast.LENGTH_SHORT).show();
             }
         });
         view.findViewById(R.id.daipingjia).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getActivity(), "购买商品后可评价", Toast.LENGTH_SHORT).show();
             }
         });
         view.findViewById(R.id.wodedingdan).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getActivity(), "我的订单没有商品", Toast.LENGTH_SHORT).show();
             }
         });
         view.findViewById(R.id.shouhuodizhitext).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getActivity(),DizhiActivity.class);
                 startActivity(intent);
             }
         });
         view.findViewById(R.id.mypay).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //点击我的钱包可以查看余额，余额支付
                 Toast.makeText(getActivity(), "余额", Toast.LENGTH_SHORT).show();
             }
         });
    }

    @Override
    protected int initLayout() {
        return R.layout.five;
    }
}
