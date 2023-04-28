package kr.ac.kopo.ctc.kopo40.domain;

public class WifiItem {
	private int id; // 번호
	private String installationLocationName; // 설치장소명
	private String installationLocationDetails; // 설치장소상세
	private String installationCityName; // 설치시도명
	private String installaitionDistrictName; // 설치시군구명
	private String serviceProviderName; // 서비스제공사명
	private String wifiSsid; // 와이파이SSID
	private String dateOfInstallation; // 설치연월
	private String roadNameAddress; // 소재지도로명주소
	private String lotNumberAddress; // 소재지지번주소
	private String managementAgencyName; // 관리기관명
	private String managementAgencyPhoneNumber; // 관리기관전화번호
	private double latitude; // 위도
	private double longitude; // 경도
	private String created; // 데이터기준일자
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInstallationLocationName() {
		return installationLocationName;
	}
	public void setInstallationLocationName(String installationLocationName) {
		this.installationLocationName = installationLocationName;
	}
	public String getInstallationLocationDetails() {
		return installationLocationDetails;
	}
	public void setInstallationLocationDetails(String installationLocationDetails) {
		this.installationLocationDetails = installationLocationDetails;
	}
	public String getInstallationCityName() {
		return installationCityName;
	}
	public void setInstallationCityName(String installationCityName) {
		this.installationCityName = installationCityName;
	}
	public String getInstallaitionDistrictName() {
		return installaitionDistrictName;
	}
	public void setInstallaitionDistrictName(String installaitionDistrictName) {
		this.installaitionDistrictName = installaitionDistrictName;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public String getWifiSsid() {
		return wifiSsid;
	}
	public void setWifiSsid(String wifiSsid) {
		this.wifiSsid = wifiSsid;
	}
	public String getDateOfInstallation() {
		return dateOfInstallation;
	}
	public void setDateOfInstallation(String dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	}
	public String getRoadNameAddress() {
		return roadNameAddress;
	}
	public void setRoadNameAddress(String roadNameAddress) {
		this.roadNameAddress = roadNameAddress;
	}
	public String getLotNumberAddress() {
		return lotNumberAddress;
	}
	public void setLotNumberAddress(String lotNumberAddress) {
		this.lotNumberAddress = lotNumberAddress;
	}
	public String getManagementAgencyName() {
		return managementAgencyName;
	}
	public void setManagementAgencyName(String managementAgencyName) {
		this.managementAgencyName = managementAgencyName;
	}
	public String getManagementAgencyPhoneNumber() {
		return managementAgencyPhoneNumber;
	}
	public void setManagementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
		this.managementAgencyPhoneNumber = managementAgencyPhoneNumber;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}

}
