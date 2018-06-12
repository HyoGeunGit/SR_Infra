package kr.co.highton.slacks.sim;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.GridView;

/**
 * Created by shimh on 2018-06-13.
 */
public  class tmFragment extends  Fragment {
    public class tmfragment extends Activity {

        GridView GridSchedule;
        ScheduleAdapter adapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);

            setContentView(R.layout.fragment_tm);

            GridSchedule = (GridView) findViewById(R.id.schedule);

            adapter = new ScheduleAdapter(this);

            GridSchedule.setAdapter(adapter);
        }
    }
}