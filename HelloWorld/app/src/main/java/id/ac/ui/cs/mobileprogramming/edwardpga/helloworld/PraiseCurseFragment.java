package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PraiseCurseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PraiseCurseFragment extends Fragment {

    private NameVIewModel nameViewModel;
    private TextView txtName;

    public PraiseCurseFragment() {
        // Required empty public constructor
    }

    public static PraiseCurseFragment newInstance() {
        return new PraiseCurseFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nameViewModel = ViewModelProviders.of(requireActivity()).get(NameVIewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_praise_curse, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.textViewName);

        nameViewModel.getPhrase().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtName.setText(s);
            }
        });
    }
}