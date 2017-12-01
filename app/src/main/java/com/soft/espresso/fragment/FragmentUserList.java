package com.soft.espresso.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soft.espresso.R;
import com.soft.espresso.UserDetail;
import com.soft.espresso.adapter.MyRecyclerViewAdapter;
import com.soft.espresso.model.DataObject;

import java.util.ArrayList;

/**
 * Created by narinder.rana on 11/30/2017.
 */

public class FragmentUserList extends Fragment {

    private static final String TAG = "FragmentUserList.class";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyRecyclerViewAdapter mAdapter;

    public FragmentUserList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userlist, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView) {

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

    }

    @Override
    public void onResume() {
        super.onResume();

        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
             //   Log.e(TAG, " Clicked on Item " + position);
               // Toast.makeText(getActivity(), "Clicked on Item "+position, Toast.LENGTH_LONG).show();

                startActivity(new Intent(getActivity(), UserDetail.class));

            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("UserName " + index,
                    "name" + index+"@gmail.com");
            results.add(index, obj);
        }
        return results;
    }


}