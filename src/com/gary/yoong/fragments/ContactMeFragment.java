package com.gary.yoong.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gary.yoong.R;
import com.gary.yoong.model.ContactInfo;
import com.gary.yoong.model.Resume;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactMeFragment extends Fragment {

	private TextView mAddress1;
	private TextView mAddress2;
	private TextView mAddress3;
	private TextView mAddress4;
	
	private LatLng mCoords;
	private String mAddress;
	private String mProvince;
	private String mCountry;
	private String mPostalCode;
	private String mPhoneNumber;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ContactMeFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_contact_me,
				container, false);
		mAddress1 = (TextView) rootView.findViewById(R.id.address1);
		mAddress2 = (TextView) rootView.findViewById(R.id.address2);
		mAddress3 = (TextView) rootView.findViewById(R.id.address3);
		mAddress4 = (TextView) rootView.findViewById(R.id.address4);
		return rootView;
	}

	@Override
	public void onActivityCreated (Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		SupportMapFragment fragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
		GoogleMap map = fragment.getMap();
		
		if (savedInstanceState == null) {
			
			ContactInfo info = Resume.getInstance().getContactInfo();
			mAddress = info.getAddress();
			mCoords = info.getCoords();
			mProvince = info.getProvince();
			mCountry = info.getCountry();
			mPostalCode = info.getPostalCode();
			mPhoneNumber = info.getPhoneNumber();
			
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(mCoords, 20));
			map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
			
		} else {
			
			mAddress = savedInstanceState.getString("address");
			mCoords = savedInstanceState.getParcelable("coords");
			mProvince = savedInstanceState.getString("province");
			mCountry = savedInstanceState.getString("country");
			mPostalCode = savedInstanceState.getString("postalCode");
			mPhoneNumber = savedInstanceState.getString("phoneNumber");
		}
		
		
		map.addMarker(new MarkerOptions().position(mCoords));
		mAddress1.setText(mAddress);
		mAddress2.setText(mProvince + ", " + mCountry);
		mAddress3.setText(mPostalCode);
		mAddress4.setText(mPhoneNumber);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		
		outState.putString("address", mAddress);
		outState.putParcelable("coords", mCoords);
		outState.putString("province",mProvince);
		outState.putString("country", mCountry);
		outState.putString("postalCode", mPostalCode);
		outState.putString("phoneNumber", mPhoneNumber);
		
	}
}
