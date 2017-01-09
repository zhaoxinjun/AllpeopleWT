package zxj.com.allpeoplewt.view.fragment.alltvfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zxj.com.allpeoplewt.R;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/4.
 */

public class tv1 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.tv1_fragment_layout,null);
    }
}
