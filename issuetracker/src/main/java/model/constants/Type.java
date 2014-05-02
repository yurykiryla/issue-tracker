/**
 * 
 */
package model.constants;

/**
 * @author Yury Kiryla
 *
 */
public enum Type {
	COSMETIC("Cosmetic"), 
	BUG("Bug"), 
	FEATURE("Feature"), 
	PERFOMANCE("Perfomance");
	
	private String name;
	
	private Type(String name){
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
