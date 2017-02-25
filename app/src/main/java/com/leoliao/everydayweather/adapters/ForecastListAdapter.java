package com.leoliao.everydayweather.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.leoliao.everydayweather.R;
import com.leoliao.everydayweather.beans.gson.DailyForecast;

import java.util.ArrayList;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/26 0:55
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ForecastListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DailyForecast> list;

    public ForecastListAdapter(Context context, ArrayList<DailyForecast> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView=View.inflate(context,R.layout.item_forecast,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        DailyForecast forecast = list.get(position);
        viewHolder.tv_date.setText(forecast.getDate());
        viewHolder.tv_dsr.setText(forecast.getWeatherCondition().getDayTimeDescription());
        viewHolder.tv_maxTemp.setText(forecast.getTmp().getMax());
        viewHolder.tv_minTemp.setText(forecast.getTmp().getMin());
        return convertView;
    }

    private class ViewHolder{
        TextView tv_date;
        TextView tv_dsr;
        TextView tv_maxTemp;
        TextView tv_minTemp;

        public ViewHolder(View contentView) {
            tv_date= (TextView) contentView.findViewById(R.id.item_forecast_tv_date);
            tv_dsr= (TextView) contentView.findViewById(R.id.item_forecast_tv_description);
            tv_maxTemp= (TextView) contentView.findViewById(R.id.item_forecast_tv_temp_max);
            tv_minTemp= (TextView) contentView.findViewById(R.id.item_forecast_tv_temp_min);
        }

    }
}
