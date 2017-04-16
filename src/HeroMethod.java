import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class HeroMethod.
 */
public class HeroMethod {

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public int getTotal() {
		int total = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection c = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/qiaodatabase?characterEncoding=UTF-8", "root", "admin");

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

	/**
	 * Adds the.
	 *
	 * @param hero
	 *            the hero
	 */
	public void add(Hero hero) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection c = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/qiaodatabase?characterEncoding=UTF-8", "root", "admin");

			String sql = "insert into hero values(null,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, hero.getName());
			ps.setFloat(2, hero.getHp());
			ps.setInt(3, hero.getDamage());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				hero.setId(id);
			}

			ps.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Update.
	 *
	 * @param hero
	 *            the hero
	 */
	public void update(Hero hero) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection c = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/qiaodatabase?characterEncoding=UTF-8", "root", "admin");

			String sql = "update hero set name= ?, hp = ? , damage = ? where id = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, hero.getName());
			ps.setFloat(2, hero.getHp());
			ps.setInt(3, hero.getDamage());
			ps.setInt(4, hero.getId());

			ps.execute();

			ps.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Connection c = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/qiaodatabase?characterEncoding=UTF-8", "root", "admin");

			Statement s = c.createStatement();

			String sql = "delete from hero where id = " + id;

			s.execute(sql);

			s.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the hero
	 */
	public Hero get(int id) {
		Hero hero = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			Connection c = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/qiaodatabase?characterEncoding=UTF-8", "root", "admin");

			Statement s = c.createStatement();

			String sql = "select * from hero where id = " + id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				hero = new Hero();
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				hero.setName(name);
				hero.setHp(hp);
				hero.setDamage(damage);
				hero.setId(id);
			}

			s.close();

			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hero;
	}

	/**
	 * List.
	 *
	 * @return the list
	 */
	public List<Hero> list() {
		return list(0, Short.MAX_VALUE);
	}

	/**
	 * List.
	 *
	 * @param start
	 *            the start
	 * @param count
	 *            the count
	 * @return the list
	 */
	public List<Hero> list(int start, int count) {
		List<Hero> heros = new ArrayList<Hero>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			Connection c = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/qiaodatabase?characterEncoding=UTF-8", "root", "admin");
			String sql = "select * from hero limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Hero hero = new Hero();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				hero.setId(id);
				hero.setName(name);
				hero.setHp(hp);
				hero.setDamage(damage);
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