import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";

		// URLָ��Ҫ���ʵ����ݿ���scutcs

		String url = "jdbc:mysql://172.16.16.150:3306/hr_dev?useUnicode=true&characterEncoding=UTF-8";

		// MySQL����ʱ���û���

		String user = "root";

		// Java����MySQL����ʱ������

		String password = "iflytek!1";
		try {
			Class.forName(driver);

			// �������ݿ�

			Connection conn = DriverManager.getConnection(url, user, password);

			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			System.out.println(conn);
			

			// statement����ִ��SQL���

			Statement statement = conn.createStatement();

			// Ҫִ�е�SQL���

			String sql = "select * from project_info";
			ResultSet rs = statement.executeQuery(sql);
			String name=null;
			while(rs.next()){
				name = rs.getString("name");
				break;
			}
			System.out.println(name);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
