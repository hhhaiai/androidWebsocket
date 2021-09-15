package me.hhhaiai.ws.ui;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import me.hhhaiai.ws.client.demo.TestWs;
import me.hhhaiai.ws.utils.ClazzUtils;
import me.hhhaiai.ws.utils.Logs;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Activity mContext;

    private CRelativeLayout mLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        mContext = this;
        mLayout = new CRelativeLayout(this, this, 4, 3);
        setContentView(mLayout);
    }

    private void processOnclick(View view) {
        switch (view.getId()) {
            case 1:
                TestWs.connect(mContext);
                break;
            case 2:
                TestWs.sendMsg(mContext);
                break;
            case 3:
                TestWs.disconnect(mContext);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        new Thread(() -> {
            try {
                Logs.d(TAG,"you click Item ---->(" + view.toString() + ")[ "
                        + ClazzUtils.invokeObjectMethod(view, "getIterableTextForAccessibility")
                        + " ]<" + view.getId() + "><----");
                processOnclick(view);
            } catch (Throwable e) {
                Logs.e(TAG, Log.getStackTraceString(e));
            }
        }).start();
    }


}