package com.leoliao.everydayweather.fragment;

import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.leoliao.everydayweather.R;
import com.leoliao.everydayweather.activity.MainActivity;
import com.leoliao.everydayweather.base.BaseFragment;
import com.leoliao.everydayweather.utils.NetUtils;
import com.leoliao.everydayweather.utils.ToastUtil;
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
    private ProgressBar loadingIcon;
    private TextView tv_title;
    private int currentLevel;
    private static final int PROVINCE_LEVEL=0;
    private static final int CITY_LEVEL=1;
    private static final int COUNTRY_LEVEL=2;
    private ImageView iv_backPress;


    @Override
    protected int setLayoutId() {
        return R.layout.fragment_domestic_region;
    }

    @Override
    protected void initView() {
        mListView= (ListView) findViewById(R.id.fragment_domestic_region_lstv);
        loadingIcon= (ProgressBar) findViewById(R.id.fragment_domestic_region_prgsb_loading);
        tv_title= (TextView) findViewById(R.id.fragment_domestic_region_tv_title);
        iv_backPress= (ImageView) findViewById(R.id.fragment_domestic_region_iv_back_press);
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

    @Override
    protected void initListeners() {
        iv_backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentLevel){
                    case PROVINCE_LEVEL:
                        if(getActivity()instanceof MainActivity){
                            ((MainActivity) getActivity()).closeDrawer();
                        }
                        break;
                    case CITY_LEVEL:
                        break;
                    case COUNTRY_LEVEL:
                        break;
                    default:
                        break;
                }
            }
        });

    }



    private void updateProvincesList(){
        loadingIcon.setVisibility(View.VISIBLE);
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

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                mList.clear();
                ToastUtil.showToast("加载省份失败，请检查网络是否连接。");

            }

            @Override
            public void onFinish() {
                mAdapter.notifyDataSetChanged();
                loadingIcon.setVisibility(View.GONE);
                tv_title.setText("中国");
                currentLevel=PROVINCE_LEVEL;
                super.onFinish();
            }
        });
    }



}
