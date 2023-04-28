package kr.ac.kopo.ctc.kopo40.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.ac.kopo.ctc.kopo40.domain.WifiItem;
import kr.ac.kopo.ctc.kopo40.servie.WifiItemService;

public class WiFiItemDao {

	public WifiItemService selectOne(int id) {
		return null;
	}

	public List<WifiItem> selectAll() {
		List<WifiItem> wifiItems = new ArrayList<>();

		try {

			File k40_f = new File("c:\\Test\\Kopo40\\wifi.txt");
			BufferedReader k40_br = new BufferedReader(new FileReader(k40_f));

			String k40_readtxt;// 출력할 문자열을 담을 변수 선언

			if ((k40_readtxt = k40_br.readLine()) == null) {
				return wifiItems;
			}

			int k40_LineCnt = 0;
			while ((k40_readtxt = k40_br.readLine()) != null) {
				String[] k40_field = k40_readtxt.split("\t");

				WifiItem wifiItem = new WifiItem();
				wifiItem.setInstallationLocationName(k40_field[1]);
				wifiItem.setId(k40_LineCnt);
				wifiItem.setLotNumberAddress(k40_field[10]);
				wifiItem.setLatitude(Double.parseDouble(k40_field[13]));
				wifiItem.setLongitude(Double.parseDouble(k40_field[14]));
				wifiItems.add(wifiItem);
				k40_LineCnt++;
			}
			k40_br.close();// close 명령어로 BufferedReader 객체 닫기
			return wifiItems;
		} catch (Exception iO) {
			return null;
		}
	}

	public WifiItem update(WifiItem wifiItem) {
		return null;
	}

	public WifiItem delete(int id) {
		return null;
	}

}
