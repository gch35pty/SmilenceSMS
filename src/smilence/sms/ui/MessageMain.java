package smilence.sms.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import smilence.sms.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MessageMain extends Activity{
	ListView itemlist = null;
    List<Map<String, Object>> list;
    private  String[] texts=new String[]{"天气阿斯顿会发送给的发生伽师道个"
			  ,"hahaasdfasdf","背景阿斯顿仿盛大发生的"};
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        itemlist = (ListView) findViewById(R.id.messageList);
        itemlist.setAdapter(new MessageItemAdapter(this));
        itemlist.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				show(arg2);
			}
        	
        });
        //refreshListItems();
	}
	public void show(int pos)
	{
		Toast.makeText(this, texts[pos], Toast.LENGTH_SHORT).show();  
	}
	private class MessageItemAdapter extends BaseAdapter
	{
		private Context mContext;  
		public MessageItemAdapter(Context context)
		{
			this.mContext = context;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return texts.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView==null)
			{
				if(position%2==0)
				{
					convertView = LayoutInflater.from(mContext).
									inflate(R.layout.message_item_in, null);
					ItemViewCache viewCache = new ItemViewCache();
					viewCache.messageText = (TextView)convertView.
											findViewById(R.id.TextView01);
					convertView.setTag(viewCache);
				}
				else
				{
					convertView = LayoutInflater.from(mContext).
									inflate(R.layout.message_item_out, null);
					ItemViewCache viewCache = new ItemViewCache();
					viewCache.messageText = (TextView)convertView.
									findViewById(R.id.TextView02);
					convertView.setTag(viewCache);
				}
			}
			ItemViewCache cache = (ItemViewCache)convertView.getTag();
			cache.messageText.setText(texts[position]);
			return convertView;
		}
		
	}
	private static class ItemViewCache
	{
		public TextView messageText;
	}
}
