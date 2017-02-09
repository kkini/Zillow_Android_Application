package com.example.zillowapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ProgressDialog PD;
	TextView noDataMsg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.button1);
		final EditText address = (EditText) findViewById(R.id.editText1);
		final EditText city = (EditText) findViewById(R.id.editText2);
		final Spinner state = (Spinner) findViewById(R.id.spinner1);
		noDataMsg=(TextView) findViewById(R.id.noDataMsg);
		final TextView addrErr=(TextView) findViewById(R.id.addressErr);
		final TextView cityErr=(TextView) findViewById(R.id.cityErr);
		final TextView stateErr=(TextView) findViewById(R.id.stateErr);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				String address1=address.getText().toString();

				String city1=city.getText().toString();
				String state1=state.getSelectedItem().toString();
				boolean flag=true;
				addrErr.setText("");
				cityErr.setText("");
				stateErr.setText("");
				if("".equals(address1.trim()))
				{
					flag=false;
					addrErr.setText("This field is required");
				}
				if("".equals(city1.trim()))
				{
					flag=false;
					cityErr.setText("This field is required");
				}
				if("".equals(state1.trim()))
				{
					flag=false;
					stateErr.setText("This field is required");
				}
				if(flag)
				{
				 DownloadWebPageTask task = new DownloadWebPageTask();
				    task.execute(new String[] { address1,city1,state1 });
				}
			}

		});
	}
	
	
	 private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
		 
		 
			@Override
			protected void onPreExecute() {
			// TODO Auto-generated method stub
				super.onPreExecute();
				
				PD = new ProgressDialog(MainActivity.this);
				PD.setTitle("Please Wait..");
				PD.setMessage("Loading...");
				PD.setCancelable(false);
				PD.show();
			}		 
		    @Override
		    protected String doInBackground(String... params) {
		      String response = "";
		        DefaultHttpClient client = new DefaultHttpClient();
		        String url="http://karthikhw8-env.elasticbeanstalk.com/index.php";
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
		        nameValuePairs.add(new BasicNameValuePair("streetAddress",params[0]));
		        nameValuePairs.add(new BasicNameValuePair("city",
			            params[1]));
		        nameValuePairs.add(new BasicNameValuePair("state",
			            params[2]));
				String paramString = URLEncodedUtils.format(nameValuePairs, "utf-8");
		          url += "?" + paramString;
		          System.out.print(url);
		        HttpGet httpGet = new HttpGet(url);
		        try {
		          HttpResponse execute = client.execute(httpGet);
		          InputStream content = execute.getEntity().getContent();
		          BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
		          String s = "";
		          while ((s = buffer.readLine()) != null) {
		            response += s;
		          }

		        } catch (Exception e) {
		          e.printStackTrace();
		        }
		      
		      return response;
		    }

		    @Override
		    protected void onPostExecute(String result) {
		    	PD.dismiss();
		    	JSONObject mo;
				try {
					mo = new JSONObject(result);

			    	String errMsg = mo.getString("errorMsg");
			    	if(errMsg.length()>0)
			    	{
			    		noDataMsg.setText(errMsg);
			    	}
			    	else
			    	{
			    		Intent i = new Intent(MainActivity.this, TabActivity.class);
			    		Property p = new Property();
			    		p.setAddress(mo.getString("street"));
			    		p.setAllPropChange(mo.getString("ZesValRange"));
			    		p.setAllRentChange(mo.getString("rentValRange"));
			    		p.setBathRooms(mo.getInt("bathrooms"));
			    		p.setBedRooms(mo.getInt("bedRooms"));
			    		p.setCity(mo.getString("city"));
			    		p.setFinishedArea(mo.getString("fArea"));
			    		p.setLastSoldDate(mo.getString("lSoldDate"));
			    		p.setLastSoldPrice(mo.getString("lastSold"));
			    		p.setLotSize(mo.getString("lotSize"));
			    		p.setOverChange(mo.getString("oChangeVal"));
			    		p.setOverChangeImg(mo.getString("zesImg"));
			    		p.setPropType(mo.getString("useCode"));
			    		p.setRentAmount(mo.getString("rZestAmnt"));
			    		p.setRentChange(mo.getString("renValueChge"));
			    		p.setRentChangeImg(mo.getString("renImg"));
			    		p.setRentDate(mo.getString("rZentDate"));
			    		p.setState(mo.getString("state"));
			    		p.setTaxAssess(mo.getString("taxAssess"));
			    		p.setTaxAssessYear(mo.getInt("TxAssesYr"));
			    		p.setYearBuilt(mo.getInt("yearBuilt"));
			    		p.setZestAmount(mo.getString("Zamnt"));
			    		p.setZestUpdateDate(mo.getString("zesLastUpdated"));
			    		p.setChart10yrs(mo.getString("chart10yrs"));
			    		p.setChart5yrs(mo.getString("chart5yrs"));
			    		p.setChart1yrs(mo.getString("chart1yr"));
			    		i.putExtra("property", p);
			    		startActivity(i);
			       	}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		  }
	
}
