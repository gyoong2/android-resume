package com.gary.yoong.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class WorkExperience implements Parcelable {
	
	private String mProject;
	private String mRole;
	private String mDate;
	private ArrayList <BulletPoint> mPoints;
	
	public WorkExperience () {
		this.mPoints = new ArrayList <BulletPoint> ();
	}
	
	@SuppressWarnings("unchecked")
	public WorkExperience (Parcel in) {
		this.mProject = in.readString();
		this.mRole = in.readString();
		this.mDate = in.readString();
		in.readList(mPoints, null);
	}
	
	public ArrayList <BulletPoint> getPoints () {
		return this.mPoints;
	}
	
	public void setProject (String project) {
		this.mProject = project;
	}
	
	public String getProject () {
		return this.mProject;
	}
	
	public void setRole (String role) {
		this.mRole = role;
	}
	
	public String getRole () {
		return this.mRole;
	}
	
	public void setDate (String date) {
		this.mDate = date;
	}
	
	public String getDate () {
		return this.mDate;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mProject);
		dest.writeString(mRole);
		dest.writeString(mDate);
		dest.writeList(mPoints);
		// TODO Auto-generated method stub
		
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public WorkExperience createFromParcel(Parcel in) {
            return new WorkExperience(in); 
        }

        public WorkExperience[] newArray(int size) {
            return new WorkExperience[size];
        }
    };
	
}
