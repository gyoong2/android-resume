package com.gary.yoong.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gary.yoong.R;
import com.gary.yoong.model.BulletPoint;
import com.gary.yoong.model.WorkExperience;

public class WorkExperienceAdapter extends BaseExpandableListAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList <WorkExperience> mExperiences;

	public WorkExperienceAdapter (Context context, ArrayList <WorkExperience> experiences) {
		this.mContext = context;
		this.mInflater = ((Activity)mContext).getLayoutInflater();
		this.mExperiences = experiences;
	}

	@Override
	public BulletPoint getChild(int groupPosition, int childPosition) {

		BulletPoint point = this.mExperiences.get(groupPosition).getPoints().get(childPosition);
		return point;

	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		ChildViewHolder holder = null;
		BulletPoint point = this.getChild(groupPosition, childPosition);

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_bullet_point, parent, false);
			holder = new ChildViewHolder();
			holder.point = (TextView) convertView.findViewById(R.id.point);
			convertView.setTag(holder);
		} else {
			holder = (ChildViewHolder) convertView.getTag();
		}

		holder.point.setText(point.getDescription());
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {

		ArrayList <BulletPoint> points = this.mExperiences.get(groupPosition).getPoints();

		if (points != null) {
			return points.size();
		} 

		return 0;

	}

	@Override
	public WorkExperience getGroup(int groupPosition) {

		return this.mExperiences.get(groupPosition);

	}

	@Override
	public int getGroupCount() {

		return this.mExperiences.size();
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		GroupViewHolder holder = null;
		WorkExperience experience = this.getGroup(groupPosition);

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.group_work_experience,  parent, false);
			holder = new GroupViewHolder();
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.project = (TextView) convertView.findViewById(R.id.project);
			holder.role = (TextView) convertView.findViewById(R.id.role);
			//holder.date = (TextView) convertView.findViewById(R.id.date);
			convertView.setTag(holder);
		} else {
			holder = (GroupViewHolder) convertView.getTag();
		}

		//holder.icon.setImageResource(R.drawable);
		holder.project.setText(experience.getProject());
		holder.role.setText(experience.getRole());
		//holder.date.setText(experience.getDate());
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	static class ChildViewHolder {
		TextView point;
	}

	static class GroupViewHolder {
		ImageView icon;
		TextView project;
		TextView role;
		TextView date;

	}

}