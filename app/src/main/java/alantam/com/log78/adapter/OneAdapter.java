package alantam.com.log78.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import alantam.com.log78.Holder.OneHolder;
import alantam.com.log78.R;
import alantam.com.log78.bean.OneBean;

public class OneAdapter extends RecyclerView.Adapter<OneHolder> {
    private Context context;
    private List<OneBean.ResultBean.RxxpBean.CommodityListBean> rxxpdatas;

    public OneAdapter(Context context, List<OneBean.ResultBean.RxxpBean.CommodityListBean> rxxpdatas) {
        this.context = context;
        this.rxxpdatas = rxxpdatas;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new OneHolder(inflater.inflate(R.layout.item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder oneHolder, int i) {
        Glide.with(context).load(rxxpdatas.get(i).getMasterPic()).into(oneHolder.img);
        oneHolder.ttt.setText(rxxpdatas.get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return rxxpdatas.size();
    }
}
