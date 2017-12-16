package touch.in.keep.sobin.loginapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sobin on 16/12/17.
 */

public class PrefManager {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE =0;



    private static final String PREF_NAME = "startapp";

    private static final String KEY_IS_LOGGED_IN        = "isLoggedIn";

    public PrefManager(Context context) {
        this.context = context;
        sp =context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor= sp.edit();
    }

    public void createUser(int user){
        editor.putBoolean(KEY_IS_LOGGED_IN,true);
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sp.getBoolean(KEY_IS_LOGGED_IN,false);
    }

    public void clearSession(){
        editor.clear();
        editor.commit();
    }


}
