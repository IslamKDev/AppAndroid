// Generated by view binder compiler. Do not edit!
package fr.univ_reims.informatique.islam.shareit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import fr.univ_reims.informatique.islam.shareit.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySplashScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar SplashScreenProgressBar;

  @NonNull
  public final TextView loadingSplashScreenTextView;

  @NonNull
  public final ImageView logoSplashScreenImageView;

  private ActivitySplashScreenBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar SplashScreenProgressBar, @NonNull TextView loadingSplashScreenTextView,
      @NonNull ImageView logoSplashScreenImageView) {
    this.rootView = rootView;
    this.SplashScreenProgressBar = SplashScreenProgressBar;
    this.loadingSplashScreenTextView = loadingSplashScreenTextView;
    this.logoSplashScreenImageView = logoSplashScreenImageView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySplashScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySplashScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_splash_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySplashScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.SplashScreenProgressBar;
      ProgressBar SplashScreenProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (SplashScreenProgressBar == null) {
        break missingId;
      }

      id = R.id.loadingSplashScreenTextView;
      TextView loadingSplashScreenTextView = ViewBindings.findChildViewById(rootView, id);
      if (loadingSplashScreenTextView == null) {
        break missingId;
      }

      id = R.id.logoSplashScreenImageView;
      ImageView logoSplashScreenImageView = ViewBindings.findChildViewById(rootView, id);
      if (logoSplashScreenImageView == null) {
        break missingId;
      }

      return new ActivitySplashScreenBinding((ConstraintLayout) rootView, SplashScreenProgressBar,
          loadingSplashScreenTextView, logoSplashScreenImageView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
