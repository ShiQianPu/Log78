package alantam.com.log78.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import alantam.com.log78.R;
import alantam.com.log78.adapter.CartAdapter;
import alantam.com.log78.base.BaseFragment;
import alantam.com.log78.bean.OneBean;
import alantam.com.log78.mvp.IOneContract;
import alantam.com.log78.mvp.OnePresenter;

public class ThreeFragment extends BaseFragment implements IOneContract.IOneView {
    private IOneContract.IOnePresenter Cartpresenter;
    private RecyclerView cartRecyc;

    @Override
    protected void loadData() {
        Cartpresenter.fromList("http://172.17.8.100/small/commodity/v1/commodityList");
        Cartpresenter.fromtwoList("http://172.17.8.100/small/order/verify/v1/findShoppingCart");
    }

    @Override
    protected void initView(View view) {
        cartRecyc = view.findViewById(R.id.CartRecyc);
        view.findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_SHORT).show();
            }
        });
        cartRecyc.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        Cartpresenter = new OnePresenter();
        Cartpresenter.onAttach(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.three;
    }

    @Override
    public void showXbanner(String s) {

    }

    @Override
    public void showTwoList(String s) {

    }

    @Override
    public void showList(String s) {
        Gson gson = new Gson();
        OneBean oneBean = gson.fromJson(s, OneBean.class);
        List<OneBean.ResultBean.PzshBean.CommodityListBeanX> commodityListX = oneBean.getResult().getPzsh().getCommodityList();
        CartAdapter cartAdapter = new CartAdapter(getActivity(), commodityListX);
        cartRecyc.setAdapter(cartAdapter);
    }
}
