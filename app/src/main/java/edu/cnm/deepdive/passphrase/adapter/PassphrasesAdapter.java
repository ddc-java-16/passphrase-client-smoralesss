package edu.cnm.deepdive.passphrase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.passphrase.R;
import edu.cnm.deepdive.passphrase.adapter.PassphrasesAdapter.Holder;
import edu.cnm.deepdive.passphrase.model.Passphrase;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class PassphrasesAdapter extends RecyclerView.Adapter<Holder> {

  private final List<Passphrase> passphrases;
  private final LayoutInflater inflater;
  @ColorInt
  private final int evenRowColor;
  @ColorInt
  private final int oddRowColor;
  public PassphrasesAdapter(Context context, List<Passphrase> passphrases) {
    this.passphrases = passphrases;
    inflater = LayoutInflater.from(context);
    evenRowColor = context.getColor(R.color.even_row_color);
    oddRowColor = context.getColor(R.color.odd_row_color);
  }

  @NonNull
  @NotNull
  @Override
  public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull @NotNull Holder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  public class Holder extends RecyclerView.ViewHolder {

    public Holder(
        @NonNull @NotNull View itemView) {
      super(itemView);
    }
  }
}
