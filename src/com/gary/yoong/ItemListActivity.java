package com.gary.yoong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.gary.yoong.activities.ContactMeActivity;
import com.gary.yoong.activities.WorkExperienceActivity;
import com.gary.yoong.fragments.ContactMeFragment;
import com.gary.yoong.model.Section;

/**
 * An activity representing a list of Items. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link ItemDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ItemListFragment} and the item details (if present) is a
 * {@link ItemDetailFragment}.
 * <p>
 * This activity also implements the required {@link ItemListFragment.Callbacks}
 * interface to listen for item selections.
 */
public class ItemListActivity extends FragmentActivity implements
		ItemListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);
	
		if (findViewById(R.id.item_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((ItemListFragment) getSupportFragmentManager().findFragmentById(
					R.id.item_list)).setActivateOnItemClick(true);
		}
		
		if (savedInstanceState == null && !mTwoPane) {
			// Create the detail fragment and add it to the activity
			// using a fragment transaction.
			Bundle arguments = new Bundle();
			ItemListFragment fragment = new ItemListFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.item_list_container, fragment).commit();
		}
		
		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link ItemListFragment.Callbacks} indicating that
	 * the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(int id, String type) {
		if (mTwoPane) {

			Bundle arguments = new Bundle();
			Fragment fragment = null;
			
			if (type == Section.CONTACT) {
				fragment = new ContactMeFragment();
			} else {
				arguments.putInt(ItemDetailFragment.ARG_ITEM_ID, id);
				fragment = new ItemDetailFragment();
				fragment.setArguments(arguments);
			}
			
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.item_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			
			Intent intent = null;
			
			if (type == Section.CONTACT) {
				intent = new Intent(this, ContactMeActivity.class);
			} else if (type == Section.WORK_EXPERIENCE) {
				intent = new Intent(this, WorkExperienceActivity.class);
			} else {
				intent = new Intent(this, ItemDetailActivity.class);
				intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
			}
			
			startActivity(intent);
			overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
		}
	}
}
