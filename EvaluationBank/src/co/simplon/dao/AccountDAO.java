package co.simplon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao extends Dao<Account> {
	@Override
	public Account find(int id) {
		String str = "select * from T_Account where NumAT=?";
		PreparedStatement ps;
		Account Account = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				Account = new Account(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return account;
	}

	@Override
	public boolean create(Account obj) {
		String str = "INSERT INTO T_Account (NumAt,Balance,IdCust) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getNumAt());
			ps.setDouble(2,obj.getbalance());
			ps.setInt(3,obj.getIdCust());
			ps.executeQuery();
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Account obj) {		
		String str = " update T_Account setBalance=? where NumAt=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setDouble(1,obj.getBalance());
			ps.setInt(2,obj.getNumAt());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(Account obj) {
		String str = "delete from T_Account where NumAte=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getNumAt());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}