package hyh.androidlogin.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (AccessToken.getCurrentAccessToken() == null) {
//            goLoginScreen();
//        }
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();
            String uid = user.getUid();


            Toast.makeText(this, "Welcome "+ name + " with email: " + email, Toast.LENGTH_LONG).show();
        }



    }

    // Facebook Logout
    public void logout_facebook(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    // Google Logout
    // [START signOut]
    public void logout_google(View view) {
        FirebaseAuth.getInstance().signOut();
    }
    // [END signOut]

    private void goLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
