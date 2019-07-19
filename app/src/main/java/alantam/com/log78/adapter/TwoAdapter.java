package alantam.com.log78.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import alantam.com.log78.Holder.TwoHolder;
import alantam.com.log78.R;
import alantam.com.log78.bean.OneBean;

public class TwoAdapter extends RecyclerView.Adapter<TwoHolder> {
    private Context context;
    private List<OneBean.ResultBean.MlssBean.CommodityListBeanXX> mlssdatas;

    public TwoAdapter(Context context, List<OneBean.ResultBean.MlssBean.CommodityListBeanXX> mlssdatas) {
        this.context = context;
        this.mlssdatas = mlssdatas;
    }

    @NonNull
    @Override
    public TwoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new TwoHolder(inflater.inflate(R.layout.twoitem,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TwoHolder twoHolder, int i) {
        Glide.with(context).load(mlssdatas.get(i).getMasterPic()).into(twoHolder.twoimg);
        twoHolder.twottt.setText(mlssdatas.get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return mlssdatas.size();
    }
}
