package bhakadekailas.dailerintentfilter

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dial = findViewById<Button>(R.id.button)

        dial.setOnClickListener {
//            if (isTelephonyEnabled()) {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9921710694"))
//            intent.data = Uri.parse("tel:9921710694")
            startActivity(intent)
//            }
        }
    }

    private fun isTelephonyEnabled(): Boolean {
        val telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        val typeGsm = telephonyManager.phoneType != TelephonyManager.PHONE_TYPE_GSM
        val features = this.packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)
        Log.e("KAILAS", ": $typeGsm")
        Log.e("KAILAS", ": $features")
        return telephonyManager.simState == TelephonyManager.SIM_STATE_READY
    }
}