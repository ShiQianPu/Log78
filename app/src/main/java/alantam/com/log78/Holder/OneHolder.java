package alantam.com.log78.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import alantam.com.log78.R;

public class OneHolder extends RecyclerView.ViewHolder {

    public ImageView img;
    public TextView ttt;

    public OneHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        ttt = itemView.findViewById(R.id.ttt);
    }
}
