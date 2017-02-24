package com.leoliao.everydayweather.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leoliao.everydayweather.utils.LogUtil;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 20:46
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public abstract class BaseFragment extends Fragment {
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(setLayoutId(),null);
        initView();
        initData();
        initListeners();
        return rootView;
    }

    protected abstract void initListeners();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int setLayoutId();

    protected void showLog(String msg){
        LogUtil.showLog(getClass().getName(),msg);
    }

    protected View findViewById(int id){
        return rootView.findViewById(id);
    }
}
