package com.fcfy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import com.fcfy.bean.User;


//�� ɾ �� �� ������
public class JDBCUtil {

	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	//��̬�����
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("���ǵ���mysql��jar��");
			e.printStackTrace();
		}
	}
	//���Connection  
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/card", "root", "java");
		} catch (Exception e) {
			System.out.println("���Connectionʧ��...�����ݿ����Ǹ�������)");
			e.printStackTrace();
		}
		return conn;
	}
	//��ȡԤ�������
	public static PreparedStatement getPs(String sql,Object...args){
		try {
			conn =getConnection();
			ps = conn.prepareStatement(sql);
			if(args!=null){//֤��sql�У�ռλ��  ��Ҫps.setObject();
				for(int i=1;i<=args.length;i++){
					System.out.println("�ɱ�����ǣ���"+args[i-1]);
					ps.setObject(i, args[i-1]);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ps;
	} 
	//��ѯ����
	public static <T> List<T> getList(Class<T> clazz,String sql,Object...args){
		List<T> list = new ArrayList<T>();
		T t=null;
		
		try {
			ps=getPs(sql,args);
			rs = ps.executeQuery();
			//��ȡ��ResultSet ������еı�š����ͺ�����
			ResultSetMetaData metaData=rs.getMetaData();
			// ���ش�ResultSet �����е�����
			int count= metaData.getColumnCount();			
			while(rs.next()){
				t=clazz.newInstance();//ͨ�����䴴������ ���t����ֵ ֻ��ͨ��set������ֵ
				for(int i=1;i<=count;i++){
					//���ÿһ�е����� metaData.getColumnName(i)
					String name = metaData.getColumnName(i);
					//System.out.println(name);
					BeanUtils.copyProperty(t, name, rs.getObject(i));
				}
				list.add(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, ps, conn);
		}		
		return list;
	}
	//���� ɾ�� �޸�
	public static int executeSql(String sql,Object... args){
		int i=0;
		try {
			ps=getPs(sql,args);
			i = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			close(rs, ps, conn);
		}			
		return i;
	}
	
	//ͨ��������ѯ����
	public static <T> T getObject(Class<T> clazz,String sql,Object... args){
		T t=null;		
		try {
			ps=getPs(sql,args);
			rs = ps.executeQuery();
			//��ȡ��ResultSet ������еı�š����ͺ�����
			ResultSetMetaData metaData=rs.getMetaData();
			// ���ش�ResultSet �����е�����
			int count= metaData.getColumnCount();			
			while(rs.next()){
				t=clazz.newInstance();//ͨ�����䴴������ ���t����ֵ ֻ��ͨ��set������ֵ
				for(int i=1;i<=count;i++){
					//���ÿһ�е����� metaData.getColumnName(i)
					String name = metaData.getColumnName(i);
					//System.out.println(name);
					BeanUtils.copyProperty(t, name, rs.getObject(i));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, ps, conn);
		}		
		return t;
	} 
	//��ѯ����
	public static int getConut(String sql,Object... args){
		int count=0;
		try {
			ps = getPs(sql, args);
			rs = ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("��ѯ����ʧ�ܡ�������");
			e.printStackTrace();
		} finally{
			close(rs, ps, conn);
		}
		return count;
	}
	
	
	//�ر�����
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}if(ps!=null){
				ps.close();
			}if(conn!=null){
				conn.close();
			}
			
		} catch (Exception e) {
			System.out.println("�ر�����ʧ��...");
			e.printStackTrace();
		}
	}
	
}
