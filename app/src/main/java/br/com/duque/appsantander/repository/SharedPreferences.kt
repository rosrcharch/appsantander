import android.content.Context
import android.content.SharedPreferences

/**
 * Acesso a dados rápidos do projeto - SharedPreferences
 */
class SharedPreferences(context: Context) {

    private val mPreferences: SharedPreferences =
            context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)

    fun store(key: String, value: String){
        mPreferences.edit().putString(key, value).apply()
    }

    fun remove(key: String){
        mPreferences.edit().remove(key).apply()
    }

    fun get(key: String): String{
        return mPreferences.getString(key, "")?: ""
    }

}