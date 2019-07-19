package alantam.com.log78.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        bindView();
        loadData();
    }

    protected abstract void bindView();

    protected abstract void loadData();

    protected abstract int initLayout();
}
