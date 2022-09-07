package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
	public void dbSelect() {
		Connection connection = null;
		Statement statement = null;
	    PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
	    ResultSet rs = null;
	    String url = "jdbc:mariadb://localhost:3306/";
	    String dbUserId = "root";
	    String dbPassword = "zerobase";

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            // DB연결
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 쿼리 실행
            String countryValue = "한국";
            String sql = "select * from actor where country = ? limit 10000, 10;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, countryValue);

            // 결과 수행
            rs = preparedStatement.executeQuery();

            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                String country =  rs.getString("country");

                System.out.println(code + ", " + name + ", " + country);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 6. 객체 연결 해제(close) finally로 꼭 실행되게 빼줘야함
            try {
                if(rs != null && rs.isClosed()) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(preparedStatement != null && !preparedStatement.isClosed()) preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(connection != null && !connection.isClosed()) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

	}

	public void dbSelect2() {
		Connection connection = null;
		Statement statement = null;
	    PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
	    ResultSet rs = null;
	    String url = "jdbc:mariadb://localhost:3306/wifi";
	    String dbUserId = "root";
	    String dbPassword = "zerobase";

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            // DB연결
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            
            // 쿼리 실행
            String countryValue = "한국";
            String sql = "select * from wifi";
            preparedStatement = connection.prepareStatement(sql);

            // 결과 수행
            rs = preparedStatement.executeQuery();
            System.out.println(22);
            while(rs.next()){
                String lat = rs.getString("LAT");
                
                System.out.println(2);
                System.out.println(lat);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 6. 객체 연결 해제(close) finally로 꼭 실행되게 빼줘야함
            try {
                if(rs != null && rs.isClosed()) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(preparedStatement != null && !preparedStatement.isClosed()) preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(connection != null && !connection.isClosed()) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

	}
	
	public static void insertWifi(ArrayList<Wifi> wifis) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
	    ResultSet rs = null;
	    String url = "jdbc:mariadb://localhost:3306/wifi";
	    String dbUserId = "root";
	    String dbPassword = "zerobase";

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            // DB연결
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            
            for(Wifi wifi: wifis) {
            	// 쿼리 실행
                String sql = "insert into wifi(X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR,\r\n"
                		+ "				X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR,\r\n"
                		+ "				X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM) \r\n"
                		+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, wifi.getX_SWIFI_MGR_NO());
                preparedStatement.setString(2, wifi.getX_SWIFI_WRDOFC());
                preparedStatement.setString(3, wifi.getX_SWIFI_MAIN_NM());
                preparedStatement.setString(4, wifi.getX_SWIFI_ADRES1());
                preparedStatement.setString(5, wifi.getX_SWIFI_ADRES2());
                preparedStatement.setString(6, wifi.getX_SWIFI_INSTL_FLOOR());
                preparedStatement.setString(7, wifi.getX_SWIFI_INSTL_TY());
                preparedStatement.setString(8, wifi.getX_SWIFI_INSTL_MBY());
                preparedStatement.setString(9, wifi.getX_SWIFI_SVC_SE());
                preparedStatement.setString(10, wifi.getX_SWIFI_CMCWR());
                preparedStatement.setString(11, wifi.getX_SWIFI_CNSTC_YEAR());
                preparedStatement.setString(12, wifi.getX_SWIFI_INOUT_DOOR());
                preparedStatement.setString(13, wifi.getX_SWIFI_REMARS3());
                preparedStatement.setDouble(14, wifi.getLAT());
                preparedStatement.setDouble(15, wifi.getLNT());
                preparedStatement.setString(16, wifi.getWORK_DTTM());
                
                // 결과 수행
                preparedStatement.executeQuery();
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(preparedStatement != null && !preparedStatement.isClosed()) preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(connection != null && !connection.isClosed()) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

	}

	
	
	public static int getTotalCnt() {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
	    ResultSet rs = null;
	    String url = "jdbc:mariadb://localhost:3306/wifi";
	    String dbUserId = "root";
	    String dbPassword = "zerobase";

        // 1. 드라이버 로드
	    int cnt = 0;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            // DB연결
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            
            // 쿼리 실행
            String sql = "select count(*) as count from wifi;";
            preparedStatement = connection.prepareStatement(sql);
            // 결과 수행
            rs = preparedStatement.executeQuery();
            while(rs.next()){
            	cnt = rs.getInt(1);
            }
            
            		
            
            return cnt;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        	try {
                if(rs != null && rs.isClosed()) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(preparedStatement != null && !preparedStatement.isClosed()) preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(connection != null && !connection.isClosed()) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

	}
	
}
