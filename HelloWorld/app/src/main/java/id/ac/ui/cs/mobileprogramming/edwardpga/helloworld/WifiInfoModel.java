package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import com.google.gson.annotations.SerializedName;

public class WifiInfoModel {
    @SerializedName("ssid")
    private String ssid;

    @SerializedName("bssid")
    private String bssid;

    @SerializedName("capabilities")
    private String capabilities;

    @SerializedName("frequency")
    private int frequency;

    @SerializedName("channelWidth")
    private int channelWidth;

    public WifiInfoModel(String ssid, String bssid, String capabilities, int frequency, int channelWidth) {
        this.ssid = ssid;
        this.bssid = bssid;
        this.capabilities = capabilities;
        this.frequency = frequency;
        this.channelWidth = channelWidth;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getChannelWidth() {
        return channelWidth;
    }

    public void setChannelWidth(int channelWidth) {
        this.channelWidth = channelWidth;
    }
}
