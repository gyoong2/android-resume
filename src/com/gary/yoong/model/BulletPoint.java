package com.gary.yoong.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BulletPoint implements Parcelable {
	
	private String description;
	
	public BulletPoint (String description) {
		this.description = description;
	}
	
	private BulletPoint (Parcel in) {
		this.description = in.readString();
	}
	
	public String getDescription () {
		return this.description;
	}
	
	public void setDescription (String description) {
		this.description = description;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(description);		
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public BulletPoint createFromParcel(Parcel in) {
            return new BulletPoint(in); 
        }

        public BulletPoint[] newArray(int size) {
            return new BulletPoint[size];
        }
    };

}
