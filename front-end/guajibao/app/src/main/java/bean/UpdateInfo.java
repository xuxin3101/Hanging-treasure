package bean;

public class UpdateInfo {
    private String Code;
    private String Msg;
    private String UpdateStatus;
    private String VersionCode;
    private String VersionName;
    private String DownloadUrl;
    private String ModifyContent;
    private String ApkSize;
    private String ApkMd5;

    public String getApkMd5() {
        return ApkMd5;
    }

    public String getApkSize() {
        return ApkSize;
    }

    public String getCode() {
        return Code;
    }

    public String getDownloadUrl() {
        return DownloadUrl;
    }

    public String getModifyContent() {
        return ModifyContent;
    }

    public String getMsg() {
        return Msg;
    }

    public String getUpdateStatus() {
        return UpdateStatus;
    }

    public String getVersionCode() {
        return VersionCode;
    }

    public String getVersionName() {
        return VersionName;
    }

    public void setApkMd5(String apkMd5) {
        ApkMd5 = apkMd5;
    }

    public void setApkSize(String apkSize) {
        ApkSize = apkSize;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setDownloadUrl(String downloadUrl) {
        DownloadUrl = downloadUrl;
    }

    public void setModifyContent(String modifyContent) {
        ModifyContent = modifyContent;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public void setUpdateStatus(String updateStatus) {
        UpdateStatus = updateStatus;
    }

    public void setVersionCode(String versionCode) {
        VersionCode = versionCode;
    }

    public void setVersionName(String versionName) {
        VersionName = versionName;
    }
}
