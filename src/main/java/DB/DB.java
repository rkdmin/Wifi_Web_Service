package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	// wifi 정보들을 insert
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
                preparedStatement.setDouble(15, wifi.getLAT());// 공공데이터 위도 경도가 반대로 되어있어서 반대로 db insert
                preparedStatement.setDouble(14, wifi.getLNT());
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
	
	// wifi 정보들이 몇 개 저장되어있는지 카운트
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
	
	// wifi 정보들을 select
	public static ArrayList<WifiDistance> selectWifis(double lat, double lnt) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
	    ResultSet rs = null;
	    String url = "jdbc:mariadb://localhost:3306/wifi";
	    String dbUserId = "root";
	    String dbPassword = "zerobase";
	    ArrayList<WifiDistance> wifiDistances = new ArrayList<>();
	    
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
            String sql = "SELECT\r\n"
            		+ "      *, round((\r\n"
            		+ "      6371 * acos (\r\n"
            		+ "      cos ( radians(?) )\r\n"
            		+ "      * cos( radians(lat) )\r\n"
            		+ "      * cos( radians(lnt) - radians(?) )\r\n"
            		+ "      + sin ( radians(?) )\r\n"
            		+ "      * sin( radians(lat) )\r\n"
            		+ "    )\r\n"
            		+ "),4) AS 거리\r\n"
            		+ "FROM wifi\r\n"
            		+ "ORDER BY 거리\r\n"
            		+ "LIMIT 0 , 20;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, lat);
            preparedStatement.setDouble(2, lnt);
            preparedStatement.setDouble(3, lat);
           
           
            // 결과 수행
            rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                double distance = rs.getDouble("거리");
                String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
                double LAT = rs.getDouble("LAT");
                double LNT = rs.getDouble("LNT");
                String WORK_DTTM = rs.getString("WORK_DTTM");
                
                WifiDistance wifiDistance = new WifiDistance(distance, X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2,
                		X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR,
                		X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM);
                
                wifiDistances.add(wifiDistance);
            }
            
            return wifiDistances;
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
	// history 정보를 insert
	public static void insertHistory(History history) {
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
            
            // 쿼리 실행
            String sql = "insert into history (LAT, LNT, INQUERY_DATE)\r\n"
            		+ "values(?, ?, ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, history.getLat());
            preparedStatement.setDouble(2, history.getLnt());
            preparedStatement.setString(3, history.getInqueryDate());
            
            
            // 결과 수행
            preparedStatement.executeQuery();
            
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

	// history 정보들을 select
	public static ArrayList<History> getHistoryList() {
		Connection connection = null;
		Statement statement = null;
	    PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
	    ResultSet rs = null;
	    ArrayList<History> historys = new ArrayList<>();
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
            String sql = "select *\r\n"
            		+ "from history\r\n"
            		+ "ORDER BY HISTORY_ID DESC;";
            preparedStatement = connection.prepareStatement(sql);

            // 결과 수행
            rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("HISTORY_ID");
                double lat = rs.getDouble("LAT");
                double lnt =  rs.getDouble("LNT");
                String date = rs.getString("INQUERY_DATE");
                historys.add(new History(id, lat, lnt, date));
            }
            
            return historys;

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

	// history 정보를 id로 delete
		public static void deleteHistory(int id) {
			Connection connection = null;
			Statement statement = null;
		    PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
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
	            String sql = "delete \r\n"
	            		+ "from history\r\n"
	            		+ "where HISTORY_ID = ?;";
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, id);

	            // 결과 수행
	            preparedStatement.executeQuery();

	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        } finally {
	            // 6. 객체 연결 해제(close) finally로 꼭 실행되게 빼줘야함
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

