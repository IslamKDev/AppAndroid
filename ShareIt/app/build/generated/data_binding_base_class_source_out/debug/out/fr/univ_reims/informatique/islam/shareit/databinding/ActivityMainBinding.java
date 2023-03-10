// Generated by view binder compiler. Do not edit!
package fr.univ_reims.informatique.islam.shareit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import fr.univ_reims.informatique.islam.shareit.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button connexionBouton;

  @NonNull
  public final CardView connexionCardView;

  @NonNull
  public final LinearLayout connexionLinearLayout;

  @NonNull
  public final LinearLayout connexionLinearLayoutBouton;

  @NonNull
  public final CheckBox connexionMotDePasseCheckBox;

  @NonNull
  public final TextView connexionTextView;

  @NonNull
  public final TextView erreurConnexionTextView;

  @NonNull
  public final TextView informationsConnexionTextView;

  @NonNull
  public final TextView lienVersLaPageInscriptionTextView;

  @NonNull
  public final EditText motDePasseConnexionTextView;

  @NonNull
  public final TextView nameAppTextView;

  @NonNull
  public final EditText nomUtilisateurConnexionTextView;

  @NonNull
  public final TextView textView;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button connexionBouton,
      @NonNull CardView connexionCardView, @NonNull LinearLayout connexionLinearLayout,
      @NonNull LinearLayout connexionLinearLayoutBouton,
      @NonNull CheckBox connexionMotDePasseCheckBox, @NonNull TextView connexionTextView,
      @NonNull TextView erreurConnexionTextView, @NonNull TextView informationsConnexionTextView,
      @NonNull TextView lienVersLaPageInscriptionTextView,
      @NonNull EditText motDePasseConnexionTextView, @NonNull TextView nameAppTextView,
      @NonNull EditText nomUtilisateurConnexionTextView, @NonNull TextView textView) {
    this.rootView = rootView;
    this.connexionBouton = connexionBouton;
    this.connexionCardView = connexionCardView;
    this.connexionLinearLayout = connexionLinearLayout;
    this.connexionLinearLayoutBouton = connexionLinearLayoutBouton;
    this.connexionMotDePasseCheckBox = connexionMotDePasseCheckBox;
    this.connexionTextView = connexionTextView;
    this.erreurConnexionTextView = erreurConnexionTextView;
    this.informationsConnexionTextView = informationsConnexionTextView;
    this.lienVersLaPageInscriptionTextView = lienVersLaPageInscriptionTextView;
    this.motDePasseConnexionTextView = motDePasseConnexionTextView;
    this.nameAppTextView = nameAppTextView;
    this.nomUtilisateurConnexionTextView = nomUtilisateurConnexionTextView;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.connexionBouton;
      Button connexionBouton = ViewBindings.findChildViewById(rootView, id);
      if (connexionBouton == null) {
        break missingId;
      }

      id = R.id.connexionCardView;
      CardView connexionCardView = ViewBindings.findChildViewById(rootView, id);
      if (connexionCardView == null) {
        break missingId;
      }

      id = R.id.connexionLinearLayout;
      LinearLayout connexionLinearLayout = ViewBindings.findChildViewById(rootView, id);
      if (connexionLinearLayout == null) {
        break missingId;
      }

      id = R.id.connexionLinearLayoutBouton;
      LinearLayout connexionLinearLayoutBouton = ViewBindings.findChildViewById(rootView, id);
      if (connexionLinearLayoutBouton == null) {
        break missingId;
      }

      id = R.id.connexionMotDePasseCheckBox;
      CheckBox connexionMotDePasseCheckBox = ViewBindings.findChildViewById(rootView, id);
      if (connexionMotDePasseCheckBox == null) {
        break missingId;
      }

      id = R.id.connexionTextView;
      TextView connexionTextView = ViewBindings.findChildViewById(rootView, id);
      if (connexionTextView == null) {
        break missingId;
      }

      id = R.id.erreurConnexionTextView;
      TextView erreurConnexionTextView = ViewBindings.findChildViewById(rootView, id);
      if (erreurConnexionTextView == null) {
        break missingId;
      }

      id = R.id.informationsConnexionTextView;
      TextView informationsConnexionTextView = ViewBindings.findChildViewById(rootView, id);
      if (informationsConnexionTextView == null) {
        break missingId;
      }

      id = R.id.lienVersLaPageInscriptionTextView;
      TextView lienVersLaPageInscriptionTextView = ViewBindings.findChildViewById(rootView, id);
      if (lienVersLaPageInscriptionTextView == null) {
        break missingId;
      }

      id = R.id.motDePasseConnexionTextView;
      EditText motDePasseConnexionTextView = ViewBindings.findChildViewById(rootView, id);
      if (motDePasseConnexionTextView == null) {
        break missingId;
      }

      id = R.id.nameAppTextView;
      TextView nameAppTextView = ViewBindings.findChildViewById(rootView, id);
      if (nameAppTextView == null) {
        break missingId;
      }

      id = R.id.nomUtilisateurConnexionTextView;
      EditText nomUtilisateurConnexionTextView = ViewBindings.findChildViewById(rootView, id);
      if (nomUtilisateurConnexionTextView == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, connexionBouton,
          connexionCardView, connexionLinearLayout, connexionLinearLayoutBouton,
          connexionMotDePasseCheckBox, connexionTextView, erreurConnexionTextView,
          informationsConnexionTextView, lienVersLaPageInscriptionTextView,
          motDePasseConnexionTextView, nameAppTextView, nomUtilisateurConnexionTextView, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
