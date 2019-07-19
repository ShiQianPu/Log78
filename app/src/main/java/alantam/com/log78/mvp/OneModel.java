package alantam.com.log78.mvp;

import alantam.com.log78.net.NetUtil;

public class OneModel implements IOneContract.IOneModel {
    private NetUtil util;

    public OneModel() {
        util = NetUtil.getInstance();
    }

    @Override
    public void doHttpGet(String url, NetUtil.CallBackTask backTask) {
        util.doHttpGet(url,backTask);
    }
}
