package alantam.com.log78.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import alantam.com.log78.activity.DizhiActivity;
import alantam.com.log78.R;
import alantam.com.log78.adapter.TwoShowAdapter;
import alantam.com.log78.base.BaseFragment;
import alantam.com.log78.bean.OneBean;
import alantam.com.log78.bean.XbannerBean;
import alantam.com.log78.mvp.IOneContract;
import alantam.com.log78.mvp.OnePresenter;

public class TwoFragment extends BaseFragment implements IOneContract.IOneView {
    private IOneContract.IOnePresenter twopresenter;
    private XBanner twoBanner;
    private List<XbannerBean.ResultBean> result1;
    private RecyclerView twoshowRecyc;
    private Button buybtn;

    @Override
    protected void loadData() {
          twopresenter.fromXbanner("http://172.17.8.100/small/commodity/v1/bannerShow");
          twopresenter.fromList("http://172.17.8.100/small/commodity/v1/commodityList");
    }

    @Override
    protected void initView(View view) {
        twoBanner = view.findViewById(R.id.twobanner);
        view.findViewById(R.id.xzshouhuodizhi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), DizhiActivity.class);
                startActivity(intent1);
            }
        });
        buybtn = view.findViewById(R.id.buy_btn);
        buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "去结算", Toast.LENGTH_SHORT).show();
            }
        });
        twoshowRecyc = view.findViewById(R.id.twoshowrecyc);
        twoshowRecyc.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        twopresenter = new OnePresenter();
        twopresenter.onAttach(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.two;
    }

    @Override
    public void showXbanner(String s) {
        Gson gson = new Gson();
        XbannerBean xbannerBean = gson.fromJson(s, XbannerBean.class);
        result1 = xbannerBean.getResult();
        twoBanner.setBannerData(result1);
        twoBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(result1.get(position).getImageUrl()).into((ImageView)view);
            }
        });

    }

    @Override
    public void showTwoList(String s) {

    }

    @Override
    public void showList(String s) {
        Gson gson = new Gson();
        OneBean oneBean = gson.fromJson(s, OneBean.class);
        List<OneBean.ResultBean.RxxpBean.CommodityListBean> commodityList = oneBean.getResult().getRxxp().getCommodityList();
        TwoShowAdapter twoShowAdapter = new TwoShowAdapter(getActivity(), commodityList);
        twoshowRecyc.setAdapter(twoShowAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        twopresenter.onDeatch();
    }
}
