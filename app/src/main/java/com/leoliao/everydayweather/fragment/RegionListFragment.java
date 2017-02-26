package com.leoliao.everydayweather.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.leoliao.everydayweather.R;
import com.leoliao.everydayweather.activity.MainActivity;
import com.leoliao.everydayweather.adapters.RegionListAdapter;
import com.leoliao.everydayweather.base.BaseFragment;
import com.leoliao.everydayweather.beans.loc.City;
import com.leoliao.everydayweather.beans.loc.Country;
import com.leoliao.everydayweather.beans.loc.Province;
import com.leoliao.everydayweather.beans.loc.Region;
import com.leoliao.everydayweather.utils.NetUtils;
import com.leoliao.everydayweather.utils.ToastUtil;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

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
    private List<Region> mList=new ArrayList<>();
    private RegionListAdapter mAdapter;
    private ProgressBar loadingIcon;
    private TextView tv_title;
    private int currentLevel;
    private static final int PROVINCE_LEVEL=0;
    private static final int CITY_LEVEL=1;
    private static final int COUNTRY_LEVEL=2;
    private ImageView iv_backPress;
    private Province currentProvince;
    private City currentCity;
    private Country currentCountry;



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
        mAdapter=new RegionListAdapter(getContext(),mList);
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
                        updateProvincesList();
                        break;
                    case COUNTRY_LEVEL:
                        updateCitiesList(currentProvince);
                        break;
                    default:
                        break;
                }
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Region temp = mList.get(position);
                if(temp instanceof Province){
                    currentProvince= (Province) temp;
                    updateCitiesList(currentProvince);
                }else if(temp instanceof City){
                    currentCity= (City) temp;
                    updateCountriesList(currentCity);
                }else if(temp instanceof Country){
                    currentCountry= (Country) temp;
                    if(getActivity()instanceof MainActivity){
                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).updateWeather(currentCountry);
                        updateProvincesList();
                    }
                }
            }
        });

    }

    private void updateCitiesList(final Province province){
        loadingIcon.setVisibility(View.VISIBLE);
        List<City> cities = DataSupport.where("provinceCode=?", province.getProvinceCode()).find(City.class);
        if(cities.size()>0){
            showLog("get cities from local data base");
            mList.clear();
            mList.addAll(cities);
            mAdapter.notifyDataSetChanged();
            mListView.setSelection(0);
            loadingIcon.setVisibility(View.GONE);
            tv_title.setText(province.getProvinceName());
            currentLevel=CITY_LEVEL;
            return;
        }
        NetUtils.requestCities(province, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                mListView.setEnabled(false);
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONArray jsonArray=new JSONArray(new String(responseBody));
                    int len=jsonArray.length();
                    mList.clear();
                    for(int i=0;i<len;i++){
                        JSONObject temp = jsonArray.getJSONObject(i);
                        if(temp!=null){
                            City city=new City(province.getProvinceCode(),
                                               province.getProvinceName(),
                                               temp.getString("name"),
                                               temp.getString("id"));
                            mList.add(city);
                            city.save();
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    mListView.setSelection(0);
                    tv_title.setText(province.getProvinceName());
                    currentLevel= CITY_LEVEL;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ToastUtil.showToast("加载城市失败，请检查网络是否连接。");
            }

            @Override
            public void onFinish() {
                mListView.setEnabled(true);
                loadingIcon.setVisibility(View.GONE);
                super.onFinish();
            }
        });
    }



    private void updateProvincesList(){
        loadingIcon.setVisibility(View.VISIBLE);
        List<Province> all = DataSupport.findAll(Province.class);
        if(all.size()>0){
            showLog("get provinces from local data base");
            mList.clear();
            mList.addAll(all);
            mAdapter.notifyDataSetChanged();
            mListView.setSelection(0);
            loadingIcon.setVisibility(View.GONE);
            tv_title.setText("中国");
            currentLevel=PROVINCE_LEVEL;
            return;
        }
        NetUtils.requestProvinces(new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                mListView.setEnabled(false);
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONArray jsonArray=new JSONArray(new String(responseBody));
                    int len=jsonArray.length();
                    mList.clear();
                    for(int i=0;i<len;i++){
                        JSONObject temp = jsonArray.getJSONObject(i);
                        if(temp!=null){
                            Province province=new Province(temp.getString("name"),temp.getString("id"));
                            mList.add(province);
                            province.save();
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    mListView.setSelection(0);
                    tv_title.setText("中国");
                    currentLevel=PROVINCE_LEVEL;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ToastUtil.showToast("加载省份失败，请检查网络是否连接。");
            }

            @Override
            public void onFinish() {
                mListView.setEnabled(true);
                loadingIcon.setVisibility(View.GONE);
                super.onFinish();
            }
        });
    }

    private void updateCountriesList(final City city){
        loadingIcon.setVisibility(View.VISIBLE);
        List<Country> countries = DataSupport.where("cityCode=?", city.getCityCode()).find(Country.class);
        if(countries.size()>0){
            showLog("get counties from local data base");
            mList.clear();
            mList.addAll(countries);
            mAdapter.notifyDataSetChanged();
            mListView.setSelection(0);
            loadingIcon.setVisibility(View.GONE);
            tv_title.setText(city.getCityName());
            currentLevel=COUNTRY_LEVEL;
            return;
        }
        NetUtils.requestCountries(city, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                mListView.setEnabled(false);
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONArray jsonArray=new JSONArray(new String(responseBody));
                    int len=jsonArray.length();
                    mList.clear();
                    for(int i=0;i<len;i++){
                        JSONObject temp = jsonArray.getJSONObject(i);
                        if(temp!=null){
                            Country country = new Country(temp.getString("name"),
                                                          temp.getString("id"),
                                                          city.getCityName(),
                                                          city.getCityCode(),
                                                          city.getProvinceName(),
                                                          city.getProvinceCode(),
                                                          temp.getString("weather_id"));
                            mList.add(country);
                            country.save();
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    mListView.setSelection(0);
                    tv_title.setText(city.getCityName());
                    currentLevel= COUNTRY_LEVEL;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ToastUtil.showToast("加载县城失败，请检查网络是否连接。");
            }

            @Override
            public void onFinish() {
                mListView.setEnabled(true);
                loadingIcon.setVisibility(View.GONE);
                super.onFinish();
            }
        });
    }



}
