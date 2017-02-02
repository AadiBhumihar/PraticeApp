package com.example.aadi.praticeapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by aadi on 10/3/16.
 */
public class ImageAdapter extends BaseAdapter {

    public Context mcontext;

    public ImageAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    private int[] imarray = {R.drawable.sam3,R.drawable.sam4,
            R.drawable.sam5 ,R.drawable.sam6,
            R.drawable.sam1 ,R.drawable.sam2,
            R.drawable.sam3,R.drawable.sam4 ,
            R.drawable.sam5,R.drawable.sam6,
            R.drawable.sam0 ,R.drawable.sam7
    };



    @Override
    public int getCount() {
        return imarray.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imv;
        if (view==null)
        {
            imv = new ImageView(mcontext);
            imv.setLayoutParams(new GridView.LayoutParams(350,350));
            imv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imv.setPadding(1,1,1,1);
        } else {
            imv = (ImageView)view ;
        }

        imv.setImageResource(imarray[i]);
        return imv;

    }
}
