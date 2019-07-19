package alantam.com.log78.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import alantam.com.log78.R;
import alantam.com.log78.adapter.FourAdapter;
import alantam.com.log78.base.BaseFragment;
import alantam.com.log78.bean.OneBean;
import alantam.com.log78.mvp.IOneContract;
import alantam.com.log78.mvp.OnePresenter;

public class FourFragment extends BaseFragment implements IOneContract.IOneView {
    private IOneContract.IOnePresenter fourpresenter;
    private Button zaicigoumai;
    private Button chakanwuliu;
    private Button woyaocuidaan;
    private RecyclerView fourRecyc;

    @Override
    protected void loadData() {
        fourpresenter.fromList("http://172.17.8.100/small/commodity/v1/commodityList");
      zaicigoumai.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toast.makeText(getActivity(), "返回购物车界面", Toast.LENGTH_SHORT).show();
          }
      });
    }

    @Override
    protected void initView(View view) {
        fourpresenter = new OnePresenter();
        fourpresenter.onAttach(this);
        fourRecyc = view.findViewById(R.id.fourRecyc);
        fourRecyc.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        zaicigoumai = view.findViewById(R.id.zaicigoumai);
        chakanwuliu = view.findViewById(R.id.chakanwuliu);
        woyaocuidaan = view.findViewById(R.id.woyaocuidan);
    }

    @Override
    protected int initLayout() {
        return R.layout.four;
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
        List<OneBean.ResultBean.RxxpBean.CommodityListBean> commodityList = oneBean.getResult().getRxxp().getCommodityList();
        FourAdapter fourAdapter = new FourAdapter(getActivity(), commodityList);
        fourRecyc.setAdapter(fourAdapter);
    }
}
