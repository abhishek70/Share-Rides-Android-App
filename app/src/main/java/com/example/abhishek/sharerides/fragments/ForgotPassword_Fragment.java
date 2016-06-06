package com.example.abhishek.sharerides.fragments;

import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhishek.sharerides.R;
import com.example.abhishek.sharerides.activities.MainActivity;
import com.example.abhishek.sharerides.helpers.CustomToast;
import com.example.abhishek.sharerides.helpers.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by abhishek on 5/24/16.
 */
public class ForgotPassword_Fragment extends Fragment {

    private static View view;
    private Unbinder unbinder;

    @BindView(R.id.tv_submit) TextView tv_submit;
    @BindView(R.id.tv_backtologin) TextView tv_backtologin;
    @BindView(R.id.registered_emailid) EditText et_registered_emailid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.forgotpassword_layout, container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({ R.id.tv_submit, R.id.tv_backtologin })
    public void actions(View view) {

        switch (view.getId()) {

            case R.id.tv_backtologin:

                // Load Login Fragment on back
                new MainActivity().replaceLoginFragment();
                break;

            case R.id.tv_submit:

                // Validation the email and process it
                validateForgotPasswordFormFields();
                break;

        }
    }

    /*
     * Form Validation
     */
    private void validateForgotPasswordFormFields(){
        String emailId = et_registered_emailid.getText().toString();

        // Pattern for email id validation
        Pattern p = Pattern.compile(Utils.regEx);

        // Match the pattern
        Matcher m = p.matcher(emailId);

        // First check if email id is not null else show error toast
        if (emailId.equals("") || emailId.length() == 0) {

            new CustomToast().Show_Toast(getActivity(), view, getString(R.string.required_emailid_error));

        } else if(!m.find()) {

            // Check if email id is valid or not
            new CustomToast().Show_Toast(getActivity(), view, getString(R.string.invalid_emailid_error));

        } else {

            // Process
            processForgotPasswordAction(emailId);
        }

    }

    /*
     * Process Forgot Password task after successful validation
     */
    private void processForgotPasswordAction(String emailId){
        Log.d("Email Id", emailId);
        Toast.makeText(getActivity(), "Forgot Password Success", Toast.LENGTH_SHORT).show();
    }
}
