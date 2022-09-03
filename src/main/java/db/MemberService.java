package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberService {
	public void dbSelect() {
		String url = "jdbc:mariadb://localhost:3306/kobis_db";
        String dbUserId = "kobis_user";
        String dbPassword = "kobis1234";

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성, rs도 미리
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
        ResultSet rs = null;

        try {
            // DB연결
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 4. 쿼리 실행
            String countryValue = "한국";
            String sql = "select * from actor where country = ? limit 10000, 10;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, countryValue);

            // 5. 결과 수행
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

	
}
