package com.leoliao.everydayweather.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.leoliao.everydayweather.beans.gson.Suggestions;

import java.util.ArrayList;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/26 15:43
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class SuggestionListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Suggestions>mList;

    public SuggestionListAdapter(Context context, ArrayList<Suggestions> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
