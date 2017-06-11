package shivasanghatana.onine.com.shiva_sanghatana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import shivasanghatana.onine.com.shiva_sanghatana.R;

/*import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AppEventListener;
import com.google.ads.doubleclick.DfpAdView;*/



public class AddNewsPage extends  Activity implements View.OnClickListener/*,
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


    private EditText  newsTitle=null;
    private EditText  newsDetails=null;
    private TextView headerValue;

    private Button publishnews;
    ArrayList<HashMap<String, String>> lcs ;
    //TableLayout tbl;
    //TableRow newRow ;
    String sessionId=null;
    int counter = 3;

    // JSON Node names
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_ID = "id";
    private static final String HEADER_VALUE = "name";
    private static final String NEWS_DETAILS = "email";
    private static final String IDVALUE = "mobile";

    ProgressDialog pdialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pdialog=new ProgressDialog(AddNewsPage.this);
        // TODO Auto-generated method stub
        System.out.println("I am in autho");

        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.addnewspage);


        //adView = (DfpAdView) this.findViewById(R.id.adView);
        //adView.loadAd(new AdRequest());
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
        System.out.println("#######Add News - sessionId##########"+sessionId);

        publishnews = (Button)findViewById(R.id.btnRegister);


        newsTitle = (EditText)findViewById(R.id.newstitle);
        newsDetails = (EditText)findViewById(R.id.newsdetails);

        publishnews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sessionId!=null){
                    System.out.println("I  am inside the image1 one listner ");

                    pdialog.setCancelable(true);
                    pdialog.setMessage("कृपया प्रतीक्षा करा. बातम्या प्रकाशन प्रक्रिया सुरु आहे  (Please Wait. News is publishing...)");
                    pdialog.show();
                    new HttpAsyncTask().execute("http://onine.in/Shiva/AddNews");
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






    }




    @Override
    public void onClick(View view) {

        AddNewsPage.this.finish();
        Intent  intent = new Intent().setClass(this, AddNewsPage.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;

    }


    //Fetching Data:
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        ProgressDialog asyncDialog = new ProgressDialog(AddNewsPage.this);
        String newsDetails_=null;
        String newsTitle_=null;
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            pdialog.setMessage("कृपया प्रतीक्षा करा. बातम्या प्रकाशन प्रक्रिया सुरु आहे  (Please Wait. News is publishing...)");

            if(newsDetails==null || newsDetails.getText().toString().equalsIgnoreCase("") || newsTitle==null || newsTitle.getText().toString().equalsIgnoreCase("")){
                Toast.makeText(getApplicationContext(), "कृपया सर्व तपशील भरा (Please All The Details)",Toast.LENGTH_SHORT).show();

            }else{
                newsDetails_=newsDetails.getText().toString();
                newsTitle_=newsTitle.getText().toString();
            }
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... urls) {
            try{
                // ImageUpload();//uploading images to server
                if(newsDetails!=null && !newsDetails_.toString().equalsIgnoreCase("") && newsTitle!=null && !newsTitle_.toString().equalsIgnoreCase("")){
                    System.out.println("I am in if.....................");
                    String newsTitleStr = new String(newsTitle_.toString().getBytes("UTF-8"), "UTF-8");
                    String newsDetailsStr = new String(newsTitle_.toString().getBytes("UTF-8"), "UTF-8");
                    String arr[]={newsTitleStr,newsDetailsStr,sessionId};
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
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            asyncDialog.dismiss();
            if(newsDetails!=null && !newsDetails.getText().toString().equalsIgnoreCase("") && newsTitle!=null && !newsTitle.getText().toString().equalsIgnoreCase("")){
                Toast.makeText(getApplicationContext(), "बातम्या  प्रकाशित यशस्वी (News is published)",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Authorization.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        }


    }

    public static String POST(String url, String auth[]){
        InputStream inputStream = null;
        String result = "";
        ;
        //String result1 = "";
        try {

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);
            //httpPost.setHeader("Accept", "application/json");
            //httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader(HTTP.CONTENT_TYPE,"application/x-www-form-urlencoded;charset=UTF-8");


            String newsTitleStr = new String(auth[0].toString().getBytes("UTF-8"), "UTF-8");
            String newsDetailsStr = new String(auth[1].toString().getBytes("UTF-8"), "UTF-8");
            String sessionIdValue = new String(auth[2].toString().getBytes("UTF-8"), "UTF-8");


            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("headerText", newsTitleStr));
            nameValuePairs.add(new BasicNameValuePair("newsDetails", newsDetailsStr));
            nameValuePairs.add(new BasicNameValuePair("sessionId", sessionIdValue));

            System.out.println("############################################################################"+newsTitleStr);
            System.out.println("############################################################################"+newsDetailsStr);
            System.out.println("#########################################auth[2].toString()###################################"+sessionIdValue);

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
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
/*

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
*/

}
