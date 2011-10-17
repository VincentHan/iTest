package com.hkmc.smartusblauncher;

import android.graphics.Bitmap;

/**
 * System private API for talking with the Smartusb Resource
 */
interface ISmartusbResourceService {
    /**
     * 리소스 파일의 root path 설정
     */
    void setResourceRootPath(String path);

    /**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 문자열 얻어오기
     */
    String getResourceString(int resID);

    /**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 Bitmap 이미지 객체 얻어오기
     */
    Bitmap getResourceImage(int resID);

    /**
     * 리소스 파일에서 지정된 리소스ID(resID)에 해당하는 바이너리 데이터 얻어오기
     */
    byte[] getResourceData(int resID);
}
