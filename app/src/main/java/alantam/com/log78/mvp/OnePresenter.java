package alantam.com.log78.mvp;

import alantam.com.log78.net.NetUtil;

public class OnePresenter implements IOneContract.IOnePresenter {
    private IOneContract.IOneView oneView;
    private IOneContract.IOneModel oneModel;

    @Override
    public void onAttach(IOneContract.IOneView view) {
        this.oneView = view;
        oneModel = new OneModel();
    }

    @Override
    public void onDeatch() {
       if (oneView!=null){
           oneView = null;
       }
        if (oneModel!=null){
            oneModel = null;
        }
    }
    @Override
    public void fromXbanner(String url) {
       oneModel.doHttpGet(url, new NetUtil.CallBackTask() {
           @Override
           public void onSuccess(String s) {
               oneView.showXbanner(s);
           }

           @Override
           public void onError() {

           }
       });
    }

    @Override
    public void fromList(String url) {
       oneModel.doHttpGet(url, new NetUtil.CallBackTask() {
           @Override
           public void onSuccess(String s) {
               oneView.showList(s);
           }

           @Override
           public void onError() {

           }
       });
    }

    @Override
    public void fromtwoList(String url) {
        oneModel.doHttpGet(url, new NetUtil.CallBackTask() {
            @Override
            public void onSuccess(String s) {
                oneView.showTwoList(s);
            }

            @Override
            public void onError() {

            }
        });
    }

}
