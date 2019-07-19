package alantam.com.log78.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import alantam.com.log78.Holder.FourHolder;
import alantam.com.log78.Holder.TwoHolder;
import alantam.com.log78.R;
import alantam.com.log78.bean.OneBean;

public class FourAdapter extends RecyclerView.Adapter<FourHolder> {
    private Context context;
    private List<OneBean.ResultBean.RxxpBean.CommodityListBean> fourdatas;

    public FourAdapter(Context context, List<OneBean.ResultBean.RxxpBean.CommodityListBean> fourdatas) {
        this.context = context;
        this.fourdatas = fourdatas;
    }

    @NonNull
    @Override
    public FourHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new FourHolder(inflater.inflate(R.layout.fouritem,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FourHolder fourHolder, int i) {
        Glide.with(context).load(fourdatas.get(i).getMasterPic()).into(fourHolder.fourimg);
        fourHolder.fourttt.setText(fourdatas.get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return fourdatas.size();
    }
}
