package alantam.com.log78.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import alantam.com.log78.R;

public class TwoHolder extends RecyclerView.ViewHolder {

    public ImageView twoimg;
    public TextView twottt;

    public TwoHolder(@NonNull View itemView) {
        super(itemView);
        twoimg = itemView.findViewById(R.id.twoimg);
        twottt = itemView.findViewById(R.id.twottt);
    }
}
