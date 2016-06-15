package com.example.abhishek.sharerides.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.abhishek.sharerides.R;
import com.example.abhishek.sharerides.fragments.Login_Fragment;
import com.example.abhishek.sharerides.helpers.Utils;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Setting Fragment Manager
    private static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();

        // Load Login Fragment if savedinstancestate is null
        if (savedInstanceState == null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frameContainer, new Login_Fragment(), Utils.LOGIN_FRAGMENT)
                    .commit();
        }

        /*
        ParseUser user = new ParseUser();
        user.setUsername("my name");
        user.setPassword("my pass");
        user.setEmail("email@example.com");

        // other fields can be set just like with ParseObject
        user.put("phone", "650-253-0000");

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("Success", "Success");
                } else {
                    Log.d("Fail", e.toString());
                }
            }
        });*/

    }

    /*
     * Close the app when the user click on the close activity view.
     */
    @OnClick(R.id.close_activity)
    public void closeApplication() {
        Log.d("closeApplication","Close the Application");
        finish();
    }

    /*
     * Load Login Fragment with custom Animation
     */
    public void replaceLoginFragment() {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.frameContainer, new Login_Fragment(), Utils.LOGIN_FRAGMENT)
                .commit();
    }

    @Override
    public void onBackPressed() {

        // Find the tag of Sign Up and Forgot Password Fragment
        Fragment SignUp_Fragment = fragmentManager
                .findFragmentByTag(Utils.SIGNUP_FRAGMENT);
        Fragment ForgotPassword_Fragment = fragmentManager
                .findFragmentByTag(Utils.FORGOTPASSWORD_FRAGMENT);


        // Future Enhancement : Add Dialog Builder to take confirmation from the User

        if (SignUp_Fragment != null) {
            replaceLoginFragment();
        } else if (ForgotPassword_Fragment != null) {
            replaceLoginFragment();
        } else {
            super.onBackPressed();
        }
    }
}
