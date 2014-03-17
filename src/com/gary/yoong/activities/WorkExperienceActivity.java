package com.gary.yoong.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.gary.yoong.R;
import com.gary.yoong.fragments.WorkExperienceFragment;

public class WorkExperienceActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_work_experience);
	
		if (savedInstanceState == null) {
			WorkExperienceFragment fragment = new WorkExperienceFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.work_experience_container, fragment).commit();
		}
	}

	
}

