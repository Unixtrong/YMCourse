package com.huangshan.demo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangshan.demo.R;
import com.huangshan.demo.utils.Tools;

/**
 * Author(s): danyun
 * Date: 2017/7/15
 */
public class L41FragmentBlue extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Tools.debug("onCreateView");
        return inflater.inflate(R.layout.fragment_l41_fragment_blue, container, false);
    }

    @Override
    public void onAttach(Context context) {
        Tools.debug("onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Tools.debug("onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Tools.debug("onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        Tools.debug("onPause");
        super.onPause();
    }

    @Override
    public void onResume() {
        Tools.debug("onResume");
        super.onResume();
    }

    @Override
    public void onStart() {
        Tools.debug("onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        Tools.debug("onStop");
        super.onStop();
    }

    @Override
    public void onDetach() {
        Tools.debug("onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Tools.debug("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Tools.debug("onDestroyView");
        super.onDestroyView();
    }
}
