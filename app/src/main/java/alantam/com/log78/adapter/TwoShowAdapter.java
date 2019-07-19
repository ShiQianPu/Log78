package alantam.com.log78.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import alantam.com.log78.Holder.TwoHolder;
import alantam.com.log78.Holder.TwoShowHolder;
import alantam.com.log78.R;
import alantam.com.log78.bean.OneBean;

public class TwoShowAdapter extends RecyclerView.Adapter<TwoShowHolder> {
    private Context context;
    private List<OneBean.ResultBean.RxxpBean.CommodityListBean> twoshowdatas;

    public TwoShowAdapter(Context context, List<OneBean.ResultBean.RxxpBean.CommodityListBean> twoshowdatas) {
        this.context = context;
        this.twoshowdatas = twoshowdatas;
    }

    @NonNull
    @Override
    public TwoShowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new TwoShowHolder(inflater.inflate(R.layout.twoshowitem,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TwoShowHolder twoShowHolder, int i) {
        Glide.with(context).load(twoshowdatas.get(i).getMasterPic()).into(twoShowHolder.twoimg);
        twoShowHolder.twottt.setText(twoshowdatas.get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return twoshowdatas.size();
    }
}
