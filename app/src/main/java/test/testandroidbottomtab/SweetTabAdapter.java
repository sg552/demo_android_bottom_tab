package test.testandroidbottomtab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siwei on 17-6-22.
 */
public class SweetTabAdapter extends FragmentPagerAdapter {
    Context myContext;

    List<Fragment> pagerList;
    String[] titles = { "title1", "title2", "title3"};

    private static final int[] icons = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher };

    public SweetTabAdapter(Context context, FragmentManager fm){
        super(fm);
        myContext = context;
        pagerList = new ArrayList<>();
        for(int i=0; i< 3; i++){
            pagerList.add(new TabFragment());
        }
    }

    @Override
    public int getCount(){
        return pagerList != null ?
                pagerList.size() :
                0;
    }

    @Override
    public Fragment getItem(int position){
        return pagerList.get(position);

    }

    public View getTabView(int position){
        View view = LayoutInflater.from(myContext).inflate(R.layout.tab_view, null);
        TextView tv = (TextView) view.findViewById(R.id.tab_title);
        tv.setText(titles[position]);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        imageView.setImageResource(icons[position]);
        return view;
    }

}
