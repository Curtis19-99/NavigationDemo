package edu.cnm.deepdive.navigationdemo.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.navigationdemo.R;

public class MainFragment extends Fragment {

  private MainViewModel mViewModel;

  public static MainFragment newInstance() {
    return new MainFragment();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.main_fragment, container, false);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    Button button = getView().findViewById(R.id.button2);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        EditText userText = getView().findViewById(R.id.userText);
        MainFragmentDirections.ActionMainFragmentToSecondFragment action = MainFragmentDirections.actionMainFragmentToSecondFragment();
        action.setMessage(userText.getText().toString());
        Navigation.findNavController(view).navigate(action);
      }
    });
  }

}
