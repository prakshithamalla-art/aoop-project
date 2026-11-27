package campuslostfound;
import java.time.LocalDate; import java.util.List; import java.util.Scanner;
public class Main {
 public static void main(String[] args){
  CampusLostAndFoundService app=new CampusLostAndFoundService(); Scanner in=new Scanner(System.in);
  Student student=new Student(new StudentId("S101"),"Asha","asha@college.edu");
  Student reporter=new Student(new StudentId("S102"),"Ravi","ravi@college.edu");
  Admin admin=new Admin(new AdminId("A1"),"Campus Admin"); app.registerStudent(student);app.registerStudent(reporter);
  app.reportFoundItem(reporter.id(),new ItemDescription("Black Wallet","Small wallet with a blue card",ItemCategory.WALLET),new Location("Library","First Floor"),LocalDate.now());
  while(true){
   System.out.println("\n=== CAMPUS LOST & FOUND ===");
   System.out.println("1 Report lost item\n2 Report found item\n3 Search found items\n4 Submit claim\n5 Admin approve claim\n6 Admin reject claim\n7 View all records\n0 Exit");
   System.out.print("Choice: "); String choice=in.nextLine().trim();
   try { switch(choice){
    case "1" -> {ItemDescription d=readDescription(in);Location l=readLocation(in);System.out.print("Lost date (YYYY-MM-DD): ");var date=LocalDate.parse(in.nextLine());System.out.println(app.reportLostItem(student.id(),d,l,date));}
    case "2" -> {ItemDescription d=readDescription(in);Location l=readLocation(in);System.out.print("Found date (YYYY-MM-DD): ");var date=LocalDate.parse(in.nextLine());System.out.println(app.reportFoundItem(reporter.id(),d,l,date));}
    case "3" -> {System.out.print("Search keyword: ");List<FoundItem> found=app.searchFoundItems(in.nextLine());if(found.isEmpty())System.out.println("No items found");else found.forEach(System.out::println);}
    case "4" -> {System.out.print("Found item ID (e.g. F1): ");FoundItemId fid=new FoundItemId(in.nextLine());System.out.print("Evidence to identify ownership: ");System.out.println(app.submitClaim(student.id(),fid,in.nextLine()));}
    case "5" -> {System.out.print("Claim ID (e.g. C1): ");app.approveClaim(new ClaimId(in.nextLine()),admin,new EvidenceClaimVerifier());System.out.println("Claim approved; item returned.");}
    case "6" -> {System.out.print("Claim ID: ");app.rejectClaim(new ClaimId(in.nextLine()),admin);System.out.println("Claim rejected; item available again.");}
    case "7" -> {System.out.println("-- LOST --");app.lostItems().forEach(System.out::println);System.out.println("-- FOUND --");app.foundItems().forEach(System.out::println);System.out.println("-- CLAIMS --");app.claims().forEach(System.out::println);}
    case "0" -> {System.out.println("Goodbye");return;}
    default -> System.out.println("Invalid choice");
   }} catch(RuntimeException ex){System.out.println("Operation failed: "+ex.getMessage());}
  }
 }
 private static ItemDescription readDescription(Scanner in){System.out.print("Item name: ");String n=in.nextLine();System.out.print("Description: ");String d=in.nextLine();System.out.print("Category (ID_CARD, BOOK, ELECTRONICS, KEYS, WALLET, WATER_BOTTLE, OTHER): ");return new ItemDescription(n,d,ItemCategory.valueOf(in.nextLine().trim().toUpperCase()));}
 private static Location readLocation(Scanner in){System.out.print("Building: ");String b=in.nextLine();System.out.print("Area: ");return new Location(b,in.nextLine());}
}
