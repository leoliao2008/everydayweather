package com.leoliao.everydayweather.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.leoliao.everydayweather.beans.loc.City;
import com.leoliao.everydayweather.beans.loc.Country;
import com.leoliao.everydayweather.beans.loc.Province;
import com.leoliao.everydayweather.beans.loc.Region;

import java.util.List;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/25 21:01
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class RegionListAdapter extends ArrayAdapter<Region> {
    private List<Region>mList;
    private Context mContext;
    public RegionListAdapter(Context context,List<Region> list) {
        super(context, android.R.layout.simple_list_item_1, list);
        mList=list;
        mContext=context;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setGravity(Gravity.CENTER);
        Region temp=mList.get(position);
        if(temp instanceof Province){
            view.setText(((Province) temp).getProvinceName());
        }else if(temp instanceof City){
            view.setText(((City) temp).getCityName());
        }else if(temp instanceof Country){
            view.setText(((Country) temp).getCountryName());
        }
        return view;
    }
}
