package com.gary.yoong.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.gary.yoong.R;
import com.gary.yoong.fragments.ContactMeFragment;

public class ContactMeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_me);
	
		if (savedInstanceState == null) {
			ContactMeFragment fragment = new ContactMeFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.contact_me_container, fragment).commit();
		}
	}

	
}
