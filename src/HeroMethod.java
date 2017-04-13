import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeroMethod {

	public int getTotal() {
		int total = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qiaoJava?characterEncoding=UTF-8",
					"root", "admin");

			Statement s = c.createStatement();

			String sql = "select count(*) from hero";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

			System.out.println("total:" + total);

			s.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	public void add(Hero hero) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qiaoJava?characterEncoding=UTF-8",
					"root", "admin");

			String sql = "insert into hero values(null,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int Id = rs.getInt(1);
				hero.Id = Id;
			}

			ps.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Hero hero) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qiaoJava?characterEncoding=UTF-8",
					"root", "admin");

			String sql = "update hero set name= ?, hp = ? , damage = ? where Id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.Id);

			ps.execute();

			ps.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int Id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qiaoJava?characterEncoding=UTF-8",
					"root", "admin");

			Statement s = c.createStatement();

			String sql = "delete from hero where Id = " + Id;

			s.execute(sql);

			s.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Hero get(int Id) {
		Hero hero = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qiaoJava?characterEncoding=UTF-8",
					"root", "admin");

			Statement s = c.createStatement();

			String sql = "select * from hero where Id = " + Id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				hero = new Hero();
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				hero.Id = Id;
			}

			s.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hero;
	}

	public List<Hero> list() {
		return list(0, Short.MAX_VALUE);
	}

	public List<Hero> list(int start, int count) {
		List<Hero> heros = new ArrayList<Hero>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qiaoJava?characterEncoding=UTF-8",
					"root", "admin");
			String sql = "select * from hero order by Id desc limit ?,? ";

			System.out.println(c.getAutoCommit());
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Hero hero = new Hero();
				int Id = rs.getInt(1);
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				hero.Id = Id;
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				heros.add(hero);
			}

			ps.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}
}