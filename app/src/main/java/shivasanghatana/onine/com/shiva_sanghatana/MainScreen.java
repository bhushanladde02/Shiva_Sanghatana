package shivasanghatana.onine.com.shiva_sanghatana;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TextView;

import shivasanghatana.onine.com.shiva_sanghatana.R;

/*
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AppEventListener;
import com.google.ads.doubleclick.DfpAdView;*/


public class MainScreen extends Activity implements View.OnClickListener/*,
        AdListener, AppEventListener*/{
    Context context;
    int flag=0;
    String tabValue="";
    int fillOnlyOnce=0;
    int fillOnlyOnce1=0;
    TextView firstTab;
    TextView previousTab;
    boolean isShaking = false;
   // DfpAdView adView;

    Vibrator vibe;
    WebView webView =null;
    //WebView webView1=null;
    //Intent i = new Intent(getBaseContext(), SecondScreen.class); //transfering flow to second screen // This is the way we can work like webpase
    //startActivity(i);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dailydetail);
       /* adView = (DfpAdView) this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest());
       */
        TextView text = (TextView) findViewById(R.id.text_header);

        text.setText("Shiva Sanghatana");

        MainScreen.this.finish();
        Intent  intent = new Intent().setClass(this, Tab3.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }
/*
    @Override
    public void onAppEvent(Ad arg0, String arg1, String arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDismissScreen(Ad arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onLeaveApplication(Ad arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPresentScreen(Ad arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onReceiveAd(Ad arg0) {
        // TODO Auto-generated method stub

    }



*/



}
