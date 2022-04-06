package com.example.ezlocasestudy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataArray {

    @SerializedName("PK_Device")
    @Expose
    private int pk_device;

    @SerializedName("MacAddress")
    @Expose
    private String mac_address;

    @SerializedName("PK_DeviceType")
    @Expose
    private int pk_device_type;

    @SerializedName("PK_DeviceSubType")
    @Expose
    private int pk_device_sub_type;

    @SerializedName("Firmware")
    @Expose
    private String firmware;

    @SerializedName("Server_Device")
    @Expose
    private String server_device;

    @SerializedName("Server_Event")
    @Expose
    private String server_event;

    @SerializedName("Server_Account")
    @Expose
    private String server_account;

    @SerializedName("InternalIP")
    @Expose
    private String ip;

    @SerializedName("LastAliveReported")
    @Expose
    private String last_alive_reported;

    @SerializedName("Platform")
    @Expose
    private String platform;


    public int getPk_device() {
        return pk_device;
    }

    public void setPk_device(int pk_device) {
        this.pk_device = pk_device;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public int getPk_device_type() {
        return pk_device_type;
    }

    public void setPk_device_type(int pk_device_type) {
        this.pk_device_type = pk_device_type;
    }

    public int getPk_device_sub_type() {
        return pk_device_sub_type;
    }

    public void setPk_device_sub_type(int pk_device_sub_type) {
        this.pk_device_sub_type = pk_device_sub_type;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getServer_device() {
        return server_device;
    }

    public void setServer_device(String server_device) {
        this.server_device = server_device;
    }

    public String getServer_event() {
        return server_event;
    }

    public void setServer_event(String server_event) {
        this.server_event = server_event;
    }

    public String getServer_account() {
        return server_account;
    }

    public void setServer_account(String server_account) {
        this.server_account = server_account;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLast_alive_reported() {
        return last_alive_reported;
    }

    public void setLast_alive_reported(String last_alive_reported) {
        this.last_alive_reported = last_alive_reported;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
