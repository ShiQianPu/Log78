package alantam.com.log78.mvp;

import alantam.com.log78.net.NetUtil;

public interface IOneContract {
    public interface IOneView{
        void showXbanner(String s);
        void showTwoList(String s);
        void showList(String s);
    }
    public interface IOneModel{
       void doHttpGet(String url, NetUtil.CallBackTask backTask);
    }
    public interface IOnePresenter{
      void fromXbanner(String url);
      void fromList(String url);
      void fromtwoList(String url);

      void onAttach(IOneView view);
      void onDeatch();
    }
}
