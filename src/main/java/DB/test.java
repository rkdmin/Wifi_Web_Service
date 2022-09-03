package DB;

public class test {
	static double distance(double lat1, double lon1, double lat2, double lon2){
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))* Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1))*Math.cos(deg2rad(lat2))*Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60*1.1515*1609.344*0.001;
       
        return Math.round((dist) * 10000) / 10000.0;
    }
	
	static double deg2rad(double deg){
        return (deg * Math.PI/180.0);
    }
    //radian(라디안)을 10진수로 변환
    static double rad2deg(double rad){
        return (rad * 180 / Math.PI);
    }
    
	public static void main(String[] args) {
		double dist = distance(37.5544069, 126.8998666, 37.55557, 126.905556);
		System.out.println(dist);

	}

}
