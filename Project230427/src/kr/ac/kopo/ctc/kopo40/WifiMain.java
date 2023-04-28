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
		double k40_lat = 37.385809; // ������ ��ġ�� ����
		double k40_lng = 127.121282; // ������ ��ġ�� �浵
		me.setLatitude(k40_lat);
		me.setLongitude(k40_lng);
		double k40_maxDist = 0;
		double k40_minDist = 0;

		WifiItem Max = new WifiItem();
		WifiItem Min = new WifiItem();

		for (WifiItem target : wifiItems) {
			double k40_dist = wifiItemService.getDistance(me, target);
			System.out.printf("**[%d��° �׸�]*******************\n", target.getId());// ����ϱ�
			System.out.printf(" %s : %s\n", "���������ּ�", target.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "����", target.getLatitude());
			System.out.printf(" %s : %s\n", "�浵", target.getLongitude());
			System.out.printf(" ���� ������ �Ÿ� : %f\n", k40_dist);
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

		// ���� ����� ��� ���� ���
		if (Min != null) {
			System.out.printf("**********************************\n");
			System.out.printf(" ��������(�д������)�� ���� ����� ���\n");
			System.out.printf(" %s : %s\n", "��ġ��Ҹ�", Min.getInstallationLocationName());
			System.out.printf(" %s : %s\n", "���������ּ�", Min.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "����", Min.getLatitude());
			System.out.printf(" %s : %s\n", "�浵", Min.getLongitude());
			System.out.printf(" ���������� �Ÿ� : %f\n", k40_minDist);
			System.out.printf("**********************************\n");
		}

		// ���� �� ��� ���� ���
		if (Max != null) {
			System.out.printf(" ��������(�д������)�� ���� �� ���\n");
			System.out.printf(" %s : %s\n", "��ġ��Ҹ�", Max.getInstallationLocationName());
			System.out.printf(" %s : %s\n", "���������ּ�", Max.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "����", Max.getLatitude());
			System.out.printf(" %s : %s\n", "�浵", Max.getLongitude());
			System.out.printf(" ���������� �Ÿ� : %f\n", k40_maxDist);
			System.out.printf("**********************************\n");
		}
	}
}