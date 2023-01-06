// Generated by view binder compiler. Do not edit!
package fr.univ_reims.informatique.islam.shareit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import fr.univ_reims.informatique.islam.shareit.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentStockageBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button charger;

  @NonNull
  public final Button sauvegarder;

  private FragmentStockageBinding(@NonNull LinearLayout rootView, @NonNull Button charger,
      @NonNull Button sauvegarder) {
    this.rootView = rootView;
    this.charger = charger;
    this.sauvegarder = sauvegarder;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentStockageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentStockageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_stockage, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentStockageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.charger;
      Button charger = ViewBindings.findChildViewById(rootView, id);
      if (charger == null) {
        break missingId;
      }

      id = R.id.sauvegarder;
      Button sauvegarder = ViewBindings.findChildViewById(rootView, id);
      if (sauvegarder == null) {
        break missingId;
      }

      return new FragmentStockageBinding((LinearLayout) rootView, charger, sauvegarder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}