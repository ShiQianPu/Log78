package alantam.com.log78.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import alantam.com.log78.R;

public class Cartholder extends RecyclerView.ViewHolder {

    public CheckBox checkBox;
    public ImageView cartimg;
    public TextView cartttt;

    public Cartholder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.check);
        cartimg = itemView.findViewById(R.id.cartimg);
        cartttt = itemView.findViewById(R.id.cartttt);
    }
}
