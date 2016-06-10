package com.example.abhishek.sharerides.fragments;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhishek.sharerides.R;
import com.example.abhishek.sharerides.helpers.CustomToast;
import com.example.abhishek.sharerides.helpers.Utils;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by abhishek on 5/24/16.
 */

public class Login_Fragment extends Fragment {

    private static View view;
    private static Animation shakeAnimation;
    private static FragmentManager fragmentManager;
    private Unbinder unbinder;
    private ProgressDialog progressDialog;

    @BindView(R.id.login_emailid) EditText et_login_emailid;
    @BindView(R.id.login_password) EditText et_login_password;
    @BindView(R.id.forgot_password) TextView tv_forgot_password;
    @BindView(R.id.create_account) TextView tv_create_account;
    @BindView(R.id.show_hide_password) CheckBox cb_show_hide_password;
    @BindView(R.id.login_btn) Button b_login_btn;
    @BindView(R.id.login_layout) LinearLayout ll_login_layout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_layout, container, false);

        unbinder = ButterKnife.bind(this, view);

        fragmentManager = getActivity().getSupportFragmentManager();
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({ R.id.forgot_password, R.id.create_account, R.id.login_btn})
    public void actions(View view) {

        switch (view.getId()) {

            case R.id.forgot_password:

                // Load Forgot Password Fragment
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer,
                                new ForgotPassword_Fragment(),
                                Utils.FORGOTPASSWORD_FRAGMENT).commit();
                break;

            case R.id.create_account:

                // Load Sign Up Fragment
                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                        .replace(R.id.frameContainer, new SignUp_Fragment(),
                                Utils.SIGNUP_FRAGMENT).commit();
                break;

            case R.id.login_btn:
                validateLoginFormFields();
                break;
        }

    }

    @OnCheckedChanged(R.id.show_hide_password)
    public void showPassword(){

        if(cb_show_hide_password.isChecked()) {

            cb_show_hide_password.setText(R.string.hide_pwd);
            et_login_password.setInputType(InputType.TYPE_CLASS_TEXT);
            et_login_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

        } else {

            cb_show_hide_password.setText(R.string.show_pwd);
            et_login_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            et_login_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /*
     * Form Validation
     */
    private void validateLoginFormFields() {

        // Get email id and password
        String getEmailId = et_login_emailid.getText().toString();
        String getPassword = et_login_password.getText().toString();

        // Check patter for email id
        Pattern p = Pattern.compile(Utils.regEx);

        Matcher m = p.matcher(getEmailId);

        // Check for both field is empty or not
        if (getEmailId.equals("") || getEmailId.length() == 0
                || getPassword.equals("") || getPassword.length() == 0) {

            ll_login_layout.startAnimation(shakeAnimation);
            new CustomToast().Show_Toast(getActivity(), view, getString(R.string.invalid_login_credentials));

        } else if (!m.find()) {

            new CustomToast().Show_Toast(getActivity(), view, getString(R.string.invalid_emailid_error));

        } else {

            // Process
            showCustomProgress(true);
            processLoginAction(getEmailId, getPassword);

        }

    }

    /*
     * Process Login task after successful validation
     */
    private void processLoginAction(String emailId, String password){

        ParseUser.logInInBackground(emailId, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user != null && e == null) {

                    Log.i("LogInSuccess", "LogInSuccess");

                    // Create Dashboard and take user to that dashboard activity

                } else {

                    Toast.makeText(getContext(), e.getMessage(),Toast.LENGTH_LONG).show();

                }

                showCustomProgress(false);
            }
        });
    }

    /**
     * Shows the custom progress UI after login.
     */
    private void showCustomProgress(final boolean show)
    {
        if(show) {
            progressDialog = new ProgressDialog(getActivity(), R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Authenticating...");
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

}
