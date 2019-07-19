package alantam.com.log78.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import alantam.com.log78.R;
import alantam.com.log78.adapter.OneAdapter;
import alantam.com.log78.adapter.TwoAdapter;
import alantam.com.log78.base.BaseFragment;
import alantam.com.log78.bean.OneBean;
import alantam.com.log78.bean.XbannerBean;
import alantam.com.log78.mvp.IOneContract;
import alantam.com.log78.mvp.OnePresenter;

public class OneFragment extends BaseFragment implements IOneContract.IOneView {
private IOneContract.IOnePresenter onePresenter;
    private XBanner xBanner;
    private List<XbannerBean.ResultBean> result;
    private RecyclerView recyc;
    private RecyclerView tworecyclerView;

    @Override
    protected void loadData() {
       onePresenter.fromXbanner("http://172.17.8.100/small/commodity/v1/bannerShow");
       onePresenter.fromList("http://172.17.8.100/small/commodity/v1/commodityList");
       onePresenter.fromtwoList("http://172.17.8.100/small/commodity/v1/commodityList");
    }

    @Override
    protected void initView(View view) {
        xBanner = view.findViewById(R.id.xbanner);
        recyc = view.findViewById(R.id.Recyc);
        tworecyclerView = view.findViewById(R.id.twoRecyc);
        recyc.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        tworecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        onePresenter = new OnePresenter();
        onePresenter.onAttach(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.one;
    }

    @Override
    public void showXbanner(String s) {
        Gson gson = new Gson();
        XbannerBean xbannerBean = gson.fromJson(s, XbannerBean.class);
        result = xbannerBean.getResult();
        xBanner.setBannerData(result);
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(result.get(position).getImageUrl()).into((ImageView)view);
            }
        });
    }

    @Override
    public void showTwoList(String s) {
        Gson gson = new Gson();
        OneBean oneBean = gson.fromJson(s, OneBean.class);
        List<OneBean.ResultBean.MlssBean.CommodityListBeanXX> commodityListxx = oneBean.getResult().getMlss().getCommodityList();
        TwoAdapter twoAdapter = new TwoAdapter(getActivity(), commodityListxx);
        tworecyclerView.setAdapter(twoAdapter);
    }

    @Override
    public void showList(String s) {
      Gson gson = new Gson();
        OneBean oneBean = gson.fromJson(s, OneBean.class);
        List<OneBean.ResultBean.RxxpBean.CommodityListBean> commodityList = oneBean.getResult().getRxxp().getCommodityList();
        OneAdapter oneAdapter = new OneAdapter(getActivity(), commodityList);
        recyc.setAdapter(oneAdapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onePresenter.onDeatch();
    }
}
