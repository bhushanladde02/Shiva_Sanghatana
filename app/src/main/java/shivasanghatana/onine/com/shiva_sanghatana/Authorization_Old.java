/*
package shivasanghatana.onine.com.shiva_sanghatana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AppEventListener;
import com.google.ads.doubleclick.DfpAdView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.onine.pojo.DataShiva;

import shivasanghatana.onine.com.shiva_sanghanata.SingleNewsActivity;


public class Authorization_Old extends  ListActivity implements View.OnClickListener,
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

	Vibrator vibe;
	WebView webView =null;
	//WebView webView1=null;


	private EditText  username=null;
	private EditText  password=null;
	private TextView headerValue;
	private Button login;
	private Button register;
	ArrayList<HashMap<String, String>> lcs ;
	//TableLayout tbl;
	//TableRow newRow ;

	 private Button directnw;

	int counter = 3;

	// JSON Node names
	private static final String TAG_CONTACTS = "contacts";
	private static final String TAG_ID = "id";
	private static final String HEADER_VALUE = "name";
	private static final String NEWS_DETAILS = "email";
	private static final String IDVALUE = "mobile";
	private static final String PERSONNAME = "personname";
	private static final String DATEVALUE = "datevalue";

	
    String sessionId=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		System.out.println("I am in autho");
		
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.authorizationpage);
		

		adView = (DfpAdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());
		TextView text = (TextView) findViewById(R.id.text_header);

		text.setText("शिवा संघटना");
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
		  return;
		}
		// get data via the key
		String value1 = extras.getString("sessionId");
		if (value1 != null) {
			sessionId=value1;
		} 
		//View inflatedView = getLayoutInflater().inflate(R.layout.internalheader, null);
		//directnw = (Button) inflatedView.findViewById(R.id.button_menu);
		//text.setText("Hello!");
		//headerValue =(TextView)findViewById(R.id.textView5);
		//headerValue.setText("");
		
		directnw = (Button)findViewById(R.id.button3);
			
	      
	      
	      directnw.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                if(sessionId!=null){
	            	System.out.println("I  am inside the image1 one listner ");
	            	Intent intent = new Intent(getApplicationContext(), AddNewsPage.class);
	            	//String message = "Bhushan Arun Ladde";
	            	//intent.putExtra(EXTRA_MESSAGE, message);
	            	intent.putExtra("sessionId",sessionId);
	            	System.out.println("#######Auth - sessionId##########"+sessionId);
	            	startActivity(intent);
	                //v.getId() will give you the image id
	                }
	                else{
	                	Toast.makeText(getApplicationContext(), "पुन्हा लॉग इन करा (Please login again)",Toast.LENGTH_SHORT).show();
	                	Intent intent = new Intent(getApplicationContext(), Tab3.class);
		            	//String message = "Bhushan Arun Ladde";
		            	//intent.putExtra(EXTRA_MESSAGE, message);
		            	
		            	startActivity(intent);
	                }

	            }
	        });
	

		lcs = new ArrayList<HashMap<String, String>>();

		ListView lv = getListView();



		// Listview on item click listener
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String name = ((TextView) view.findViewById(R.id.name))
						.getText().toString();
				String cost = ((TextView) view.findViewById(R.id.email))
						.getText().toString();
				String description = ((TextView) view.findViewById(R.id.mobile))
						.getText().toString();
				
				String personname = ((TextView) view.findViewById(R.id.personname))
						.getText().toString();
				
				String datevalue = ((TextView) view.findViewById(R.id.datevalue))
						.getText().toString();

				// Starting single contact activity
				Intent in = new Intent(getApplicationContext(),
						SingleNewsActivity.class);
				in.putExtra(HEADER_VALUE, name);
				in.putExtra(NEWS_DETAILS, cost);
				in.putExtra(IDVALUE, description);
				in.putExtra(PERSONNAME, personname);
				in.putExtra(DATEVALUE, datevalue);
				
				startActivity(in);

			}
		});

		

	
		new HttpAsyncTask().execute("http://onine.in/Shiva/AuthServlet");

		*/
/*context = this;
		this.firstTab = ((TextView) findViewById(R.id.firstTab));
		this.firstTab.setOnClickListener(this);


		this.previousTab = ((TextView) findViewById(R.id.previousTab));
		this.previousTab.setOnClickListener(this);
		this.firstTab.setBackgroundResource(R.drawable.tab);
		this.previousTab.setBackgroundResource(R.drawable.tab);

		this.lastTab = ((TextView) findViewById(R.id.lastTab));
		this.lastTab.setOnClickListener(this);
		this.lastTab.setBackgroundResource(R.drawable.tab_active);
*//*




	}


	private final class AsyncSender extends AsyncTask<Void, Void, Void> {

		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();

		}

		@Override
		protected Void doInBackground(Void... params) {

			
			

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
		
		}


	}

	boolean isFirstTab = true;
	private ArrayAdapter<String> adapter;

	@Override
	public void onClick(View view) {


	*/
/*	if (view == this.firstTab) {
			Authorization.this.finish();
			Intent  intent = new Intent().setClass(this, Tab1.class);
			startActivity(intent);
		}
		else if(view == this.previousTab)
		{
			Authorization.this.finish();
			Intent  intent = new Intent().setClass(this, Tab2.class);
			startActivity(intent);

		}
		else{*//*

			Authorization_Old.this.finish();
			Intent  intent = new Intent().setClass(this, Authorization_Old.class);
			startActivity(intent);
		//}
	}


	public void login(View view){
		*/
/*if(username.getText().toString().equals("admin") &&
				password.getText().toString().equals("admin")){
		*//*
	Toast.makeText(getApplicationContext(), " लॉग-इन  यशस्वी  (Login Successful)",Toast.LENGTH_SHORT).show();
		*/
/*}
		else{
			Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
			
		}*//*


	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;

	}


	//Fetching Data:
	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			// ImageUpload();//uploading images to server
			return POST(urls[0],"auth");
		}
		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			System.out.println("#####################################result#########################################"+result);
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray jArray = parser.parse(result).getAsJsonArray();


			for(JsonElement obj : jArray )
			{
				HashMap<String,String> hashing=new HashMap();
				
				DataShiva cse = gson.fromJson( obj , DataShiva.class);
				//hashing.put(, );
				hashing.put(HEADER_VALUE,cse.headerValue.trim());
				hashing.put(NEWS_DETAILS,cse.newsDetails.trim());
				hashing.put(IDVALUE,"बातम्या क्र. (News No.) : "+ cse.id.trim());
				hashing.put(PERSONNAME,"बातमी दिलेल्या व्यक्तीचे नाव [ News given by ]: "+ cse.person.trim());
				System.out.println("बातमी दिलेल्या व्यक्तीचे नाव [ News given by ]: "+ cse.person.trim());
				hashing.put(DATEVALUE,"बातमी तारीख [News Date]:"+ cse.lastUpdatedDt.trim());
				System.out.println("बातमी तारीख [News Date]:"+ cse.lastUpdatedDt.trim());
				lcs.add(hashing);
				//lcs.add();
			}
			
			Collections.reverse(lcs);
		ListAdapter adapter = new SimpleAdapter(
					Authorization_Old.this, lcs,
					R.layout.list_item, new String[] { HEADER_VALUE, NEWS_DETAILS,
							IDVALUE,PERSONNAME,DATEVALUE }, new int[] { R.id.name,
							R.id.email, R.id.mobile, R.id.personname , R.id.datevalue});

			setListAdapter(adapter);

		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

		}

	}

	public static String POST(String url, String auth){
		InputStream inputStream = null;
		String result = "";
		//String result1 = "";
		try {

			// 1. create HttpClient
			HttpClient httpclient = new DefaultHttpClient();
			// 2. make POST request to the given URL
			HttpPost httpPost = new HttpPost(url);
			String json = "";
			MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );
			// json = jsonObject.toString();//(make a string as following format)
			System.out.println("##############Json###############"+json);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			httpPost.addHeader(new BasicHeader("jsonString",json));
			httpPost.setEntity( entity );
			HttpResponse httpResponse = httpclient.execute(httpPost);
			System.out.println("################inputstream###############################"+httpResponse+"################inputstream###############################" );
			inputStream = httpResponse.getEntity().getContent();
			System.out.println("################inputstream###############################"+inputStream);
			// 10. convert inputstream to string
			if(inputStream != null){
				result = convertInputStreamToString(inputStream);

			}
			else{
				result = "Did not work!";
			}

		} catch (Exception e) {
			System.out.println("I am in exception :::::::::::"+ e);
			System.out.println("I am in exception :::::::::::"+ e.getLocalizedMessage());
			Log.d("InputStream", e.getLocalizedMessage());
		}

		// 11. return result
		return result ;//+","+result1;
	}
	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

	}

//end of main code
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

}
*/
