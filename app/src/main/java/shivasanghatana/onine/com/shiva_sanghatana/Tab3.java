package shivasanghatana.onine.com.shiva_sanghatana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

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
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import shivasanghatana.onine.com.shiva_sanghatana.R;

/*import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AppEventListener;
import com.google.ads.doubleclick.DfpAdView;*/



public class Tab3 extends Activity implements View.OnClickListener/*,
        AdListener, AppEventListener*/{
    Context context;
    int flag=0;
    String tabValue="";
    int fillOnlyOnce=0;
    int fillOnlyOnce1=0;
    TextView firstTab;
    TextView previousTab;
    TextView lastTab;
    boolean isShaking = false;
    //DfpAdView adView;

    Vibrator vibe;
    WebView webView =null;
    //WebView webView1=null;

    private EditText  username=null;
    private EditText  password=null;
    private TextView attempts;
    private Button login;
    private Button register;
    private Button directnw;
    static String results1=null;

    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tab3);

        /*adView = (DfpAdView) this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest());*/
        TextView text = (TextView) findViewById(R.id.text_header);

        text.setText("शिवा संघटना");


        attempts = (TextView)findViewById(R.id.textView5);
        attempts.setText("");
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button1);


        register = (Button)findViewById(R.id.button2);


        directnw = (Button)findViewById(R.id.button3);



        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                System.out.println("I  am inside the image1 one listner ");
                Intent intent = new Intent(getApplicationContext(), RegisterPage.class);
                //String message = "Bhushan Arun Ladde";
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                //v.getId() will give you the image id

            }
        });

        directnw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                System.out.println("I  am inside the image1 one listner ");
                Intent intent = new Intent(getApplicationContext(), DirectNews.class);
                //String message = "Bhushan Arun Ladde";
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                //v.getId() will give you the image id

            }
        });

    }


    @Override
    public void onClick(View view) {


		/*if (view == this.firstTab) {
			Tab3.this.finish();
			Intent  intent = new Intent().setClass(this, Tab1.class);
			startActivity(intent);
		}
		else if(view == this.previousTab)
		{
			Tab3.this.finish();
			Intent  intent = new Intent().setClass(this, Tab2.class);
			startActivity(intent);

		}
		else{
		*/	Tab3.this.finish();
        Intent  intent = new Intent().setClass(this, Tab3.class);
        startActivity(intent);
        //}
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




    public void login(View view){
        String results=null;

        System.out.println("I  am inside the image1 one listner ");
        new HttpAsyncTask().execute("http://104.239.230.58/Shiva/LoginServlet");


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }


    //Fetching Data:
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        ProgressDialog asyncDialog = new ProgressDialog(Tab3.this);
        String username_=null;
        String password_=null;
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            asyncDialog.setMessage("लोड करीत आहे (loading....)");
            //show dialog
            asyncDialog.show();
            if(username==null || username.getText().toString().equalsIgnoreCase("") || password==null || password.getText().toString().equalsIgnoreCase("")){
                Toast.makeText(getApplicationContext(), "कृपया सर्व तपशील भरा (Please All The Details)",Toast.LENGTH_SHORT).show();
                flag=1;

            }else{
                username_=username.getText().toString();
                password_=password.getText().toString();
            }
            super.onPreExecute();

        }

        int flag=0;
        @Override
        protected String doInBackground(String... urls) {
            try{
                // ImageUpload();//uploading images to server
                if(username!=null && !username_.toString().equalsIgnoreCase("") && password!=null && !password_.toString().equalsIgnoreCase("")){
                    System.out.println("I am in if.....................");
                    String newsTitleStr = new String(username_.toString().getBytes("UTF-8"), "UTF-8");
                    String newsDetailsStr = new String(password_.toString().getBytes("UTF-8"), "UTF-8");
                    String arr[]={newsTitleStr,newsDetailsStr};

                    return POST(urls[0],arr);
                }
                else {
                    return null;
                }
            }catch(Exception e){
                System.out.println(e);
                return null;
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String results) {
            results=Tab3.results1;
            asyncDialog.dismiss();
            if(results!=null && !results.equalsIgnoreCase("")&&!results.equalsIgnoreCase("empty")){

                Toast.makeText(getApplicationContext(), "लॉग-इन यशस्वी (Login Successful...)",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Authorization.class);
                intent.putExtra("sessionId",results);

                startActivity(intent);
            }
            else{
                if(flag==0)
                    Toast.makeText(getApplicationContext(), "चुकीची माहिती (Wrong Credentials) : मोबाइल क्रमांक आणि पासवर्ड जुळणारे नाही (Mobile Number and password is not matching)",Toast.LENGTH_SHORT).show();

            }



        }


    }

    public static String POST(String url, String auth[]){
        InputStream inputStream = null;
        String result = "";
        //String result1 = "";
        try {

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);
            //httpPost.setHeader("Accept", "application/json");
            //httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader(HTTP.CONTENT_TYPE,"application/x-www-form-urlencoded;charset=UTF-8");


            String username = new String(auth[0].toString().getBytes("UTF-8"), "UTF-8");
            String password = new String(auth[1].toString().getBytes("UTF-8"), "UTF-8");

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("username", username));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            System.out.println("############################################################################"+username);
            System.out.println("############################################################################"+password);

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse httpResponse = httpclient.execute(httpPost);

            System.out.println("################inputstream###############################"+httpResponse+"################inputstream###############################" );
            inputStream = httpResponse.getEntity().getContent();
            System.out.println("################inputstream###############################"+inputStream);
            // 10. convert inputstream to string
            if(inputStream != null){
                result = convertInputStreamToString(inputStream);
                results1=result;
                System.out.println("################result###############################"+result);


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

}
