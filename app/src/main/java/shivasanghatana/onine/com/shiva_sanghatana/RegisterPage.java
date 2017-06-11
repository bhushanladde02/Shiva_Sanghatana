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
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AppEventListener;
import com.google.ads.doubleclick.DfpAdView;
*/

import shivasanghatana.onine.com.shiva_sanghatana.R;


public class RegisterPage extends  Activity implements View.OnClickListener/*,
        AdListener, AppEventListener*/{
    Context context;
    private EditText  name=null;
    private EditText  phonenumber=null;
    private EditText  city=null;
    private EditText  country=null;
    //private EditText  deviceid=null;
    private EditText  gender=null;
    private EditText  password=null;
    private EditText  position=null;
    private String deviceId=null;
    ProgressDialog pdialog=null;
    private Button publishnews;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        pdialog=new ProgressDialog(RegisterPage.this);

        System.out.println("I am in autho");

        //http://onine.in/Shiva/Registeruser?name=bhushan&phonenumber=8055925868&city=nasik&country=india&deviceid=22&gender=m&password=test

        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.registerpage);


        //adView = (DfpAdView) this.findViewById(R.id.adView);
        //adView.loadAd(new AdRequest());
        TextView text = (TextView) findViewById(R.id.text_header);

        text.setText("शिवा संघटना");


        publishnews = (Button)findViewById(R.id.btnRegister);



        name = (EditText)findViewById(R.id.name);
        phonenumber = (EditText)findViewById(R.id.phonenumber);
        city = (EditText)findViewById(R.id.city);
        country = (EditText)findViewById(R.id.country);
        //deviceid = (EditText)findViewById(R.id.deviceid);
        gender = (EditText)findViewById(R.id.gender);
        password = (EditText)findViewById(R.id.password);
        position = (EditText)findViewById(R.id.position);
        deviceId=Secure.getString(this.getContentResolver(),Secure.ANDROID_ID);

        publishnews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pdialog.setCancelable(true);
                pdialog.setMessage("कृपया प्रतीक्षा करा. नोंदणी सुरू आहे (Registration is start....)");
                pdialog.show();
                System.out.println("I  am inside the image1 one listner ");
                new HttpAsyncTask().execute("http://104.239.230.58/Shiva/Registeruser");
            }
        });






    }




    @Override
    public void onClick(View view) {

        RegisterPage.this.finish();
        Intent  intent = new Intent().setClass(this, RegisterPage.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;

    }


    //Fetching Data:
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        ProgressDialog asyncDialog = new ProgressDialog(RegisterPage.this);
        String name_=null;
        String phonenumber_=null;
        String city_=null;
        String country_=null;
        String gender_=null;
        String password_=null;
        String position_=null;

        @Override
        protected void onPreExecute() {
            asyncDialog.setMessage("नोंदणी सुरू आहे (Registration is start....)");
            // TODO Auto-generated method stub
            if(name==null || name.getText().toString().equalsIgnoreCase("")
                    || phonenumber==null || phonenumber.getText().toString().equalsIgnoreCase("")
                    || city==null || city.getText().toString().equalsIgnoreCase("")
                    || country==null || country.getText().toString().equalsIgnoreCase("")
                    || gender==null || gender.getText().toString().equalsIgnoreCase("")
                    || password==null || password.getText().toString().equalsIgnoreCase("")
                    || position==null || position.getText().toString().equalsIgnoreCase("")){
                Toast.makeText(getApplicationContext(), "कृपया सर्व तपशील भरा (Please All The Details)",Toast.LENGTH_SHORT).show();

                super.onPreExecute();
            }
            else{
                name_= name.getText().toString();
                phonenumber_=phonenumber.getText().toString();
                city_=city.getText().toString();
                country_=country.getText().toString();
                gender_=gender.getText().toString();
                password_=password.getText().toString();
                position_=position.getText().toString();
            }
        }

        @Override
        protected String doInBackground(String... urls) {
            try{
                // ImageUpload();//uploading images to server

             //important code
                if(     name!=null && !name_.equalsIgnoreCase("")
                        && phonenumber!=null && !phonenumber_.equalsIgnoreCase("")
                        && city!=null && !city_.equalsIgnoreCase("")
                        && country!=null && !country_.equalsIgnoreCase("")
                        && gender!=null && !gender_.equalsIgnoreCase("")
                        && password!=null && !password_.equalsIgnoreCase("")
                        && deviceId!=null && !deviceId.toString().equalsIgnoreCase("")
                        && position!=null && !position_.equalsIgnoreCase("")){
                    System.out.println("I am in if.....................");

                    String nameStr = new String(name_.toString().getBytes("UTF-8"), "UTF-8");
                    String phonenumberStr = new String(phonenumber_.toString().getBytes("UTF-8"), "UTF-8");
                    String cityStr = new String(city_.toString().getBytes("UTF-8"), "UTF-8");
                    String countryStr = new String(country_.toString().getBytes("UTF-8"), "UTF-8");
                    String genderStr = new String(gender_.toString().getBytes("UTF-8"), "UTF-8");
                    String passwordStr = new String(password_.toString().getBytes("UTF-8"), "UTF-8");
                    String positionStr = new String(position_.toString().getBytes("UTF-8"), "UTF-8");
                    String deviceIdStr = new String(deviceId.toString().getBytes("UTF-8"), "UTF-8");

                    String arr[]={nameStr,phonenumberStr,cityStr,countryStr,genderStr,passwordStr,positionStr,deviceIdStr};
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


            if(     name!=null && !name.getText().toString().equalsIgnoreCase("")
                    && phonenumber!=null && !phonenumber.getText().toString().equalsIgnoreCase("")
                    && city!=null && !city.getText().toString().equalsIgnoreCase("")
                    && country!=null && !country.getText().toString().equalsIgnoreCase("")
                    && gender!=null && !gender.getText().toString().equalsIgnoreCase("")
                    && password!=null && !password.getText().toString().equalsIgnoreCase("")
                    && deviceId!=null && !deviceId.toString().equalsIgnoreCase("")
                    && position!=null && !position.getText().toString().equalsIgnoreCase("")){
                System.out.println("I am in if.....................");

                Toast.makeText(getApplicationContext(), "नोंदणी यशस्वी (Registration Completed)",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Tab3.class);
                startActivity(intent);
            }
			/*System.out.println("#####################################result#########################################"+result);
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray jArray = parser.parse(result).getAsJsonArray();


			for(JsonElement obj : jArray )
			{
				HashMap<String,String> hashing=new HashMap();

				DataShiva cse = gson.fromJson( obj , DataShiva.class);
				//hashing.put(, );
				hashing.put(HEADER_VALUE,cse.headerValue);
				hashing.put(NEWS_DETAILS,cse.newsDetails);
				hashing.put(IDVALUE,"बातम्या क्र. (News No.) : "+ cse.id);
				lcs.add(hashing);
				//lcs.add();
			}

			Collections.reverse(lcs);
			ListAdapter adapter = new SimpleAdapter(
					AddNewsPage.this, lcs,
					R.layout.list_item, new String[] { HEADER_VALUE, NEWS_DETAILS,
							IDVALUE }, new int[] { R.id.name,
							R.id.email, R.id.mobile });

			 */			//setListAdapter(adapter);

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

            String nameStr = new String(auth[0].toString().getBytes("UTF-8"), "UTF-8");
            String phonenumberStr = new String(auth[1].toString().getBytes("UTF-8"), "UTF-8");
            String cityStr = new String(auth[2].toString().getBytes("UTF-8"), "UTF-8");
            String countryStr = new String(auth[3].toString().getBytes("UTF-8"), "UTF-8");
            String genderStr = new String(auth[4].toString().getBytes("UTF-8"), "UTF-8");
            String passwordStr = new String(auth[5].toString().getBytes("UTF-8"), "UTF-8");
            String positionStr = new String(auth[6].toString().getBytes("UTF-8"), "UTF-8");
            String deviceIdStr = new String(auth[7].toString().getBytes("UTF-8"), "UTF-8");

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

            nameValuePairs.add(new BasicNameValuePair("name", nameStr));
            nameValuePairs.add(new BasicNameValuePair("phonenumber", phonenumberStr));
            nameValuePairs.add(new BasicNameValuePair("city", cityStr));
            nameValuePairs.add(new BasicNameValuePair("country", countryStr));
            nameValuePairs.add(new BasicNameValuePair("gender", genderStr));
            nameValuePairs.add(new BasicNameValuePair("password", passwordStr));
            nameValuePairs.add(new BasicNameValuePair("position", positionStr));
            nameValuePairs.add(new BasicNameValuePair("deviceid", deviceIdStr));


            System.out.println("############################################################################"+ nameStr );
            System.out.println("############################################################################"+ phonenumberStr );
            System.out.println("############################################################################"+ cityStr );
            System.out.println("############################################################################"+ countryStr);
            System.out.println("############################################################################"+ genderStr);
            System.out.println("############################################################################"+ passwordStr);
            System.out.println("############################################################################"+ positionStr );
            System.out.println("############################################################################"+ deviceIdStr);
            //System.out.println("############################################################################"+newsTitleStr);
            //System.out.println("############################################################################"+newsDetailsStr);

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

    //end of main code
    /*@Override
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

    }*/

}
