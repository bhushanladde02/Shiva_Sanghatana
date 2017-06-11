package shivasanghatana.onine.com.shiva_sanghatana;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import shivasanghatana.onine.com.shiva_sanghatana.R;


public class SingleNewsActivity  extends Activity {

    // JSON node keys
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PHONE_MOBILE = "mobile";
    private static final String TAG_PERSONNAME = "personname";
    private static final String TAG_DATEVALUE = "datevalue";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_news);

        // getting intent data
        Intent in = getIntent();

        // Get JSON values from previous intent
        String name = in.getStringExtra(TAG_NAME);
        String email = in.getStringExtra(TAG_EMAIL);
        String mobile = in.getStringExtra(TAG_PHONE_MOBILE);
        String personname = in.getStringExtra(TAG_PERSONNAME);
        String datevalue = in.getStringExtra(TAG_DATEVALUE);

        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name_label);
        TextView lblEmail = (TextView) findViewById(R.id.email_label);
        TextView lblMobile = (TextView) findViewById(R.id.mobile_label);
        TextView lblpersonname = (TextView) findViewById(R.id.personname_label);
        TextView lbldatevale = (TextView) findViewById(R.id.datevalue_label);

        lblName.setText(name);
        lblEmail.setText(email);
        lblMobile.setText(mobile);
        lblpersonname.setText(personname);
        lbldatevale.setText(datevalue);

    }
}
