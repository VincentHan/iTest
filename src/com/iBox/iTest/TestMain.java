package com.iBox.iTest;

import java.io.IOException;
import java.util.Properties;

import hkmc.api.sdk.SdkManager;
import hkmc.api.telematics.TelematicsAdapter;

import com.hkmc.smartusblauncher.ISmartusbResourceService;
import com.iBox.HDTest.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TestMain extends Activity {
    private final String LOG_TAG = "ExampleActivity";
    
    private ISmartusbResourceService mResourceService;
    private ResourceServiceConnection  mResourceServiceConn;
    private TelematicsAdapter mTelematicsAdapter;
    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String ipAddress = null;
        try {
            ipAddress = getIpAddress("/host.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SdkManager.Init(ipAddress);
        mTelematicsAdapter = TelematicsAdapter.getDefaultAdapter();
        //runService();

        Button btn = (Button)findViewById(R.id.btn_doortest);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if(mTelematicsAdapter != null) {
                    int doorStatus = mTelematicsAdapter.getDoorStatus();
                    if(doorStatus == 1) {
                        mTelematicsAdapter.requestUnlockDoor();
                    } else {
                        mTelematicsAdapter.requestLockDoor();
                    }
                } else {
                    Log.e(LOG_TAG, "mTelematicsAdapter is NULL");
                }
            }
        });
    }
    
    private String getIpAddress(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(path));
        return (String) properties.get("IP_ADDRESS");
    }
    
    protected void onDestroy() {
        super.onDestroy();
        releaseService();
    }

    private boolean runService() {
        if(mResourceServiceConn == null) {
            mResourceServiceConn = new ResourceServiceConnection();
            boolean conRes = bindService(new Intent(ISmartusbResourceService.class.getName()), mResourceServiceConn, Context.BIND_AUTO_CREATE);
            return conRes;
        }
        return false;
    }
    
    private void releaseService() {
        if(mResourceServiceConn != null) {
            unbindService(mResourceServiceConn);
            mResourceServiceConn = null;
            mResourceService = null;
        }
    }
    
    public void getResourceData() {
        if(mResourceService != null) {
            try {
                mResourceService.setResourceRootPath("/data/data/com.iBox.HDTest/");
                //String str = mResourceService.getResourceString(1001);
                //Bitmap bitmap = mResourceService.getResourceImage(2001);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    class ResourceServiceConnection implements ServiceConnection {
        public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
            if(mResourceService == null) {
                mResourceService = ISmartusbResourceService.Stub.asInterface((IBinder) ibinder);
            }
            getResourceData();
        }
        public void onServiceDisconnected(ComponentName componentname) {
            mResourceService = null;
        }
        
    }

    public boolean onKeyDown(final int keyCode, KeyEvent event) {
        Log.d(LOG_TAG, "Action="+event.getAction()+" keyCode="+keyCode);
        if(event.getAction() == KeyEvent.ACTION_DOWN) {
            Toast.makeText(this, "onKeyDown[" + keyCode + "]",
                    Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }
}


