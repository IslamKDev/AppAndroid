// Generated by view binder compiler. Do not edit!
package fr.univ_reims.informatique.islam.shareit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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

public final class ActivityRegistrationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText checkpasswordRegistrationEditText;

  @NonNull
  public final TextView checkpasswordRegistrationTextView;

  @NonNull
  public final EditText emailEditText;

  @NonNull
  public final TextView emailTextView;

  @NonNull
  public final TextView erreurRegistrationTextView;

  @NonNull
  public final TextView informationsRegistrationTextView;

  @NonNull
  public final CheckBox inscriptionMotDePasseCheckBox;

  @NonNull
  public final TextView lienVersLaPageConnexionTextView;

  @NonNull
  public final TextView nameAppTextView;

  @NonNull
  public final EditText nomRegistrationEditText;

  @NonNull
  public final TextView nomRegistrationTextView;

  @NonNull
  public final EditText passwordEditText;

  @NonNull
  public final TextView passwordRegistrationTextView;

  @NonNull
  public final EditText prenomRegistrationEditText;

  @NonNull
  public final TextView prenomRegistrationTextView;

  @NonNull
  public final Button registrationButton;

  @NonNull
  public final CardView registrationCardView;

  @NonNull
  public final TextView registrationLayout;

  @NonNull
  public final LinearLayout registrationLinearLayout;

  @NonNull
  public final ScrollView registrationScrollView;

  @NonNull
  public final LinearLayout registrationScrollViewLinearLayout;

  @NonNull
  public final TextView textView;

  @NonNull
  public final EditText usernameRegistrationEditText;

  @NonNull
  public final TextView usernameRegistrationTextView;

  private ActivityRegistrationBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText checkpasswordRegistrationEditText,
      @NonNull TextView checkpasswordRegistrationTextView, @NonNull EditText emailEditText,
      @NonNull TextView emailTextView, @NonNull TextView erreurRegistrationTextView,
      @NonNull TextView informationsRegistrationTextView,
      @NonNull CheckBox inscriptionMotDePasseCheckBox,
      @NonNull TextView lienVersLaPageConnexionTextView, @NonNull TextView nameAppTextView,
      @NonNull EditText nomRegistrationEditText, @NonNull TextView nomRegistrationTextView,
      @NonNull EditText passwordEditText, @NonNull TextView passwordRegistrationTextView,
      @NonNull EditText prenomRegistrationEditText, @NonNull TextView prenomRegistrationTextView,
      @NonNull Button registrationButton, @NonNull CardView registrationCardView,
      @NonNull TextView registrationLayout, @NonNull LinearLayout registrationLinearLayout,
      @NonNull ScrollView registrationScrollView,
      @NonNull LinearLayout registrationScrollViewLinearLayout, @NonNull TextView textView,
      @NonNull EditText usernameRegistrationEditText,
      @NonNull TextView usernameRegistrationTextView) {
    this.rootView = rootView;
    this.checkpasswordRegistrationEditText = checkpasswordRegistrationEditText;
    this.checkpasswordRegistrationTextView = checkpasswordRegistrationTextView;
    this.emailEditText = emailEditText;
    this.emailTextView = emailTextView;
    this.erreurRegistrationTextView = erreurRegistrationTextView;
    this.informationsRegistrationTextView = informationsRegistrationTextView;
    this.inscriptionMotDePasseCheckBox = inscriptionMotDePasseCheckBox;
    this.lienVersLaPageConnexionTextView = lienVersLaPageConnexionTextView;
    this.nameAppTextView = nameAppTextView;
    this.nomRegistrationEditText = nomRegistrationEditText;
    this.nomRegistrationTextView = nomRegistrationTextView;
    this.passwordEditText = passwordEditText;
    this.passwordRegistrationTextView = passwordRegistrationTextView;
    this.prenomRegistrationEditText = prenomRegistrationEditText;
    this.prenomRegistrationTextView = prenomRegistrationTextView;
    this.registrationButton = registrationButton;
    this.registrationCardView = registrationCardView;
    this.registrationLayout = registrationLayout;
    this.registrationLinearLayout = registrationLinearLayout;
    this.registrationScrollView = registrationScrollView;
    this.registrationScrollViewLinearLayout = registrationScrollViewLinearLayout;
    this.textView = textView;
    this.usernameRegistrationEditText = usernameRegistrationEditText;
    this.usernameRegistrationTextView = usernameRegistrationTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegistrationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegistrationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_registration, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegistrationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.checkpasswordRegistrationEditText;
      EditText checkpasswordRegistrationEditText = ViewBindings.findChildViewById(rootView, id);
      if (checkpasswordRegistrationEditText == null) {
        break missingId;
      }

      id = R.id.checkpasswordRegistrationTextView;
      TextView checkpasswordRegistrationTextView = ViewBindings.findChildViewById(rootView, id);
      if (checkpasswordRegistrationTextView == null) {
        break missingId;
      }

      id = R.id.emailEditText;
      EditText emailEditText = ViewBindings.findChildViewById(rootView, id);
      if (emailEditText == null) {
        break missingId;
      }

      id = R.id.emailTextView;
      TextView emailTextView = ViewBindings.findChildViewById(rootView, id);
      if (emailTextView == null) {
        break missingId;
      }

      id = R.id.erreurRegistrationTextView;
      TextView erreurRegistrationTextView = ViewBindings.findChildViewById(rootView, id);
      if (erreurRegistrationTextView == null) {
        break missingId;
      }

      id = R.id.informationsRegistrationTextView;
      TextView informationsRegistrationTextView = ViewBindings.findChildViewById(rootView, id);
      if (informationsRegistrationTextView == null) {
        break missingId;
      }

      id = R.id.inscriptionMotDePasseCheckBox;
      CheckBox inscriptionMotDePasseCheckBox = ViewBindings.findChildViewById(rootView, id);
      if (inscriptionMotDePasseCheckBox == null) {
        break missingId;
      }

      id = R.id.lienVersLaPageConnexionTextView;
      TextView lienVersLaPageConnexionTextView = ViewBindings.findChildViewById(rootView, id);
      if (lienVersLaPageConnexionTextView == null) {
        break missingId;
      }

      id = R.id.nameAppTextView;
      TextView nameAppTextView = ViewBindings.findChildViewById(rootView, id);
      if (nameAppTextView == null) {
        break missingId;
      }

      id = R.id.nomRegistrationEditText;
      EditText nomRegistrationEditText = ViewBindings.findChildViewById(rootView, id);
      if (nomRegistrationEditText == null) {
        break missingId;
      }

      id = R.id.nomRegistrationTextView;
      TextView nomRegistrationTextView = ViewBindings.findChildViewById(rootView, id);
      if (nomRegistrationTextView == null) {
        break missingId;
      }

      id = R.id.password_EditText;
      EditText passwordEditText = ViewBindings.findChildViewById(rootView, id);
      if (passwordEditText == null) {
        break missingId;
      }

      id = R.id.passwordRegistrationTextView;
      TextView passwordRegistrationTextView = ViewBindings.findChildViewById(rootView, id);
      if (passwordRegistrationTextView == null) {
        break missingId;
      }

      id = R.id.prenomRegistrationEditText;
      EditText prenomRegistrationEditText = ViewBindings.findChildViewById(rootView, id);
      if (prenomRegistrationEditText == null) {
        break missingId;
      }

      id = R.id.prenomRegistrationTextView;
      TextView prenomRegistrationTextView = ViewBindings.findChildViewById(rootView, id);
      if (prenomRegistrationTextView == null) {
        break missingId;
      }

      id = R.id.registrationButton;
      Button registrationButton = ViewBindings.findChildViewById(rootView, id);
      if (registrationButton == null) {
        break missingId;
      }

      id = R.id.registrationCardView;
      CardView registrationCardView = ViewBindings.findChildViewById(rootView, id);
      if (registrationCardView == null) {
        break missingId;
      }

      id = R.id.registrationLayout;
      TextView registrationLayout = ViewBindings.findChildViewById(rootView, id);
      if (registrationLayout == null) {
        break missingId;
      }

      id = R.id.registrationLinearLayout;
      LinearLayout registrationLinearLayout = ViewBindings.findChildViewById(rootView, id);
      if (registrationLinearLayout == null) {
        break missingId;
      }

      id = R.id.registrationScrollView;
      ScrollView registrationScrollView = ViewBindings.findChildViewById(rootView, id);
      if (registrationScrollView == null) {
        break missingId;
      }

      id = R.id.registrationScrollViewLinearLayout;
      LinearLayout registrationScrollViewLinearLayout = ViewBindings.findChildViewById(rootView, id);
      if (registrationScrollViewLinearLayout == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.usernameRegistrationEditText;
      EditText usernameRegistrationEditText = ViewBindings.findChildViewById(rootView, id);
      if (usernameRegistrationEditText == null) {
        break missingId;
      }

      id = R.id.usernameRegistrationTextView;
      TextView usernameRegistrationTextView = ViewBindings.findChildViewById(rootView, id);
      if (usernameRegistrationTextView == null) {
        break missingId;
      }

      return new ActivityRegistrationBinding((ConstraintLayout) rootView,
          checkpasswordRegistrationEditText, checkpasswordRegistrationTextView, emailEditText,
          emailTextView, erreurRegistrationTextView, informationsRegistrationTextView,
          inscriptionMotDePasseCheckBox, lienVersLaPageConnexionTextView, nameAppTextView,
          nomRegistrationEditText, nomRegistrationTextView, passwordEditText,
          passwordRegistrationTextView, prenomRegistrationEditText, prenomRegistrationTextView,
          registrationButton, registrationCardView, registrationLayout, registrationLinearLayout,
          registrationScrollView, registrationScrollViewLinearLayout, textView,
          usernameRegistrationEditText, usernameRegistrationTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}