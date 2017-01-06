package cc.activity.activityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.functions.Action1;
import rx_activity_result.Result;
import rx_activity_result.RxActivityResult;

public class FirstActivity extends AppCompatActivity {
    Button btn_toSecond;
    TextView tvResult;
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_toSecond = (Button) findViewById(R.id.btn_toSecond);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btn_toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: go to second");
                
                RxActivityResult.on(FirstActivity.this)
                        .startIntent(new Intent(FirstActivity.this, SecondActivity.class))
                        .subscribe(new Action1<Result<FirstActivity>>() {
                            @Override
                            public void call(Result<FirstActivity> startActivityResult) {
                                Log.i(TAG, "call: get result from second activity");
                                if (startActivityResult.resultCode() == RESULT_OK) {
                                    tvResult.setText("Result OK");
                                } else {
                                    tvResult.setText("Result Cancel");
                                }
                            }
                        });
            }
        });
    }


    @Override
    protected void onPause() {
        Log.i(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: ");
        super.onResume();
    }
}
