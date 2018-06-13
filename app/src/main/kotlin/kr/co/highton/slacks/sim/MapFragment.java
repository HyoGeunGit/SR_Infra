package kr.co.highton.slacks.sim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MapFragment extends Fragment {
    public CanvasMapView m;

    public MapFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        m = new CanvasMapView(getContext());
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.map_view);
        frameLayout.addView(m);
    }
}


class CanvasMapView extends View {
    float y=-1000, savedY;
    //public boolean isChanged = true;

    public CanvasMapView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //if (isChanged) {
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            Bitmap b= BitmapFactory.decodeResource(getResources(), R.drawable.test_image);

            canvas.drawBitmap(b, (b.getWidth() - canvas.getWidth()) / 2 * -1, y, paint);
        //    isChanged = false;
        //}
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                savedY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE :
                float finalY = event.getY();
                y += finalY - savedY;

                savedY = event.getY();
                invalidate();
//                isChanged = true;

                break;
        }
        return true;
    }
}