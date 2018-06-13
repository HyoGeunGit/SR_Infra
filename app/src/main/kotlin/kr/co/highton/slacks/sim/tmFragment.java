package kr.co.highton.slacks.sim;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by shimh on 2018-06-13.
 */
public  class tmFragment extends  Fragment {

    public void tmFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridView GridSchedule;
        ScheduleAdapter adapter;

        GridSchedule = view.findViewById(R.id.maintable);
        adapter = new ScheduleAdapter(getContext());
    }
}
