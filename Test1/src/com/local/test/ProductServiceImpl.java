package com.local.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductServiceImpl implements ProductService {

	private static final String UPDATE_PRODUCT_SQL = "update product set price = ? where id = ?";
    private static final String INSERT_LOG_SQL = "insert into log (created, description) values (?, ?)";

    public void updateProductPrice(long productId, int price) {
        try {
            // ��ȡ����
            Connection conn = DBUtil.getConnection();
            conn.setAutoCommit(false); // �ر��Զ��ύ���񣨿�������

            // ִ�в���
            updateProduct(conn, UPDATE_PRODUCT_SQL, productId, price); // ���²�Ʒ
            insertLog(conn, INSERT_LOG_SQL, "Create product."); // ������־

            // �ύ����
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ر�����
            DBUtil.closeConnection();
        }

    }
    private void updateProduct(Connection conn, String updateProductSQL,long productId,
    		int productPrice){
    	try {
			PreparedStatement pstmt = conn.prepareStatement(updateProductSQL);
			pstmt.setInt(1, productPrice);
			pstmt.setLong(2,productId);
			int rows = pstmt.executeUpdate();
			if(rows!=0){
				System.out.println("Update product success!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void insertLog(Connection conn, String insertLogSQL, String logDescription) throws Exception {
        PreparedStatement pstmt = conn.prepareStatement(insertLogSQL);
        pstmt.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        pstmt.setString(2, logDescription);
        int rows = pstmt.executeUpdate();
        if (rows != 0) {
            System.out.println("Insert log success!");
        }
    }
    public static void main(String[] args) {
        /*ProductService productService = new ProductServiceImpl();
        productService.updateProductPrice(1, 3000);*/
    	for(int i=0;i<10;i++){
    		ProductService productService = new ProductServiceImpl();
    		ClientThread thread = new ClientThread(productService);
    		thread.start();
    	}
    }
}
