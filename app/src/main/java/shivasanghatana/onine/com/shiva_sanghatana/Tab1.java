/*package com.onine.shivasanghatana;

import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AppEventListener;
import com.google.ads.doubleclick.DfpAdView;


public class Tab1 extends Activity implements View.OnClickListener,
		AdListener, AppEventListener{
	Context context;
	int flag=0;
	String tabValue="";
	int fillOnlyOnce=0;
	int fillOnlyOnce1=0;
	TextView firstTab;
	TextView previousTab;
	TextView lastTab;
	
	
	boolean isShaking = false;
	DfpAdView adView;
	//private ShakeListener mShaker;
	Vibrator vibe;
	WebView webView =null;
	//WebView webView1=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dailydetail);
		adView = (DfpAdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());
		TextView text = (TextView) findViewById(R.id.text_header);
	
		text.setText("Shiva Sanghatana");
		webView1 = (WebView) findViewById(R.id.dailyPreDetailWebView);
		
		webView1.getSettings().setCacheMode(
				android.webkit.WebSettings.LOAD_NO_CACHE);
		
		
		webView = (WebView) findViewById(R.id.dailyDetailWebView); //baba
		webView.getSettings().setCacheMode(
				android.webkit.WebSettings.LOAD_NO_CACHE);
		
		
		
		vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		webView.loadUrl("http://onine.in/Shiva/SecondPageShiv.html");
		webView.clearCache(true);
		webView.clearHistory();
		webView.getSettings().setJavaScriptEnabled(true);
		//new ReloadWebView(this, 1, webView);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
		
		

		
	
		context = this;
		this.firstTab = ((TextView) findViewById(R.id.firstTab));
		this.firstTab.setOnClickListener(this);
		this.firstTab.setBackgroundResource(R.drawable.tab_active);
		
		this.previousTab = ((TextView) findViewById(R.id.previousTab));
		this.previousTab.setOnClickListener(this);
		this.previousTab.setBackgroundResource(R.drawable.tab);
		
		this.lastTab = ((TextView) findViewById(R.id.lastTab));
		this.lastTab.setOnClickListener(this);
		this.lastTab.setBackgroundResource(R.drawable.tab);
		
		
		
	}

	
	private final class AsyncSender extends AsyncTask<Void, Void, Void> {

		ProgressDialog pd;
		MediaPlayer mediaPlayer = new MediaPlayer();

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			pd = new ProgressDialog(Tab1.this);
			pd.setIcon(R.drawable.ic_launcherbig);
			pd.setTitle("");
			pd.setCancelable(true);
			pd.setOnCancelListener(new OnCancelListener() {
				
				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					mediaPlayer.stop();
				}
			});
			//pd.setMessage("Score Updating....");
			pd.setIndeterminate(true); 
			pd.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			
			if (isShaking == false && isFirstTab) {
				isShaking = true;
				vibe.vibrate(100);
//			playAudio(); // You probably have to try/catch this
				
				
			//	mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); 
				try {
					//mediaPlayer.setDataSource("http://onine.in/god/SIREN1.mp3");
					mediaPlayer.prepare();
					//mediaPlayer.start();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				isShaking=false;
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			pd.dismiss();
		}

		
	}

	boolean isFirstTab = true;
	private ArrayAdapter<String> adapter;

	@Override
	public void onClick(View view) {
		
		
		if (view == this.firstTab) {
			webView = (WebView) findViewById(R.id.dailyDetailWebView);//baba
		//new ReloadWebView(this, 1, webView);
		//webView.setVisibility(View.GONE);
		//	isFirstTab = true;
		//	webView.setVisibility(View.VISIBLE);
			
			this.firstTab.setBackgroundResource(R.drawable.tab_active);
			
			flag=0;
			webView.loadUrl("http://onine.in/god/LiveScore.html");
			webView.clearCache(true);
			webView.clearHistory();
			webView.getSettings().setJavaScriptEnabled(true);
			//webView.getSettings().setJavaScriptEnabled(true);
			new ReloadWebView(this, 1, webView);
			//webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
			this.firstTab.setBackgroundResource(R.drawable.tab_active);
			this.previousTab.setBackgroundResource(R.drawable.tab);
			this.tabValue="";
			adView.loadAd(new AdRequest());
			Tab1.this.finish();
			Intent  intent = new Intent().setClass(this, Tab1.class);
			startActivity(intent);
		}
		else if(view == this.previousTab)
		{
			webView = (WebView) findViewById(R.id.dailyPreDetailWebView);
			System.out.println("I am in second tab");
			
		   //webView = (WebView) findViewById(R.id.dailyDetailWebView);
			//webView.clearView();
			//webView.stopLoading();
			//new ReloadWebView(this, 540, webView);
		//	webView.setVisibility(View.GONE);
		//	isFirstTab = true;
		//	webView.setVisibility(View.VISIBLE);			
		//	this.firstTab.setBackgroundResource(R.drawable.tab);			
			flag=0;						
			webView.loadUrl("http://onine.in/god/FullScoreCard.html");
			//webView.bringToFront();		
			webView.clearCache(true);
			webView.clearHistory();
			webView.getSettings().setJavaScriptEnabled(true);
			//webView.getSettings().setJavaScriptEnabled(true);
			//webView.stopLoading();
			
			this.firstTab.setBackgroundResource(R.drawable.tab);
			this.previousTab.setBackgroundResource(R.drawable.tab_active);
			//webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
			this.tabValue="";
			adView.loadAd(new AdRequest());
			Tab1.this.finish();
			Intent  intent = new Intent().setClass(this, Tab2.class);
			startActivity(intent);
			
		}
		else{
			Tab1.this.finish();
			Intent  intent = new Intent().setClass(this, Tab3.class);
			startActivity(intent);
		}
	}

	

	
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

	

	
	@Override
	protected void onStop() {
	    super.onStop();  // Always call the superclass method first

	}
	


}
*/