package shivasanghatana.onine.com.shiva_sanghatana;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import shivasanghatana.onine.com.shiva_sanghatana.R;

//import com.google.android.gcm.GCMRegistrar;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 *
 * */
public class GodSplash extends Activity {

    private static final int SPLASH_DISPLAY_TIME=2500;
    private static final String SENDER_ID = "263505509884"; //GCM Sender ID for Google Cloud Messaging


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_splash);
//		startActivity(new Intent(this,MainScreen.class));
		/*final ProgressDialog progDailog = ProgressDialog.show(this, "Please Wait",
	            "Loading....", true);*/

        //GCMRegistrar.checkDevice(this);
        //GCMRegistrar.checkManifest(this);
        //final String regId = GCMRegistrar.getRegistrationId(this);
        //System.out.println("Registration ID is "+ regId);
        //if (regId.equals("")) {
        //  GCMRegistrar.register(this, SENDER_ID);
        //	} else {
        //  Log.v("Checking GCM", "Already registered");
        //	}

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(GodSplash.this, MainScreen.class);
                GodSplash.this.startActivity(intent);
                GodSplash.this.finish();
//				progDailog.dismiss();



            }
        },SPLASH_DISPLAY_TIME);

    }
}
