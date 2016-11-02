package com.srima.listfrag;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by srima on 02-11-2016.
 */
public class CountryList extends ListFragment {
    // Array of strings storing country names
    String[] countries = new String[] {
            "jellybean",
            "honeycomb",
            "icecream sandwich",
            "lollypop"
    };

    // Array of integers points to images stored in /res/drawable/
    int[] flags = new int[]{
            R.drawable.jellybean,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.lollypop
    };

    // Array of strings to store currencies
    String[] currency = new String[]{
            "4.1–4.3.1",
            "3.0–3.2.6",
            "4.0–4.0.4",
            "5.0–5.1.1"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<4;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", "androidname : " + countries[i]);
            hm.put("cur","version : " + currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
