package kr.ac.kopo.ctc.kopo40.servie;

import kr.ac.kopo.ctc.kopo40.domain.WifiItem;

public class WifiItemService {
	// 위도, 경도를 바탕으로 한 거리 계산식
	public double getDistance(WifiItem wifiItem1,WifiItem wifiItem2) {		
		double k40_dist = Math.sqrt(Math.pow(wifiItem2.getLatitude() - wifiItem1.getLatitude(), 2)
				+ Math.pow(wifiItem2.getLongitude() - wifiItem1.getLongitude(), 2));
		
		return k40_dist;
	}
	
}