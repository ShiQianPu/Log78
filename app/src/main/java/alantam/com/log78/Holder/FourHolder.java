package alantam.com.log78.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import alantam.com.log78.R;

public class FourHolder extends RecyclerView.ViewHolder {

    public ImageView fourimg;
    public TextView fourttt;

    public FourHolder(@NonNull View itemView) {
        super(itemView);
        fourimg = itemView.findViewById(R.id.fourimg);
        fourttt = itemView.findViewById(R.id.fourttt);
    }
}
