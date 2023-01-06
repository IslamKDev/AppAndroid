// Generated by view binder compiler. Do not edit!
package fr.univ_reims.informatique.islam.shareit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import fr.univ_reims.informatique.islam.shareit.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentContactBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button buttonContact;

  private FragmentContactBinding(@NonNull FrameLayout rootView, @NonNull Button buttonContact) {
    this.rootView = rootView;
    this.buttonContact = buttonContact;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentContactBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentContactBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_contact, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentContactBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonContact;
      Button buttonContact = ViewBindings.findChildViewById(rootView, id);
      if (buttonContact == null) {
        break missingId;
      }

      return new FragmentContactBinding((FrameLayout) rootView, buttonContact);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}