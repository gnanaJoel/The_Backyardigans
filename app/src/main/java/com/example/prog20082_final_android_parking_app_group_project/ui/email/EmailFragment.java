package com.example.prog20082_final_android_parking_app_group_project.ui.email;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.prog20082_final_android_parking_app_group_project.R;

public class EmailFragment extends Fragment implements View.OnClickListener {


    EditText edtName, edtEmail, edtMessage;

    Button btnEmail;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_email, container, false);

        edtName = root.findViewById(R.id.edt_name);
        edtEmail = root.findViewById(R.id.edt_email);
        edtMessage  = root.findViewById(R.id.edt_message);

        btnEmail = root.findViewById(R.id.btn_send);
        btnEmail.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_send:
                this.sendEmail();
                break;
        }
    }

    private void sendEmail() {

        String name = edtName.getText().toString();
        String email= edtEmail.getText().toString();
        String message = edtMessage.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("message/rfc822");

        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, name);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});

        startActivity(Intent.createChooser(emailIntent, "Please select email client"));
    }

}