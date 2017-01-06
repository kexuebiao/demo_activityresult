package cc.activity.activityresult;

import android.app.Application;

import rx_activity_result.RxActivityResult;

/**
 * Created by kexuebiao on 2017/1/6.
 */

public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RxActivityResult.register(this);
    }
}
