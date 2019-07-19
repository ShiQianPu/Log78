package alantam.com.log78.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import alantam.com.log78.Holder.Cartholder;
import alantam.com.log78.R;
import alantam.com.log78.bean.OneBean;

public class CartAdapter extends RecyclerView.Adapter<Cartholder> {
    private Context context;
    private List<OneBean.ResultBean.PzshBean.CommodityListBeanX> pzshdatas;

    public CartAdapter(Context context, List<OneBean.ResultBean.PzshBean.CommodityListBeanX> pzshdatas) {
        this.context = context;
        this.pzshdatas = pzshdatas;
    }

    @NonNull
    @Override
    public Cartholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new Cartholder(inflater.inflate(R.layout.cartitem,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Cartholder cartholder, int i) {
       cartholder.cartttt.setText(pzshdatas.get(i).getCommodityName());
        Glide.with(context).load(pzshdatas.get(i).getMasterPic()).into(cartholder.cartimg);
    }

    @Override
    public int getItemCount() {
        return pzshdatas.size();
    }
}
