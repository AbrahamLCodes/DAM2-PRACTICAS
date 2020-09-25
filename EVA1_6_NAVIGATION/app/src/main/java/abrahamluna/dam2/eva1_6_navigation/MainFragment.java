package abrahamluna.dam2.eva1_6_navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment implements View.OnClickListener {

    private Button bRed, bBlue;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bRed = view.findViewById(R.id.bRed);
        bBlue = view.findViewById(R.id.bBlue);

        navController = Navigation.findNavController(view);

        bRed.setOnClickListener(this);
        bBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bBlue:
                navController.navigate(R.id.action_mainFragment_to_blueFragment);
                break;
            case R.id.bRed:
                navController.navigate(R.id.action_mainFragment_to_redFragment);
                break;

        }
    }
}