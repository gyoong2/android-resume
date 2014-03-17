package com.gary.yoong.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.gary.yoong.R;
import com.gary.yoong.adapters.WorkExperienceAdapter;
import com.gary.yoong.model.Resume;
import com.gary.yoong.model.WorkExperience;

public class WorkExperienceFragment extends Fragment {

	private ExpandableListView mListView;
	private TextView mTextViewCompany;
	private TextView mTextViewDate;
	private ArrayList <WorkExperience> mExperience;
	private String mCompany, mDate;
	
	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public WorkExperienceFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_work_experience,
				container, false);
		mListView = (ExpandableListView) rootView.findViewById(R.id.work_experiences);
		mTextViewCompany = (TextView) rootView.findViewById(R.id.company);
		mTextViewDate = (TextView) rootView.findViewById(R.id.date);
		return rootView;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onActivityCreated (Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (savedInstanceState == null) {
			mExperience = Resume.getInstance().getExperience();
			mCompany = Resume.getInstance().getCompany();
			mDate = Resume.getInstance().getDate();
		} else {
			mExperience = (ArrayList<WorkExperience>) savedInstanceState.getSerializable("experience");
			mCompany = savedInstanceState.getString("company");
			mDate = savedInstanceState.getString("date");
		}
		
		mListView.setAdapter(new WorkExperienceAdapter(getActivity(), mExperience));
		mListView.expandGroup(0, false);
		mTextViewCompany.setText(mCompany);
		mTextViewDate.setText(mDate);
		
	}
	
	@Override
	public void onSaveInstanceState (Bundle outState) {
		outState.putSerializable("experience", mExperience);
		outState.putString("company", mCompany);
		outState.putString("date", mDate);
	}
}
