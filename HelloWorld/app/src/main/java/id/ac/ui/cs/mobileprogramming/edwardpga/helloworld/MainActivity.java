package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    WifiManager wifiManager;
    private APIInterface APIservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIservice = APIClient.getClient().create(APIInterface.class);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            // If wifi disabled then enable it
            Toast.makeText(getApplicationContext(), "Turning wifi on..",
                    Toast.LENGTH_LONG).show();
            wifiManager.setWifiEnabled(true);
        }

        boolean scanSuccess = wifiManager.startScan();
        if (!scanSuccess) {
            scanFailure();
        }

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        getApplicationContext().registerReceiver(wifiScanReceiver, intentFilter);


        String textMessage = "Success Scan: " + scanSuccess + "\n"
                + "Wifi Info: " + wifiManager.getConnectionInfo() + "\n"
                + "Wifi State: " + wifiManager.getWifiState() + "\n"
                + "Wifi Scan Results: " + wifiManager.getScanResults().size() + "\n"
                + "Wifi Connection State: " + wifiManager.getWifiState();

        TextView textView = findViewById(R.id.textID);
        textView.setText(textMessage);
    }

    private final BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {
            boolean success = intent.getBooleanExtra( WifiManager.EXTRA_RESULTS_UPDATED, false );
            if (success) {
                scanSuccess();
            } else {
                // scan failure handling
                scanFailure();
            }
        }
    };

    private void scanFailure() {
        Log.d("SCAN GAGALL", "scanFailure: "+"GAGAL");
    }

    private void scanSuccess() {
        List<ScanResult> scanResults = wifiManager.getScanResults();
        for (ScanResult result:scanResults) {
            Call<ResponseBody> call = APIservice.addWifiData(
                    new WifiInfoModel(
                            result.SSID,
                            result.BSSID,
                            result.capabilities,
                            result.frequency,
                            result.channelWidth));

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplication(),
                                "Data WIFI berhasil terkirim",
                                Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.d("GAGAL POST", "onFailure: "+"POST failed because: " + t.getLocalizedMessage());
                    Toast.makeText(getApplication(),
                            "POST failed because: " + t.getLocalizedMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


}