package com.example.abhishek.sharerides.fragments;

import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhishek.sharerides.R;
import com.example.abhishek.sharerides.activities.MainActivity;
import com.example.abhishek.sharerides.helpers.CustomToast;
import com.example.abhishek.sharerides.helpers.Utils;
import com.example.abhishek.sharerides.models.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by abhishek on 5/24/16.
 */

public class SignUp_Fragment extends Fragment {

    private static View view;
    private Unbinder unbinder;
    private User user;

    @BindView(R.id.first_name) EditText et_first_name;
    @BindView(R.id.last_name) EditText et_last_name;
    @BindView(R.id.signup_email_id) EditText et_signup_email_id;
    @BindView(R.id.mobile_number) EditText et_mobile_number;
    @BindView(R.id.signup_password) EditText et_signup_password;
    @BindView(R.id.signup_confirm_password) EditText et_signup_confirm_password;
    @BindView(R.id.login) TextView tv_login;
    @BindView(R.id.sign_up_btn) Button b_sign_up_btn;
    @BindView(R.id.terms_conditions) CheckBox cb_terms_conditions;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_layout, container, false);

        unbinder = ButterKnife.bind(this, view);
        user = new User();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({ R.id.sign_up_btn, R.id.login })
    public void actions(View view) {

        switch (view.getId()) {

            case R.id.login:

                // Load Login Fragment
                new MainActivity().replaceLoginFragment();
                break;

            case R.id.sign_up_btn:

                // Validation
                validateSignUpFormFields();
                break;

        }
    }

    /*
     * Form Validation
     */
    private void validateSignUpFormFields() {

        String firstName         = et_first_name.getText().toString();
        String lastName          = et_last_name.getText().toString();
        String emailId           = et_signup_email_id.getText().toString();
        String mobileNumber      = et_mobile_number.getText().toString();
        String password          = et_signup_password.getText().toString();
        String confirmPassword   = et_signup_confirm_password.getText().toString();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMobileNumber(mobileNumber);
        user.setEmailId(emailId);
        user.setPassword(password);

        // Pattern match for email id
        Pattern p = Pattern.compile(Utils.regEx);
        Matcher m = p.matcher(emailId);

        if (firstName.equals("") || firstName.length() == 0
                || lastName.equals("") || lastName.length() == 0
                || emailId.equals("") || emailId.length() == 0
                || mobileNumber.equals("") || mobileNumber.length() == 0
                || password.equals("") || password.length() == 0
                || confirmPassword.equals("")
                || confirmPassword.length() == 0) {

            new CustomToast().Show_Toast(getActivity(), view, getString(R.string.required_all_fields_error));

        } else if (!m.find()) {

            new CustomToast().Show_Toast(getActivity(), view, getString(R.string.invalid_emailid_error));

        } else if (!confirmPassword.equals(confirmPassword)) {

            new CustomToast().Show_Toast(getActivity(), view, getString(R.string.password_not_match));

        } else if (!cb_terms_conditions.isChecked()) {

            new CustomToast().Show_Toast(getActivity(), view, getString(R.string.label_terms));

        } else {

            processSignUpAction();
        }

    }

    /*
     * Process SignUp task after successful validation
     */
    private void processSignUpAction(){

        Log.d("First Name",user.getFirstName());
        Log.d("Last Name", user.getLastName());
        Log.d("Mobile Number", user.getMobileNumber());
        Log.d("Email ID", user.getEmailId());
        Log.d("Password", user.getPassword());

        Toast.makeText(getActivity(), "SignUp Success", Toast.LENGTH_SHORT).show();
    }
}
