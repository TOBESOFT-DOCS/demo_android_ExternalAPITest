package com.nexacro.ExternalAPITest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ExternalAPIReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		//브로드캐스트 메시지를 받으면 인텐트로부터 받은 내용을 로그로 출력
		Log.i("nexacro", ">> [com.nexacro.ExternalAPITest] message received.");
		Log.i("nexacro", "- sender:" + intent.getExtras().getString("sender"));
		Log.i("nexacro", "- recvID:" + intent.getExtras().getString("recvID"));
		Log.i("nexacro", "- apiname:" + intent.getExtras().getString("apiname"));
		Log.i("nexacro", "- params:" + intent.getExtras().getString("params"));
		

		//인텐트를 만들어 브로드캐스팅으로 전달
		Intent callExtAPI = new Intent(intent.getExtras().getString("sender"));
		callExtAPI.putExtra("recvID", intent.getExtras().getString("recvID"));
		callExtAPI.putExtra("recvdata", "This is a message from com.nexacro.ExternalAPITest");
		context.sendBroadcast(callExtAPI);
	}

}
