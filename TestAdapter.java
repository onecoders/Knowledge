package com.nachuantech.opensync;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TestAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<TestList> testList;
	private int selectedIndex;
	private int selectedColor = Color.parseColor("#1b1b1b");

	public TestAdapter(Context ctx, ArrayList<TestList> testList) {
		this.context = ctx;
		this.testList = testList;
		selectedIndex = -1;
	}

	public void setSelectedIndex(int ind) {
		selectedIndex = ind;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return testList.size();
	}

	@Override
	public Object getItem(int position) {
		return testList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	private class ViewHolder {
		TextView tv;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		ViewHolder holder;
		if (convertView == null) {
			vi = LayoutInflater.from(context).inflate(R.layout.test_list_item,
					null);
			holder = new ViewHolder();

			holder.tv = (TextView) vi;

			vi.setTag(holder);
		} else {
			holder = (ViewHolder) vi.getTag();
		}

		if (selectedIndex != -1 && position == selectedIndex) {
			holder.tv.setBackgroundColor(Color.BLACK);
		} else {
			holder.tv.setBackgroundColor(selectedColor);
		}
		holder.tv.setText("" + (position + 1) + " "
				+ testList.get(position).getTestText());

		return vi;
	}

}

class TestActivity extends Activity implements OnItemClickListener {
	// Implemented onItemClickListener

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		adapter.setSelectedIndex(position);
	}
}