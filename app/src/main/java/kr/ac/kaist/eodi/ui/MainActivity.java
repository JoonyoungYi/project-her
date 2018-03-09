package kr.ac.kaist.eodi.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.kaist.eodi.api.BuildingSearchApi;
import kr.ac.kaist.eodi.utils.MapManager;
import kr.ac.kaist.eodi.R;
import kr.ac.kaist.eodi.model.Building;

public class MainActivity extends ActionBarActivity {

    /**
     *
     */
    private TextView mSearchTv;
    private View mSearchBtn;
    private View mProgressbar;
    private View mResultView;
    private View mMapBtn;
    private TextView mNameTv;
    private TextView mSymbolTv;
    private ListView mLv;


    /**
     *
     */
    private LvAdapter mLvAdapter;

    /**
     *
     */
    private SearchApiTask mSearchApiTask = null;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        /**
         *
         */
        mLv = (ListView) findViewById(R.id.lv);
        mProgressbar = findViewById(R.id.progress_bar);
        mSearchTv = (TextView) findViewById(R.id.search_tv);
        mSearchBtn = findViewById(R.id.search_btn);


        mResultView = findViewById(R.id.result_view);
        mMapBtn = findViewById(R.id.map_btn);
        mNameTv = (TextView) findViewById(R.id.name_tv);
        mSymbolTv = (TextView) findViewById(R.id.symbol_tv);

        /**
         *
         */
        View headerView = getLayoutInflater().inflate(R.layout.main_activity_lv_header, null);
        View footerView = getLayoutInflater().inflate(R.layout.main_activity_lv_footer, null);
        mLv.addHeaderView(headerView);
        mLv.addFooterView(footerView);

          /*
         * ListView Setting
		 */
        ArrayList<Building> buildings = new ArrayList<>();
        mLvAdapter = new LvAdapter(this, R.layout.main_activity_lv, buildings);
        mLv.setAdapter(mLvAdapter);

        /**
         *
         */
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecordActivity.startActivity(MainActivity.this);
            }
        });

        /**
         *
         */
        RecordActivity.startActivity(MainActivity.this);
    }


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class SearchApiTask extends AsyncTask<ArrayList<String>, Void, ArrayList<Building>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            mProgressbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<Building> doInBackground(ArrayList<String>... keywords) {

            try {
                BuildingSearchApi buildingSearchApi = new BuildingSearchApi(keywords[0]);
                return buildingSearchApi.getResult();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(final ArrayList<Building> buildings) {

            if (buildings != null) {

                mLvAdapter.buildings.clear();
                mLvAdapter.buildings.addAll(buildings);
                mLvAdapter.notifyDataSetChanged();

            } else {


            }

            /**
             *
             */
            mProgressbar.setVisibility(View.GONE);

            /**
             *
             */
            mSearchApiTask = null;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mSearchApiTask = null;
        }
    }


    /**
     * ListView Apdater Setting
     */

    private class LvAdapter extends ArrayAdapter<Building> {
        private static final String TAG = "MainActivity LvAdapter";
        public ArrayList<Building> buildings;
        private ViewHolder viewHolder = null;
        private int textViewResourceId;
        private Resources r;

        public LvAdapter(Activity context, int textViewResourceId,
                         ArrayList<Building> stores) {
            super(context, textViewResourceId, stores);

            this.textViewResourceId = textViewResourceId;
            this.buildings = stores;
            this.r = getResources();

        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public int getCount() {
            return buildings.size();
        }

        @Override
        public Building getItem(int position) {
            return buildings.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

			/*
             * UI Initiailizing : View Holder
			 */

            if (convertView == null) {
                convertView = getLayoutInflater()
                        .inflate(textViewResourceId, null);

                viewHolder = new ViewHolder();
                viewHolder.mIv = (ImageView) convertView.findViewById(R.id.iv);
                viewHolder.mSymbolTv = (TextView) convertView.findViewById(R.id.symbol_tv);
                viewHolder.mNameTv = (TextView) convertView.findViewById(R.id.name_tv);
                viewHolder.mMapBtn = convertView.findViewById(R.id.map_btn);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            final Building building = this.getItem(position);

			/*
             * Data Import and export
			 */
            viewHolder.mNameTv.setText(building.getName());
            viewHolder.mSymbolTv.setText(building.getSymbol());

            viewHolder.mMapBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MapManager mapManager = new MapManager(building.getLocation());
                    mapManager.showMap(MainActivity.this);
                }
            });

            if (building.getImage_resource() == 0) {
                viewHolder.mIv.setVisibility(View.GONE);
            } else {
                viewHolder.mIv.setVisibility(View.VISIBLE);
                viewHolder.mIv.setImageResource(building.getImage_resource());
            }

            return convertView;
        }


        private class ViewHolder {
            ImageView mIv;
            TextView mSymbolTv;
            TextView mNameTv;
            View mMapBtn;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> keywords = data.getStringArrayListExtra("arg_keyword");


                if (mSearchApiTask == null) {
                    mSearchApiTask = new SearchApiTask();
                    mSearchApiTask.execute(keywords);
                }
            }
        }
    }

    /**
     *
     */
    public void onDestroy() {
        super.onDestroy();

        if (mSearchApiTask != null) {
            mSearchApiTask.cancel(true);
        }
    }

}
