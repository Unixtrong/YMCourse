package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.huangshan.demo.R;
import com.huangshan.demo.utils.Tools;

/**
 * Author(s): danyun
 * Date: 2017/7/15
 */
public class L41FragmentRed extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_l41_fragment_red, container, false);
        Button button = (Button) view.findViewById(R.id.l41_btn_red);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Tools.toast(getContext(), "Icon Man");
    }
}
