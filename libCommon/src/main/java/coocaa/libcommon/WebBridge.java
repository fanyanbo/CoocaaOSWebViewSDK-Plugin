package coocaa.libcommon;

public class WebBridge {

    public interface IWebPageListener{
        void onPageStarted(String url);
        void onPageFinished(String url);
        void onProgressChanged(int newValue);
    }

    public interface IWebPlugin{

        void setListener(IWebPageListener listener);
    }
}
