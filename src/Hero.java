
// TODO: Auto-generated Javadoc
/**
 * The Class Hero.
 */
public class Hero {
	/** The name. */
	private String name;

	/** The id. */
	private int id;

	/** The hp. */
	private float hp;

	/** The damage. */
	private int damage;

	public Hero() {

	}

	public Hero(String name, int id, float hp, int damage) {
		this.setName(name);
		this.setId(id);
		this.setHp(hp);
		this.setDamage(damage);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
}
