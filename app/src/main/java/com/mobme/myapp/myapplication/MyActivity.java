package com.mobme.myapp.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyActivity extends Activity {

    ListView lv_plants;
    EditText et_plants_search;

    ArrayList<String> plant_name_array = new ArrayList<String>();
    ArrayList<String> search_plant_name_array = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        lv_plants = (ListView) findViewById(R.id.lv_plants);
        et_plants_search = (EditText) findViewById(R.id.et_search_plant);

        plant_name_array.add("Black Alder");
        plant_name_array.add("Almond");
        plant_name_array.add("Apple");
        plant_name_array.add("Blue Ash");
        plant_name_array.add("Bamboo");
        plant_name_array.add("Banana");
        plant_name_array.add("Bearberry");
        plant_name_array.add("Birch");
        plant_name_array.add("Blackberry");
        plant_name_array.add("Canada Root");
        plant_name_array.add("Coneflower");
        plant_name_array.add("Cress");
        plant_name_array.add("Deadnettle");
        plant_name_array.add("Drumstick");
        plant_name_array.add("Earth Gall");
        plant_name_array.add("Fellenwort");

        for (int i = 0; i < plant_name_array.size(); i++)
            search_plant_name_array.add(plant_name_array.get(i));

        MySimpleBaseAdapter adapter = new MySimpleBaseAdapter();
        lv_plants.setAdapter((ListAdapter) adapter);


        /************plants name search by text********************/
        et_plants_search.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

                String search_name = et_plants_search.getText().toString();
                int search_length = search_name.length();
                try {
                    search_plant_name_array.clear();

                    for (int i = 0; i < plant_name_array.size(); i++) {
                        if (search_length <= plant_name_array.get(i).length()) {
                            if (search_name.equalsIgnoreCase("" + plant_name_array.get(i).subSequence(0, search_length))) {
                                search_plant_name_array.add(plant_name_array.get(i));

                            }
                        }
                    }

                   /* if(event_search_id_array.size()>0)
                    {
                        iv_event_list_back.setVisibility(View.GONE);
                    }
                    else
                    {
                        iv_event_list_back.setVisibility(View.VISIBLE);
                    }*/
                    MySimpleBaseAdapter adapter = new MySimpleBaseAdapter();
                    lv_plants.setAdapter((ListAdapter) adapter);

                } catch (Exception e) {
                    // TODO: handle exception
                    Log.e("search", e.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**************base adapter to show list view in account details*************/
    class MySimpleBaseAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public MySimpleBaseAdapter()
        {

            inflater = (LayoutInflater) MyActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return search_plant_name_array.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            if(convertView==null)
                convertView= inflater.inflate(R.layout.custom_plats_listview, parent, false);

            ((TextView)convertView.findViewById(R.id.tv_plants_name)).setText(search_plant_name_array.get(position));
            return convertView;

        }
    }


}
