package com.example.zillowapp;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.ProgressDialog;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class HistZestFragment extends Fragment {
	ProgressDialog PD;
	String imageIds[]=null;
	String texts[]={"Historical zestimates for past 1 year","Historical zestimates for past 5 years","Historical zestimates for past 10 years"};
	int currentIndex=0; 
	 int messageCount=3;
	 ImageSwitcher imageSwitcher=null;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.histzest_frag, container, false);
        
        Button btnNext=(Button)view.findViewById(R.id.next);
        Button btnPrevious=(Button)view.findViewById(R.id.previous);
        imageSwitcher= (ImageSwitcher) view.findViewById(R.id.imageSwitcher1);
        final TextSwitcher textSwitcher = (TextSwitcher) view.findViewById(R.id.textSwitcher1);
        Intent i=getActivity().getIntent();
        Bundle b = i.getExtras();
        Property p = (Property) b.getParcelable("property");
        
        imageIds=new String[3];
        imageIds[0]=p.getChart1yrs();
        imageIds[1]=p.getChart5yrs();
        imageIds[2]=p.getChart10yrs();
        
        final TextView imageAddr=(TextView) view.findViewById(R.id.imageAddr);
        imageAddr.setText(p.getAddress()+" "+p.getCity()+" "+p.getState());
        textSwitcher.setFactory(new ViewFactory(){

        	   @Override
        	   public View makeView() {
        	    TextView textView = new TextView(getActivity());
        	    textView.setTextSize(16);
        	    textView.setTextColor(Color.BLACK);
        	    textView.setGravity(Gravity.CENTER_HORIZONTAL);
        	    textView.setTypeface(Typeface.DEFAULT_BOLD);
        	    textView.setShadowLayer(10, 10, 10, Color.BLACK);
        	    return textView;
        	   }});
        imageSwitcher.setFactory(new ViewFactory() {
            
            public View makeView() {
                // TODO Auto-generated method stub
                
                    // Create a new ImageView set it's properties 
                    ImageView imageView = new ImageView(getActivity().getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
                    return imageView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this.getActivity(),android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this.getActivity(),android.R.anim.slide_out_right);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

	    textSwitcher.setText(texts[currentIndex]);
        DownloadWebPageTask task = new DownloadWebPageTask();
	    task.execute(new String[] { imageIds[currentIndex]});
        btnNext.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
                // TODO Auto-generated method stub
                 currentIndex++;
                   // If index reaches maximum reset it
                    if(currentIndex==messageCount)
                        currentIndex=0;
                    DownloadWebPageTask task = new DownloadWebPageTask();
				    task.execute(new String[] { imageIds[currentIndex]});
                    //Uri uri1=Uri.parse(imageIds[currentIndex]);
                    
                    //imageSwitcher.setImageURI(uri1);
                    textSwitcher.setText(texts[currentIndex]);
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
                // TODO Auto-generated method stub
                 currentIndex--;
                   // If index reaches maximum reset it
                    if(currentIndex==-1)
                        currentIndex=messageCount;
                    DownloadWebPageTask task = new DownloadWebPageTask();
				    task.execute(new String[] { imageIds[currentIndex]});
                    textSwitcher.setText(texts[currentIndex]);
            }
        });
        return view;
}
	
	 private class DownloadWebPageTask extends AsyncTask<String, Void, Drawable> {

		 @Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

			PD = new ProgressDialog(getActivity());
			PD.setTitle("Please Wait..");
			PD.setMessage("Loading...");
			PD.setCancelable(false);
			PD.show();
		}
		 
		@Override
		protected Drawable doInBackground(String... params) {
			URL myUrl;
			Drawable drawable = null;
			try {
				myUrl = new URL(params[0]);

                InputStream inputStream = (InputStream)myUrl.getContent();
                 drawable = Drawable.createFromStream(inputStream, null);
                
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.i("ERROR", e.getMessage());
			}
			return drawable;
		}
		@Override
		protected void onPostExecute(Drawable result) {
			PD.dismiss();
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Log.i("SUCCESS", "s");
			try
			{
				imageSwitcher.setImageDrawable(result);
			}
			catch(Exception e)
			{
				Log.i("e", e.getMessage());
			}
			Log.i("SUCCESS", "s2");
		}
	 
	 }
}
