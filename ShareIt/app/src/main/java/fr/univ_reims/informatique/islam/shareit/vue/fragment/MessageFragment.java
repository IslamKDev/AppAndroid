package fr.univ_reims.informatique.islam.shareit.vue.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.vue.activity.MessageActivity;


public class MessageFragment extends Fragment {

    private Button buttonMessage;
    public MessageFragment() {
    }


    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);
        // Inflate the layout for this fragment
        buttonMessage = (Button) rootView.findViewById(R.id.buttonMessage);
        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messageActivity = new Intent(getActivity(), MessageActivity.class);
                startActivity(messageActivity);

            }
        });
        return rootView;
    }
}