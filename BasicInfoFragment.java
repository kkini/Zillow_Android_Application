package com.example.zillowapp;

import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BasicInfoFragment extends Fragment {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View android = getActivity().getLayoutInflater().inflate(R.layout.basicinfo_frag, container, false);
        
        Intent i=getActivity().getIntent();
        Bundle b = i.getExtras();
        final Property p = (Property) b.getParcelable("property");
        Log.i("property", p.toString());
        TextView address=(TextView) android.findViewById(R.id.address);
        TextView propType=(TextView) android.findViewById(R.id.propType);
        TextView yearBuilt=(TextView) android.findViewById(R.id.yearBuilt);
        TextView allTimePropChange=(TextView) android.findViewById(R.id.allTimePropChange);
        TextView allTimeRentChange=(TextView) android.findViewById(R.id.allTimeRentChange);
        TextView bathrooms=(TextView) android.findViewById(R.id.bathrooms);
        TextView bedrooms=(TextView) android.findViewById(R.id.bedrooms);
        TextView finishArea=(TextView) android.findViewById(R.id.finishArea);
        TextView lastSoldDate=(TextView) android.findViewById(R.id.lastSoldDate);
        TextView lastSoldPrice=(TextView) android.findViewById(R.id.lastSoldPrice);
        TextView lotSize=(TextView) android.findViewById(R.id.lotSize);
        TextView taxAssessYear=(TextView) android.findViewById(R.id.taxAssessYear);
        TextView taxAssess=(TextView) android.findViewById(R.id.taxAssess);
        TextView footer=(TextView) android.findViewById(R.id.footer2);
        footer.setMovementMethod(LinkMovementMethod.getInstance());
        address.setMovementMethod(LinkMovementMethod.getInstance());
        TextView footer3=(TextView) android.findViewById(R.id.footer3);
        footer3.setMovementMethod(LinkMovementMethod.getInstance());
        address.setText(Html.fromHtml("<a href=\"\">"+p.getAddress()+" "+p.getCity()+" "+p.getState()+"</a>"));
        propType.setText(p.getPropType());
        allTimePropChange.setText(p.getAllPropChange());
        allTimeRentChange.setText(p.getAllRentChange());
        bathrooms.setText(p.getBathRooms()+"");
        bedrooms.setText(p.getBedRooms()+"");
        finishArea.setText(p.getFinishedArea());
        lastSoldDate.setText(p.getLastSoldDate());
        lastSoldPrice.setText(p.getLastSoldPrice());
        lotSize.setText(p.getLotSize());
        yearBuilt.setText(p.getYearBuilt()+"");
        taxAssess.setText(p.getTaxAssess());
        taxAssessYear.setText(p.getTaxAssessYear()+"");
        String rentZestStr = getResources().getString(R.string.rentPropEstimate);
        String zestStr = getResources().getString(R.string.zestPropEstimate);
        TextView zestimate=(TextView) android.findViewById(R.id.textView24);
        TextView rentZestimate=(TextView) android.findViewById(R.id.textView30);
        rentZestimate.setText(rentZestStr+" "+p.getRentDate());
        zestimate.setText(zestStr+" "+p.getZestUpdateDate());
        TextView zestAmount=(TextView) android.findViewById(R.id.zestAmount);
        zestAmount.setText(p.getZestAmount());
        TextView rentAmount=(TextView) android.findViewById(R.id.rentAmount);
        rentAmount.setText(p.getRentAmount());

        TextView rentChange=(TextView) android.findViewById(R.id.rentChange);
        rentChange.setText(p.getRentChange());
        
        TextView overChange=(TextView) android.findViewById(R.id.overChange);
        overChange.setText(p.getOverChange());
        
        Button sendRequestButton = (Button) android.findViewById(R.id.share);
        sendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestDialog(p);        
            }
        });
        
            return android;
}
	
	private void sendRequestDialog(Property p) {
	    Bundle params = new Bundle();
	    params.putString("message", p.getAddress()+" "+p.getCity()+" "+p.getState()+"\n"+"Last Sold Price:"+p.getLastSoldPrice()+"\n Overall Change:"+p.getOverChange());
	    
	    try
	    {
	   WebDialog requestsDialog = (
	        new WebDialog.RequestsDialogBuilder(getActivity(),
	            Session.getActiveSession(),
	            params))
	            .setOnCompleteListener(new OnCompleteListener() {

	                @Override
	                public void onComplete(Bundle values,
	                    FacebookException error) {
	                    if (error != null) {
	                        if (error instanceof FacebookOperationCanceledException) {
	                            Toast.makeText(getActivity().getApplicationContext(), 
	                                "Post cancelled", 
	                                Toast.LENGTH_SHORT).show();
	                        } else {
	                            Toast.makeText(getActivity().getApplicationContext(), 
	                                "Network Error", 
	                                Toast.LENGTH_SHORT).show();
	                        }
	                    } else {
	                        final String requestId = values.getString("request");
	                        if (requestId != null) {
	                            Toast.makeText(getActivity().getApplicationContext(), 
	                                "Posted Story, ID:"+requestId,  
	                                Toast.LENGTH_SHORT).show();
	                        } else {
	                            Toast.makeText(getActivity().getApplicationContext(), 
	                                "Post cancelled", 
	                                Toast.LENGTH_SHORT).show();
	                        }
	                    }   
	                }


	            })
	            .build();
	    requestsDialog.show();
	    }
	    catch(Exception e)
	    {}
	}
}
