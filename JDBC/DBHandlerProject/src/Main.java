
public class Main {

	public static void main(String[] args) {
		DbHandler db = new DbHandler();
		
		System.out.println(db.connectToDb("root", "password", "world"));
		db.queryDbAndPrintRs("SELECT * FROM city");

	}

}
