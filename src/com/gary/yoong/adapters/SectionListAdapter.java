package com.gary.yoong.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gary.yoong.R;
import com.gary.yoong.model.Section;

public class SectionListAdapter extends BaseAdapter {
	
	private ArrayList <Section> mItems; 
	private LayoutInflater mInflater;
	private Context mContext;

	
	public SectionListAdapter (ArrayList <Section> sections, Context context) {
		this.mItems = sections;
		this.mContext = context;
		this.mInflater = ((Activity)this.mContext).getLayoutInflater();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItems.size();
	}

	@Override
	public Object getItem(int index) {
		// TODO Auto-generated method stub
		return mItems.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		Section item = mItems.get(position);
		
		if(convertView==null){
            // inflate the layout
            convertView = mInflater.inflate(R.layout.section_item, parent, false);
            holder = new ViewHolder();
            holder.title = ((TextView)convertView.findViewById(R.id.title));
            holder.description = ((TextView)convertView.findViewById(R.id.description));
            holder.icon = ((ImageView)convertView.findViewById(R.id.icon));
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
		}
		
		holder.title.setText(item.getTitle());
		holder.description.setText(item.getDescription());
		holder.icon.setImageResource(item.getIcon());
        return convertView;
	}
	
	static class ViewHolder{
        TextView title;
        TextView description;
        ImageView icon;
    }

}
