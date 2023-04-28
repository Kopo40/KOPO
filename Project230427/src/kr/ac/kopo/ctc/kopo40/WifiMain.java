package kr.ac.kopo.ctc.kopo40;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import kr.ac.kopo.ctc.kopo40.dao.WiFiItemDao;
import kr.ac.kopo.ctc.kopo40.domain.WifiItem;
import kr.ac.kopo.ctc.kopo40.servie.WifiItemService;

public class WifiMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WifiItemService wifiItemService = new WifiItemService();
		WiFiItemDao wifiItemDao = new WiFiItemDao();
		List<WifiItem> wifiItems = wifiItemDao.selectAll();
		WifiItem me = new WifiItem();
		double k40_lat = 37.385809; // 설정한 위치의 위도
		double k40_lng = 127.121282; // 설정한 위치의 경도
		me.setLatitude(k40_lat);
		me.setLongitude(k40_lng);
		double k40_maxDist = 0;
		double k40_minDist = 0;

		WifiItem Max = new WifiItem();
		WifiItem Min = new WifiItem();

		for (WifiItem target : wifiItems) {
			double k40_dist = wifiItemService.getDistance(me, target);
			System.out.printf("**[%d번째 항목]*******************\n", target.getId());// 출력하기
			System.out.printf(" %s : %s\n", "소재지번주소", target.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "위도", target.getLatitude());
			System.out.printf(" %s : %s\n", "경도", target.getLongitude());
			System.out.printf(" 현재 지점과 거리 : %f\n", k40_dist);
			System.out.printf("**********************************\n");

			if (target.getId() == 1) {
				k40_maxDist = k40_dist;
				k40_minDist = k40_dist;
			} else {
				if (k40_dist < k40_minDist) {
					k40_minDist = k40_dist;
					Min = target;
				}
				if (k40_dist > k40_maxDist) {
					k40_maxDist = k40_dist;
					Max = target;
				}
			}

		}

		// 가장 가까운 장소 정보 출력
		if (Min != null) {
			System.out.printf("**********************************\n");
			System.out.printf(" 현재지점(분당융기원)과 가장 가까운 장소\n");
			System.out.printf(" %s : %s\n", "설치장소명", Min.getInstallationLocationName());
			System.out.printf(" %s : %s\n", "소재지번주소", Min.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "위도", Min.getLatitude());
			System.out.printf(" %s : %s\n", "경도", Min.getLongitude());
			System.out.printf(" 현재지점과 거리 : %f\n", k40_minDist);
			System.out.printf("**********************************\n");
		}

		// 가장 먼 장소 정보 출력
		if (Max != null) {
			System.out.printf(" 현재지점(분당융기원)과 가장 먼 장소\n");
			System.out.printf(" %s : %s\n", "설치장소명", Max.getInstallationLocationName());
			System.out.printf(" %s : %s\n", "소재지번주소", Max.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "위도", Max.getLatitude());
			System.out.printf(" %s : %s\n", "경도", Max.getLongitude());
			System.out.printf(" 현재지점과 거리 : %f\n", k40_maxDist);
			System.out.printf("**********************************\n");
		}
	}
}