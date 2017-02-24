package com.leoliao.everydayweather.fragment;

import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.leoliao.everydayweather.R;
import com.leoliao.everydayweather.base.BaseFragment;
import com.leoliao.everydayweather.utils.NetUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 20:54
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class RegionListFragment extends BaseFragment {
    private ListView mListView;
    private ArrayList<String> mList=new ArrayList<>();
    private ArrayAdapter<String> mAdapter;
    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,mList){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setGravity(Gravity.CENTER);
                return view;
            }
        };
        mListView.setAdapter(mAdapter);
        updateProvincesList();

    }

    private void updateProvincesList(){
        NetUtils.requestProvinces(new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONArray jsonArray=new JSONArray(new String(responseBody));

                    int len=jsonArray.length();
                    mList.clear();
                    for(int i=0;i<len;i++){
                        JSONObject temp = jsonArray.getJSONObject(i);
                        if(temp!=null){
                            mList.add(temp.getString("name"));
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    @Override
    protected void initView(View rootView) {
        mListView= (ListView) rootView.findViewById(R.id.fragment_domestic_region_lstv);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_domestic_region;
    }
}
