package com.gary.yoong.model;

import java.util.ArrayList;

import com.gary.yoong.R;
import com.google.android.gms.maps.model.LatLng;

public class Resume {
	
	private ArrayList <Section> sections;
	private ArrayList <WorkExperience> mExperience;
	private ContactInfo contactInfo;
	private String mCompany;
	private String mDate;
	
	private static Resume mInstance;
	
	
	public Resume () {
		
		Section skills = new Section ("Skills & Qualifications", "What makes me special?", "GENERAL", R.drawable.ic_action_important);
		Section experience = new Section ("Work Experience", "Where have I worked?", "WORK_EXPERIENCE", R.drawable.ic_action_copy);
		Section education = new Section ("Education", "Where did I go to school?", "GENERAL", R.drawable.ic_action_edit);
		Section contact = new Section ("Contact Me", "How to reach me?", "CONTACT", R.drawable.ic_action_call);
		
		contactInfo = new ContactInfo();
		contactInfo.setAddress("18 George Martin Drive");
		contactInfo.setCountry("Canada");
		contactInfo.setPhoneNumber("416-388-3623");
		contactInfo.setPostalCode("L3R 8V1");
		contactInfo.setProvince("Ontario");
		contactInfo.setCoords(new LatLng(43.861223,-79.285612));
							
		mCompany = "IBM Canada - Global Business Services";
		mDate = "2008 - Present";
		
		BulletPoint point1 = new BulletPoint("Purpose of this project was to develop a mobile application using the IBM Worklight platform for a large Canadian financial institution.  Using this application, users are able to complete everyday personal banking transactions from their mobile phones.");
		BulletPoint point2 = new BulletPoint("Key responsibilities included development of critical path components, writing technical documentation, defect triage, leading scrums, code reviews, managing development timelines, creating builds/releases and providing technical leadership.");
		
		WorkExperience work1 = new WorkExperience();
		work1.setProject("Large Canadian Financial Institution");
		work1.setDate("January 1, 2014");
		work1.setRole("Lead Developer");
		work1.getPoints().add(point1);
		work1.getPoints().add(point2);
		
		BulletPoint point3 = new BulletPoint("Purpose of this project was to develop a mobile application using the Kony platform for a large Canadian financial institution.  Using this application, users are able manage their business banking transactions from their mobile phones.");
		BulletPoint point4 = new BulletPoint("Key responsibilities included development of critical path components, code reviews, creating builds/releases and providing technical leadership.");
		
		WorkExperience work2 = new WorkExperience();
		work2.setProject("Large Canadian Financial Institution");
		work2.setRole("Senior Developer");
		work2.getPoints().add(point3);
		work2.getPoints().add(point4);
				
		mExperience = new ArrayList <WorkExperience> ();
		mExperience.add(work1);
		mExperience.add(work2);


		sections = new ArrayList <Section> ();
		sections.add(skills);
		sections.add(experience);
		sections.add(education);
		sections.add(contact);

	}
	
	public static Resume getInstance () {
		
		if (mInstance == null) {
			mInstance = new Resume();
		}
		return mInstance;
	}
	
	public ArrayList <Section> getSections () {
		return this.sections;
	}
	
	public ContactInfo getContactInfo () {
		return this.contactInfo;
	}
	
	public ArrayList <WorkExperience> getExperience() {
		return this.mExperience;
	}
	
	public String getCompany() {
		return this.mCompany;
	}
	
	public String getDate () {
		return this.mDate;
	}

}
