import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

@RequiresApi(Build.VERSION_CODES.M)
val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

//Cria criptografia no Preferences para dados nao serem abertos
object SharedPreferences {
    fun create(context: Context): SharedPreferences {
        return EncryptedSharedPreferences.create(
            "PreferencesFilename",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    }
}

