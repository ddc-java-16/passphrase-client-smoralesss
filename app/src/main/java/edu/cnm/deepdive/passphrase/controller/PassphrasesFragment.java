package edu.cnm.deepdive.passphrase.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.passphrase.adapter.PassphrasesAdapter;
import edu.cnm.deepdive.passphrase.databinding.FragmentPassphrasesBinding;
import edu.cnm.deepdive.passphrase.viewmodel.PassphraseViewModel;

public class PassphrasesFragment extends Fragment {

  private FragmentPassphrasesBinding binding;
  private PassphraseViewModel viewModel;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentPassphrasesBinding.inflate(inflater, container, false);
    binding.refresh.setOnClickListener((v) -> viewModel.fetch());
    //noinspection DataFlowIssue
    binding.search.setOnClickListener(
        (v) -> viewModel.search(binding.searchText.getText().toString()));
    // TODO: 11/2/23 Attach listeners.
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(requireActivity())
        .get(PassphraseViewModel.class);
    getLifecycle().addObserver(viewModel);
    viewModel
        .getPassphrases()
        .observe(getViewLifecycleOwner(), (passphrases) -> binding.passphrases.setAdapter(
            new PassphrasesAdapter(requireContext(), passphrases)));
  }

}