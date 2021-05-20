package com.eclipseprogrammer.takeawalk.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.eclipseprogrammer.takeawalk.R;

import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import model.ViewRepository;


public class ViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private ViewViewModel viewViewModel;
    private ViewRepository repository;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewViewModel = new ViewModelProvider(this).get(ViewViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view, container, false);

        recyclerView = root.findViewById(R.id.recyclerCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.hasFixedSize();

        walkAdapter adapter = new walkAdapter(new walkAdapter.OnListItemClickListener() {
            @Override
            public void onClick(int position) {
                //NavHostFragment.findNavController(ViewFragment.this).navigate(R.id.recyclerCategory);
            if (position == 0){
                Navigation.findNavController(ViewFragment.this.getView()).navigate(R.id.trueFragment);
            } else if (position == 1){
                Navigation.findNavController(ViewFragment.this.getView()).navigate(R.id.testFragment);
            } else if (position == 2){
                Navigation.findNavController(ViewFragment.this.getView()).navigate(R.id.skovrutenFragment);
            } else if (position == 3){
                Navigation.findNavController(ViewFragment.this.getView()).navigate(R.id.arslevFragment);
            } else if (position == 4){
                Navigation.findNavController(ViewFragment.this.getView()).navigate(R.id.brabrandFragment);
            } else if (position == 5){
                Navigation.findNavController(ViewFragment.this.getView()).navigate(R.id.egaFragment);
            } else if (position == 6){
                Navigation.findNavController(ViewFragment.this.getView()).navigate(R.id.mapsActivity);

            }
            }
        });
        recyclerView.setAdapter(adapter);

        viewViewModel.getWalk().observe(getViewLifecycleOwner(), walks -> {
            adapter.updateData(walks);
        });
        return root;
    }


}