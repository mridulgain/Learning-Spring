import java.util.Scanner; 
public class TestDbWriter{
	public static void main(String args[]) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("id : ");
			String id = sc.nextLine();
			System.out.print("First Name : ");
			String fname= sc.nextLine();
			System.out.print("Last Name : ");
			String lname = sc.nextLine();
			System.out.print("Insert into :\n1. SQL DB\n2. No SQL DB\nyour choice ? ");
		
			DbWriter dw = null;
			int op = sc.nextInt();

			switch(op) {
			case 1 : 
				dw = new SqlWriter();
				break;
			case 2 : 
				dw = new NoSqlWriter();
				break;
			default :
			System.out.println("Wrong choice");
			}
		//db writing
			if( dw.dbWrite(id, fname, lname) ) {
				System.out.println("Inserted Successfully");
			}
		//
			sc.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}