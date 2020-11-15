package com.example.fragmenthuman;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListFragment extends Fragment implements OnItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<Human> ltsHuman;
    private HumanAdapter humanAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "oncreate fragment1");
        initData();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("TAG", "oncreate fragment2");
        humanAdapter = new HumanAdapter(ltsHuman, this);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //  humanAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(humanAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG", "aa");
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    private void initData() {
        ltsHuman = new ArrayList<Human>();
        for (int i = 0; i < 15; i++) {
            ltsHuman.add(new Human(i,"Nguyen Van A" + i, i + 20));
        }
    }

    public void sendPositionItem(int position) {
        DetailFragment detail = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("human", ltsHuman.get(position));
        detail.setArguments(bundle);
        getActivity().getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, detail,detail.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    public void deleteHuman(int id) {   
        if (!ltsHuman.isEmpty()){
            for (Human human : ltsHuman ) {
                if (human.getId()==id){
                    ltsHuman.remove(human);
                    break;
                }
            }
        }
    }
}